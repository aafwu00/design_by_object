package kr.ac.jeju.usecases.interactors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

import org.junit.Before;
import org.junit.Test;

public class CreateOrderUseCaseFactoryTest {

	private UseCaseFactory<CreateOrderInteractor, CreateOrderRequestModel> factory;

	@Before
	public void setUp() throws Exception {
		factory = new CreateOrderUseCaseFactory();
	}

	@Test
	public void shouldBeCreate() throws Exception {
		final CreateOrderRequestModel request = new CreateOrderRequestModel();
		assertThat(factory.create(request), is(CreateOrderInteractor.class));
	}

}
