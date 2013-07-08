jsPlumb.ready(function() {
	var i = 0;
	jsPlumb.Defaults.PaintStyle = {
		lineWidth : 5,
		strokeStyle : 'rgba(100,200,200,0.5)'
	};
	jsPlumb.Defaults.Connector = [ "Flowchart", {
		gap : 10,
		cornerRadius : 5,
	} ];
	
	
	// this is the paint style for the connecting lines..
	var connectorPaintStyle = {
		lineWidth:4,
		strokeStyle:"#deea18",
		joinstyle:"round",
		outlineColor:"#EAEDEF",
		outlineWidth:2
	},
	// .. and this is the hover style. 
	connectorHoverStyle = {
		lineWidth:4,
		strokeStyle:"#2e2aF8"
	},
	endpointHoverStyle = {fillStyle:"#2e2aF8"},
	sourceEndpoint = {
		endpoint : "Dot",
		paintStyle : {
			strokeStyle : "#225588",
			fillStyle : "transparent",
			radius : 7,
			lineWidth : 2
		},
		isSource : true,
		connector : [ "Flowchart", {
			stub : [ 40, 60 ],
			gap : 10,
			cornerRadius : 5,
			alwaysRespectStubs : true
		} ],
		connectorStyle : connectorPaintStyle,
		hoverPaintStyle : endpointHoverStyle,
		connectorHoverStyle : connectorHoverStyle,
		dragOptions : {},
		overlays : [ [ "Label", {
			location : [ 0.5, 1.5 ],
			label : "Drag",
			cssClass : "endpointSourceLabel"
		} ] ]
	};

	$('#container').dblclick(function(e) {
		var newState = $('<div>').attr('id', 'state' + i).addClass('item');

		var title = $('<div>').addClass('title').text('State ' + i);
		var connect = $('<div>').addClass('connect');

		newState.css({
			'top' : e.pageY,
			'left' : e.pageX
		});

		jsPlumb.makeTarget(newState, {
			anchor : 'Top'
		});

		jsPlumb.makeSource(connect, {
			parent : newState,
			anchor : 'Right',

		});

		newState.append(title);
		newState.append(connect);

		jsPlumb.draggable(newState, {
			containment : 'parent'
		});

		newState.dblclick(function(e) {
			jsPlumb.detachAllConnections($(this));
			$(this).remove();
			e.stopPropagation();
		});

		$('#container').append(newState);

		i++;
	});
});