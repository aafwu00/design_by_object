package kr.ac.jeju.usecases.interactors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

import org.junit.Before;
import org.junit.Test;

public class UseCaseFactoryTest {

	private UseCaseFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new UseCaseFactoryImpl();
	}

	@Test
	public void shouldBeCreateOrder() throws Exception {
		final CreateOrderRequestModel request = new CreateOrderRequestModel(null, null, null, null, null);
		assertThat(factory.create(request), is(CreateOrderInteractor.class));
	}
}
