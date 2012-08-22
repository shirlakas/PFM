
<html>
  <head>
  	  <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            color: #48802c;
   			font-weight: normal;
   			font-size: 16px;
    		margin: .8em 0 .3em 0;
            
        }
        #pageBody {
            margin-left:280px;
            margin-right:20px;
        }
        body {
  	  	background: #fff;
    	color: #333;
    	font: verdana, arial, helvetica, sans-serif;
}
        </style>
  </head>

  <body>
  
  <p>Welcome to the Menu Page for the William Osler Hospital PFM System. Please click on a link below. </p>
    <h2><a href="index.gsp" target="_blank">Grails main page to see all the data changes</a></h2>
    <h2><a href="map1.gsp" target="_blank">Map1</a></h2>
    <h2><a href="map2.gsp" target="_blank">Map2</a></h2>
    <h2><a href="arrival/getTodayArrivals" target="_blank">Today Arrival By hour Bar Chart</a></h2>
    <h2><a href="admission/getAdmissionVsDischarge" target="_blank">Today Admission Vs Discharge Bar Chart</a></h2>
    <h2><a href="msgList.gsp" target="_blank">Message List for Testing</a></h2>
    <h2><a href="simpleMap.gsp" target="_blank">Simple Map for Rooms and Patients</a></h2>
    <h2><a href="patientDetails.gsp" target="_blank">Patient Details including events received and states even in</a></h2>
    <h2><a href="patient/getCurrentPatientsWaitTime" target="_blank">Current wait time table</a></h2>
    <h2><a href="patient/getPatientMap" target="_blank">Unit map</a></h2>     
  </body>
</html>