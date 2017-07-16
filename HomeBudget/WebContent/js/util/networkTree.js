$(document).ready(function() {
	
    var viewModel = new kendo.data.HierarchicalDataSource({
        transport: {
            read: {
                url: "data/networkTree.json",
                dataType: "json"
            }
        },
        schema: {
            model: {
                children: "SubNodes",
            }
        }
    });
	
	var treeview = $("#networkTree").kendoTreeView({
        dataSource: viewModel,
		selected:true,
        dataTextField: ["Name"],
        loadOnDemand: false,
		template: kendo.template($("#networkTreeTemplate").html()),
       /* checkboxes: {
            checkChildren: true,
            name: "checkedItems[]"
        },*/
        animation: {
            expand: {
                effects: "fadeIn expandVertical",
                duration: 100
            }
        },
		select:treeSelect,

    }).data("kendoTreeView");
	treeview.resize(true);
	
	// Expand First Element
	setTimeout(function(){
		$("#networkTree").data("kendoTreeView").expand("li:first");
		$("#networkTree").data("kendoTreeView").expand("li:first li:first");
	}, 300);
	//treeview.bind("expand", treeSelect);	
	
	
	$("#networkTree").dblclick( function () {

		var treeView = $("#networkTree").data("kendoTreeView");	
		var selectedNode = treeView.select(), 
		dataItem = treeView.dataItem(selectedNode);
		var root = treeView.dataItem(selectedNode[0]);
		var node = root.info;
		
	if(typeof(node) != "undefined"){
		 $('#treePopup').fadeIn();
		 $('.cardSection').hide();
		 
		 // Hide Sites
		 if(typeof(node.totalSites) == "undefined"){
			 $('.sitesHide').hide();
		 }else{
			 $('.sitesHide').show();
		 }
		 
		 if(typeof(node.totalNe) == "undefined"){
			 $('.nesHide').hide();
		 }else {
			 $('.nesHide').show();
		 }
		 
		 var groupId = node.groupId;
		 var totalSites = node.totalSites;
		 var totalNe = node.totalNe;
		 var neAlarm = node.neAlarm;
		 var criticalAlarm = node.criticalAlarm;
		 var majorAlarm = node.majorAlarm;
		 var minorAlarm = node.minorAlarm;
		 var infoEvent = node.infoEvent;
		 var inService = node.inService;
		 var outofService = node.outofService;
		 var underMaintenance= node.underMaintenance;
		 var preProvisioned = node.preProvisioned;
		 var neInitialization = node.neInitialization;
		 var neSync = node.neSync;
		 var desc = node.desc;
		 
	 	 if(typeof(node.cardNumber) != "undefined"){
			 var cardNumber = node.cardNumber;
			 var cardType = node.cardType;
			 var position = node.position;
			 var ituChannel = node.ituChannel;
			 $('.cardSection').show();
			 $('#cardNumber').val(cardNumber);
			 $('#cardType').val(cardType);
			 $('#position').val(position);
			 $('#ituChannel').val(ituChannel);						
		 }
		 
		 $('#groupId').val(groupId);
		 $('#totalSites').val(totalSites);
		 $('#totalNe').val(totalNe);
		 $('#desc').val(desc);
		 $('#criticalAlarm').val(criticalAlarm);
		 $('#majorAlarm').val(majorAlarm);
		 $('#minorAlarm').val(minorAlarm);
		 $('#inService').val(inService);
		 $('#outofService').val(outofService);
		 $('#preProvisioned').val(preProvisioned);
		 $('#neInitialization').val(neInitialization);
		}
	});
	
	
	var element = document.getElementById('networkTree');
var hammertime = Hammer(element).on("doubletap", function(event) {
		console.log('double')
		var treeView = $("#networkTree").data("kendoTreeView");	
		var selectedNode = treeView.select(), 
		dataItem = treeView.dataItem(selectedNode);
		var root = treeView.dataItem(selectedNode[0]);
		var node = root.info;
		
	if(typeof(node) != "undefined"){
		 $('#treePopup').fadeIn();
		 $('.cardSection').hide();
		 
		 // Hide Sites
		 if(typeof(node.totalSites) == "undefined"){
			 $('.sitesHide').hide();
		 }else{
			 $('.sitesHide').show();
		 }
		 
		 if(typeof(node.totalNe) == "undefined"){
			 $('.nesHide').hide();
		 }else {
			 $('.nesHide').show();
		 }
		 
		 var groupId = node.groupId;
		 var totalSites = node.totalSites;
		 var totalNe = node.totalNe;
		 var neAlarm = node.neAlarm;
		 var criticalAlarm = node.criticalAlarm;
		 var majorAlarm = node.majorAlarm;
		 var minorAlarm = node.minorAlarm;
		 var infoEvent = node.infoEvent;
		 var inService = node.inService;
		 var outofService = node.outofService;
		 var underMaintenance= node.underMaintenance;
		 var preProvisioned = node.preProvisioned;
		 var neInitialization = node.neInitialization;
		 var neSync = node.neSync;
		 var desc = node.desc;
		 
	 	 if(typeof(node.cardNumber) != "undefined"){
			 var cardNumber = node.cardNumber;
			 var cardType = node.cardType;
			 var position = node.position;
			 var ituChannel = node.ituChannel;
			 $('.cardSection').show();
			 $('#cardNumber').val(cardNumber);
			 $('#cardType').val(cardType);
			 $('#position').val(position);
			 $('#ituChannel').val(ituChannel);						
		 }
		 
		 $('#groupId').val(groupId);
		 $('#totalSites').val(totalSites);
		 $('#totalNe').val(totalNe);
		 $('#desc').val(desc);
		 $('#criticalAlarm').val(criticalAlarm);
		 $('#majorAlarm').val(majorAlarm);
		 $('#minorAlarm').val(minorAlarm);
		 $('#inService').val(inService);
		 $('#outofService').val(outofService);
		 $('#preProvisioned').val(preProvisioned);
		 $('#neInitialization').val(neInitialization);
		}
	});
	
	
	$("#networkTree").click( function () {

		var treeView = $("#networkTree").data("kendoTreeView");	
		var selectedNode = treeView.select(), 
		dataItem = treeView.dataItem(selectedNode);
		var root = treeView.dataItem(selectedNode[0]);
		//var node = root.info;
		if(document.getElementById('topologyIframe')){
			document.getElementById('topologyIframe').contentWindow.nodeSelected({name:root.Name});
		}
	});
	function treeSelect(k){
	    var root = this.dataItem(k.node);
		var site = root.Name;
		var subNodes = root.SubNodes;
		var subNodesArray = [];
		subNodesArray.push(root.Name)
		var subNodesValue = nodeInsertion(root,subNodesArray);
		//netwrokTreeRowSelect(subNodesValue);
	}
});


	function nodeInsertion(root, subNodesArray){
		var subNodes = root.SubNodes;
		subNodesLength = subNodes.length;
		
		if(subNodesLength == 0){
			return subNodesArray;
		}else {
			for(var i=0; i<subNodesLength;i++){
				subNodesArray.push(subNodes[i].Name)
			}
			if(subNodes.length==0){
				root = subNodes;
			}else{
				for(var j=0;j<subNodes.length;j++){
					root = subNodes[j];
					nodeInsertion(root,subNodesArray)
				}
			}
			return subNodesArray;	
		}
	}


	


