package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.RequestModel;
import kr.ac.jeju.usecases.responsemodels.ResponseModel;

public interface UseCaseFactory<REQUEST extends RequestModel, RESPONSE extends ResponseModel> {

	UseCaseInteractor<RESPONSE> create(final REQUEST request);

}