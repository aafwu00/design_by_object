<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Order Home</title>
</head>
<body>
	<form action="create" method="get">
		<p>
			<label>Customer Id</label>
			<input type="text" name="customerId" />
		</p>
		<p>
			<label>Customer ContactInfo</label>
			<input type="text" name="customerContactInfo" />
		</p>
		<p>
			<label>Shipment Destination</label>
			<input type="text" name="shipmentDestination" />
		</p>
		<p>
			<label>Shipment Mechanism</label>
			<input type="text" name="shipmentMechanism" />
		</p>
		<p>
			<label>Payment Information</label>
			<input type="text" name="paymentInformation" />
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>

</body>
</html>
