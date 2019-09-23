window.onload = function () {
document.getElementById("refresh").addEventListener("click", refreshAs);
}
function refreshAs(){
    window.location.reload()
}
const url = "https://randomuser.me/api/?results=25";
const ul = document.getElementById("users");
function createNode(e) { // create node based on type
   return document.createElement(e);
}
function append(parent, e) {
   return parent.appendChild(e); // Append the second element to the first
}
fetch(url)
.then((resp) => resp.json())
.then(function(data) {
 let users = data.results;
 console.log(data.results);
 return users.map(function(user) {
   let li = createNode('li'),
       img = createNode('img'),
       span = createNode('span');
   img.src = user.picture.thumbnail;
   span.innerHTML = `${user.name.first} ${user.name.last}, ${user.dob.age}`;
   append(li, img);
   append(li, span);
   append(ul, li);
 })
})
.catch(function(error) {
 console.log(error);
});