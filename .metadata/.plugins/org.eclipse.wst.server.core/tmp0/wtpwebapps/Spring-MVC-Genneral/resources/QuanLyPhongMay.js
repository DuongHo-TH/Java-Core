function validateEmail(input){
    const regex_email = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
        return regex_email.test(input);
 }

function isValidPhoneNumber(phoneNumber) {
    phoneNumber = phoneNumber.replace(/\s/g, '');
    const regex = /^(0[89]0|\(84\)\+90)(\d{7}|\d{8})$/;
    return regex.test(phoneNumber);
}

function isValidPositiveInteger(number) {
    return Number.isInteger(number) && number > 0;
}

function formatDate(inputDate) {
    const parts = inputDate.split('-');
    return `${parts[2]}/${parts[1]}/${parts[0]}`;
}
