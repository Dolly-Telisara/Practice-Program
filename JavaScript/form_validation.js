const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const password = document.getElementById('password');
const cpassword = document.getElementById('cpassword');

//add event
//fat arrow function
form.addEventListener('submit',(event) => { 
    event.preventDefault();
    validate();
})

const sendData = (usernameVal,sRate,count) =>{
    if(sRate == count){
        alert('Registration Successful');
        swal("Welcome, " + usernameVal, "Registration Successful", "success");
        location.href = `response.html?username=${usernameVal}` // Passing data to new page
    }
}

// For final validation 

const successMsg = (usernameVal) => {
    let formCon = document.getElementsByClassName('form-control');

    var count = formCon.length - 1;
    for(var i=0; i<formCon.length; i++){
        if(formCon[i].className == "form-control success"){  // Checking if all the input boxes have become green(i.e. all div has 'success' class)
            var successRate = 0 + i;
            console.log(successRate);
            sendData(usernameVal,successRate,count);
        }else{
            return false;
        }
    }

}

// email validate

const isEmail = (emailVal) => {
    var atSymbol = emailVal.indexOf("@");
    if(atSymbol < 1) return false;
    var dot = emailVal.lastIndexOf(".");
    if(dot <= atSymbol + 2) return false;
    if(dot==emailVal.length - 1) return false;
    return true;
}

//define the validate function

const validate = () => {
    const usernameVal = username.value.trim(); // remove all whitespaces at beginning and at end
    const emailVal = email.value.trim();
    const phoneVal = phone.value.trim();
    const passwordVal = password.value.trim();
    const cpasswordVal = cpassword.value.trim();

    //validate username

    if(usernameVal == ""){
        setErrorMsg(username,'Username cannot be blank');
    }
    else if(usernameVal.length <=2){
        setErrorMsg(username,'Username should be min 3 characters');
    }
    else{
        setSuccessMsg(username);
    }
 
    //validate email

    if(emailVal == ""){
        setErrorMsg(email,'email cannot be blank');
    }
    else if(!isEmail(emailVal)){
        setErrorMsg(email,'Invalid Email_Id');
    }
    else{
        setSuccessMsg(email);
    }

    
    // Validate phone

    if(phoneVal== ""){
        setErrorMsg(phone,'Phone cannot be blank');
    }
    else if(phoneVal.length != 10){
        setErrorMsg(phone,'Invalid Phone Number');
    }
    else{
        setSuccessMsg(phone);
    }

      
    // Validate password

    if(passwordVal== ""){
        setErrorMsg(password,'Password cannot be blank');
    }
    else if(passwordVal.length <= 6){
        setErrorMsg(password,'Minimum 6 characters required');
    }
    else{
        setSuccessMsg(password);
    }

    // Validate confirm password

    if(cpasswordVal== ""){
        setErrorMsg(cpassword,'Confirm Password cannot be blank');
    }
    else if(cpasswordVal != passwordVal){
        setErrorMsg(cpassword,'Password Not Matching');
    }
    else{
        setSuccessMsg(cpassword);
    }

    successMsg(usernameVal);

}

function setErrorMsg(input, errormsgs){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = "form-control error";
    small.innerText = errormsgs;
}

function setSuccessMsg(input){
    const formControl = input.parentElement;
    formControl.className = "form-control success";
}
