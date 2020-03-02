window.onload = function(){
    alert("html file loaded")
    var addButton = document.getElementById("addButton");
    
    addButton.addEventListener('click',function(){
        alert("clicked");
        var textFiled1 = document.getElementById("textFiled1");
        var value1 = parseInt(textFiled1.value);

        var textFiled2 = document.getElementById("textFiled2");
        var value2 = parseInt(textFiled2.value);

        var result = value1 + value2;

        var resultLabel = document.getElementById("resultLabel");
        resultLabel.innerHTML = result;

        var divElement = document.createElement('div');
        divElement.className = "item";
        var pElement = document.createElement('p');
        pElement.innerHTML = result;
        divElement.appendChild(pElement);

        var container = document.getElementById("container");
        container.appendChild(divElement);
    });
    
}