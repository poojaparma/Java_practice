 $(document).ready(function () {
                    var crudServiceBaseUrl = "http://localhost:8000/RestClient/rest/ctc",
				//	var crudServiceBaseUrl = "http://localhost:8000/RestClient/rest/json/metallica",
                        dataSource = new kendo.data.DataSource({
                            transport: {
                                read:  {
									contentType: "application/json; charset=utf-8",
            type: "GET",
            dataType: "json",
            url: crudServiceBaseUrl+"/get",
                                 
							
                                },
								
                                update: {
								
									 type: "POST",
									//   data: JSON.stringify(options),
                                   url: crudServiceBaseUrl+"/post",
								     dataType: "json",
									 contentType: 'application/json', // content type sent to server"
                    
                                },
                                destroy: {
                                  url: crudServiceBaseUrl+"/get",
                    dataType: "json"
                                },
                                create: {
                                  url: crudServiceBaseUrl+"/post",
                    dataType: "json",
					 contentType: 'application/json'
					
                                },
                                parameterMap: function(options, operation) {
                           
								  if (operation !== "read" && options.models) {
                                if(operation=='update'){
									var result = {};
                  for (var i = 0; i < options.models.length; i++) {
                      var order = options.models[i];
                      for (var member in order) {
                       
					   result[member] = order[member];
                      }
                  }
				  return JSON.stringify(result);
								}
								
								  }
									
									
         return JSON.stringify(options); 							
				
				
								
									  
									  

						
							
                                }
                            },
                            batch: true,
							autosync: false,
                            pageSize: 20,
                            schema: {
								type:"json",
                                model: {
                                    id: "dateI",
                                    fields: {
                                        dateI: { editable: true, nullable: false },
                                        DailyExpenditure: {  editable: true, nullable: false },
                                        MedicalExpenses: { editable: true, nullable: false },
                                        KidExpenses: {editable: true, nullable: false },
                                        TravellingExpenses: {editable: true, nullable: false }
                                    }
                                }
                            }
                        });



$(document).ready(function() {
    var grid = $("#familygrid").kendoGrid({
        dataSource: dataSource,
            pageSize: 10,
        
		toolbar: ["create"],
        dataBound: iconChange,
        detailInit: detailInit,
        detailTemplate: kendo.template($("#familygridTemplate").html()),
        scrollable: true,
		resizable: true,
		navigatable: true,
		sortable:true,
        filterable: {
            operators: {
                string: {
                    startswith: "Starts with",
                    eq: "Is equal to",
                    neq: "Is not equal to"
                }
            }
        },
        navigatable: true,
        pageable: {
            input: true,
            numeric: true
        },
		selectable:"row",
		columns:[
			{
				"field":"dateI",
				"title":"Date"
			},
			{
				"field":"dailyExpenditure",
				"title":"DailyExpenditure"
			},
			{
				"field":"medicalExpenses",
				"title":"Medical Expenses"
			},
			{
				"field":"kidExpenses",
				"title":"Kid Expenses"
			},
			{
				"field":"travellingExpenses",
				"title":"Outing"
			},
			{
				"field":"vehicleExpenses",
				"title":"vehicle Expenses"
			},
			{
				"field":"billPayments",
				"title":"Bill Payments"
			},
			{
				"field":"rentEmi",
				"title":"Rent EMI"
			},
			{
				"field":"cosmeticsItems",
				"title":"cosmetics"
			},
			{
				"field":"officeExpenses",
				"title":"Office Expenses"
			},
			 { command: ["edit", "destroy"], title: "&nbsp;", width: "250px" }
		],
		editable: "popup"
		 
    }).data("kendoGrid");
		grid.bind('change', selectRow)
   // grid.resize(true);
function selectRow(e){
		//console.log(e);
		 var selectedRows = this.select();
		var dataItem = this.dataItem(selectedRows[0]);
		dataItem.sourceSite="IMLEUSGA100";
	dataItem.destinationSite="IMLEUSGA008";
		
		if(document.getElementById('topologyIframe')){
			document.getElementById('topologyIframe').contentWindow.showCircuit(dataItem);
		}
	}
    // Place the Icon	
    function iconChange(e) {
        $('#familygrid .k-master-row td').each(function() {
            if ($(this).text() == 'Major') {
                $(this).html('<img src="images/major.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'Warning') {
                $(this).html('<img src="images/warning.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'critical') {
                $(this).html('<img src="images/critical.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'info') {
                $(this).html('<img src="images/info.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'close') {
                $(this).html('<img src="images/close.png" class="gridIcon" />' + $(this).text());
            }
        });
		
    }

    // Collapsible method
    function detailInit(e) {}


});
 });
 function circuitsTreeRowSelect(sourceSite, destinationSite, circuitSize, circuitType){

	var grids = $('#familygrid').data('kendoGrid');
	/*
	var ds = grids.dataSource;	
	var view = kendo.data.Query.process(ds.data(), {
                filter: ds.filter(),
                sort: ds.sort()
            })
            .data;
	
	var index = -1;
	// find the index of the matching dataItem
	for (var x = 0; x < view.length; x++) {
		if ((view[x].sourceSite == sourceSite) && (view[x].destinationSite == destinationSite) && (view[x].circuitSize == circuitSize)) {
			index = x;
			break;
		}
		else if(((sourceSite == "IMLEUSGA100") && (destinationSite == "IMLEUSGA008") && (circuitType == "OCHCC")) || ((sourceSite == "IMLEUSOH101") && (destinationSite == "IMLEUSOH007") && (circuitType == "OCHCC")))
		{
			index =0;
		}
		else if(((sourceSite == "IMLEUSGA100") && (destinationSite == "IMLEUSGA008") && (circuitType == "Wave")) || ((sourceSite == "IMLEUSOH101") && (destinationSite == "IMLEUSOH007") && (circuitType == "Wave")))
		{
			index =9;
		}
	}
	
	if (index === -1) {
		return;
	}
	
	
	var page = Math.floor(index / grids.dataSource.pageSize());    
	var targetIndex = index - (page * grids.dataSource.pageSize()) + 1;    
	//page is 1-based index    
	grids.dataSource.page(++page);
	//grid wants a html element. tr:eq(x) by itself searches in the first grid!    
	var row = $("#circuitsGrid").find("tr:eq(" + targetIndex + ")");
	grids.select(row);		
	
*/


	grids.dataSource.filter({
		"logic":"or",
		"filters":[
			{ field: "medicalExpenses", operator: "neq", value: sourceSite },
			{ field: "travellingExpenses", operator: "neq", value: destinationSite },
			{ field: "vehicleExpenses", operator: "neq", value: circuitSize },
			{ field: "billPayments", operator: "neq", value: circuitType }
		]
	});
	//grids.dataSource.filter({});

}
function circuitsTreeRingSelect(ring){
	var grids = $('#familygrid').data('kendoGrid');
	console.log(ring);
	
	if(typeof(ring)== 'undefined'){
		grids.dataSource.filter({
			"logic":"and",
			"filters":[
				{ field: "dateI", operator: "neq", value: ring },
			]
		});

	}else{
		grids.dataSource.filter({});
	}
	filter.filters.push(
            	{ field: "dateI", operator: "neq", value: subNodesArray[i]  }
        	);
			
			 grids.dataSource.filter([filter]);
		
}

function netwrokTreeRowSelect(subNodesArray){
	console.log(subNodesArray)
	var grids = $('#familygrid').data('kendoGrid');
	for(var i=0; i<subNodesArray.length;i++){
		//console.log(subNodesArray[i])
		if(subNodesArray[i].indexOf('IM')!=-1){
			grids.dataSource.filter({
				"logic":"and",
				"filters":[
					{ field: "dateI", operator: "neq", value: subNodesArray[i] }
				]
			});
			
		}
		
		filtering = true;
			 var filter = {
				logic: "and",
				filters: []
			};  
        	filter.filters.push(
            	{ field: "dateI", operator: "neq", value: subNodesArray[i]  }
        	);

			 grids.dataSource.filter([filter]);
		
}
	//grids.dataSource.filter({});
} 
