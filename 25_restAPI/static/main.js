$(document).ready(function() {
    $(".list .item.form p").click(function() {
        var data = {
            text: $('#textField').val()
        }
        axios.post("/api/todo", data);
    });
});

function updateViews() {
    axios.get("/api.todo").then(function (response) {
        var items = response.data;
        console.log(items);
        //
    });

}