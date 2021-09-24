function convertToUpperCase(){
	var productName = document.getElementById("Product name");
	  productName.value = productName.value.toUpperCase();
}
function validateProductName() {
	console.log("Namee.")
	var productName = document.getElementById("Product name").value;
	productName.toUpperCase();
	if (productName == "" || productName == null) {
		document.getElementById('productNameError').innerHTML = "<span class='error' style='color:red'>Product Name is a mandatory field!</span> ";
		return false;
	}
		
	if (!/^[a-zA-z]+([\s][a-zA-Z]+)*$/g.test(productName)) {
		document.getElementById('productNameError').innerHTML = "<span class='error' style='color:red'>Product Name should contain only alphabets!</span> ";
		return false;
	}
	
	else
		{
		document.getElementById('productNameError').innerHTML = "";
		return true;
		}
		

}
function validateQuantity() {
	console.log("quantity..........")
	var productQuantity = document.getElementById("Quantity").value;
	if (productQuantity == "" || productQuantity == null) {
		document.getElementById('productQuantity').innerHTML = "<span class='error'style='color:red'>Product Quantity is a mandatory field! </span>"
		return false;
	}
	if (isNaN(productQuantity)) {
		document.getElementById("productQuantity").innerHTML = "<span class='error' style='color:red'>Product Quantity should be numeric!</span> ";
		return false;
	}  else
		{
		document.getElementById('productQuantity').innerHTML = ""
		return true;
		}
		

}
function validateDescription()
{ console.log("dscription..........")
	var productDescription = document.getElementById("description").value;
	if (productDescription == "" || productDescription == null) {
		document.getElementById('productDescriptionError').innerHTML = "<span class='error' style='color:red'>Product Description is mandatory!</span> ";
		return false;
	}
	else 
		{
		document.getElementById('productDescriptionError').innerHTML = "";
		return true;
		}
		
}

function validateProductPrice() {
	console.log("priceeeee")
	var productPrice = document.getElementById("Price").value;
	if (isNaN(productPrice)) {
		document.getElementById('productPriceError').innerHTML = "<span class='error' style='color:red'>Product Price should be numeric!</span> ";
		return false;
	}
	if (productPrice == "" || productPrice == null) {
		document.getElementById('productPriceError').innerHTML = "<span class='error'style='color:red'>Product Price is a mandatory field! </span>"
		return false;
	}

	else
		{
		document.getElementById('productPriceError').innerHTML = ""
		return true;
		}
	
}
function success()
{
if(validation())
   { 
	console.log("true")
	return true;
	}
else
	return false;

}
function validation()

{   
	validateProductName()
	validateProductPrice()
	validateQuantity()
	validateDescription()
	if(!validateProductName() || !validateProductPrice()|| !validateQuantity()||!validateDescription())
	   return false;
	   else
		   return true;
}