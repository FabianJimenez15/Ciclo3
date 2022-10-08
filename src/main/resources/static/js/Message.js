const BASE_URL='Http://150.136.245.151:81'
function MostrarInformacionMessage(){
     $.ajax({
        url: BASE_URL +"/api/Message/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintarRespuestaMessage(respuesta);
       } 
    }
 ); 
}
function pintarRespuestaMessage(items){
    $("#resultMessage").empty();
     let myTable = "<table border =3 >";
     myTable += "<caption> CATEGORY </caption>";
     myTable += "<tr><th>CODE</th> <th> MESSAGE </th>  </tr>"
     for (i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idMessage + "</td>";
        myTable += "<td>" + items[i].messageText + "</td>";
        myTable += "</tr>";
}
myTable += "</table>";
$("#resultMessage").append(myTable);
}
function InsertarInformacionMessage(){
    $("#resultMessage").empty();
    let myData = {
       
        messageText: $("#Message").val()
    }
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: BASE_URL+"/api/Message/save",
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