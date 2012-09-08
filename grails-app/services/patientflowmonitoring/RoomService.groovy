package patientflowmonitoring
import java.util.List;
import java.util.Map;
import patientflowmonitoring.RoomState.RoomStateName
import patientflowmonitoring.Room

class RoomService {

    static transactional = true

    def serviceMethod() {

    }
	
	def updateRoomState(){
	
	}
	
	def Map queryRoomMap(){
		
/*		def c = Patient.createCriteria()

		def patientList = c.list{
			notEqual("roomID","")
		}
		
		def roomList = Room.withCriteria(){
			currentState{
				or{
					eq("stateName",RoomStateName.BED_ASSIGNED)
					eq("stateName",RoomStateName.BED_OCCUPIED)
					eq("stateName",RoomStateName.WAIT_FOR_BED_CLEANUP)
					eq("stateName",RoomStateName.IN_CLEANUP)
					eq("stateName",RoomStateName.BED_AVAILABLE)
				}
			}
			//eq("roomID","R107")
			//eq("roomID","R106")
			//eq("roomID","R105")
		}*/
		
		def roomList = Room.getAll()
		
		def roomMap = [:]
		
		roomList.each({
			roomMap[it.roomID]=it.roomID
		})
		
		println(roomMap)
		
		return roomMap
	}

	
	def List getWaitingRooms(){
		def rooms = Room.withCriteria(){
			currentState{
				or{
					eq("stateName",RoomStateName.WAIT_FOR_BED_CLEANUP)
				}
			}
		}
		return rooms
	}
}
