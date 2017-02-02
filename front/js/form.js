$( function() {
	populateClubListBox();

    $( "#club" ).selectmenu();
 	
 	$( "#coach" ).selectmenu();
 	$( "#coach" ).selectmenu( "disable" );

 	$( "#activity" ).selectmenu();
 	$( "#activity" ).selectmenu( "disable" );

 	$( "#room" ).selectmenu();
 	$( "#room" ).selectmenu( "disable" );

 	$( "#btn-submit" ).prop('disabled', true);

 	$("#unavailable").hide();
 	$("#available").hide();
 	$("#thank-you").hide();
 	
 	$( "#coach" ).prop('disabled', true);
	$( "#activity" ).prop('disabled', true);
	$( "#room" ).prop('disabled', true);	

	$(".datepicker").datepicker({ 
		showOn: 'button', 
		buttonImageOnly: true, 
		buttonImage: 'http://www.superreturnme.com/img/icon/icon-outlook.png',
		dateFormat: "yy-mm-dd",
		minDate: 0,
		monthNames: [ "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" ]
	});
	$( ".datepicker" ).datepicker( "option", "disabled", true );

 	var selectedClub = '';
 	var previousClub = '';
 	window.clubName = '';
 	$( "#club" ).on('selectmenuchange', function() {
 		previousClub = selectedClub;
    	selectedClub = $(this).val();
    	
    	if (selectedClub == '') {
    		$( ".datepicker" ).datepicker( "option", "disabled", false );
        	$( "#coach" ).selectmenu( "disable" );
 			$( "#activity" ).selectmenu( "disable" );
 			$( "#room" ).selectmenu( "disable" );
 			$( "#btn-submit" ).prop('disabled', true);
 			clubName = '';
    	} else {

    		if(previousClub != selectedClub) {
    			window.loaded = false;

    			populateActivityListBox(selectedClub);
		    	populateCoachListBox(selectedClub);
		    	populateRoomListBox(selectedClub);

    			function wailForLoading() {
				    if(window.loaded == false) {
				    	window.setTimeout(wailForLoading, 100);
				    } else {
				    	clubName = $('#club option[value=' + selectedClub + ']').text();

				    	$( ".datepicker" ).datepicker( "option", "disabled", false );
			        	$( "#coach" ).selectmenu( "enable" );
			 			$( "#activity" ).selectmenu( "enable" );
			 			$( "#room" ).selectmenu( "enable" );
			 			$( "#btn-submit" ).prop('disabled', false);
				    }
				}
				wailForLoading();
    		}		
    	}
	});

	$( "#btn-submit" ).click(function() {
		submit();
	});

	$( "#btn-booking" ).click(function() {
		$("#available").dialog( "close" );
		 $( "#thank-you" ).dialog({
      		modal: true,
      		width: 450,
      		buttons: {
        		Ok: function() {
          			$( this ).dialog( "close" );
        		}
      		}
    	});
	});

 } );


/* Get the list of suppliers */
function populateClubListBox() {

	$.ajax({ 
		async: false,
	    type: 'GET', 
	    url: 'http://localhost:8080/resamania/suppliers', 
	    data: '', 
	    dataType:'json',
	    success: function (data) { 

            var items = [];
            for (var i=0; i <= data.length - 1; i++) {
         		items += '<option value=\"' + data[i].id + '\">' + data[i].name + '</option>';
         	}
         	$( "#club" ).append(items);
	    }
	});
}

/* Get the list of activity proposed by a given supplier */
function populateActivityListBox(supplierId) {

	$.ajax({ 
		async: false,
	    type: 'GET', 
	    url: 'http://localhost:8080/resamania/activities?supplierId=' + supplierId, 
	    data: '', 
	    dataType:'json',
	    success: function (data) { 

            var items = [];
            for (var i=0; i <= data.length - 1; i++) {
         		items += '<option value=\"' + data[i].id + '\">' + data[i].name + '</option>';
         	}
         	$( "#activity" ).append(items);
	    }
	});
}

/* Get the list of coach proposed by a given supplier */
function populateCoachListBox(supplierId) {

	$.ajax({ 
		async: false,
	    type: 'GET', 
	    url: 'http://localhost:8080/resamania/coachs?supplierId=' + supplierId, 
	    data: '', 
	    dataType:'json',
	    success: function (data) { 

            var items = [];
            for (var i=0; i <= data.length - 1; i++) {
         		items += '<option value=\"' + data[i].id + '\">' + data[i].surname + '</option>';
         	}
         	$( "#coach" ).append(items);
	    }
	});
}

/* Get the list of room proposed by a given supplier */
function populateRoomListBox(supplierId) {

	$.ajax({ 
		async: false,
	    type: 'GET', 
	    url: 'http://localhost:8080/resamania/rooms?supplierId=' + supplierId, 
	    data: '', 
	    dataType:'json',
	    success: function (data) { 
            var items = [];
            for (var i=0; i <= data.length - 1; i++) {
         		items += '<option value=\"' + data[i].id + '\">' + data[i].name + '</option>';
         	}
         	$( "#room" ).append(items);
         	window.loaded = true;
	    }
	});
}


function submit() {
	var serializedForm = $( "#booking-form" ).serialize();
	console.log(serializedForm);
	checkBooking(serializedForm);
}

function checkBooking(serializedForm) {
	$.ajax({ 
		async: true,
	    type: 'GET', 
	    url: 'http://localhost:8080/resamania/booking?' + serializedForm, 
	    data: '', 
	    dataType:'json',
	    success: function (data) { 
	    	console.log(data);

	    	if( !$.isArray(data) || !data.length ) {
			    $( "#unavailable" ).dialog({
		      		modal: true,
		      		buttons: {
		        		Ok: function() {
		          			$( this ).dialog( "close" );
		        		}
		      		}
		    	});
		    	return;
			} else {
				var table = showBookingAvailability(data);
				$( "#available" ).dialog({
      				modal: true,
		      		width: 1000,
		      		title: "Votre réservation au club " + clubName,
		      		close: function( event, ui ) {
		      			table.destroy();
		      		}
		    	});
		    	
			}
            
	    }
	});
}

function showBookingAvailability(data) {

	var table = $('#availabilities').DataTable({
		searching: false,
		ordering:  false,
		data: data,
		columnDefs : [
			{ visible: false, targets: [0] },
			{ className: 'dt-body-center', targets: [ 0,1,2,3,4,5,6,7,8 ] },
			{ 
				targets: 9,
         		searchable: false,
         		orderable: false,
         		className: 'dt-body-center',
         		'render': function (data, type, full, meta) {
             		return '<input type="checkbox" name="inscription[]" value="' + $('<div/>').text(data).html() + '">';
         		}
     		}
		],
		select: {
            style:    'os',
            selector: 'td:first-child'
        },
    	columns: [
	        { data: 'id' },
	        { data: 'activityName' },
	        { data: 'roomName' },
	        { data: 'coachName' },
	        { data: 'beginDate' },
	        { data: 'beginHour' },
	        { data: 'duration' },
	        { data: 'nbPlace' },
	        { data: 'nbPlaceAvailable' }
	    ]
	});

	return table;
}