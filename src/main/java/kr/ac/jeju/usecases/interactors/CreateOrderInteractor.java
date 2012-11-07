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
		// TODO Auto-generated method stub

	}

}
