const list = document.querySelectorAll(".option");
list.forEach(function(element) {
    element.innerText = formatDate(element.innerText); // Output the text content of each element
});

document.getElementById('btnCreerSession').addEventListener('click', function() {
    // Get the value of the element with id "Sessions"
    var date = document.getElementById('date').value;
    var time = document.getElementById('time').value;
    var btnValue=document.getElementById('btnCreerSession').value;
    // Set the value of the element with id "selectedValue"
    document.getElementById('dateValue').value = date;
    document.getElementById('timeValue').value = time;
    document.getElementById('myBtn').value = btnValue;
    // Submit the form with id "hiddenForm"
    document.getElementById('hiddenForm').submit();
});
document.getElementById('btnDetail').addEventListener('click', function() {
    // Get the value of the element with id "Sessions"
    var selectedValue = document.getElementById('rdv').value;
    var btnValue=document.getElementById('btnDetail').value;
    // Set the value of the element with id "selectedValue"
    document.getElementById('selectedValue').value = selectedValue;
    document.getElementById('myBtn2').value = btnValue;
    // Submit the form with id "hiddenForm"
    document.getElementById('hiddenForm2').submit();
});


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
