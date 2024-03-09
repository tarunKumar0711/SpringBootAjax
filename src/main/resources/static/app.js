$(document).ready(function() {
    // Function to fetch and update the table with persons data
    function fetchAndDisplayPersons() {
        $.ajax({
            url: '/persons', // Your RESTful API endpoint to fetch persons
            type: 'GET',
            success: function(persons) {
                // Clear existing table rows
                $('#personTableBody').empty();
                // Process retrieved data and display in HTML
                persons.forEach(function(person) {
                    $('#personTableBody').append(
                        `<tr>
                            <td>${person.name}</td>
                            <td>${person.mobileNumber}</td>
                            <td>${person.email}</td>
                            <td>${person.fathersName}</td>
                            <td>${person.panNumber}</td>
                        </tr>`
                    );
                });
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    // Initial call to fetch and display persons on page load
    fetchAndDisplayPersons();

    // Handle form submission
    $('#addPersonForm').submit(function(event) {
        event.preventDefault(); // Prevent default form submission

        // Get form data
        var formData = {
            name: $('#name').val(),
            mobileNumber: $('#mobileNumber').val(),
            email: $('#email').val(),
            fathersName: $('#fathersName').val(),
            panNumber: $('#panNumber').val()
        };

        // Send AJAX request to add person
        $.ajax({
            type: 'POST',
            url: '/add',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                // Handle success
                alert('Person added successfully!');
                // Fetch and display updated persons data
                fetchAndDisplayPersons();
                // Optionally, update table or perform other actions
            },
            error: function(xhr, status, error) {
                // Handle errors
                alert('Error: ' + xhr.responseText);
            }
        });
    });
});
