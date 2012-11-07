-----
Create Order

Data:

	<Customer-id>. <Customer-contact-info>,
	<Shipment-destination>, <Shipment-mechanism>, 
	<Payment-information>

Primary Course:

x	1. Order clerk issues "Create Order" command with the above data
x	2. System validates all data
x	3. System creates order and determines order-id
x	4. System delivers order-id to clerk.

Exception Course: Validation Error

x	1. System delivers error message to clerk

------
