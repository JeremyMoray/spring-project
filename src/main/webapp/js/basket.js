function init(){
    let infoColumns = document.getElementsByClassName("product-infos-basket");
    for(let infoColumn of infoColumns){
        infoColumn.addEventListener('input', function (evt) {
            showUpdateButton(evt);
            updateTotalPrice();
        });
    }
    addValidations();

    let totalPrice = document.getElementById('totalPrice');
    totalPrice.innerText = (Math.round(parseFloat(totalPrice.innerText) * 100) / 100).toFixed(2);
}
window.onload = init;

function addValidations(){
    let quantities = document.getElementsByClassName('quantity-value');

    for(let quantity of quantities){
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
}

function updateTotalPrice(){
    let infoColumns = document.getElementsByClassName("product-infos-basket");
    let totalPrice = 0;
    for(let infoColumn of infoColumns){
        totalPrice += parseFloat(infoColumn.getElementsByClassName("price-value")[0].innerHTML) * parseFloat(infoColumn.getElementsByClassName("quantity-value")[0].value);
    }
    totalPrice = (Math.round(totalPrice * 100) / 100).toFixed(2);
    document.getElementById("totalPrice").innerText = totalPrice.toString();
}

function showUpdateButton(evt) {
    let keyname = evt.target.id.replace('basket-input-','');
    document.getElementById("link-update-basket-" + keyname).style.visibility = "visible";
}

function reloadQuantity(event){
    let keyname = event.id.replace('link-update-basket-','');
    let quantity = document.getElementById("basket-input-" + keyname).value;

    window.location.href = ("/basket/update?keyname=" + keyname + "&quantity=" + quantity);
}