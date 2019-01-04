function signup(){
	var pass = document.getElementById("password").value;
	var cnfpass = document.getElementById("cnfpassword").value;
	if(pass != cnfpass){
		alert("Password doesnot match");
		return false;
	}
	alert("Registration Successful");
	return true;
}