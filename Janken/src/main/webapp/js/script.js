/**
 * 
 */
document.getElementById("myForm").addEventListener("submit", function(event) {
  var selectedJanken = document.querySelector('input[name="selection"]:checked');
  
  if (!selectedJanken) {
    document.getElementById("error-message").textContent = "Choose your rock-paper-scissors hand!!";
    event.preventDefault(); // フォームの送信を中止
  } else {
    document.getElementById("error-message").textContent = "";
  }
});