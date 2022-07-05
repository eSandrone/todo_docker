/**
 * 
 */

 var input = document.getElementById("toDO__text");
 var addBtn = document.getElementById("submit");
 var clearBtn = document.getElementById("clear");
 var clearCompletedBtn = document.getElementById("clear__completed");
 var list = document.getElementById("list");
 var completed = document.getElementById("list__completed");
 var url = "http://192.168.49.2:30100/";
 var lastId;

 addBtn.addEventListener("click", addToDO);
 clearBtn.addEventListener("click", clearList);
 clearCompletedBtn.addEventListener("click", clearCompleted);

 // FUNCTIONS
 function addToDO() {
   let toDOText = input.value;
   let li = document.createElement("li");
   let deleteBtn = document.createElement("button");
   let doneBtn = document.createElement("button");
   let id = "toDO_" + (lastId + 1);
   lastId += 1;
   li.setAttribute("id", id);
   li.appendChild(document.createTextNode(toDOText));
   deleteBtn.appendChild(document.createTextNode("X"));
   deleteBtn.setAttribute("class", "button-small");
   doneBtn.appendChild(document.createTextNode("Done"));
   doneBtn.setAttribute("class", "button-small");
   list.appendChild(li);
   li.appendChild(deleteBtn);
   li.appendChild(doneBtn);
   deleteBtn.addEventListener("click", function () {
     deleteToDO(document.getElementById(id));
   });
   doneBtn.addEventListener("click", function () {
     setToDODone(document.getElementById(id));
   });
   fetch(url + "addTodo", {
    method: "POST",
    headers: {
      "Accept": "application/json, text/plain",
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      description: toDOText,
      isCompleted: false
    })
   })
   .then(data => {return data.json()})
   .then(res => {
    console.log(res)
   })
   input.value = "";
 }

 function clearList() {
   list.innerHTML = "";
 }

 function clearCompleted() {
   completed.innerHTML = "";
 }

 function deleteToDO(toDO) {
  let id = toDO.getAttribute("id");
   list.removeChild(document.getElementById(id));
   fetch(url + "deleteTodo/" + id.split("_").pop(), {
    method: "DELETE"
   })
   .then(data => {return data.json()})
   .then(res => {
    console.log(res)
   })
 }

 function setToDODone(toDO) {
   let toDOElement = document.getElementById(toDO.getAttribute("id"));
   list.removeChild(toDOElement);
   completed.appendChild(toDOElement);
   toDOElement.setAttribute("style", "text-decoration: line-through");
   toDOElement.removeChild(toDOElement.children.item(0));
   toDOElement.removeChild(toDOElement.children.item(0));
   deleteToDO(toDOElement);
 }

 function getAll() {
    fetch(url + "todos")
    .then(data => data.json())
    .then(res => {
      res.forEach(todo => {
        let li = document.createElement("li");
        let deleteBtn = document.createElement("button");
        let doneBtn = document.createElement("button");
        let id = "toDO_" + (todo.id);
        lastId = todo.id;
        li.setAttribute("id", id);
        li.appendChild(document.createTextNode(todo.description));
        deleteBtn.appendChild(document.createTextNode("X"));
        deleteBtn.setAttribute("class", "button-small");
        doneBtn.appendChild(document.createTextNode("Done"));
        doneBtn.setAttribute("class", "button-small");
        list.appendChild(li);
        li.appendChild(deleteBtn);
        li.appendChild(doneBtn);
        deleteBtn.addEventListener("click", function () {
          deleteToDO(document.getElementById(id));
        });
        doneBtn.addEventListener("click", function () {
          setToDODone(document.getElementById(id));
        });
      });
    })
 }

 getAll()