<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>arenavision</title>

	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

	<div class="container">
	<div class="row">
		<table class="table table-hover table-bordered">
			${html}
		</table>
	</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		// execute when DOM is ready
		$(document).ready(function() {
			
			var table = $('table');
			rows = table.find('tr');
			
			rows.each(function(key,val) {

				if ( key != 0 ) {

					last = $(val).find('td').last();
					links = last.html().split(/-| /);
					oneOrTwoDigit = /^[0-9]{1,2}$/;
					sopId = /^S[0-9]{1,2}$/;
					
					last.text("");

					$.each(links,function(a,b) {

						if (oneOrTwoDigit.exec(b)) {
							last.append($('<a target="_blank" href="#" class="acelink">' + b + '</a>'))
						}
						else {
							
							if ( sopId.exec(b) )
								last.append($('<a target="_blank" href="#" value=' + b.slice(1) + ' class="soplink">' + b + '</a>'))
							else
								last.append(b);
						}

						last.append(" ");
					})
				}
			});		
			
			$('.acelink').click(function(event) {

				event.preventDefault();
				link = $(this);
				var aceID = "av" + link.text();

				$.ajax({
					url: "arena", 
					type: "GET",
					data: {ace: aceID },
					success: function(result) {
						link.attr("href",result);
						window.open(result,'_blank');
					}
				});
			});
			
			$('.soplink').click(function(event) {

				event.preventDefault();
				link = $(this);
				var sopID = "avs" + link.attr("value");

				$.ajax({
					url: "arena", 
					type: "GET",
					data: {sop: sopID },
					success: function(result) {
						link.attr("href",result);
					}
				});
			});
		
		});

	</script>

</body>

</html>
