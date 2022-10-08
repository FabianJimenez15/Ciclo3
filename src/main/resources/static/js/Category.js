const BASE_URL='Http://152.70.153.10:81'
function MostraInformacionCategory(){
     $.ajax({
        url: BASE_URL +"/api/Category/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintarRespuestaCategory(respuesta);
       } 
    }
 ); 
}
function pintarRespuestaCategory(items){
    $("#resultCategory").empty();
     let myTable = "<table border =3 >";
     myTable += "<caption> CATEGORY </caption>";
     myTable += "<tr><th>CODE</th> <th> NAME</th> <th> DESCRIPTION </th> </tr>"
     for (i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "</tr>";
}
myTable += "</table>";
$("#resultCategory").append(myTable);
}
function InsertarInformaconCategory(){
    $("#resultCategory").empty();
    let myData = {
        name:        $("#nameCategory").val(),
        description: $("#descriptionCategory").val()
    }
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: BASE_URL + "/api/Category/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}