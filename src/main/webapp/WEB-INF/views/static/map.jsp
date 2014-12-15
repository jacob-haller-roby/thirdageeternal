

<div id="mapDiv" style="position: relative">
	<div id="baseMapDiv" style="position: absolute;">
		<img src="resources/images/map.jpg" name="baseMap" class="fit-to-div"
			width=1022 height=574>
	</div>
	
	<div id="aOverlayDiv" style="position: absolute; z-index: 10"
		hold=false>
		<img src="resources/images/aristocracyOverlay.png" name="aOverlay"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	<div id="sOverlayDiv" style="position: absolute; z-index: 10"
		hold=false>
		<img src="resources/images/summonerOverlay.png" name="aOverlay"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	<div id="bOverlayDiv" style="position: absolute; z-index: 10"
		hold=false>
		<img src="resources/images/breakerOverlay.png" name="aOverlay"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	<div id="mOverlayDiv" style="position: absolute; z-index: 10"
		hold=false>
		<img src="resources/images/mysticOverlay.png" name="aOverlay"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	<div id="dOverlayDiv" style="position: absolute; z-index: 10"
		hold=false>
		<img src="resources/images/denizenOverlay.png" name="aOverlay"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	<div id="transparentOverlay" style="position: absolute; z-index: 20">
		<img src="resources/images/map.jpg" name="transparentLayer"
			class="fit-to-div" width=1022 height=574 usemap="#factionMap">
	</div>
	
	<div id="transparentOverlayPush" style="position: relative; opacity: 0;">
		<img src="resources/images/map.jpg" name="transparentLayer"
			class="fit-to-div" width=1022 height=574>
	</div>
	
	
	<map name="factionMap" id="factionMap">
		<area alt="" title="aristocracy" href="#/game/factions/aristocracy" shape="poly" onclick="unstick('#aOverlayDiv');"
			coords="317,123,312,102,312,83,334,67,362,51,458,38,473,31,519,31,538,33,592,39,603,43,641,40,656,44,691,65,706,102,701,133,687,159,685,186,671,204,665,245,639,249,627,262,627,278,640,300,638,329,643,344,643,366,640,369,608,361,594,343,613,312,617,305,608,285,577,287,562,284,548,272,543,260,541,251,537,236,524,222,502,216,457,181,423,157,400,133,364,116" />
		<area alt="" title="breaker" href="#/game/factions/breaker" shape="poly" onclick="unstick('#bOverlayDiv');"
			coords="646,394,645,369,636,324,644,303,626,281,628,261,638,250,665,245,675,235,675,214,684,198,690,183,704,172,708,166,715,111,725,99,735,97,749,101,755,99,758,80,756,42,734,34,719,4,1021,3,1022,111,1011,121,1004,136,960,162,888,226,869,272,852,307,835,326,809,358,795,384,773,400,745,414,692,409,664,408" />
		<area alt="" title="mystic" href="#/game/factions/mystic" shape="poly" onclick="unstick('#mOverlayDiv');"
			coords="165,177,151,152,154,120,137,91,143,61,161,30,191,17,222,20,251,39,264,58,285,97,302,141,309,158,313,169,254,185,235,153,225,147,209,150,200,163,191,175" />
		<area alt="" title="denizen" href="#/game/factions/denizen" shape="poly" onclick="unstick('#dOverlayDiv');"
			coords="145,184,191,175,216,188,233,188,248,180,252,183,311,168,313,165,322,184,317,194,305,201,306,210,320,229,337,249,335,261,331,274,318,289,284,302,270,313,264,327,265,339,282,350,324,350,349,356,360,353,360,360,288,373,273,391,280,418,298,450,316,477,330,503,322,526,285,532,261,515,213,440,193,386,179,357,158,341,140,312,123,263,122,227,138,189" />
		<area alt="" title="summoner" href="#/game/factions/summoner" shape="poly" onclick="unstick('#sOverlayDiv');"
			coords="322,125,362,117,400,133,424,160,502,214,503,220,538,245,545,267,548,273,570,287,582,289,592,286,615,300,596,341,600,356,595,362,549,378,550,387,534,399,531,410,532,420,527,423,513,423,505,412,497,413,501,434,487,440,491,471,499,490,495,559,490,568,489,573,439,572,424,550,397,509,394,500,387,487,384,478,407,450,412,446,412,431,403,403,400,383,403,350,390,347,361,354,347,355,327,348,281,349,267,339,268,327,276,305,293,300,327,285,330,272,372,262,405,266,410,259,405,238,408,224,392,202,377,194,363,166,374,157,374,152,358,150,350,159,325,159,313,141,316,131" />
	</map>

</div>
<div id="factiondesc" class="blog-background top-buffer">
{{outlet}}</div>