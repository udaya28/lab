function okie() {
    let id = document.getElementById("uname").value;
    let flag = 0;
    let url = "data.xml";
    fetch(url)
    .then((response) => response.text())
    .then((data) => {
    let parser = new DOMParser();
    let xml = parser.parseFromString(data, "application/xml");
    let userid = xml.getElementsByTagName("userid");
    let username = xml.getElementsByTagName("username");
    let address = xml.getElementsByTagName("address");
    let phone = xml.getElementsByTagName("phone");
    let email = xml.getElementsByTagName("email");
    for (let i = 0; i < userid.length; i++) {
    if (id == userid[i].firstChild.nodeValue) {
    let user =
    username[i].firstChild.nodeValue +
    " - " +
    address[i].firstChild.nodeValue +
    " - " +
    phone[i].firstChild.nodeValue +
    " - " +
    email[i].firstChild.nodeValue;
    document.getElementById("result").innerHTML = user;
    flag = 1;
    }
    }
    if (flag === 0) {
    document.getElementById("result").innerHTML = "Invalid User";
    }
    });
}
okie()
