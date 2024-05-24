window.addEventListener("load", function () {
    const slider = document.querySelector(".header-slider");
    const sliderMain = document.querySelector(".slider-main");
    const sliderItem = document.querySelectorAll(".slider-item");
    const nextBtn = document.querySelector(".slider-next");
    const prevBtn = document.querySelector(".slider-prev");
    const dotItems = document.querySelectorAll(".slider-dot-item");
    const sliderItemWidth = sliderItem[0].offsetWidth;
    const slidesLength = sliderItem.length;
    let positionX = 0;
    let index = 0;

    let autoplayInterval;

    function startAutoplay() {
        autoplayInterval = setInterval(function () {
            handleChangeSlide(1);
            if (index >= slidesLength - 1) {
                setTimeout(function () {
                    sliderMain.style.transition = "none";
                    positionX = 0;
                    sliderMain.style.transform = `translateX(${positionX}px)`;
                    index = 0;
                    dotItems.forEach(dot => dot.classList.remove("active"));
                    dotItems[index].classList.add("active");
                }, 1000);
                setTimeout(function () {
                    sliderMain.style.transition = "transform 1s ease-in-out";
                }, 1500);
            }
        }, 5000);
    }

    startAutoplay();

    nextBtn.addEventListener("click", function () {
        handleChangeSlide(1);
    });

    prevBtn.addEventListener("click", function () {
        handleChangeSlide(-1);
    });

    [...dotItems].forEach(item => item.addEventListener("click", function (e) {
        [...dotItems].forEach(el => el.classList.remove("active"));
        e.target.classList.add("active");
        const slideIndex = parseInt(e.target.dataset.index);
        index = slideIndex;
        positionX = -1 * index * sliderItemWidth;
        sliderMain.style = `transform: translateX(${positionX}px)`;
    }));

    function handleChangeSlide(direction) {
        if (direction === 1) {
            if (index >= slidesLength - 1) {
                index = slidesLength - 1;
                return;
            }
            positionX = positionX - sliderItemWidth;
            sliderMain.style = `transform: translateX(${positionX}px)`;
            index++;
        }
        else if (direction === -1) {
            if (index <= 0) {
                index = 0;
                return;
            }
            positionX = positionX + sliderItemWidth;
            sliderMain.style = `transform: translateX(${positionX}px)`;
            index--;
        }
        [...dotItems].forEach(el => el.classList.remove("active"));
        dotItems[index].classList.add("active");
    }
});