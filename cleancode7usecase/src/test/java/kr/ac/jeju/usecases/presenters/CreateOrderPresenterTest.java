package kr.ac.jeju.usecases.presenters;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import kr.ac.jeju.usecases.entities.Order;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class CreateOrderPresenterTest {
	private CreateOrderPresenter presenter;

	@Mock
	private CreateOrderResponseModel response;

	@Mock
	private Model model;

	@Mock
	private Order order;

	@Before
	public void setUp() throws Exception {
		presenter = new CreateOrderPresenter();
		presenter.setModel(model);
		presenter.accept(response);
	}

	@Test
	public void shouldBeSetOrderToModel() throws Exception {
		when(response.getOrder()).thenReturn(order);

		presenter.execute();

		verify(model, times(1)).addAttribute("order", order);
	}
}
