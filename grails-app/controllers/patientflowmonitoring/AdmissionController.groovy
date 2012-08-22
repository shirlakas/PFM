package patientflowmonitoring

import patientflowmonitoring.Admission;
import patientflowmonitoring.Discharge;
import patientflowmonitoring.Statistics;

class AdmissionController {

    def scaffold = true
	
	def getHourlyAdmission (def dayTag){
		
		def c1 = Admission.createCriteria()
		def result = c1 {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def hourlyDischarge= {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		List dataSet = getHourlyDischarge(dayTag)
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{\"hour\":${it[0]},\"discharge\":${it[1]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		//render(contentType:"application/json",text:retVal)
		return retVal
	}
	
	def hourlyAdmissionDischarge = {
		//def admission = hourlyAdmission()
		//def discharge = hourlyDischarge()
		//def retVal = "{\"hourlyAdmission\":${admission},\"hourlyDischarge\":${discharge}}"
		
		def retVal = "{\"hourlyAdmission\":[{\"hour\":0,\"admission\":1},{\"hour\":1,\"admission\":2},{\"hour\":2,\"admission\":2},{\"hour\":3,\"admission\":1},{\"hour\":4,\"admission\":1},{\"hour\":5,\"admission\":2},{\"hour\":6,\"admission\":3},{\"hour\":7,\"admission\":4},{\"hour\":8,\"admission\":4},{\"hour\":9,\"admission\":1},{\"hour\":10,\"admission\":3}],\"hourlyDischarge\":[{\"hour\":0,\"discharge\":1},{\"hour\":5,\"discharge\":1},{\"hour\":6,\"discharge\":1},{\"hour\":7,\"discharge\":2},{\"hour\":8,\"discharge\":2},{\"hour\":9,\"discharge\":3},{\"hour\":10,\"discharge\":4}]}"
		render(contentType:"application/json",text:retVal)
	}

		
		
		

	
	def hourlyAdmission = {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		List dataSet = getHourlyAdmission(dayTag)
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{\"hour\":${it[0]},\"admission\":${it[1]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		//render(contentType:"application/json",text:retVal)
		return retVal
	}
	
	def getHourlyDischarge (def dayTag){
		
		def c2 = Discharge.createCriteria()
		def result = c2 {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def getAdmissionVsDischarge = {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def hourlyAdmission = getHourlyAdmission(dayTag)
		def hourlyDischarge = getHourlyDischarge(dayTag)

		render(view:"admissionVsDischarge", model:[admission:hourlyAdmission, discharge:hourlyDischarge])
	}
	
	
}
