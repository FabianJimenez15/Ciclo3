const BASE_URL='Http://152.70.153.10:81'
function MostrarInformacionReservation(){
     $.ajax({
        url: BASE_URL+"/api/Reservation/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintarRespuestaReservation(respuesta);
       } 
    }
 ); 
}
function pintarRespuestaReservation(items){
    $("#resultReservation").empty();
     let myTable = "<table border =3 >";
     myTable += "<caption> RESERVATION </caption>";
     myTable += "<tr><th>CODE</th> <th> START </th> <th> DEVOLUTION </th> </tr>"
     for (i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].startDate + "</td>";
        myTable += "<td>" + items[i].devolutionDate + "</td>";
        myTable += "</tr>";
}
myTable += "</table>";
$("#resultReservation").append(myTable);
}
function InsertarInformacionReservation(){
    $("#resultCategory").empty();
    let myData = {
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val()
    }
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: BASE_URL+"/api/Reservation/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria ' + xhr.status);
        }
    }
    );
}