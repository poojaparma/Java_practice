$(document).ready(function() {
	$("#tabsData").kendoTabStrip({
		animation:  {
			open: {
				effects: "fadeIn"
			}
		}
	}).data("kendoTabStrip");
	setTimeout(function(){
			var height = ($('#wrap').height());	
			
			$('#left').css('height',height-150);
			$('#left .treeSection').css('height',height-150);
			$('#left .treeSection .k-tabstrip-wrapper').css('height',height-150);
			$('#left .treeSection #tabsData').css('height',height-150);	
	}, 5000)
});
