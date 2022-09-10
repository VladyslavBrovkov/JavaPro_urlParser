$(document).ready(
    function () {
        $("#parseUrl").submit(function (event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            var formData = {
                url: $("#longUrl").val()
            }
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "shorten",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "Url Added Successfully!" + "</p>");
                    } else if (result.status == "duplicate") {
                        $("#postResultDiv").html(
                            "Duplicate or Empty Value" + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Error, Something went wrong!</strong>");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

        }

    })