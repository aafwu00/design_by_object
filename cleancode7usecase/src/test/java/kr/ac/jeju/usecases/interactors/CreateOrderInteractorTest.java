package kr.ac.jeju.usecases.interactors;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import kr.ac.jeju.usecases.boundaries.Presenter;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

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

	private CreateOrderRequestModel request;

	@Mock
	private CreateOrderResponseModel response;

	@Mock
	private Presenter<CreateOrderResponseModel> presenter;

	@Before
	public void setUp() throws Exception {
		request = new CreateOrderRequestModel(customerId, customerContactInfo, shipmentDestination, shipmentMechanism, paymentInformation);
		interactor = new CreateOrderInteractor();
		interactor.accept(request);
		interactor.setPresenter(presenter);
	}

	@Test
	public void shouldBeValidatesAllDate() throws Exception {
		interactor.validatesAllData();
	}

	@Test(expected = InvalidateException.class)
	public void shouldBeThrowInvalidateExceptionWhenCustomerIsInvalidate() throws Exception {
		final CreateOrderRequestModel request = new CreateOrderRequestModel(null, null, null, null, null);
		interactor = new CreateOrderInteractor();
		interactor.accept(request);
		interactor.validatesAllData();
	}

	@Test
	public void shouldBeCreateOrderAndDeterminesOrderId() throws Exception {
		interactor.createOrderAndDeterminesOrderId();
		interactor.deliverOrderId();

		verify(presenter, times(1)).accept(any(CreateOrderResponseModel.class));
		verify(presenter, times(1)).execute();
	}

	@Test(expected = NotCreatedOrderException.class)
	public void shouldBeThrowNotCreatedOrderExceptionWhenDeliverOrderId() throws Exception {
		interactor.deliverOrderId();
	}

	@Test
	public void shouldBeExecutePrimaryCourse() throws Exception {
		interactor = new CreateOrderInteractor() {
			@Override
			protected void validatesAllData() {
				mock.validatesAllData();
			}

			@Override
			protected void createOrderAndDeterminesOrderId() {
				mock.createOrderAndDeterminesOrderId();
			}

			@Override
			protected void deliverOrderId() {
				mock.deliverOrderId();
			}
		};
		interactor.execute();

		verify(mock, times(1)).validatesAllData();
		verify(mock, times(1)).createOrderAndDeterminesOrderId();
		verify(mock, times(1)).deliverOrderId();
	}

}
