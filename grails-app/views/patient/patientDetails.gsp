<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<nav:resources/>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>Patient Details</title>
<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath() %>/css/demo_page.css";
@import "<%=request.getContextPath() %>/css/demo_table.css";
@import "<%=request.getContextPath() %>/css/jQuery_menu.css";
</style>


<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.tabify.source.js"></script>	
<script type="text/javascript" charset="utf-8">

			//console.info("<%=patient%>");

			<%
				def events = [];
				def eventList = patient.events
				eventList.each({
					events<<"['${it.eventName}','${it.timeStamp}']"
				})
				//println events
				
				def states = [];
				def chartStates =[];
				def total=0;
				def duratn=[];
				int i=0;
				chartStates<<"['State', 'Duration','Target']"
				def stateList = patient.states;
				def cnt =0;
				stateList.each({
					states<<"['${it.stateName}','${it.startTime}','${it.endTime}','${it.duration}','${it.target}']"
					chartStates<<"['${it.stateName}',${it.duration},${it.target}]"
					cnt++;
				})
				total =duratn.sum()
			%>
			
			/* Data set - can contain whatever information you want */
			var eventDataSet = <%=events%>;

			var stateDataSet = <%=states%>;
				
			$(document).ready(function() {

				$('#events').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="event_table"></table>' );
				$('#event_table').dataTable( {
					"bPaginate": false, /* Delete this line if you want paging*/
					"aaData": eventDataSet,
					"aaSorting": [[ 1, "desc" ]],
					"aoColumns": [
						{ "sTitle": "Event data received" },
						{ "sTitle": "Received Time", "sClass": "center" }
					]
				} );	
				$('#states').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="state_table"></table>' );
				$('#state_table').dataTable( {
					"bPaginate": false, /* Delete this line if you want paging*/
					"aaData": stateDataSet,
					"aaSorting": [[ 2, "desc" ]],
					"aoColumns": [
						{ "sTitle": "State" },
						{ "sTitle": "Start Time", "sClass": "center",
							"fnRender":function(oObj){
								if (oObj.aData[1]=="null")
									return 'N/A';
								return oObj.aData[1];
							} },
						{ "sTitle": "End Time", "sClass": "center",
							"fnRender":function(oObj){
									if (oObj.aData[2]=="null")
										return 'N/A';
									return oObj.aData[2];
								}
							 },
						{ "sTitle": "Duration (mins)", "sClass": "center","sWidth":"5%",
							"fnRender":function(oObj){
									if (oObj.aData[2]=="N/A")
										return 'N/A';
									return oObj.aData[3];
								}
							 },
							 { "sTitle": "Target (mins)", "sClass": "center","sWidth":"5%",
									"fnRender":function(oObj){
											if ((oObj.aData[4]=="null")||(oObj.aData[4]==0))
												return 'N/A';
											return oObj.aData[4];
										}
									 }
					]
				} );

				$('#menutab').tabify();
			} );
		</script>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>     <script type="text/javascript">       google.load("visualization", "1", {packages:["corechart"]});       google.setOnLoadCallback(drawChart);
      function drawChart() {
  // Create and populate the data table.
  var data = google.visualization.arrayToDataTable(          
				<%=chartStates%>
);

  // Create and draw the visualization.
  new google.visualization.BarChart(document.getElementById('chart_arrivals_div')).
      draw(data,
           {title:"Average Time Patients Spend in Each Step of the Cardiac Care Process",
            width:1400, height:800,
            vAxis: {title: "State"},
            hAxis: {title: "Duration in Minutes"}}
      );
}

</script>
</head>
<body id="dt_example">

	<div id="container">
		<nav:render group="tabs"/>
		<h1>Patient Info:<%=patient%> &nbsp; Room: <%=patient.roomID %></h1>
		
		<ul id="menutab" class="menu">
			<li class="active"><a href="#patientstats">Patient States Chart</a></li>
			<li><a href="#clinicalInfo">Patient States</a></li>
			<li><a href="#otherInfo">Events Received</a></li>
		</ul>
		
		<div id="patientstats">
			<h1>Patient States Chart &nbsp; &nbsp; Total Time Spent: <g:formatNum number="${total}" format="### minutes"/> </h1>
			<div id="chart_arrivals_div"></div>
		</div>

		<div id="clinicalInfo">
			<h1>Patient States</h1>
			<div id="states"></div>
			<h1>Total Time Spent: <g:formatNum number="${total}" format="### minutes"/></h1>			
		</div>
				
		<div id="otherInfo">
			<h1>Events Received</h1>
			<div id="events"></div>
		</div>
	</div>
</body>
</html>
