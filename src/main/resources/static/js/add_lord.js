function getLordForm(){
    $('#content').empty().append(`
    <input type="text" name="name" id="name" placeholder="name">
<input type="number" name="age" id="age" placeholder="age">
<button id="button" type="submit">Add Lord</button>
`)
}


var responseDto = {
    name:"" , age:0
}
$("body").on("#button", function(){
    console.log(responseDto)



$.ajax({
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    type: 'POST',
    url: 'http://localhost:8080/lord',
    data: JSON.stringify(responseDto),
    success: function (data) {
        console.log(data)

    }

});
})
