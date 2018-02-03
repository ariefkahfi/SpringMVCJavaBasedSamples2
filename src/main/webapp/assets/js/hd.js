function submitHD(){
    var dName = document.getElementById("director_name").value;
    var dHosp = document.getElementById("director_hospital").value;

    if(dName === "" || dHosp === "" || dName === undefined || dHosp === undefined){
        alert("form empty");
        return false;
    }else{
        return true;
    }
}