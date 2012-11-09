package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

public class CreateOrderUseCaseFactory implements UseCaseFactory<CreateOrderInteractor, CreateOrderRequestModel> {

	@Override
	public CreateOrderInteractor create(final CreateOrderRequestModel request) {
		return new CreateOrderInteractor(request);
	}

}
