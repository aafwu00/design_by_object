package kr.ac.jeju.usecases.requestmodels;

public class CreateOrderRequestModel {
	private Integer customerId;
	private String customerContactInfo;
	private String shipmentDestination;
	private String shipmentMechanism;
	private String paymentInformation;

	public CreateOrderRequestModel(Integer customerId, String customerContactInfo, String shipmentDestination, String shipmentMechanism, String paymentInformation) {
		this.customerId = customerId;
		this.customerContactInfo = customerContactInfo;
		this.shipmentDestination = shipmentDestination;
		this.shipmentMechanism = shipmentMechanism;
		this.paymentInformation = paymentInformation;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getCustomerContactInfo() {
		return customerContactInfo;
	}

	public String getShipmentDestination() {
		return shipmentDestination;
	}

	public String getShipmentMechanism() {
		return shipmentMechanism;
	}

	public String getPaymentInformation() {
		return paymentInformation;
	}
}