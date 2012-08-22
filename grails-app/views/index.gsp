<html>
    <head>
    <nav:resources/>
        <meta name="layout" content="main" />
        <title>Welcome to the Osler Patient Flow Monitoring System</title>
        <g:set var="ds" value="${grailsApplication.config.dataSource.url.toString()}"/>
		<style type="text/css">
			#options {
				list-style: none;				
				padding: 0.2em 0 0 2em;				
			}
			
			#options li {
				padding: 0 0 1em 3em;
			}
			
			#test-li {
				background: url(images/test-runner.png) no-repeat left top;
			}
			#pat-li {
				background: url(images/patient_icon.gif) no-repeat left top;
			}
			
			#log-li {
				background: url(images/analytics.png) no-repeat left top;
			}
			
			#routing-li {
				background: url(images/router.png) no-repeat left top;
			}
			#settings {
				background: url(images/settings3.jpg) no-repeat left top;
			}
	
		</style>
	  </head>
    <body>
      <div id="status" role="complementary">
            <h1>PFM Status</h1>
                  <ul>
                        <li>PFM version: <g:meta name="app.version"></g:meta></li>
                        <li>Grails version: <g:meta name="app.grails.version"></g:meta></li>
                        <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
                        <li>JVM version: ${System.getProperty('java.version')}</li>
                        <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                        <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                        <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                        <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                  </ul>
                <h1>Installed Plugins</h1>
                  <ul>
                        <g:set var="pluginManager"
                               value="${applicationContext.getBean('pluginManager')}"></g:set>

                        <g:each var="plugin" in="${pluginManager.allPlugins}">
                            <li>${plugin.name} - ${plugin.version}</li>
                        </g:each>
                  </ul>
     </div>
     <div id="body" class ="indented">
            <span ></span>
            <br/>
            This application provides real-time information on the state of Cardiac Patients in the William Osler Hospital project.
			
            <ul id="options">
                 <li id="pat-li">
				    <h2><a href="patient/getPatientDetails">Patient Details</a></h2>Use this tool to obtain information about patients, events received and states.
      				<div>
      				     <a href="patient/getPatientDetails">Patient Details</a>|
      				     <a href="patient/getCurrentPatientsWaitTime">Current wait time table</a>|
      				     <g:link controller="patient">Patient List</g:link> |
      				     <g:link controller="patientState">Patient State List</g:link> |
   						 
   					</div>
				</li>
				<li id="test-li">
				    <h2><a href="msgList.gsp">Test Driver</a></h2>Use this tool to inject test events from a script into PFM.
      				<div>
						<a href="monitor/showTestDriverPage">Test Driver</a>|
					</div>
				</li>
				<li id="log-li">
					<h2><a href="unit/showUnitPerformance#statistics-tab">Charts</a></h2>Use this tool to view the PFM Charts.	
					<div>
					<a href="unit/showUnitPerformance#statistics-tab">Today Arrival By hour Bar Chart</a>|
    				<a href="admission/getAdmissionVsDischarge">Today Admission Vs Discharge Bar Chart</a>|			
					<a href="unit/showUnitPerformance">Report</a>|
					</div>
				</li>
				<li id="routing-li">
					<h2><a href="simpleMap.gsp">Map of Rooms and Patients</a></h2> Use this tool to view the maps of the ED and CCU.
					<div>
					   <a href="patient/getPatientMap">Unit map</a>|
					   <a href="simpleMap.gsp">Simple Map for Rooms and Patients</a>|
					   <a href="map1.gsp">Map1</a>|
    				   <a href="map2.gsp">Map2</a>|
    				   
					</div>
				</li> 
			 <li id="settings">
			  <h2> PFM Controllers</h2> Below is a list of the controllers that are currently deployed in this application. 
			    <div>
                 <g:link controller="admission">Admissions List</g:link> |
                 <g:link controller="arrival">Arrival List</g:link> |
                 <g:link controller="bed">Bed List</g:link> |
                 <g:link controller="discharge">Discharge List</g:link> |
                 <g:link controller="event">Events List</g:link> |
                 <g:link controller="message">Message List</g:link> |
                 <g:link controller="patient">Patient List</g:link> |
				 <g:link controller="patientState">Patient State List</g:link> |
                 <g:link controller="unit">Unit List</g:link> |
              </div>
			</li>	
			</ul>
        </div>
    </body>
</html>
