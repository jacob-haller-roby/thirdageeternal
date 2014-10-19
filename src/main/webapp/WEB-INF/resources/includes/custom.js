jqueryInit = function() {

	$('.sidebar a').click(function() {
		$(this).siblings('a').removeClass('active');
		$(this).addClass('active');
	});
};

mapSetup = function(){
	$('#transparentOverlay').addClass('transparent');
	$('#aOverlayDiv').hide();
};

$(window).load(function() {
	
	mapSetup();
	
	
	
	$('img[usemap]').rwdImageMaps();

	if ($('#factionMap')) {
		$('#factionMap area').each(function() {
		
			$(this).mouseover(function() {
				$('#aOverlayDiv').show();

			});

			

		});
	}
	
	if($('#aristocracyMap')) {
		$('#factionMap area').each(function() {
			$(this).mouseover(function() {
				$('#aOverlayDiv').show();

			});
			$(this).mouseout(function() {

				$('#aOverlayDiv[hold=false]').hide();

			});
		});
	}
});