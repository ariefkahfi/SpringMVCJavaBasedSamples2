function submitDoctor(){
    var docHosp = document.getElementById("doctor_hospital").value;

    if(docHosp === "" || docHosp === undefined){
        alert("form still empty");
        return false;
    }else{
        return true;
    }
}