function getTopLords(){
    $.ajax({
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        type: 'GET',
        url: 'http://localhost:8080/lord',
        success: function (data) {

            $('#content').empty()
            data.forEach((item,index)=>{
                $('#content').append(`
   <span>${(index+1)+'. '+item.name+' - '+item.age+'years'}</span><br>
`)
        })


        }
    });

}


var responseDto = {
    name:"" , age:0
}
$("body").on("click", "#button", function(){

    $.each( $("input[name='name']:input"),function (){
        console.log($(this).val())
        responseDto.name=$(this).val();
    })
    $.each( $("input[name='age']:input"),function (){
        console.log($(this).val())
        responseDto.age=$(this).val();
    })
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
