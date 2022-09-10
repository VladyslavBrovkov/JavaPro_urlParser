$(document).ready(
    function () {
        $("#getUrl").submit(function (event) {
            event.preventDefault();
            ajaxGet();
        });

        function ajaxGet() {
            var formData = {
                id: $("#urlId").val()
            }
            $.ajax({
                type: "GET",
                url: "/my/" + $("#urlId").val(),
                success: function (result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        $('#getResultDiv .list-group').append(
                            "Your URL is: " + result.data)
                    } else if (result.status == "empty") {
                        $('#getResultDiv ul').empty();
                        $('#getResultDiv .list-group').append(
                            "No such URL")
                    }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error, empty value</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })