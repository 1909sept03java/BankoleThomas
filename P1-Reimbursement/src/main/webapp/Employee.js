window.onload = function () {

    fetch(empUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            document.getElementById("welcome").innerText = "Welcome " + data.employeeUsername + "!";
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })

}
//document.getElementById("getInfo").addEventListener("click", getInfo);
//document.getElementById("getEmployeeInfo").addEventListener("click", getEmployeeInfo);
var name=document.getElementById("name");
var pen=document.getElementById("pen");
let empUrl = 'http://localhost:8082/ServletDemo/login';
let penUrl = 'http://localhost:8082/ServletDemo/getAllPending';
let reimUrl = 'http://localhost:8082/ServletDemo/login';

function getInfo() {
    fetch(reimUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            while (document.getElementById("reimbursements-pending").firstChild) {
                document.getElementById("reimbursements-pending").removeChild(document.getElementById("reimbursements-pending").firstChild);
            }
            while (document.getElementById("reimbursements-done").firstChild) {
                document.getElementById("reimbursements-done").removeChild(document.getElementById("reimbursements-done").firstChild);
            }
            var headPen = document.createElement("H3");
            var headNote = document.createTextNode("Pending: ")
            headPen.appendChild(headNote);
            document.getElementById("reimbursements-pending").appendChild(headPen);
            var headDone = document.createElement("H3");
            var headResolved = document.createTextNode("Resolved: ")
            headDone.appendChild(headResolved);
            document.getElementById("reimbursements-done").appendChild(headDone);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId)
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBal = document.createTextNode("Reimbursement Balace: " + data[i].reimbursementBalance)
                node1.appendChild(reimBal);

                var node2 = document.createElement("DIV");
                var reimStat = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus)
                node2.appendChild(reimStat);

                var node3 = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);

                if (data[i].reimbursementStatus == 'P') {
                    document.getElementById("reimbursements-pending").appendChild(main);
                } else {
                    document.getElementById("reimbursements-done").appendChild(main);
                }
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}
function getEmployeeInfo() {
    fetch(norURL, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
//            document.getElementById("info").innerText = "General user info-";
            document.getElementById("employeeId").innerText = "Employee ID: " + data[0].name;
//            document.getElementById("employeeEmail").innerText = "Email: " + data.employeeEmail;
//            document.getElementById("name").innerText = "Username: " + data.name;
//            document.getElementById("employeePassword").innerText = "Password: " + data.employeePassword;
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}

function getPendingInfo() {
    fetch(penUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].name);
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBalance = document.createTextNode("Reimbursement Balance: " + data[i].reimbursementBalance);
                node1.appendChild(reimBalance);

                var node2 = document.createElement("DIV");
                var reimStatus = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus);
                node2.appendChild(reimStatus);
                
                var node3 = document.createElement("DIV");
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node3.appendChild(empId);
                
                var node4 = document.createElement("DIV");
                var empManagerId = document.createTextNode("Employee Manager ID: " + data[i].employeeManagerId);
                node4.appendChild(empManagerId);

                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(nodeBr);
                
                document.getElementById("employeeId").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}
//            document.getElementById("info").innerText = "General user info-";
//            document.getElementById("employeeId").innerHTML = "Employee Name: " + data.name;
//            document.getElementById("employeeEmail").innerText = "Email: " + data.employeeEmail;
//            document.getElementById("name").innerText = "Username: " + data.name;
//            document.getElementById("employeePassword").innerText = "Password: " + data.employeePassword;
      