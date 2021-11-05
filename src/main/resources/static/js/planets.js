function getPlanets() {



    $.ajax({
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        type: 'GET',
        url: 'http://localhost:8080/planet',
        success: function (data) {
            $('#content').empty()
            data.forEach((item, index) => {
                $('#content').append(`
               <span>${(index + 1) + '. ' + item.title+ (item.lord?' - lord: '+item.lord.name:'')}</span><br>
   
`)
            })


        }
    });


}



