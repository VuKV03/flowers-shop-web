// Lấy danh sách các quận huyện của các tỉnh thành phố trong Việt Nam
const districts = {
    "Hà Nội": ["Hà Đông"],
    "Hồ Chí Minh": ["Quận 1"],

};

// Danh sách các chi nhánh của từng quận huyện
const branches = {
    "Hà Đông": ["Chi nhánh Nguyễn Trãi"],
	"Quận 1": ["Chi nhánh Nguyễn Đình Chiểu"]
};

// Function để render danh sách quận huyện theo tỉnh thành phố
function renderDistricts(city) {
    const districtSelect = document.querySelector("#district");
    districtSelect.innerHTML = ""; // Reset danh sách quận huyện

    // Render danh sách quận huyện
    districts[city].forEach((district) => {
        const option = document.createElement("option");
        option.value = district;
        option.innerHTML = district;
        districtSelect.appendChild(option);
    });
}

// Function để render danh sách các chi nhánh theo quận huyện
function renderBranches(district) {
    const branchSelect = document.querySelector("#shop");
    branchSelect.innerHTML = "" // Reset danh sách chi nhánh

    // Render danh sách chi nhánh
    branches[district].forEach((branch) => {
        const option = document.createElement("option");
        option.value = branch;
        option.innerHTML = branch;
        branchSelect.appendChild(option);
    });
}

// Lắng nghe sự kiện khi tỉnh thành phố được chọn
document.querySelector("#city").addEventListener("change", (event) => {
    const city = event.target.value;
    renderDistricts(city);
    renderBranches(districts[city][0]);
    mapChange();
});


// Lắng nghe sự kiện khi quận huyện được chọn
document.querySelector("#district").addEventListener("change", (event) => {
    const district = event.target.value;
    renderBranches(district);
    mapChange();
});

//trả về thành phố được chọn
function validateSelectCity() {
    var options = document.getElementById("city");
    var html = '';
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            html += options[i].value;
            break;
        }
    }
    return html;
}

//trả về quận, huyện được chọn
function validateSelectDistrict() {
    var options = document.getElementById("district");
    var html = '';
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            html += options[i].value;
            break;
        }
    }
    return html;
}

//trả về chi nhánh được chọn
function validateSelectShop() {
    var options = document.getElementById("shop");
    var html = '';
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            html += options[i].value;
            break;
        }
    }
    return html;
}

const maps = [
    [1, 'Hà Nội', 'Hà Đông', 'Chi nhánh Nguyễn Trãi', '96A Đường Trần Phú, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam', '☎ 1900 1010 - Nhánh 101'],
    [2, 'Hồ Chí Minh', 'Quận 1', 'Chi nhánh Nguyễn Đình Chiểu', '11 Nguyễn Đình Chiểu, Đa Kao, Quận 1, Thành phố Hồ Chí Minh, Việt Nam', '☎ 1900 1010 - Nhánh 102'],
];

//thay đổi địa chỉ, số điện thoại
function mapChange() {
    const map = document.getElementById("store-map");
    const shopAdress = document.getElementById("adress");
    const shopPhone = document.getElementById("phone");

    let city = validateSelectCity();
    let district = validateSelectDistrict();
    let shop = validateSelectShop();
    let id = 0;

    for (let i = 0; i < maps.length; i++) {
        if (maps[i][1] === city && maps[i][2] === district && maps[i][3] === shop) {
            shopAdress.textContent = maps[i][4]; // thay đổi nội dung địa chỉ
            shopPhone.textContent = maps[i][5]; // thay đổi nội dung số điện thoại
            id = i + 1;
            break;
        }
    }

    //thay đổi địa chỉ hiện trên google map
    if (id == 1) {
        map.innerHTML = '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.8550433631945!2d105.81055487444931!3d20.998446988820625!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ad451df5656b%3A0x1f65c96d05d1c064!2zUFRJVC3EkOG6oWkgSOG7jWMgVkxWSA!5e0!3m2!1svi!2s!4v1716556083752!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>';
    }
    else if (id == 2) {
        map.innerHTML = '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d62708.56631172282!2d106.62451104863281!3d10.789439900000003!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528b545b5903b%3A0x2381a6fe3f690419!2zSOG7jWMgdmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IGNow61uaCBWaeG7hW4gdGjDtG5nIEPGoSBz4bufIHThuqFpIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1716555266638!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>';
    }
}
