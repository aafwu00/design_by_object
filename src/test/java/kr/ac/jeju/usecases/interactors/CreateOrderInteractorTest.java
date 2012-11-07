package kr.ac.jeju.usecases.interactors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateOrderInteractorTest {

	private CreateOrderInteractor interactor;

	private final Integer customerId = 1;
	private final String customerContactInfo = "contactInfo";
	private final String shipmentDestination = "destination";
	private final String shipmentMechanism = "mechanism";
	private final String paymentInformation = "paymentInformation";

	@Mock
	private CreateOrderInteractor mock;

	@Before
	public void setUp() throws Exception {
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

		assertThat(interactor.deliverOrderId(), is(notNullValue()));
	}

	@Test(expected = NotCreatedOrderException.class)
	public void shouldBeThrowNotCreatedOrderExceptionWhenDeliverOrderId() throws Exception {
		interactor.deliverOrderId();
	}

	@Test
	public void shouldBeExecutePrimaryCourse() throws Exception {
		interactor = new CreateOrderInteractor(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation) {
			@Override
			public void validatesAllData() {
				mock.validatesAllData();
			}

			@Override
			public void createOrderAndDeterminesOrderId() {
				mock.createOrderAndDeterminesOrderId();
			}
		};

		interactor.execute();

		verify(mock, times(1)).validatesAllData();
		verify(mock, times(1)).createOrderAndDeterminesOrderId();
	}

}
