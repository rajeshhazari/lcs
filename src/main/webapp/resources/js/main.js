

$(document).ready(function(){
	var testJson = true;
	 //var json = {"setOfStrings" : [{"value":"sungard"},{"value":"garden"},{"value":"bosun"}]}; 
	//var json = {value : "sungard"};
	var json = '';

	$("#textArea").on('change keyup paste', function() {
	  if(($('#error').css('display') == 'visible') || ($('#error').css('display') == 'absolute')|| ($('#error').css('display') == 'block')){
			$("#error").hide();
			$("#error").html("");
			$('#statusMessage').hide();
			console.log("error");
		}
		
	});
$('.submitbutton').click(function() {
	var obj , data;
if($('#textArea').val() != ''){
	json = $('#textArea').val();
	try{
		JSON.parse(json);
		obj = JSON.parse(json);
		data = JSON.stringify(obj);
		}catch(e){
			$("#error").show();
			$("#error").html("Json parsing error occured, Please enter valid json!")
			data='';
			$('#textArea').focus();
			return;
		}
	testJson = false;
}else{
	console.log("using sample json");
	display("Please enter valid json")
	$("#error").show();
	$("#error").html("Please enter valid json")
	data='';
	return;
}

$.ajax({
	'type': 'POST',
	  	  'headers': { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
    'url': 'getSubString',
	'data' : data,
	'dataType' : 'json',
	success : function(data) {
		console.log("SUCCESS: ", data);
		$("#error").hide();
		$("#error").html("");
		display(data);
	},
	beforeSend:function(e){
		console.log("before");
		$("#statusMessage").hide();
	},
	error : function(e) {
		$('#statusMessage').hide();
		console.log("ERROR: ", e);
		$("#error").show();
		$("#error").html("error occured ")
	},
	done : function(e) {
		$("#error").hide();
		$("#error").html("");
		console.log("DONE");
	},
	failure :function(e){
		$('#statusMessage').hide();
		$("#error").show();
		$("#error").html("unknown error occured :: "+e);
		console.log("failure");
	},  statusCode: {
	    400: function() {
	    	$("#error").show();
			$("#error").html("error occured :: Please enter valid json, " +
					"			Please enter json in below format :: " +
					"            {\"setOfStrings\" : \"[\{\"value\" : \"string1\"}," +
					"             {\"value\" : \"string2\"}]\"}");
	    	console.log( "bad data" );
	      }
	    }


});
});
function display(data) {
	if(testJson){
	//var json = " Response using test json :: <pre>"+ JSON.stringify(data, null, 4) + "</pre>";
	}else{
		var json = " Response :: <pre>"+ JSON.stringify(data, null, 4) + "</pre>";
	}
	$('#statusMessage').html(json);
	$('#statusMessage').show();
}
});
