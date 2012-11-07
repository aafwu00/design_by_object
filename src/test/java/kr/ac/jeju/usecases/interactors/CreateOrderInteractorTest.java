package kr.ac.jeju.usecases.interactors;

import org.junit.Before;
import org.junit.Test;

public class CreateOrderInteractorTest {

	private CreateOrderInteractor interactor;

	@Before
	public void setUp() throws Exception {
		final Integer customerId = 1;
		final String customerContactInfo = "contactInfo";
		final String shipmentDestination = "destination";
		final String shipmentMechanism = "mechanism";
		final String paymentInformation = "paymentInformation";
		interactor = new CreateOrderInteractor(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
	}

	@Test
	public void shouldBeValidatesAllDate() throws Exception {
		interactor.validatesAllData();
	}

}
