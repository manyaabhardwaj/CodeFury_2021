function validateBidValue() {
	console.log("priceeeee")
	var amount = document.getElementById("amount").value;
    console.log(amount)
    if (amount == "" || amount== null) {
		document.getElementById('amountError').innerHTML = "<span class='error'style='color:red'>Amount is a mandatory field! </span>"
		return false;
	}
	if (isNaN(amount)) {
		document.getElementById('amountError').innerHTML = "<span class='error' style='color:red'>Amount should be numeric!</span> ";
		return false;
	}
	else 
		{
		document.getElementById('amountError').innerHTML = ""
		return true;
		}
	
}
function validateStartDate()
{  
	var startDate = document.getElementById("startdate").value;
	//console.log(startDate);
	if (startDate == "" || startDate== null) {
		document.getElementById('startDateError').innerHTML = "<span class='error' style='color:red'>Please select a start Date! </span>"
		return false;
	}

	else
		{
		document.getElementById('startDateError').innerHTML = ""
		return true;
		}

}
function validateEndDate()
{  
	var endDate = document.getElementById("enddate").value;
	var startDate = document.getElementById("startdate").value;
	console.log(endDate);
	console.log(startDate);
	if (endDate == "" || endDate== null) {
		document.getElementById('endDateError').innerHTML = "<span class='error' style='color:red'>Please select an End Date! </span>"
		return false;
	}
	if(Date.parse(endDate)<=Date.parse(startDate)){
		//alert("End date should be greater than Start date");
		document.getElementById('endDateError').innerHTML = "<span class='error' style='color:red'>End date should be greater than Start date </span>"
		return false;
}

	else
		{
		document.getElementById('endDateError').innerHTML = ""
		//console.log("goin in else")
		return true;
		}

}
function validation()
{
validateBidValue();
validateStartDate();
validateEndDate();
if(!validateBidValue() || !validateStartDate()|| !validateEndDate())
	return false
	else
		return true
}
function submitForm(){
	if(validation())
		{
		console.log("true")
		return true
		}
		
		else
			
		{console.log("false")
			return false}
						
}