
$(document).ready(createChart);
$(document).bind("kendo:skinChange", createChart);

function createChart() {
	$("#chart")
			.kendoChart(
					{
						dataSource : {
							transport : {
								read : {
									url : "http://localhost:8000/BudgetFinale/api/Budget/",
									dataType : "json"
								}
							},
							sort : {
								field : "order",
								dir : "asc"
							},
							group : {
								field : "year"
							}
						},
						legend : {
							position : "top"
						},
						title : {
							text : "1024x768 screen resolution trends"
						},
						seriesDefaults : {
							type : "donut",
							startAngle : 270
						},
						series : [ {
							field : "share",
							categoryField : "resolution",
							visibleInLegendField : "visibleInLegend",
							padding : 10
						} ],
						tooltip : {
							visible : true,
							template : "#= dataItem.resolution #: #= value #% (#= dataItem.year #)"
						}
					});
}
