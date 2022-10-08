const BASE_URL='Http://150.136.245.151:81'
function MostraInformacionSkate(){
    $.ajax({
        url:BASE_URL+"/api/Skate/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintaRespuestaSkate(respuesta);
       } 
    }
 );  
}
function pintaRespuestaSkate(items){
    $("#resultSkate").empty();
    let myTable ="<table border=3>";
    myTable += "<caption> Skate </caption>";
    myTable += "<tr> <th> Codigo </th> <th> Brand </th>  <th> Year  </th>   <th> Name </th>  <th>Description  </th> </tr>"
    for (i=0; i<items.length; i++){
      myTable += "<tr>"; 
      myTable += "<td>" + items[i].id + "</td>";
      myTable += "<td>" + items[i].name + "</td>";  
      myTable += "<td>" + items[i].brand + "</td>";
      myTable += "<td>" + items[i].year_b + "</td>";
      myTable += "<td>" + items[i].description + "</td>";
     // myTable += "<td>" + items[i].category.id + "</td>";
      myTable += "</tr>";
    }
 myTable += "</table>";
  $("#resultSkate").append(myTable);
}

function InsertarInformacionSkate(){
    $("#resultSkate").empty();
    let myData ={
        brand: $("#brand").val(),
        year_b: $("#year").val(),
        name: $ ("#name").val(),
        description :$("#description").val(),
        //category :$("#category").val()
    }
 
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url :BASE_URL+ "/api/Skate/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        
        success: function (respuesta) {
            alert("Insercion exitosa");        
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria  ' + xhr.status);
       }
    }
  );
}


