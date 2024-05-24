const modal = document.getElementById("myModal");
const btn = document.getElementById("myBtn");
const span = document.getElementsByClassName("modal-close")[0];
const span2 = document.getElementsByClassName("modal-cancel")[0];

btn.onclick = function () {
    modal.style.display = "flex";
}

span.onclick = function () {
    modal.style.display = "none";
}

span2.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

