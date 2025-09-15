
const container = document.querySelector(".container");
const btnin = document.getElementById("btn-sign-in");
const btnup = document.getElementById("btn-sign-up");

btnin.addEventListener("click", ()=>{
    container.classList.remove("toggle");
}); 
btnup.addEventListener("click", ()=>{
    container.classList.add("toggle");
}); 

