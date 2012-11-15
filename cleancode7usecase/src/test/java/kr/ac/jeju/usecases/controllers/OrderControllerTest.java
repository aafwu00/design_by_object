package kr.ac.jeju.usecases.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import kr.ac.jeju.usecases.boundaries.Interactor;
import kr.ac.jeju.usecases.boundaries.InteractorFactory;
import kr.ac.jeju.usecases.boundaries.PresenterFactory;
import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.presenters.CreateOrderPresenter;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	private OrderController controller;

	@Mock
	private PresenterFactory<CreateOrderPresenter> presenterFactory;

	@Mock
	private InteractorFactory<CreateOrderRequestModel> interactorFactory;

	@Mock
	private Model model;

	@Mock
	private CreateOrderRequestModel request;

	@Mock
	private Interactor<CreateOrderRequestModel> interactor;

	@Mock
	private CreateOrderPresenter presenter;

	@Mock
	private Order order;

	@Before
	public void setUp() throws Exception {
		controller = new OrderController();
		controller.setInteractorFactory(interactorFactory);
		controller.setPresenterFactory(presenterFactory);
	}

	@Test
	public void shouldBeCreate() throws Exception {
		when(presenterFactory.create()).thenReturn(presenter);
		when(interactorFactory.create()).thenReturn(interactor);

		controller.create(model, request);

		verify(presenter, times(1)).setModel(model);
		verify(interactor, times(1)).accept(request);
		verify(interactor, times(1)).execute();
	}

}
