<html>
	<head>
	<style type="text/css">
	
#error{
display:none;
color:red;
width:250px;
font-size:20px;
font-family:Tahoma, Geneva, sans-serif;
}
     
    </style>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	
	
			<title>Form</title>
	<script>
	$(document).ready(function(){
		var form = $("#myform");
		var id = $("#id");
		var idinfo = $("#idinfo");
		var firstName = $("#firstName");
		var firstNameinfo = $("#firstNameinfo");
		var lastName = $("#lastName");
		var lastNameinfo = $("#lastNameinfo");
		var age = $("#age");
		var ageinfo = $("#ageinfo");
		var email = $("#email");
		var emailinfo = $("#emailinfo");

		id.blur(validateId);
		firstName.blur(validateFirstName);
		lastName.blur(validateLastName);
		age.blur(validateAge);
		email.blur(validateEmail);

		id.keyup(validateId);
		firstName.keyup(validateFirstName);
		lastName.keyup(validateLastName);
		age.keyup(validateAge);
		email.keyup(validateEmail);

        form.submit(function(){
            if(validateId() & validateFirstName() & validateLastName() & validateAge() & validateEmail() ){
                   return true;
            }else
                {
                return false;
                }

            });
        function validateId(){
         if(id.val().length < 2){
             id.addClass("error");
             idinfo.text("Id should be atleast 1 number");
             idinfo.addClass("error");
             return false;
             }else
                 {
                 id.removeClass("error");
                 idinfo.text("please enter your id").hide();
                 idinfo.addClass("error");
                 return true;
                 }
         }
        function validateFirstName(){
            if(firstName.val().length < 3){
            	firstName.addClass("error");
            	firstNameinfo.text("Name should be morethan 3 letters");
            	firstNameinfo.addClass("error");
                return false;
                }else
                    {
                	firstName.removeClass("error");
                	firstNameinfo.text("please enter your firstname").hide();
                	firstNameinfo.addClass("error");
                	return true;
                    }
            }
        function validateLastName(){
            if(lastName.val().length < 3){
            	lastName.addClass("error");
            	lastNameinfo.text("Name should be morethan 3 letters");
            	lastNameinfo.addClass("error");
                return false;
                }else
                    {
                	lastName.removeClass("error");
                	lastNameinfo.text("please enter your lastname").hide();
                	lastNameinfo.addClass("error");
                	return true;
                    }
            }
        function validateAge(){
            if(age.val().length < 2){
            	age.addClass("error");
            	ageinfo.text("Age should be only 2 digits");
            	ageinfo.addClass("error");
                return false;
                }else
                    {
                	age.removeClass("error");
                	ageinfo.text("please enter your age").hide();
                	ageinfo.addClass("error");
                	return true;
                    }
            }


        function validateEmail(){
            var a=$("#email").val();
            var regexp =/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
            if(regexp.test(a)){
            	email.removeClass("error");
            	emailinfo.text("so i can get back to you").hide();
            	emailinfo.removeClass("error");
                return true;
                }else
                    {
                	email.addClass("error");
                	emailinfo.text("Enter a valid email address please");
                	emailinfo.addClass("error");
                	return false;
                    }
            }



        
       
        });
	</script>


		<Style>
		body{
		background-color:orange;
		}
		
		    tab1 { padding-left: 1.20em; }
            tab2 { padding-left: 1em; }
            tab3 { padding-left: 1em; }
            tab4 { padding-right: .50em; }
            tab5 { padding-left:6.30em; }
            tab6 { padding-left: 3.30em; }
            tab7 { padding-left: 3.50em; }
            tab8 { padding-left: 5.50em; }
            tab9 { padding-left: 5.50em; }
            tab10 { padding-left: 5.50em; }
            tab11 { padding-left: 5.50em; }
            tab12 { padding-right: 2.90em; }
            tab13 { padding-left: 5.50em; }
            tab14 { padding-left: 5.50em; }
            
   input[type=text], select {
   position:static;
    width: 20%;
    padding: 8px 15px;
    margin: 4px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 20%;
    background-color: #4CAF50;
    color: white;
    padding: 8px 15px;
    margin: 4px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}
            
div {
    border-radius: 1px;
   /* background-color: yellow;*/
    padding: 0.5px;
}
span{
color:red;
}
		
		</Style>
	</head>
	<body>
<div>
        <g:form action="" controller="person" align="center" ID="myform" action="save" method="post" nonvalidate="nonvalidate"> 
<div id="form-content">
    
            <div class="fieldgroup">   
            <tab6><label for="id">Id: </label></tab6>
            <tab1><input type="text" id="id" name="id"></tab1><br>
            <tab8><span id=idinfo>Please enter Id</span></tab8><br><br>
            </div>
            <div class="fieldgroup">
            <label for="firstName">First Name: </label>
           <tab2><input type="text" id="firstName" name="firstName"></tab2><br>
           <tab9><span id=firstNameinfo>Please enter FirstName</span></tab9><br><br>
            </div>
            <div class="fieldgroup">
            <label for="lastName">Last Name: </label>
            <tab3><input type="text" id="lastName" name="lastName"></tab3><br>
            <tab10><span id=lastNameinfo>Please enter LastName</span></tab10><br><br>
            </div>
            <div class="fieldgroup">
            <tab7><label for="age">Age: </label></tab7>&nbsp;&nbsp;&nbsp;
            <tab4><input type="text" id="age" name="age"></tab4><br>
            <tab11><span id=ageinfo>please enter Age</span></tab11><br><br>
            </div>
            <div class="fieldgroup">
            <tab14><label for="email">Email: </label></tab14>&nbsp;&nbsp;&nbsp;
            <tab12><input type="text" id="email" name="email"></tab12><br>
            <tab13><span id=emailinfo>Please enter EmailId</span></tab13><br><br>
            </div>
            <div class="fieldgroup">
            <tab5><input type="submit" ID="btnsave" value="Save" class="submit" /></tab5>
            </div>
            
        
</div>
         </g:form>
</div>
    </body>
</html>