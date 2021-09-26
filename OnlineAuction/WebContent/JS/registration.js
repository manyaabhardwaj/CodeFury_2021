function validateName(){
	var name = document.getElementById('name').value;
	if(name==""|| name==null)
	{
		document.getElementById('nameerror').innerHTML="Name is a mandatory field!";
		 
		return false;
	}if (!/^[a-zA-z]+([\s][a-zA-Z]+)*$/g.test(name)) {
		document.getElementById('nameerror').innerHTML = "Name should contain only alphabets!";
		return false;
	}
	if(name.length < 6 || name.length > 15){
		document.getElementById('nameerror').innerHTML="Length must be between 6 to 15!";
		
		return false;
	}else{
		console.log("entered else")
				document.getElementById('nameerror').innerHTML="";
				return true;
				//document.getElementById('submitbuttom').removeAttribute('disabled');
			}
	
}
function validateDOB(){
	//console.log("entered");
	var dob=document.getElementById('birthdayDate');
console.log(dob.value)
	if (dob == null || dob == "") {
        // console.log("entered if"+dob);
		document.getElementById('doberror').innerHTML="Invalid Date of Birth!";
		return false; 

	}
	if (Date.parse(dob)<18) {
        // console.log("entered if"+dob);
		document.getElementById('doberror').innerHTML="less than 18! ";
		return false; 
	}else{
		console.log("entered dob else");
				document.getElementById('doberror').innerHTML="";
				return true;
			//	document.getElementById('submitbuttom').removeAttribute('disabled');
			}
}
function validateEmail(){
	var email=document.getElementById('email').value;	
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email)) {
	document.getElementById('emailerror').innerHTML="Please enter a valid Email address! ";
		return false; 
	}else{
				document.getElementById('emailerror').innerHTML="";
				return true;
			}
	
}
function validatePhNum(){
	var pnum=document.getElementById('phoneNumber').value;
	var num=/^\d{10}$/;
	if(!num.test(pnum)){
		document.getElementById('phonenumbererror').innerHTML="Please enter a valid Phone Number! ";
		return false; 
	}else{
				document.getElementById('phonenumbererror').innerHTML="";
		       return true;
			}
	
}
function validateUserName(){
	var user=document.getElementById('username').value;
	// var uname = /^[a-zA-Z0-9]+$/;

		var uname  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!uname.test(user)){
		document.getElementById('usernameerror').innerHTML="Invalid User Name ";
		 return false;
	}else{
				document.getElementById('usernameerror').innerHTML="";
			return true;
			}
	
}
function validatePassword(){
	var password = document.getElementById("password").value;
	console.log(password);
        if(password=="" ){
	document.getElementById('passworderror').innerHTML="Password cant be empty !";
		return false;
}	
       else{
				document.getElementById('passworderror').innerHTML="";
				return true;
}
}
function validateConfPassword(){
	   var confirmPassword = document.getElementById("confirmpassword").value;
	   var password = document.getElementById("password").value;
        if (password != confirmPassword) {
            document.getElementById('Confpasserror').innerHTML="Both Password doesn't match ";
	return false; 
        }
        	if( confirmPassword==""){
	document.getElementById('Confpasserror').innerHTML="Password cant be empty! ";
		return false;

}
       else{
				document.getElementById('Confpasserror').innerHTML="";
				return true;
}

}

function validateTypeOfUser(){
	var typeUser;
	if (document.getElementById('buy').checked) {
  typeUser = document.getElementById('buy').value;
}
if (document.getElementById('sell').checked) {
  typeUser = document.getElementById('sell').value;
}
console.log(typeUser);
/*else{
		document.getElementById('submitbuttom').removeAttribute('disabled');
	}*/
}
function validateAmount(){
	var amount=document.getElementById('walletamount').value;
	var valid = /^[0-9]+$/;
	if(!valid.test(amount)){
		document.getElementById('walleterror').innerHTML="Invalid Amount !";
		return false; 
	}else{
				document.getElementById('walleterror').innerHTML="";
				return true;
			}
	
	
}

function ValidateSubmit(){    
  validateName();
validateDOB();
validateEmail();
validatePhNum();
validateUserName();
validatePassword();
validateConfPassword();

validateAmount();
    
    
	console.log("dob"+birthdayDate);
	if(!validateName()||!validateDOB()||!validateEmail()||!validateUserName()||!validatePhNum()||!validatePassword()||!validateConfPassword()||!validateAmount()){
		console.log("hello ifff");
	return false;
	}
	   else{

		 alert("true validate submit ")
		   return true;
	}	
}
function success()
{
if(Validatesubmit())
   {
	console.log("True")
	return true;}
else
	{
	console.log("False")
	return false;
	}
	

	
}

