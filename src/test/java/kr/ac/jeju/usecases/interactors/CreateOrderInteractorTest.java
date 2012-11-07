package kr.ac.jeju.usecases.interactors;

import org.junit.Test;

public class CreateOrderInteractorTest {

	@Test
	public void shouldBeCreateWithCustomerShipmentAndPayment() throws Exception {
		final Integer customerId = 1;
		final String customerContactInfo = "contactInfo";
		final String shipmentDestination = "destination";
		final String shipmentMechanism = "mechanism";
		final String paymentInformation = "paymentInformation";
		final CreateOrderInteractor interactor = new CreateOrderInteractor(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
	}

}
