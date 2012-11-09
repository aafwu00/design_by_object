package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.requestmodels.RequestModel;

public interface UseCaseFactory<U extends UseCaseInteractor<?>, R extends RequestModel> {

	U create(final R request);

}