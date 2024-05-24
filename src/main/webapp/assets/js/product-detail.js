const inputPro = document.querySelector("#number--product");
document.querySelector("#add--product").addEventListener("click", function(event) {
    event.preventDefault();
    let currentVal = parseInt(inputPro.value);
    inputPro.value = currentVal + 1;
    console.log("success");
});


document.querySelector("#sub--product").addEventListener("click", function(event) {
    event.preventDefault();
    let currentVal = parseInt(inputPro.value);
    if (currentVal <= 1) {
        inputPro.value = 1;
    } else
        inputPro.value = currentVal - 1;
});

