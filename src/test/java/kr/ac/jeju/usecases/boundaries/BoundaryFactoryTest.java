package kr.ac.jeju.usecases.boundaries;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jeju.usecases.interactors.CreateOrderInteractor;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoundaryFactoryTest {

	@Mock
	private CreateOrderRequestModel request;

	@Test
	public void shouldBeCreateOrder() throws Exception {
		assertThat(BoundaryFactory.createOrder(request), is(CreateOrderInteractor.class));
	}
}
