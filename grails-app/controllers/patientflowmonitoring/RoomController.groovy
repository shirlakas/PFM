package patientflowmonitoring

import java.util.List;
import grails.converters.*
import patientflowmonitoring.RoomState.RoomStateName

class RoomController {
	
	def scaffold = true
	def unitService
	def roomService
	
	static navigation = [
		[group:'tabs',action:'getRoomDetails', title:'Room',order:6]
	]
	
	def getRoomRoomMapping = {
		
		def retVal = new StringBuffer()
		retVal.append("[")
		def roomMap = roomService.queryRoomMap()
		def es = roomMap.entrySet()
		es.each{
			retVal.append("{\"roomId\":\"${it.value}\",\"roomId\":\"${it.key}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getRoomMap = {
		
		def roomMap = roomService.queryRoomMap()
		
		render(view:"UnitMap1",model:
			[mapping:roomMap,unitIds:unitService.getUnitIds()])
	}
	
	def getEventList = {
		
		def roomId = params.id
		Room room = Room.findByRoomID(params.id)
		List events = room.events
		
		def retVal = new StringBuffer()
		retVal.append("[")
		events.each{
			retVal.append("{\"event\":\"${it.eventName}\",\"timeStamp\":\"${it.timeStamp}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getStateList = {
		
		def roomId = params.id
		Room room = Room.findByRoomID(params.id)
		List states = room.states
		
		def retVal = new StringBuffer()
		retVal.append("[")
		states.each{
			retVal.append("{\"state\":\"${it.stateName}\",\"startTime\":\"${it.startTime}\",\"endTime\":\"${it.endTime}\",\"duration\":\"${it.duration}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getRoomDetails = {
		
		
		def file = new File(servletContext.getRealPath("/html/ClinicalPathway.html"))
		String clincalpathWay = file.getText()
		
		if (params.id){
			Room room = Room.findByRoomID(params.id)
			session.room=room
			render(view:"roomDetails",model:
				[room:room,clincalPathWay:clincalpathWay])
		}else if(session.room){
		render(view:"roomDetails",model:
			[room:session.room,clincalPathWay:clincalpathWay])
		}else{
			//getRoomMap()
		Room room = Room.findByRoomID("R107")
		session.room=room
		render(view:"roomDetails",model:
			[room:room,clincalPathWay:clincalpathWay])
		
		}

	}
	
	def getCurrentRoomsWaitTime = {
	
		def rooms = roomService.getWaitingRooms()

		render(view:"currentRoomsWaitTime",model:[rooms:rooms])
	}
}
