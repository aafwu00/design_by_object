package kr.ac.jeju.usecases.interactors;

public class CreateOrderInteractor {

	private final Integer customerId;
	private final String customerContactInfo;
	private final String shipmentDestination;
	private final String shipmentMechanism;
	private final String paymentInformation;

	public CreateOrderInteractor(final Integer customerId, final String customerContactInfo, final String shipmentDestination, final String shipmentMechanism, final String paymentInformation) {
		this.customerId = customerId;
		this.customerContactInfo = customerContactInfo;
		this.shipmentDestination = shipmentDestination;
		this.shipmentMechanism = shipmentMechanism;
		this.paymentInformation = paymentInformation;
	}

	public void validatesAllData() {
		validateCustomerId();
		validateCustomerContactInfo();
		validateShipmentDestination();
		validateShipmentMechanism();
		validatePaymentInformation();
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
