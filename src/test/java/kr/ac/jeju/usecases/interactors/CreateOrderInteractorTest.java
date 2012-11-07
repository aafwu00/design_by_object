package kr.ac.jeju.usecases.interactors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import kr.ac.jeju.usecases.entities.Order;

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

	@Test(expected = InvalidateException.class)
	public void shouldBeThrowInvalidateExceptionWhenCustomerIsInvalidate() throws Exception {
		interactor = new CreateOrderInteractor(null, null, null, null, null);
		interactor.validatesAllData();
	}

	@Test
	public void shouldBeCreateOrderAndDeterminesOrderId() throws Exception {
		interactor.createOrderAndDeterminesOrderId();
		final Order order = interactor.getOrder();

		assertThat(order.getId(), is(notNullValue()));
	}

	@Test
	public void shouldBeDeliversOrderId() throws Exception {
		interactor.createOrderAndDeterminesOrderId();

		assertThat(interactor.deliverOrderId(), is(notNullValue()));
	}

}
