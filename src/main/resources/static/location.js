function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(sendLocationToServer);
    } else {
        alert("Geolocalização não suportada pelo navegador.");
    }
}

function sendLocationToServer(position) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/location", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            var location = JSON.parse(xhr.responseText);
            updateLocationOnPage(location.city + ", " + location.state);
        }
    };
    xhr.send(JSON.stringify({lat: position.coords.latitude, lng: position.coords.longitude}));
}

function updateLocationOnPage(location) {
    document.getElementById("location").innerText = location;
}
