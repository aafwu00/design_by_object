package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

public class UseCaseFactoryImpl implements UseCaseFactory {

	@Override
	public UseCaseInterator<CreateOrderResponseModel> create(final CreateOrderRequestModel request) {
		return new CreateOrderInteractor(request);
	}

}
