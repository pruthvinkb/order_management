const orderList=document.getElementById("order-list");

fetch("http://localhost:8080/orders")
  .then(res => res.json())
  .then(data => {
   data.forEach(order=>{

    const orderItem=document.createElement("div");

    orderItem.classList.add("order-card");
     
     const statusClass = order.status === "Delivered" ? "delivered" : "pending";
    orderItem.innerHTML = `
     <p><b>Name:</b> ${order.customerName}</p>
     <p><b>Phone:</b> ${order.customerPhone}</p>
     <p><b>Address:</b> ${order.customerAddress}</p>
     <p><b>Items:</b> ${order.items}</p>
    <p class="status ${statusClass}">Status: ${order.status}</p>

    <button onclick="markDelivered(${order.id})">
    Mark Delivered
    </button>

    <hr>
    `;
    orderList.appendChild(orderItem);
   })
  });
  function markDelivered(id) {
  fetch(`http://localhost:8080/orders/${id}/status`, {
    method: "PUT"
  })
  .then(res => res.json())
  .then(data => {
    alert("Order marked as Delivered!");
    location.reload(); // refresh page
  })
  .catch(err => {
    console.error(err);
    alert("Failed to update order");
  });
}
function logout() {
  localStorage.removeItem("isAdmin");
  window.location.href = "admin.html";
}