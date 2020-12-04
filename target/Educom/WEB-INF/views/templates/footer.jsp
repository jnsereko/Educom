<style>
.educom-div-select{
	height: 180px;
	box-shadow: -9px 11px 18px 6px#5b5b5b;
    overflow: auto;
	border-bottom: 1px solid #a4a4a4;    
	border-top: 1px solid #a4a4a4;    
    white-space: nowrap;
}
.educom-table-select{
	color: #cde6ff;
	border: 1px solid #a4a4a4;
	background: #5e6262;
	text-align: center;
}
.selective-label .subjects label:hover, .table-hover tbody tr:hover {
    color: #97ffd4;
    background-color: rgba(0,0,0,0.275);
}

.selective-label{
	flex-wrap: wrap;
    margin-right: -15px;
    margin-left: -15px;
}
.selective-label .subjects{
	box-shadow: -9px 11px 18px 6px#5b5b5b;
    display: grid;
    width: 60%;
    margin-left: auto;
    margin-right: auto;
}
.selective-label .subjects label{
    background: #5e6262;
	cursor: pointer;
	font-size: 20px;
    padding: .75rem;
    vertical-align: top;
    border-top: 1px solid #a4a4a4;
    border-left: 1px solid #a4a4a4;
    border-bottom: 1px solid #7f7f7f; 
}
mark{
	color: #97ffd4;
    background-color: rgba(0,0,0,0.275);
}
    
</style>
<script>
 function calcAge(){
	 var txt = document.getElementById("dateOfBirth");
	 var y = document.getElementById("showAge")
	 
	 var bd = new Date(txt.value);
	 var yob = bd.getFullYear();
	 var mob = bd.getMonth();
	 var dob = bd.getDate();
	 
	 var today = new Date();
	 var ty = today.getFullYear();
	 var tm = today.getMonth();
	 var td = today.getDate();
	 
	 var age = ty - yob;
	 var m = tm - mob;

	 if(age>0){
		 if(m<0||( m === 0 && td <= dob)){	 
			 age--;	 
		}
		 y.value = age;
		 y.innerHTML =  y.value; 
	 }else{
		 y.innerHTML =  "";
	 }
 };
 
 function weeklySalary(){
	var hours = document.getElementById("workingHours").value;
	var perHour = document.getElementById("salary").value;
	if(hours!==NaN || perHour!==Nan){
		document.getElementById("showBaseSalary").innerHTML = hours*perHour; 
	}
 };
 
 function openTable(idName, idName1, idName2){
		var id = document.getElementById(idName);
		var id1 = document.getElementById(idName1);
		var id2 = document.getElementById(idName2);
	 
	if (id.style.display === "none") {
		id.style.display = "block";
		id1.style.display = "none";
		id2.style.display = "none";
	}
 };
</script>
  <div class="modal fade" id="delete-confirmation">
    <div class="modal-dialog animate" style="margin-top: 115px;">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" style="color: #396060;font-weight: 700;">Deleting Element</h4>
          <button type="button" class="close" data-dismiss="modal" style="color:red">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <table class="table table-striped table-bordered">
          	<tr>
          		<th>Element Id</th>
          		<th>Element Name</th>
          	</tr>
          	<tr>
				<td id="objectId"></td>          	
				<td id="objectName"></td>          	
          	</tr>
          </table>
          <div align="center">
	          <p>Click <mark style="color: snow; background: darkgreen">OK</mark> to confirm deletion</p>
          	  <div class="spinner-border text-warning"></div>
	          <div class="spinner-border text-warning"></div>
	          <div class="spinner-border text-warning"></div>
	      </div>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button style="left: 17px;position: absolute;background: darkgreen;width: 90px;" type="button" class="btn btn-success ok" >OK</button>
          <button type="button" class="btn btn-danger cancel" data-dismiss="modal">Cancel</button>
        </div>
        
      </div>
    </div>
   </div>
<script>
	function displayDeleteModal(objectId, objectName, address){
		var id = document.getElementById("objectId");
		var name = document.getElementById("objectName");
		
		id.innerHTML = objectId;
		name.innerHTML = objectName;
		$("#delete-confirmation").modal("show");
		$("#delete-confirmation button.ok").off().on("click", function() {
			//close window
			$("#delete-confirmation").modal("hide");	
			//continue and with url
			window.location.href=address;			
		});
		return false;
	};

</script>
<div class ="footer">
	<div class="footer-button" align="center">
		<button class="btn btn-danger" onclick="document.getElementById('bug').style.display='block'">Report Error</button>	
		<button class="btn btn-info">Print Page</button>	
		<button class="btn btn-info">About Educom</button>
	</div>
	<div id="alertSuccessful" class="alert success" align="center" style="display: none">
	  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>  
	  <strong style="font-size: 30px">Thanks For Your Assistance!</strong> 
	  <p>Your message has been <b style="font-size: 20px">Successfully</b> submitted to Educom Developers.  You will be receiving a reply in the next <b style="font-size: 20px">48 hours</b>.</p>
	</div>
	<div align="center">
		<p>@copyright reserved by Educom companies</p>
	</div>
	<div class="footer-icon" align="center">
		<button><i class="fa fa-twitter" aria-hidden="true"></i></button>
		<button><i class="fa fa-whatsapp" aria-hidden="true"></i></button>
		<button><i class="fa fa-facebook-square" aria-hidden="true"></i></button>
	</div>
</div>
<div id ="bug" class="report-error" style="display: none">
 	<form class="modal-content animate" action="#" method="post">
		<div class="container" style="background: #3c6262; box-shadow: 0px -1px 14px 2px #bbbbbb;">
	      <label for="email"  style="margin-top:20px;font-size: 140%"><b>Enter Email</b></label>
	      <input type="email"  style="width:100%;margin-top:5px; background: #ddebeb" placeholder="Enter email" name="email" required>
		
		  <label for="err_email"  style="margin-top:20px;font-size: 140%"><b>Page address:</b></label>
		  <input  type="text" style="width:100%;margin-top:5px" id="err_url" name="err_url" disabled="disabled">
	      
	      <label for="err_desc" style="margin-top:20px;font-size: 140%"><b>Description</b></label>	      
	      <textarea rows="10" class="w3-input w3-border" id="err_desc" name="err_desc" style="background: #ddebeb;width:100%;margin-top:5px;resize:vertical;" required></textarea>  
	     
	      <div class="row" align="center" style="margin-top:10px; margin-bottom:20px">
	      	<div class="col-sm-6">
	      		<button type="submit" class="btn btn-success" onsubmit="document.getElementById('alertSuccessful').style.display='block'">Submit</button>
	      	</div>
	      	<div class="col-sm-6">
	      		<button type="submit" class="btn btn-danger" onclick="document.getElementById('bug').style.display='none'">Cancel</button>
	      	</div>
	      </div>
	    </div>
     </form>
</div>

<style>
	.footer{
		background: darkslategrey;
		font-family: monospace;
		color: #e7ffef;
	}
	.footer-button button{
			color: inherit;
    	margin: 1.3%;	
    	background: #213838;	
	}
	.report-error{
	  display: none; /* Hidden by default */
	  position: fixed; /* Stay in place */
	  z-index: 1; /* Sit on top */
	  left: 0;
	  top: 0;
	  width: 100%; /* Full width */
	  height: 100%; /* full height*/
	  overflow: auto; /* Enable scroll if needed */
	  background-color: rgb(0,0,0); /* Fallback color */
	  background-color: rgb(0 0 0 / 70%);/* Black w/ opacity */
	  padding-top: 20px;
	}
	.modal-content{
		background-color: #fefefe;
	  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
	  border: 1px solid #888;
	  width: 70%; /* Could be more or less, depending on screen size */	
	}
	.animate {
	  -webkit-animation: animatezoom 0.6s;
	  animation: animatezoom 0.6s
	}
	@-webkit-keyframes animatezoom {
	  from {-webkit-transform: scale(0)} 
	  to {-webkit-transform: scale(1)}
	}
	  
	@keyframes animatezoom {
	  from {transform: scale(0)} 
	  to {transform: scale(1)}
	}
	.col-sm-6 button{
		font-size: 140%
	    margin-bottom: 10px;
	    width: -webkit-fill-available;
	}
	.closebtn {
	  margin-left: 15px;
	  color: white;
	  font-weight: bold;
	  float: right;
	  font-size: 30px;
	  line-height: 20px;
	  cursor: pointer;
	  transition: 0.3s;
	}
	.alert {
	  padding: 20px;
	  background-color: #f44336;
	  color: white;
	  opacity: 1;
	  transition: opacity 0.6s;
	  margin-bottom: 15px;
	  width: 80%;
	  margin: auto;
	}
	
	table a{
		color: #b9f9ff;
    	font-weight: bold;
	}
	
	table a:hover{
    	color: #ffffff;
    	text-decoration: none;
	    font-style: italic;
	    transition: 0.3s ease-out;
	    position: sticky;
    }
	.alert.success {background-color: #4CAF50;}
	
	.closebtn:hover {
	  color: darkslategrey;
	}
	
	.footer-icon button{
		width: 50px;;
	    height: 45px;
	    margin-bottom: 20px;
	    border-radius: 100%;
	}
	
	.footer-icon button:hover{
		transition: 0.3s ease-out;
   		background: #162525;	
   	}
   	
   	.footer-icon button:focus{
		outline: none;
   	}
	
	.footer-icon button i{
		width: 100%;
	    height: 30px;
	    color: darkslategrey;
	    font-size: 27px;
	}
	.footer-icon button:hover i{
		transition: 0.3s ease-out;
	    color: snow;
    	font-size: 28px;	
    }
    .educom-button:focus{
    	outline: none;
    }
	.educom-form{
	    display: block;
	    width: 100%;
	    height: calc(1.5em + .75rem + 2px);
	    padding: .375rem .75rem;
	    font-size: 1rem;
	    font-weight: 400;
	    line-height: 1.5;
	    box-shadow: -1px 12px 19px #6d6868;
	    color: #495057;
	    background-color: #dadada;
	    background-clip: padding-box;
    	border: 1px solid #a9a9a9;
    	border-radius: .25rem;
	    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
	   }
		.educom-form:focus{
			background-color: #f1ffff;
	    	border: 1px solid #a9a9a9;
	    	outline: solid #569090;
	    	transition: 0.2s ease-out;
	   }
	   .educom-form-disabled{
	   		display: block;
		    width: 100%;
		    height: calc(1.5em + .75rem + 2px);
		    padding: .375rem .75rem;
		    font-size: 1rem;
		    font-weight: 400;
		    line-height: 1.5;
		    box-shadow: -1px 12px 19px #6d6868;
		    color: #495057;
		    background-color: #556567;
		    background-clip: padding-box;
	    	border: 1px solid #a9a9a9;
	    	border-radius: .25rem;
		    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
		    color: #81d0ff;
	   }
	   legend {
			font-family: "OpenSans", Arial, sans-serif;
			-webkit-font-smoothing: subpixel-antialiased;
			color: #d2e4d4;
			font-size: 16px;
			text-align: center;
			padding: 0 10px;
			font-weight: 300;
			text-transform: uppercase;
		}
		
		h1{
			font-size: 2.5rem;
		    color: #ebfffc;
		    text-align: center;
		    text-shadow: darkcyan;
		    margin: revert;
		}
		h1::after{
			content: '';
			background-color: #1affff;
			display: block;
			height: 3px;
			width: 10%;
			z-index: 1;
			margin: 20px auto 5px;
		}
		h1:hover::after{
			transition: 0.6s ease-out;
			content: '';
			background-color: #1affff;
			display: block;
			height: 3px;
			width: 60%;
			z-index: 1;
			margin: 20px auto 5px;
		}
		
		label{
			color: #ebfffc;
		}
		.educom-submit{
			font-size: x-large;
			width: 40%;
			margin: 3%;
			border-color: #21e860;
			border-radius: 3%;
			color: #3ba02e;
			background: ghostwhite;
			vertical-align: initial;
			margin-left: auto;
			font-weight: bold;
			margin-right: auto;
		}
		.educom-submit:hover {
			color: #fff;
			background-color: #218838;
			border-color: #1e7e34;
			font-family: sans-serif;
			box-shadow: 1px 1px 15px 5px #bfbfbf;
			transition: 0.4s ease-in-out;
		}
		.educom-button{
		    padding: .375rem .75rem;
		    font-size: 1rem;
		    line-height: 1.5;
		    border-radius: .25rem;
		    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
			vertical-align: middle;
			display: inline-block;
    		background: #4d6750;
		    box-shadow: 0 0 14px 0px #474747;
		    border: none;
		    width: 80%;
		    font-size: 20px;
		    border: none;
		    color: snow;
    		font-weight: 400;
		}
		.educom-button:hover{
			color: #218231;
	    	font-weight: 700;
	    	transition: 0.4s ease-out;
	    	background: #ece8e8;
    		box-shadow: 0 0 17px 0px #353535;
		}
		.table-dark {
		    color: #fff;
		    background-color: #3e4f4f;
		    margin-top: 30PX;
		    text-align: center;
    	}
    	.table-dark td, .table-dark th, .table-dark thead th {
            border-color: #a9a9a9;
        }
        td{
        	white-space: nowrap;
        }
        
        th{
        	white-space: pre;
        }
        .spinner-border {
		    width: 1.5rem;
		    height: 1.5rem;
		}
</style>

<script>
// Get the modal
var modal = document.getElementById('bug');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>


