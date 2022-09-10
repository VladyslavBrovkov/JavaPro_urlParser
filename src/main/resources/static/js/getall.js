$(document).ready(
    function () {
        $("#getStat").click(function (event) {
            event.preventDefault();
            ajaxGet();
        });

        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: window.location + "/stat",
                success: function (result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data,
                            function (i, obj) {
                                custList = "URL Name: "
                                    + obj.url
                                    + ", shortUrl: " + obj.shortUrl
                                    + ", redirects: " + obj.redirects
                                    + ", lastAccessTime: " + obj.lastAccessTime
                                    + "<br>";
                                $('#getResultDiv .list-group').append(
                                    custList)
                            });
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })