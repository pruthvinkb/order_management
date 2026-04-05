//Admin login functionality
//login check
function login() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ username, password })
  })
  .then(res => res.text())
  .then(data => {
    if (data.includes("successful")) {

      // 🔥 still use localStorage (for frontend protection)
      localStorage.setItem("isAdmin", "true");

      alert("Login successful ✅");
      window.location.href = "admin_DashBoard.html";

    } else {
      alert("Invalid login ❌");
    }
  });
}