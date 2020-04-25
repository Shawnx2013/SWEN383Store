<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <!--link href="/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" !-->
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<style>

    </style>

<script>
document.getElementById("myForm").addEventListener("submit", myFunction);

function myFunction() {
  alert("The form was submitted");
}
</script>

  <script>
        function validateForm(){
            var fields = new Array;
            var fields = [document.getElementById('FName'),document.getElementById('LName'),document.getElementById('CardNumber'),
            document.getElementById('date'),document.getElementById('cvv'),document.getElementById('inputAddress'),
            document.getElementById('inputCity'),document.getElementById('inputState'),document.getElementById('inputZip')];
            var err = 0;

            for (i=0;i<fields.length;i++){
                if (fields[i].value == ""){
                err++;
                }
            }

            if (err != 0){
                document.getElementById("inputError").innerHTML = "Please Fill Out All Of The Fields";
                return false;
                }
        }
        </script>



<h1>Payment</h1>
<div id="main">
<div class="row mb-3">
    <div class="col-md-8 themed-grid-col">
        <div class="pb-3">
            ITEM LIST
        </div>
        <div class="row">

            <div class="col-md-6 themed-grid-col">ITEM : 1</div>
            <div class="col-md-6 themed-grid-col">ITEM : 2</div>
        </div>
    </div>
    <div class="col-md-4 themed-grid-col">PAYMENT
    <div>
       <form method="POST" name="paymentForm" onsubmit ="return validateForm()">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="validationDefault01">First name</label>
                    <input type="text" class="form-control" id="FName" name="FName" placeholder="First Name" >
                </div>
                <div class="form-group col-md-6">
                    <label for="validationDefault02">Last name</label>
                    <input type="text" class="form-control" id="LName" name="LName" placeholder="Last Name" >
                </div>
            </div>
            <div class="form-group">
                <label for="CardNumber">Card Number</label>
                <input type="text" class="form-control" id="CardNumber" name="CardNumber">
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="date">Expiration Date</label>
                    <input type="month" class="form-control" id="date" name="date">
                </div>
                <div class="form-group col-md-2">
                    <label for="cvv">CVV</label>
                    <input type="text" class="form-control" id="cvv" name="cvv">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Billing Address</label>
                <input type="text" class="form-control" id="inputAddress" name="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">City</label>
                    <input type="text" class="form-control" id="inputCity" name="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">State</label>
                    <select id="inputState" name="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option value="AL">Alabama</option>
                        <option value="AK">Alaska</option>
                        <option value="AZ">Arizona</option>
                        <option value="AR">Arkansas</option>
                        <option value="CA">California</option>
                        <option value="CO">Colorado</option>
                        <option value="CT">Connecticut</option>
                        <option value="DE">Delaware</option>
                        <option value="DC">District Of Columbia</option>
                        <option value="FL">Florida</option>
                        <option value="GA">Georgia</option>
                        <option value="HI">Hawaii</option>
                        <option value="ID">Idaho</option>
                        <option value="IL">Illinois</option>
                        <option value="IN">Indiana</option>
                        <option value="IA">Iowa</option>
                        <option value="KS">Kansas</option>
                        <option value="KY">Kentucky</option>
                        <option value="LA">Louisiana</option>
                        <option value="ME">Maine</option>
                        <option value="MD">Maryland</option>
                        <option value="MA">Massachusetts</option>
                        <option value="MI">Michigan</option>
                        <option value="MN">Minnesota</option>
                        <option value="MS">Mississippi</option>
                        <option value="MO">Missouri</option>
                        <option value="MT">Montana</option>
                        <option value="NE">Nebraska</option>
                        <option value="NV">Nevada</option>
                        <option value="NH">New Hampshire</option>
                        <option value="NJ">New Jersey</option>
                        <option value="NM">New Mexico</option>
                        <option value="NY">New York</option>
                        <option value="NC">North Carolina</option>
                        <option value="ND">North Dakota</option>
                        <option value="OH">Ohio</option>
                        <option value="OK">Oklahoma</option>
                        <option value="OR">Oregon</option>
                        <option value="PA">Pennsylvania</option>
                        <option value="RI">Rhode Island</option>
                        <option value="SC">South Carolina</option>
                        <option value="SD">South Dakota</option>
                        <option value="TN">Tennessee</option>
                        <option value="TX">Texas</option>
                        <option value="UT">Utah</option>
                        <option value="VT">Vermont</option>
                        <option value="VA">Virginia</option>
                        <option value="WA">Washington</option>
                        <option value="WV">West Virginia</option>
                        <option value="WI">Wisconsin</option>
                        <option value="WY">Wyoming</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip" name="inputZip">
                </div>
            </div>

            <p id="inputError"></p>

            <div class="col-sm-10">
                <button type="button" class="btn btn-secondary">CASH</button>
                <button type="submit" class="btn btn-primary">CONFIRM</button>
            </div>
        </form>

    </div>
    </div>
</div>
</div>

</body>
</html>








</body>
</html>