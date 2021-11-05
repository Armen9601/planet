function getLordList(){
    $.ajax({
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        type: 'GET',
        url: 'http://localhost:8080/lord/empty-lords',
        success: function (data) {

            $('#content').empty()
            data.forEach((item,index)=>{
                $('#content').append(`
   <span>${(index+1)+'. '+item.name}</span><br>
`)
        })


        }
    });

}

