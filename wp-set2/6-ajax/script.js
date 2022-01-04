function submit() {
    let flag = 0;
    const id = document.getElementById("uname").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const data = xhttp.responseText;
            let parser = new DOMParser();
            let xml = parser.parseFromString(data, "application/xml");
            let userid = xml.getElementsByTagName("userid");
            let fname = xml.getElementsByTagName("fname");
            let sname = xml.getElementsByTagName("sname");
            let balance = xml.getElementsByTagName("balance");

            for (let i = 0; i < userid.length; i++) {
                if(userid[i].firstChild.nodeValue == id){
                    flag = 1;
                    const html = `<li>id - ${userid[i].firstChild.nodeValue}</li> 
                    <li>first name - ${fname[i].firstChild.nodeValue}</li> 
                    <li>second name - ${sname[i].firstChild.nodeValue}</li> 
                    <li> balance - ${balance[i].firstChild.nodeValue}</li>`
                    document.getElementById("result").innerHTML = html
                }
            }
            if(flag === 0){
                document.getElementById("result").innerHTML = "Invalid User";
            }
        };
    }
    xhttp.open("GET", "data.xml", true);
    xhttp.send();
}
