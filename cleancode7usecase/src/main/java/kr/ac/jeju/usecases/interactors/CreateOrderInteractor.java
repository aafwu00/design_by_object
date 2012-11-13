package kr.ac.jeju.usecases.interactors;

import java.util.UUID;

import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

public class CreateOrderInteractor implements UseCaseInteractor<CreateOrderResponseModel> {

	private final Integer customerId;
	private final String customerContactInfo;
	private final String shipmentDestination;
	private final String shipmentMechanism;
	private final String paymentInformation;
	private Order order;

	public CreateOrderInteractor(final CreateOrderRequestModel request) {
		this.customerId = request.getCustomerId();
		this.customerContactInfo = request.getCustomerContactInfo();
		this.shipmentDestination = request.getShipmentDestination();
		this.shipmentMechanism = request.getShipmentMechanism();
		this.paymentInformation = request.getPaymentInformation();
	}

	@Override
	public CreateOrderResponseModel execute() {
		validatesAllData();
		createOrderAndDeterminesOrderId();
		return deliverOrderId();
	}

	protected void validatesAllData() {
		validateCustomerId();
		validateCustomerContactInfo();
		validateShipmentDestination();
		validateShipmentMechanism();
		validatePaymentInformation();
	}

	private void validateCustomerId() {
		if (isNullOrMinus(customerId)) {
			throw new InvalidateException();
		}
	}

	private boolean isNullOrMinus(final Integer content) {
		return content == null || content < 0;
	}

	private void validateCustomerContactInfo() {
		if (isEmpty(customerContactInfo)) {
			throw new InvalidateException();
		}
	}

	private boolean isEmpty(final String content) {
		return content == null || content.length() == 0;
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

	protected void createOrderAndDeterminesOrderId() {
		order = new Order(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
		order.setId(UUID.randomUUID());
	}

	protected CreateOrderResponseModel deliverOrderId() {
		if (order == null) {
			throw new NotCreatedOrderException();
		}
		return new CreateOrderResponseModel(order);
	}

}
