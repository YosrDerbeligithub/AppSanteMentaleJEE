// Select elements with class "option" and format their text content
const list = document.querySelectorAll(".option");
list.forEach(function(element) {
    element.innerText = formatDate(element.innerText); // Output the text content of each element
});

// Add an event listener to a button with id "btnP"
document.getElementById('btnP').addEventListener('click', function() {
    // Get the value of the element with id "Sessions"
    var selectValue = document.getElementById('Sessions').value;
    var btnValue=document.getElementById('btnP').value;
    // Set the value of the element with id "selectedValue"
    document.getElementById('selectedValue').value = selectValue;
    document.getElementById('myBtn').value = btnValue;
    // Submit the form with id "hiddenForm"
    document.getElementById('hiddenForm').submit();
});
document.getElementById('btnA').addEventListener('click', function() {
    // Get the value of the element with id "Sessions"
    var selectValue2 = document.getElementById('rdvs').value;
    var btnValue=document.getElementById('btnA').value;
    // Set the value of the element with id "selectedValue"
    document.getElementById('selectedValue2').value = selectValue2;
    document.getElementById('myBtn2').value = btnValue;
    // Submit the form with id "hiddenForm"
    document.getElementById('hiddenForm2').submit();
});

// Function to format date strings
function formatDate(inputDateStr){
    // Create a Date object from the input string
    const inputDate = new Date(inputDateStr);
    
    // Define arrays for month names and day names
    const monthNames = ['janvier', 'février', 'mars', 'avril', 'mai', 'juin', 'juillet', 'août', 'septembre', 'octobre', 'novembre', 'décembre'];
    const dayNames = ['dimanche', 'lundi', 'mardi', 'mercredi', 'jeudi', 'vendredi', 'samedi'];
    
    // Extract day of the week, day of the month, and month
    const dayOfWeek = dayNames[inputDate.getDay()];
    const dayOfMonth = inputDate.getDate();
    const month = monthNames[inputDate.getMonth()];

    // Extract hour and minute
    let hour = inputDate.getHours();
    const minute = inputDate.getMinutes();

    // Convert hour to AM/PM format
    const am_pm = hour >= 12 ? 'PM' : 'AM';
    hour = hour % 12;
    hour = hour ? hour : 12; // Handle midnight (0 hours)

    // Construct the formatted string
    const formattedDate = `${dayOfWeek} le ${dayOfMonth} ${month} ${hour}:${minute < 10 ? '0' + minute : minute} ${am_pm}`;
    
    return formattedDate;
}
