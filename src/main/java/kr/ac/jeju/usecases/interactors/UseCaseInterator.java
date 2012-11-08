package kr.ac.jeju.usecases.interactors;

import kr.ac.jeju.usecases.responsemodels.ResponseModel;

public interface UseCaseInterator<RESPONSE extends ResponseModel> {
	RESPONSE execute();
}