package kr.ac.jeju.usecases.boundaries;

import kr.ac.jeju.usecases.interactors.CreateOrderInteractor;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

public enum BoundaryFactory {
	INSTANCE;

	public static CreateOrderBoundary createOrder(final CreateOrderRequestModel request) {
		return new CreateOrderInteractor(request);
	}
}
