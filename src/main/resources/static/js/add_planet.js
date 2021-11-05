function getPlanetForm() {
    console.log('asdasda')
    $.ajax({
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        type: 'GET',
        url: 'http://localhost:8080/lord/all',
        success: function (lords) {
            let option =  `<input type="text" name="title" id="title" placeholder="title"><select id="lord" name="lord">`
            lords.forEach(lord => {
                console.log(lord);
               option+=`<option value="${lord}">${lord.name}</option>`
            })
            option+=` </select>  <button id="button" type="submit">Add Planet</button>  <br>`;
            $('#content').append(option)
        }
    });

}

var responseDto = {
    title: "",
    lord: ''
}
$("body").on("click", "#button",'#lord', function(){

    $.each($("input[name='title']:input"), function () {
        console.log($(this).val())
        responseDto.title = $(this).val();
    })

    console.log(responseDto)

    $.ajax({
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        type: 'POST',
        url: 'http://localhost:8080/planet',
        data: JSON.stringify(responseDto),
        success: function (data) {
            console.log(data)
        }

    });
})
