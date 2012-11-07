package kr.ac.jeju.usecases.requestmodels;

public class CreateOrderRequestModelBuilder {

	private Integer customerId;
	private String customerContactInfo;
	private String shipmentDestination;
	private String shipmentMechanism;
	private String paymentInformation;

	public CreateOrderRequestModel build() {
		return new CreateOrderRequestModel(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
	}

	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}

	public void setCustomerContactInfo(final String customerContactInfo) {
		this.customerContactInfo = customerContactInfo;
	}

	public void setShipmentDestination(final String shipmentDestination) {
		this.shipmentDestination = shipmentDestination;
	}

	public void setShipmentMechanism(final String shipmentMechanism) {
		this.shipmentMechanism = shipmentMechanism;
	}

	public void setPaymentInformation(final String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

}
