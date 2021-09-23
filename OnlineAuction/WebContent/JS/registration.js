function validateName(){
	var name = document.getElementById('name').value;
	
	if (!/^[a-zA-z]+([\s][a-zA-Z]+)*$/g.test(name)) {
		document.getElementById('nameerror').innerHTML = "<span class='error' style='color:red'>Product Name should contain only alphabets!</span> ";
		return false;
	}
	
	if(name=="")
	{
		document.getElementById('nameerror').innerHTML="name is MUST";
		 
		return false;

	}  if(name.length < 6 || name.length > 15){
		document.getElementById('nameerror').innerHTML="length must be between 6 to 15";
		
		return false;
	}else{
		console.log("entered else")
				document.getElementById('nameerror').innerHTML="";
				return true;
				//document.getElementById('submitbuttom').removeAttribute('disabled');
			}
	
}
function validateDOB(){
	console.log("entered");
	var dob=document.getElementById('birthdayDate').value;

	if (dob == null || dob == "") {
         console.log("entered if"+dob);
		document.getElementById('doberror').innerHTML="Invalid Date of Birth ";
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
	document.getElementById('emailerror').innerHTML="Invalid Email address ";
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
		document.getElementById('phonenumbererror').innerHTML="Invalid Phone Number ";
		return false; 
	}else{
				document.getElementById('phonenumbererror').innerHTML="";
		       return true;
			}
	
}
function validateUserName(){
	var user=document.getElementById('username').value;
	// var uname = /^[a-zA-Z0-9]+$/;
		var uname  = /^(?=.*[a-zA-Z\d].*)[a-zA-Z\d!@#$%&*]{7,}$/;
	if(!uname.test(user)){
		console.log(username)
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
	document.getElementById('passworderror').innerHTML="Password cant be empty ";
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
            document.getElementById('Confpasserror').innerHTML="Pass word doesn't matches' ";
	return false; 
        }
        	if( confirmPassword==""){
	document.getElementById('Confpasserror').innerHTML="Password cant be empty ";
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
		document.getElementById('walleterror').innerHTML="Invalid Amount ";
		return false; 
	}else{
				document.getElementById('walleterror').innerHTML="";
				return true;
			}
	
	
}
function Validatesubmit(){    
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

function submit(){
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var username=document.getElementById("username").value;
	var phoneNumber=document.getElementById("phoneNumber").value;
	var password=document.getElementById("password").value;
	var confirmpassword=document.getElementById("confirmpassword").value;
	var birthdayDate=document.getElementById("birthdayDate").value;
	var typeUser=document.getElementById('toUser').checked.value;
	var address=document.getElementById("address").value;
	var wallet=document.getElementById("walletamount").value;
	console.log(name);
	let xhttp = new XMLHttpRequest();
		
		xhttp.open("POST","http://localhost:8080/OnileAuction/register?name="+name+'&email='+email+'&username='+username+'&phoneNumber='+phoneNumber+'&password='
		+password+'&confirmpassword='+confirmpassword+'&birthdayDate='
		+birthdayDate+'&toUser='+typeUser+'&address='+address+'&walletamount='+wallet,true);
		xhttp.send();
		xhttp.onload = function(){
			document.write(xhttp.responseText);
			
	
	}
	
}