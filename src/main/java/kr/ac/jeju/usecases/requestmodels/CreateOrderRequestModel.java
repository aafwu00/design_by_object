package kr.ac.jeju.usecases.requestmodels;

public class CreateOrderRequestModel implements RequestModel {
	private Integer customerId;
	private String customerContactInfo;
	private String shipmentDestination;
	private String shipmentMechanism;
	private String paymentInformation;

	public CreateOrderRequestModel() {
		super();
	}

	public CreateOrderRequestModel(final Integer customerId, final String customerContactInfo, final String shipmentDestination, final String shipmentMechanism, final String paymentInformation) {
		super();
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