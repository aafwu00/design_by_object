package kr.ac.jeju.usecases.controllers;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jeju.usecases.boundaries.BoundaryFactory;
import kr.ac.jeju.usecases.boundaries.CreateOrderBoundary;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModelBuilder;

public class OrderController {

	public void create(final HttpServletRequest request, final HttpServletRequest response) {
		final CreateOrderRequestModel requestModel = buildRequestModel(request);
		final CreateOrderBoundary boundary = BoundaryFactory.createOrder(requestModel);
		boundary.execute();
		response.setAttribute("orderId", boundary.deliverOrderId());
	}

	private CreateOrderRequestModel buildRequestModel(final HttpServletRequest request) {
		final Integer customerId = Integer.valueOf(request.getParameter("customerId"));
		final String customerContactInfo = request.getParameter("customerContactInfo");
		final String shipmentDestination = request.getParameter("shipmentDestination");
		final String shipmentMechanism = request.getParameter("shipmentMechanism");
		final String paymentInformation = request.getParameter("paymentInformation");

		final CreateOrderRequestModelBuilder builder = new CreateOrderRequestModelBuilder();
		builder.setCustomerId(customerId);
		builder.setCustomerContactInfo(customerContactInfo);
		builder.setShipmentDestination(shipmentDestination);
		builder.setShipmentMechanism(shipmentMechanism);
		builder.setPaymentInformation(paymentInformation);
		final CreateOrderRequestModel requestModel = builder.build();
		return requestModel;
	}

}
