jqueryInit = function() {

	$('.sidebar a').click(function() {
		$(this).siblings('a').removeClass('active');
		$(this).addClass('active');
	});
};

mapSetup = function() {
	$('#transparentOverlay').addClass('transparent');
	$('#aOverlayDiv').hide();
	$('#sOverlayDiv').hide();
	$('#bOverlayDiv').hide();
	$('#dOverlayDiv').hide();
	$('#mOverlayDiv').hide();

	$('img[usemap]').rwdImageMaps();
	
	if ($('#factionMap')) {
		$('#factionMap area[title=aristocracy]').each(function() {

			$(this).mouseover(function() {
				$('#aOverlayDiv').show();

			});

			$(this).mouseout(function() {
				$('#aOverlayDiv[hold=false]').hide();

			});

		});

		$('#factionMap area[title=summoner]').each(function() {

			$(this).mouseover(function() {
				$('#sOverlayDiv').show();

			});

			$(this).mouseout(function() {
				$('#sOverlayDiv[hold=false]').hide();

			});

		});

		$('#factionMap area[title=mystic]').each(function() {

			$(this).mouseover(function() {
				$('#mOverlayDiv').show();

			});

			$(this).mouseout(function() {
				$('#mOverlayDiv[hold=false]').hide();

			});

		});

		$('#factionMap area[title=denizen]').each(function() {

			$(this).mouseover(function() {
				$('#dOverlayDiv').show();

			});

			$(this).mouseout(function() {
				$('#dOverlayDiv[hold=false]').hide();

			});

		});

		$('#factionMap area[title=breaker]').each(function() {

			$(this).mouseover(function() {
				$('#bOverlayDiv').show();

			});

			$(this).mouseout(function() {
				$('#bOverlayDiv[hold=false]').hide();

			});

		});
	}
};

unstick = function(sticky) {
	$('#aOverlayDiv').attr('hold', false);
	$('#aOverlayDiv').hide();
	$('#bOverlayDiv').attr('hold', false);
	$('#bOverlayDiv').hide();
	$('#mOverlayDiv').attr('hold', false);
	$('#mOverlayDiv').hide();
	$('#dOverlayDiv').attr('hold', false);
	$('#dOverlayDiv').hide();
	$('#sOverlayDiv').attr('hold', false);
	$('#sOverlayDiv').hide();
	$(sticky).show();
	$(sticky).attr('hold', true);
};

$(window).load(function() {

	mapSetup();

});