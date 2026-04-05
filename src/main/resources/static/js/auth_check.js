//login check
if (localStorage.getItem("isAdmin") !== "true") {
    alert("Access denied. Please login first.");
    window.location.href = "admin.html";
}