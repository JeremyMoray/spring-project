function init(){
    let quantity = document.getElementById('quantity-input');

    quantity.onkeydown = function(e) {
        if(!((e.key >= 1 && e.key <= 9) || e.key === 'Backspace')) {
            return false;
        }
    }

    quantity.onblur = function (e) {
        if(quantity.value === ''){
            quantity.value = 1;
        }
    }
}
window.onload = init;

function changeURL(category, product){

    let url = "/catalog/" + category + "/" + product + "/add/" + document.getElementById("quantity-input").value;
    window.location.href = url;
}