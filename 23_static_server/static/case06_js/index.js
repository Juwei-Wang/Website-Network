window.onload = function() {
    // alert("html file loaded");
    var addButton = document.getElementById("addButton");
    // int a = 1;
    // var a = 1; = "1"; = true; = new Point(2, 3);

    addButton.addEventListener('click', function() {
        // alert("clicked");
        var textField1 = document.getElementById("textField1");
        var value1 = parseInt(textField1.value); // NaN : Not a Number

        var textField2 = document.getElementById("textField2");
        var value2 = parseInt(textField2.value);

        var result = value1 + value2;
        
        var resultLabel = document.getElementById("resultLabel");
        resultLabel.innerHTML = result;

        // js create html
        var divElement = document.createElement('div');
        divElement.className = "item";
        var pElement = document.createElement('p');
        pElement.innerHTML = result;
        divElement.appendChild(pElement);

        // 把 新的 html 放到现有的 html 结构里
        var container = document.getElementById("container");
        container.appendChild(divElement);
    });
}
// alert("js file loaded")