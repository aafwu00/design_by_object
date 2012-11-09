package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

public class CreateOrderUseCaseFactory implements UseCaseFactory<CreateOrderRequestModel, CreateOrderResponseModel> {

	@Override
	public UseCaseInteractor<CreateOrderResponseModel> create(final CreateOrderRequestModel request) {
		return new CreateOrderInteractor(request);
	}

}
