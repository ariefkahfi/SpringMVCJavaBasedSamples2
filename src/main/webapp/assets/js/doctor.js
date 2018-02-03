function submitDoctor(){

    var docId = document.getElementById("doctor_id").value;
    var docName = document.getElementById("doctor_name").value;
    var docHosp = document.getElementById("doctor_hospital").value;

    if(docHosp === "" || docHosp === undefined
    || docName === "" || docName === undefined
    || docId === "" || docId === undefined){
        alert("form still empty");
        return false;
    }else{
        return true;
    }
}