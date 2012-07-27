package patientflowmonitoring

import patientflowmonitoring.Arrival;
import patientflowmonitoring.Statistics;

class ArrivalController {
	def scaffold = true
	
	def getHourlyArrival(def dayTag) {
		
		def c = Arrival.createCriteria()
		def result = c {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def hourlyArrival = {
		/*def arrivals = [:]
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def dataSet = getHourlyArrival(dayTag)
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{\"hour\":${it[0]},\"arrival\":${it[1]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		
		
		render(retVal)*/
		def retVal = "[{\"hour\":0,\"arrival\":3},{\"hour\":1,\"arrival\":4},{\"hour\":2,\"arrival\":1},{\"hour\":3,\"arrival\":1},{\"hour\":4,\"arrival\":3},{\"hour\":5,\"arrival\":5},{\"hour\":6,\"arrival\":7},{\"hour\":7,\"arrival\":7},{\"hour\":8,\"arrival\":6},{\"hour\":9,\"arrival\":4},{\"hour\":10,\"arrival\":3}]"
		render(retVal)
		
	}
	
	def getTodayArrivals = {
		def arrivals = [:]
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def hourlyArrivals = getHourlyArrival(dayTag)

		render(view:"todayArrivalsByHour", model:[mapping:hourlyArrivals])
	}
}
