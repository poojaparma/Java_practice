$(document).ready(function() {
	
	// For Show login Info
	$('#user').empty();
	$('#user').html($.cookie('user'))
	
	var bdprofile = $.cookie('user');
	if((!bdprofile) || (bdprofile== "null")){
		window.location.href = "login.html"
	}
	
	// Logout 
	$('body').on('click','.logout', function(){
		//$.removeCookie($.cookie('bdprofile'));
		var cookies = document.cookie.split(";");
		for(var i=0; i < cookies.length; i++) {
			var equals = cookies[i].indexOf("=");
			var name = equals > -1 ? cookies[i].substr(0, equals) : cookies[i];
			document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
		}
		//$.cookie('bdprofile', null)
		window.location.href = "login.html"
	});
	
	// Set Left Content Height
	setTimeout(function(){
			var height = ($('#wrap').height());
			$('#left').css('height',height-120);
			$('#left .treeSection').css('height',height-120);
			$('#left .treeSection .k-tabstrip-wrapper').css('height',height-120);
			$('#left .treeSection #tabsData').css('height',height-120);	
	}, 5000);
	
	
	
	// Initially Hide the popUp
	$('#treePopup').hide();
	
	// Hide Popup
	$('body').on('click','.hidePopup', function(){
		$('#treePopup').fadeOut();
	});
	
	// Initially hide the Grid Section
	$('#gridRow').hide();
	$('#physicalsvg').hide();
	// When swith the tab, based in that hide/show the grids
	$('#tabsDataUl li').on('click', function(){
		var clickedTab = $(this).attr('id');
		if((clickedTab.indexOf('circuitsTab')!=-1)){
			$('#gridRow').show();
			$('#alarmCounts').show();
			$('#physicalsvg').hide();			
			document.getElementById('topologyIframe').src= 'topology.html';
		}else{
			$('#alarmCounts').show();
			$('#physicalsvg').hide();
			$('#gridRow').hide();
			document.getElementById('topologyIframe').src= 'topology.html';
		}
		
		if(clickedTab.indexOf('physicalTab')!=-1){
			$('#alarmCounts').hide();
			$('#physicalsvg').show();
			
			document.getElementById('topologyIframe').src= 'physical_view.html?ring=a';
		}
	});
	
	$(document).keyup(function(e) {
  		if (e.keyCode == 27) { 
		console.log('key')
			$('#treePopup').hide();
		}  
	});
	
	// Last Login
	var d = new Date();
	var hrs = Math.floor((Math.random() * 23) + 1);
	var mins= Math.floor((Math.random() * 59) + 1);
	var days= Math.floor((Math.random() * 3) + 1);
	d.setDate(d.getDate() - days);
	d.setMinutes(d.getMinutes() - mins);	
	d.setHours(d.getHours() - hrs);
	var lDate = d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+" - "+d.toDateString();
	$('#date').text(lDate);

	
});

function doLogin(){
	console.log(document.cookie)
	var bdprofiles = getCookie("bdprofile");
	console.log(bdprofiles);
}


