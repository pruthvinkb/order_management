const productList=document.querySelector("#product-list");
const cartDiv = document.getElementById("cart");
let cart = [];
fetch("http://localhost:8080/products")
.then(response => response.json())
.then(data=>{
    data.forEach(product=>{
        const card=document.createElement("div");
        card.innerHTML=`
        <img src="${product.imageUrl}" alt="${product.name}" width="150" height="150"/>
        <h3>${product.name}</h3>
        <p>₹${product.price}</p>
        `;
        productList.appendChild(card);

        card.addEventListener("click", () => {
    const quantity = prompt("Enter quantity:");

    if (!quantity || quantity <= 0) return;

    cart.push({
        name: product.name,
        quantity: quantity
    });

    updateCartUI();
});
    });
});
//from cart adding i need to ready again i did copy paste only that why 
function updateCartUI() {
  cartDiv.innerHTML = "";
  if (cart.length === 0) {
  cartDiv.innerHTML = "<p>No items selected</p>";
  return;
}
  cart.forEach(item => {
    const p = document.createElement("p");
    p.textContent = item.name + " x " + item.quantity;
    cartDiv.appendChild(p);
  });
}
function submitOrder() {
    const name = document.getElementById("name").value;
const phone = document.getElementById("phone").value;
const address = document.getElementById("address").value;

 const items = cart.map(item => item.name + " x " + item.quantity).join(", ");

const order = {
    customerName: name,
    customerPhone: phone,
    customerAddress: address,
    items: items
  };

  fetch("http://localhost:8080/orders", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(order)
  })
  .then(res => res.json())
  .then(data => {
    alert("Order placed successfully!");
    console.log(data);
  });
}