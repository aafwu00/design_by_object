package kr.ac.jeju.usecases.responsemodels;

import kr.ac.jeju.usecases.entities.Order;

public class CreateOrderResponseModel implements ResponseModel {
	private final Order order;

	public CreateOrderResponseModel(final Order order) {
		super();
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}
}