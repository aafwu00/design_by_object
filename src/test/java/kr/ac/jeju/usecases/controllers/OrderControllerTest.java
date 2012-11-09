package kr.ac.jeju.usecases.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.interactors.UseCaseFactory;
import kr.ac.jeju.usecases.interactors.UseCaseInteractor;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

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
	private UseCaseFactory<UseCaseInteractor<CreateOrderResponseModel>, CreateOrderRequestModel> useCaseFactory;

	@Mock
	private Model model;

	@Mock
	private CreateOrderRequestModel request;

	@Mock
	private UseCaseInteractor<CreateOrderResponseModel> interactor;

	@Mock
	private CreateOrderResponseModel response;

	@Mock
	private Order order;

	@Before
	public void setUp() throws Exception {
		controller = new OrderController();
		controller.setUseCaseFactory(useCaseFactory);
	}

	@Test
	public void shouldBeCreate() throws Exception {
		when(useCaseFactory.create(request)).thenReturn(interactor);
		when(interactor.execute()).thenReturn(response);
		when(response.getOrder()).thenReturn(order);

		controller.create(model, request);

		verify(interactor, times(1)).execute();
		verify(model, times(1)).addAttribute("order", order);
	}

}
