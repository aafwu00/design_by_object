package kr.ac.jeju.usecases.entities;

import java.util.UUID;

public class Order {

	private final Integer customerId;
	private final String customerContactInfo;
	private final String shipmentDestination;
	private final String shipmentMechanism;
	private final String paymentInformation;

	private UUID id;

	public Order(final Integer customerId, final String customerContactInfo, final String shipmentDestination, final String shipmentMechanism, final String paymentInformation) {
		super();
		this.customerId = customerId;
		this.customerContactInfo = customerContactInfo;
		this.shipmentDestination = shipmentDestination;
		this.shipmentMechanism = shipmentMechanism;
		this.paymentInformation = paymentInformation;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
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
