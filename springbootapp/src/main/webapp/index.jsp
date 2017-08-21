<html>
<head>
<script type="text/javascript"
        src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function () {

    $("#subForm").click(function (event) {
        
        event.preventDefault();
        var form = $('#fileData')[0];
        var data = new FormData(form);

		$("#subForm").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/rest/uploadFile",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                $("#result").text(data);
                console.log("SUCCESS : ", data);
                $("#subForm").prop("disabled", false);

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#subForm").prop("disabled", false);

            }
        });

    });

}); 
</script>
</head>
<body>
	<h1 align="center">Welcome to Spring Boot App</h1>
	<div align="center">
		<form method="POST" enctype="multipart/form-data" id="fileData">
			<table style="padding: 10px;">
				<tr style="padding: 10px;">
					<td>Select a file to save in the server:</td>
					<td><input type="file" name="inFile" /></td>
				</tr>				
				<tr style="padding-top:-25px;">
					<td align="right"><input type="submit" value="Submit" id="subForm" /></td>
					<td align="left"><input type="reset" /></td>
				</tr>
			</table>
			
			<br/>
			<span id="result"></span>
		</form>
	</div>
	Comin here
</body>
</html>
