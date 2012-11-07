package kr.ac.jeju.usecases.interactors;

import java.util.UUID;

import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

public class CreateOrderInteractor {

	private final Integer customerId;
	private final String customerContactInfo;
	private final String shipmentDestination;
	private final String shipmentMechanism;
	private final String paymentInformation;
	private Order order;

	public CreateOrderInteractor(CreateOrderRequestModel request) {
		this.customerId = request.getCustomerId();
		this.customerContactInfo = request.getCustomerContactInfo();
		this.shipmentDestination = request.getShipmentDestination();
		this.shipmentMechanism = request.getShipmentMechanism();
		this.paymentInformation = request.getPaymentInformation();
	}

	public void execute() {
		validatesAllData();
		createOrderAndDeterminesOrderId();
	}

	public UUID deliverOrderId() {
		if (order == null) {
			throw new NotCreatedOrderException();
		}
		return order.getId();
	}

	protected void validatesAllData() {
		validateCustomerId();
		validateCustomerContactInfo();
		validateShipmentDestination();
		validateShipmentMechanism();
		validatePaymentInformation();
	}

	protected void createOrderAndDeterminesOrderId() {
		order = new Order(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
		order.setId(UUID.randomUUID());
	}

	private void validateCustomerContactInfo() {
		if (isEmpty(customerContactInfo)) {
			throw new InvalidateException();
		}
	}

	private void validateShipmentDestination() {
		if (isEmpty(shipmentDestination)) {
			throw new InvalidateException();
		}
	}

	private void validateShipmentMechanism() {
		if (isEmpty(shipmentMechanism)) {
			throw new InvalidateException();
		}
	}

	private void validatePaymentInformation() {
		if (isEmpty(paymentInformation)) {
			throw new InvalidateException();
		}
	}

	private void validateCustomerId() {
		if (isNullOrMinus(customerId)) {
			throw new InvalidateException();
		}
	}

	private boolean isEmpty(final String content) {
		return content == null || content.length() == 0;
	}

	private boolean isNullOrMinus(final Integer content) {
		return content == null || content < 0;
	}

}
