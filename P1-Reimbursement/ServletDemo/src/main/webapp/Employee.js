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
        
            console.log(error);
        })

   // document.getElementById("getInfo").addEventListener("click", getInfo);
    //document.getElementById("getEmployeeInfo").addEventListener("click", getEmployeeInfo);

}

let empsessUrl = 'http://localhost:8082/ServletDemo/EmployeeSessionServlet';

//let reimUrl = 'http://localhost:8082/Reimbursement/reimbursementSession';



var name=document.getElementById("name");
var pen=document.getElementById("pen");
var allemp=document.getElementById("allemp");

let empUrl = 'http://localhost:8082/ServletDemo/login';
let penUrl = 'http://localhost:8082/ServletDemo/getAllPending';
let appUrl = 'http://localhost:8082/ServletDemo/getAllApproved';
let reimUrl = 'http://localhost:8082/ServletDemo/login';
let allEmpUrl = 'http://localhost:8082/ServletDemo/AllEmployeesServlet';

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
    fetch(empsessUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            document.getElementById("info").innerText = "EMPLOYEE DATA";
            document.getElementById("employeeId").innerText = "Employee ID: " + data.employeeId;
            document.getElementById("employeeUsername").innerText = "Username: " + data.employeeUsername;
            document.getElementById("employeePassword").innerText = "Password: " + data.employeePassword;
            document.getElementById("employeeManager").innerText = "isManager: " + data.employeeManager;
        })
        // catching an error
        .catch((error) => {
            
            console.log(error);
        })};

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
               

                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(nodeBr);
                
                document.getElementById("employeeId").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
           
            console.log(error);
        })
}

function getApprovedInfo() {
    fetch(appUrl, { method: "GET", headers: { "Accept": "application/json" } })
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

function getAllEmployees() {
    fetch(allEmpUrl, { method: "GET", headers: { "Accept": "application/json" } })
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
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node.appendChild(empId);

                var node1 = document.createElement("DIV");
                var empUsername = document.createTextNode("Username: " + data[i].employeeUsername);
                node1.appendChild(empUsername);

                var node2 = document.createElement("DIV");
                var empPassword = document.createTextNode("Password: " + data[i].employeePassword);
                node2.appendChild(empPassword);
                
               

               
                
                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2)
                main.appendChild(nodeBr);
                
                document.getElementById("allEmployees").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}