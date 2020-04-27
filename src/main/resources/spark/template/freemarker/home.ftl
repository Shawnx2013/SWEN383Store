<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset = "UTF-8">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/index.css">
    <script
        src="https://code.jquery.com/jquery-3.5.0.min.js"
        integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
        crossorigin="anonymous"></script>

    <title>SWEN383Store</title>
           <script src="/js/homeLoadItem.js">
           </script>

</head>
<body>

        <div id="content">
            <h2>Hi ${role}, Welcome to SWEN383Store</h2>
            <div class="grid-container">
                <div class="items">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button name="itemType" onclick="loadItem('cd')" class="btn btn-secondary">Load Game CDs</button>
                        <button name="itemType" onclick="loadItem('dvd')" class="btn btn-secondary">Load Movie Dvds</button>
                    </div>
                    <form action="/load" method="get">
                        <button type="submit" value="dvd" name="itemType" class="btn btn-primary">test for dvd</button>
                    </form>
                    <#include "/items.ftl">
                </div>
                <div class="view">
                    <label>Name: ${name}</label><br>
                    <label>Email: ${email}</label><br>
                    <label>Address: ${address}</label><br>
                    <label>Home Phone: ${home}</label><br>
                    <label>Mobile Phone: ${mobile}</label>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop" id="profile">Update Profile</button>
                </div>
                <div class="action">
                    <button type="button" class="btn btn-primary btn-lg">Large button</button>
                </div>
                <div class="reservation">Manage Reservation</div>
            </div>
        </div>



<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Update Profile Information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
                <div class="modal-body">
                    <form action="/" method="POST">
                    </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>