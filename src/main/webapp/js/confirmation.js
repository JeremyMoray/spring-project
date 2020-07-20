function init(){
    let totalPrice = document.getElementById('totalPrice');
    totalPrice.innerText = (Math.round(parseFloat(totalPrice.innerText) * 100) / 100).toFixed(2);
}
window.onload = init;