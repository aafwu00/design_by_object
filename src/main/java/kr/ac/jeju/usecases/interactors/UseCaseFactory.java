package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

public interface UseCaseFactory {

	UseCaseInterator<CreateOrderResponseModel> create(CreateOrderRequestModel request);

}