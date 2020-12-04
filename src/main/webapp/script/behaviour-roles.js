var printResult = function(transport){
		var result = 
			"Status : " + transport.status
			+ "\n"
			+ "\n"
			+ "Json-Result:"
			+ "\n" + transport.responseText;
		alert(result);
};



var addErrors = function(transport){
	var json = transport.responseText.evalJSON();
	
	var error = "<label>Default ErrorConverter and Errorhandler Info:</label> </br></br>"
	+ "failure: " + json.failure +"</br>"
	+ "status : + " + transport.status +"</br>"
	+"</br>"
	+"Spring Errorhandling: </br>"
	+ "hasGlobalErrors : " + json.hasGlobalErrors +"</br>"
	+ "</br>"
	+ "hasFieldErrors : " + json.hasFieldErrors +"</br>";
	if(json.fielderrors.birthday)
		error = error + "birthday : " + json.fielderrors.birthday +"</br>";
	if(json.fielderrors.placeofbirth)
		error = error + "placeofbirth : " + json.fielderrors.placeofbirth +"</br>";
	
	$('error').innerHTML = error;
};

var addCostomisedErrors = function(transport){
	var json = transport.responseText.evalJSON();
	
	var error = "<label>Customized  ErrorConverter and Errorhandler Info:</label> </br></br>"
	+ "error status: " + json.model.status +"</br>"
	+ "http status : + " + transport.status +"</br>"
	+"</br>"
	+"Spring Errorhandling: </br>"
	if( json.model.Efeld_birthday)
		error = error + "birthday : " + json.model.Efeld_birthday +"</br>";
	if(json.model.Efeld_placeofbirth)
		error = error + "placeofbirth : " + json.model.Efeld_placeofbirth +"</br>";
	
	$('error').innerHTML = error;
};

var myrules = {
	'button#getName' : function(element){
		element.onclick = function(){
		 	new Ajax.Request('hello.json', { method:'get',
	  			onSuccess: function(transport, json){
	  			 	var json = transport.responseText.evalJSON();
	  			 	printResult(transport);
	      			$('firstname').innerHTML = json.firstname;
	      			$('secondname').innerHTML = json.secondname;
	    		}
  			});
		}
	},
	'button#clearName' : function(element){
		element.onclick = function(){
		 	$('firstname').innerHTML = '';
   			$('secondname').innerHTML = '';

		}
	},
	'button#throwException' : function(element){
		element.onclick = function(){
		 	new Ajax.Request('exception.json', { 
		 		method:'get',
		 		parameters: {throwException: 'true'},
	  			onSuccess: function(transport, json){
	  			 	var json = transport.responseText.evalJSON();
	  			 	printResult(transport);
	      			$('firstname').innerHTML = json.firstname;
	      			$('secondname').innerHTML = json.secondname;
	    		},
	    		onFailure: function(transport){
	    			var json = transport.responseText.evalJSON();
	  				printResult(transport);
	    		}
  			});
		}
	},
	'button#clearData' : function(element){
		element.onclick = function(){
		 	$('t_placeofbirth').innerHTML = '';
   			$('t_birthday').innerHTML = '';
			$('error').innerHTML = '';
			return false;
		}
	},
	
	'button#sfc_postData' : function(element){
	
	    
		element.onclick = function(){
			new Ajax.Request('hello1.json', { 
		 		method:'post',
		 		parameters: $('form').serialize(false),
	  			onSuccess: function(transport){
	  				var json = transport.responseText.evalJSON();
	  				printResult(transport);
	  				$('t_placeofbirth').innerHTML = json.command.placeofbirth;
	      			$('t_birthday').innerHTML =  json.command.birthday;
	    			$('error').innerHTML = '';
	    		},
	    		onFailure: function(transport){
	    			var json = transport.responseText.evalJSON();
	  				printResult(transport);
	  				addErrors(transport);
	    		}
	    		
  			});
		}
		
	},
	'button#cc_postData' : function(element){
		element.onclick = function(){
			new Ajax.Request('hello2.json', { 
		 		method:'post',
		 		parameters: $('form').serialize(false),
	  			onSuccess: function(transport){
	  				var json = transport.responseText.evalJSON();
	  				printResult(transport);
	      			$('t_placeofbirth').innerHTML = json.placeofbirth;
	      			$('t_birthday').innerHTML = json.birthday;
	      			$('error').innerHTML = '';
	    		},
	    		onFailure: function(transport){
	    			printResult(transport);
	  				addErrors(transport);
	    		}
	    		
  			});
		}
		
	},
	
	
	'button#sfc_postData_sojo2' : function(element){
		element.onclick = function(){
			new Ajax.Request('hello4.json', { 
		 		method:'post',
		 		parameters: $('form').serialize(false),
	  			onSuccess: function(transport){
	  				var json = transport.responseText.evalJSON();
	  				printResult(transport);
	      			$('t_placeofbirth').innerHTML = json.command.placeofbirth;
	      			$('t_birthday').innerHTML = json.command.birthday;
	      			$('error').innerHTML = '';
	    		},
	    		onFailure: function(transport){
	    			printResult(transport);
	  				addErrors(transport);
	    		}
	    		
  			});
		}
	},
	
	'button#sfc_postData_jsonlib' : function(element){
		element.onclick = function(){
			new Ajax.Request('hello3.json', { 
		 		method:'post',
		 		parameters: $('form').serialize(false),
	  			onSuccess: function(transport){
	  				var json = transport.responseText.evalJSON();
	  				printResult(transport);
	      			$('t_placeofbirth').innerHTML = json.command.placeofbirth;
	      			$('t_birthday').innerHTML = json.command.birthday;
	      			$('error').innerHTML = '';
	    		},
	    		onFailure: function(transport){
	    			printResult(transport);
	  				addErrors(transport);
	    		}
	    		
  			});
		}
	},
	
	'button#sfc_postData_xstream' : function(element){
		element.onclick = function(){
			new Ajax.Request('hello5.json', { 
		 		method:'post',
		 		parameters: $('form').serialize(false),
	  			onSuccess: function(transport){
	  				var json = transport.responseText.evalJSON();
	  				printResult(transport);
	      			$('t_placeofbirth').innerHTML = json.model.command.placeofbirth;
	      			$('t_birthday').innerHTML = json.model.command.birthday;
	      			var error = "ErrorConverter Info: </br>"
	      				+ "error status: " + json.model.status +"</br>"
	      				+ "http status : + " + transport.status +"</br>"
	      				+"</br>";
	      			$('error').innerHTML = error;
	      			
	    		},
	    		onFailure: function(transport){
	    			printResult(transport);
	  				addCostomisedErrors(transport);
	    		}
	    		
  			});
		}
	}
};

Behaviour.register(myrules);
