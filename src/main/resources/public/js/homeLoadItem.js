async function loadItem(type){
    let xhttp = new XMLHttpRequest();
    let params = "itemType="+type;
    console.log(params);
    let result;
    xhttp.open('GET', '/load'+"?"+params, true);
    xhttp.send();
    xhttp.responseType = 'json';
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            result = xhttp.response;
            console.log(result);
            let box = document.getElementById("itemBox");
            while (box.firstChild){
                box.removeChild(box.lastChild);
            }
            result.forEach(function(item){
                let button = document.createElement("button");
                button.setAttribute("class",
                    "list-group-item list-group-item-action");
                button.textContent ="Name: " + item.name + " "+ item.availableAmt + " Available";

                box.append(button);
            })

        }
    }
}

function load(method, path, in_data){

    return $.ajax({
            type: method,
            cache: false,
            async: true,
            dataType: 'json',
            url: path,
            contentType: 'multipart/form-data',
            data: in_data,
            beforeSend:function(){
                console.log("method: " + method);
                console.log("path: " + path);
                console.log("data: " + in_data);
            }
        }).done(function(){
            console.log('Sent');

        }).fail(function(){
            console.log("Failure with: ");
            console.log("method: " + method);
            console.log("path: " + path);
            console.log("data: " + in_data);
        })
}
