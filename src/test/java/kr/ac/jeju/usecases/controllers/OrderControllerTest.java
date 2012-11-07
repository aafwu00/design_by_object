package kr.ac.jeju.usecases.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class OrderControllerTest {

	private OrderController controller;
	private MockHttpServletRequest request;
	private MockHttpServletRequest response;

	private final String customerId = "1";
	private final String customerContactInfo = "contactInfo";
	private final String shipmentDestination = "destination";
	private final String shipmentMechanism = "mechanism";
	private final String paymentInformation = "paymentInformation";

	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletRequest();
		controller = new OrderController();
	}

	@Test
	public void shouldBeCreateOrder() throws Exception {
		request.setParameter("customerId", customerId);
		request.setParameter("customerContactInfo", customerContactInfo);
		request.setParameter("shipmentDestination", shipmentDestination);
		request.setParameter("shipmentMechanism", shipmentMechanism);
		request.setParameter("paymentInformation", paymentInformation);

		controller.create(request, response);

		assertThat(response.getAttribute("orderId"), is(notNullValue()));
	}
}
