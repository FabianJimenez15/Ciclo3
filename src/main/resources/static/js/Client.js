const BASE_URL='Http://152.70.153.10:81'
function MostrarInformacionClient(){
     $.ajax({
        url: BASE_URL + "/api/Client/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintarRespuestaClient(respuesta);
       } 
    }
 ); 
}
function pintarRespuestaClient(items){
    $("#resultClient").empty();
     let myTable = "<table border =3 >";
     myTable += "<caption> CLIENT </caption>";
     myTable += "<tr><th>CODE</th> <th> EMAIL</th> <th>PASSWORD</th> <th> NAME</th> <th> AGE</th></tr>"
     for (i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idClient+ "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].password + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "</tr>";
}
myTable += "</table>";
$("#resultClient").append(myTable);
}
function InsertarInformacionClient(){
    $("#resultClient").empty();
    let myData = {
        email:    $("#email").val(),
        password: $("#password").val(),
        name:     $("#nameClient").val(),
        age:      $("#age").val()
    }
    
let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: BASE_URL+"/api/Client/save",
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