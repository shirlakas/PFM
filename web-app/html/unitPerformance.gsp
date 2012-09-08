<html>
<head>
<title>
</title>
</head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>     <script type="text/javascript">       google.load("visualization", "1", {packages:["corechart"]});       google.setOnLoadCallback(drawChart);
      function drawChart() {
  // Create and populate the data table.
  var data = google.visualization.arrayToDataTable([
                ['State', 'Duration'],
                [	'TRIAGED'	,	3	]	,
[	'WAIT_FOR_CONSULTATION1'	,	2	]	,
[	'IN_CONSULTATION1'	,	3	]	,
[	'IN_BED_ED'	,	5	]	,
[	'WAIT_FOR_ORDER_EXECUTION'	,	1	]	,
[	'WAIT_FOR_CONSULTATION2'	,	2	]	,
[	'IN_CONSULTATION2'	,	1	]	,
[	'IN_BED_ED'	,	3	]	,
[	'WAIT_FOR_BED_CW'	,	5	]	,
[	'WAIT_FOR_TRANSPORT_CW'	,	1	]	,
[	'IN_TRANSPORT_CW'	,	1	]	,
[	'IN_BED_CW'	,	5	]	,
[	'WAIT_FOR_PROCEDURES'	,	2	]	,
[	'WAIT_FOR_TRANSPORT_CCL'	,	1	]	,
[	'IN_TRANSPORT_CCL'	,	1	]	,
[	'IN_BED_CCL'	,	2	]	,
[	'IN_PROCEDURE_ANGIOGRAM'	,	4	]	,
[	'IN_BED_CCL'	,	1	]	,
[	'IN_PROCEDURE_PCI'	,	5	]	,
[	'IN_BED_CCL'	,	5	]	,
[	'WAIT_FOR_TRANSPORT_CW'	,	1	]	,
[	'IN_TRANSPORT_CW'	,	1	]	,
[	'IN_BED_CW'	,	10	]	,
[	'IN_CONSULTATION3'	,	2	]	,
[	'IN_BED_CW'	,	3	]	,
[	'WAIT_FOR_DISCHARGE'	,	1	]	,
[	'DISCHARGED'	,	0	]	

   ]);

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
<body>
<div id="chart_arrivals_div"></div>

<script type="text/javascript">
    google.load("visualization", "1", { packages: ["corechart"] });
    google.setOnLoadCallback(drawChart);
    function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Time');
        data.addColumn('number', 'Arrivals');
        data.addRows(24);

        data.setValue(0, 0, "0");
        data.setValue(0, 1, 0);

        data.setValue(1, 0, "1");
        data.setValue(1, 1, 0);

        data.setValue(2, 0, "2");
        data.setValue(2, 1, 0);

        data.setValue(3, 0, "3");
        data.setValue(3, 1, 1);

        data.setValue(4, 0, "4");
        data.setValue(4, 1, 0);

        data.setValue(5, 0, "5");
        data.setValue(5, 1, 1);

        data.setValue(6, 0, "6");
        data.setValue(6, 1, 0);

        data.setValue(7, 0, "7");
        data.setValue(7, 1, 0);

        data.setValue(8, 0, "8");
        data.setValue(8, 1, 0);

        data.setValue(9, 0, "9");
        data.setValue(9, 1, 0);

        data.setValue(10, 0, "10");
        data.setValue(10, 1, 0);

        data.setValue(11, 0, "11");
        data.setValue(11, 1, 0);

        data.setValue(12, 0, "12");
        data.setValue(12, 1, 0);

        data.setValue(13, 0, "13");
        data.setValue(13, 1, 0);

        data.setValue(14, 0, "14");
        data.setValue(14, 1, 0);

        data.setValue(15, 0, "15");
        data.setValue(15, 1, 0);

        data.setValue(16, 0, "16");
        data.setValue(16, 1, 0);

        data.setValue(17, 0, "17");
        data.setValue(17, 1, 0);

        data.setValue(18, 0, "18");
        data.setValue(18, 1, 0);

        data.setValue(19, 0, "19");
        data.setValue(19, 1, 0);

        data.setValue(20, 0, "20");
        data.setValue(20, 1, 0);

        data.setValue(21, 0, "21");
        data.setValue(21, 1, 0);

        data.setValue(22, 0, "22");
        data.setValue(22, 1, 0);

        data.setValue(23, 0, "23");
        data.setValue(23, 1, 0);


        var chart = new google.visualization.ColumnChart(document.getElementById('chart_arrivals_div1'));
        chart.draw(data, { width: 800, height: 600, title: 'Today Arrivals by Hour',
            hAxis: { title: 'Time', titleTextStyle: { color: 'blue'} }
        });
    }
    </script>

    <div id="chart_arrivals_div1"></div>    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", { packages: ["corechart"] });
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Time');
            data.addColumn('number', 'Admission');
            data.addColumn('number', 'Discharge')
            data.addRows(24);

            data.setValue(0, 0, "0");
            data.setValue(0, 1, 0);
            data.setValue(0, 2, 0);

            data.setValue(1, 0, "1");
            data.setValue(1, 1, 0);
            data.setValue(1, 2, 0);

            data.setValue(2, 0, "2");
            data.setValue(2, 1, 0);
            data.setValue(2, 2, 0);

            data.setValue(3, 0, "3");
            data.setValue(3, 1, 0);
            data.setValue(3, 2, 0);

            data.setValue(4, 0, "4");
            data.setValue(4, 1, 0);
            data.setValue(4, 2, 0);

            data.setValue(5, 0, "5");
            data.setValue(5, 1, 0);
            data.setValue(5, 2, 0);

            data.setValue(6, 0, "6");
            data.setValue(6, 1, 0);
            data.setValue(6, 2, 1);

            data.setValue(7, 0, "7");
            data.setValue(7, 1, 0);
            data.setValue(7, 2, 0);

            data.setValue(8, 0, "8");
            data.setValue(8, 1, 0);
            data.setValue(8, 2, 0);

            data.setValue(9, 0, "9");
            data.setValue(9, 1, 1);
            data.setValue(9, 2, 0);

            data.setValue(10, 0, "10");
            data.setValue(10, 1, 0);
            data.setValue(10, 2, 0);

            data.setValue(11, 0, "11");
            data.setValue(11, 1, 0);
            data.setValue(11, 2, 0);

            data.setValue(12, 0, "12");
            data.setValue(12, 1, 0);
            data.setValue(12, 2, 0);

            data.setValue(13, 0, "13");
            data.setValue(13, 1, 0);
            data.setValue(13, 2, 0);

            data.setValue(14, 0, "14");
            data.setValue(14, 1, 0);
            data.setValue(14, 2, 0);

            data.setValue(15, 0, "15");
            data.setValue(15, 1, 0);
            data.setValue(15, 2, 0);

            data.setValue(16, 0, "16");
            data.setValue(16, 1, 0);
            data.setValue(16, 2, 0);

            data.setValue(17, 0, "17");
            data.setValue(17, 1, 0);
            data.setValue(17, 2, 0);

            data.setValue(18, 0, "18");
            data.setValue(18, 1, 0);
            data.setValue(18, 2, 0);

            data.setValue(19, 0, "19");
            data.setValue(19, 1, 0);
            data.setValue(19, 2, 0);

            data.setValue(20, 0, "20");
            data.setValue(20, 1, 0);
            data.setValue(20, 2, 0);

            data.setValue(21, 0, "21");
            data.setValue(21, 1, 0);
            data.setValue(21, 2, 0);

            data.setValue(22, 0, "22");
            data.setValue(22, 1, 0);
            data.setValue(22, 2, 0);

            data.setValue(23, 0, "23");
            data.setValue(23, 1, 0);
            data.setValue(23, 2, 0);


            var chart = new google.visualization.ColumnChart(document.getElementById('chart_admissionVsDischarge_div'));
            chart.draw(data, { width: 800, height: 600, title: 'Today Admission Vs Discharge by Hour',
                hAxis: { title: 'Time', titleTextStyle: { color: 'blue'} }
            });
        }
    </script>

    <div id="chart_admissionVsDischarge_div"></div>

</body>
</html>