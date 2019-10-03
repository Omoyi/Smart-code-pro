var form = document.querySelector(".form");
var signIn = document.getElementById("signIn");
var signUp = document.getElementById("signUp");

signUp.addEventListener("click", function() {
  form.classList.add("translate");
});
signIn.addEventListener("click", function() {
  form.classList.remove("translate");
});
