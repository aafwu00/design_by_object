package kr.ac.jeju.usecases.interactors;

import java.util.UUID;

import kr.ac.jeju.usecases.boundaries.Interactor;
import kr.ac.jeju.usecases.boundaries.Presenter;
import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

public class CreateOrderInteractor implements Interactor<CreateOrderRequestModel> {

	private Integer customerId;
	private String customerContactInfo;
	private String shipmentDestination;
	private String shipmentMechanism;
	private String paymentInformation;
	private Order order;

	private Presenter<CreateOrderResponseModel> presenter;

	@Override
	public void accept(final CreateOrderRequestModel request) {
		this.customerId = request.getCustomerId();
		this.customerContactInfo = request.getCustomerContactInfo();
		this.shipmentDestination = request.getShipmentDestination();
		this.shipmentMechanism = request.getShipmentMechanism();
		this.paymentInformation = request.getPaymentInformation();
	}

	@Override
	public void execute() {
		validatesAllData();
		createOrderAndDeterminesOrderId();
		deliverOrderId();
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

	protected void deliverOrderId() {
		if (order == null) {
			throw new NotCreatedOrderException();
		}
		final CreateOrderResponseModel response = new CreateOrderResponseModel(order);
		presenter.accept(response);
		presenter.execute();
	}

	public void setPresenter(final Presenter<CreateOrderResponseModel> presenter) {
		this.presenter = presenter;
	}
}
