// Function to create and append buttons
function createButton(text, className, id, onClickFunction) {
    var button = document.createElement("button");
    button.innerText = text;
    button.className = className;
    button.id = id;
    button.onclick = onClickFunction;
    return button;
  }
  
  // Function to append buttons to calculator
  function appendButton(text, className, id, onClickFunction) {
    var calculator = document.getElementById("calculator");
    calculator.appendChild(createButton(text, className, id, onClickFunction));
  }
  
  // Function to append character to display
  function appendToDisplay(character) {
    var display = document.getElementById("display");
    display.value += character;
  }
  
  // Function to clear display
  function clearDisplay() {
    var display = document.getElementById("display");
    display.value = "";
  }
  
  // Function to delete last character from display
  function deleteLast() {
    var display = document.getElementById("display");
    display.value = display.value.slice(0, -1);
  }
  
  // Function to evaluate and display result
  function calculate() {
    var display = document.getElementById("display");
    try {
      var result = eval(display.value);
      display.value = result;
    } catch (error) {
      display.value = "Error";
    }
  }
  
  // Append buttons to calculator
  window.onload = function () {
    appendButton("C", "btn btn-default", "btn-clear", clearDisplay);
    appendButton("DEL", "btn btn-default", "btn-delete", deleteLast);
    appendButton("7", "btn btn-default", "btn-7", function () { appendToDisplay('7'); });
    appendButton("8", "btn btn-default", "btn-8", function () { appendToDisplay('8'); });
    appendButton("9", "btn btn-default", "btn-9", function () { appendToDisplay('9'); });
    appendButton("/", "btn btn-default", "btn-divide", function () { appendToDisplay('/'); });
    appendButton("4", "btn btn-default", "btn-4", function () { appendToDisplay('4'); });
    appendButton("5", "btn btn-default", "btn-5", function () { appendToDisplay('5'); });
    appendButton("6", "btn btn-default", "btn-6", function () { appendToDisplay('6'); });
    appendButton("*", "btn btn-default", "btn-multiply", function () { appendToDisplay('*'); });
    appendButton("1", "btn btn-default", "btn-1", function () { appendToDisplay('1'); });
    appendButton("2", "btn btn-default", "btn-2", function () { appendToDisplay('2'); });
    appendButton("3", "btn btn-default", "btn-3", function () { appendToDisplay('3'); });
    appendButton("-", "btn btn-default", "btn-subtract", function () { appendToDisplay('-'); });
    appendButton("0", "btn btn-default", "btn-0", function () { appendToDisplay('0'); });
    appendButton(".", "btn btn-default", "btn-dot", function () { appendToDisplay('.'); });
    appendButton("=", "btn btn-default equal", "btn-equal", calculate);
    appendButton("+", "btn btn-default", "btn-add", function () { appendToDisplay('+'); });
  };
      