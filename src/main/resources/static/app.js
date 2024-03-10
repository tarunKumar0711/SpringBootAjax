function clearForm() {
    document.getElementById('name').value = '';
    document.getElementById('mobileNumber').value = '';
    document.getElementById('email').value = '';
    document.getElementById('fathersName').value = '';
    document.getElementById('panNumber').value = '';
}

$(document).ready(function() {
    function fetchAndDisplayPersons() {
        $.ajax({
            url: '/persons',
            type: 'GET',
            success: function(persons) {
                $('#personTableBody').empty();
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

    fetchAndDisplayPersons();


    $('#addPersonForm').submit(function(event) {
        event.preventDefault();

        var formData = {
            name: $('#name').val(),
            mobileNumber: $('#mobileNumber').val(),
            email: $('#email').val(),
            fathersName: $('#fathersName').val(),
            panNumber: $('#panNumber').val()
        };


        $.ajax({
            type: 'POST',
            url: '/add',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {

                alert('Person added successfully!');
                clearForm();
                fetchAndDisplayPersons();
            },
            error: function(xhr, status, error) {
                alert('Error: ' + xhr.responseText);
            }
        });
    });
});
