package kr.ac.jeju.usecases.requestmodels;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CreateOrderRequestModelBuilderTest {

	private final Integer customerId = 1;
	private final String customerContactInfo = "contactInfo";
	private final String shipmentDestination = "destination";
	private final String shipmentMechanism = "mechanism";
	private final String paymentInformation = "paymentInformation";

	private CreateOrderRequestModelBuilder builder;

	@Before
	public void setUp() throws Exception {
		builder = new CreateOrderRequestModelBuilder();
	}

	@Test
	public void shouldBeBuildWithParamter() throws Exception {
		builder.setCustomerId(customerId);
		builder.setCustomerContactInfo(customerContactInfo);
		builder.setShipmentDestination(shipmentDestination);
		builder.setShipmentMechanism(shipmentMechanism);
		builder.setPaymentInformation(paymentInformation);

		assertThat(builder.build(), is(CreateOrderRequestModel.class));
	}
}
