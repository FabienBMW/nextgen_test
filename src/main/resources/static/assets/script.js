document.getElementById("loginButton").addEventListener("click", function() {
    document.getElementById("loginModal").style.display = "block";
});

document.getElementsByClassName("close")[0].addEventListener("click", function() {
    document.getElementById("loginModal").style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target === document.getElementById("loginModal")) {
        document.getElementById("loginModal").style.display = "none";
    }
});

// Fonction pour ouvrir un modal
function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
}

// Fonction pour fermer un modal
function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "none";
}