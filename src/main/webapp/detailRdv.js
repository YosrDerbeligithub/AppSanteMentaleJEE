
document.getElementById("date").innerText=formatDate(document.getElementById("date").innerText);
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
