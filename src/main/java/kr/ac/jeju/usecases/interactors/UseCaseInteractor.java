package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.responsemodels.ResponseModel;

public interface UseCaseInteractor<R extends ResponseModel> {

	R execute();

}