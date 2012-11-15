package kr.ac.jeju.usecases.boundaries;

import kr.ac.jeju.usecases.requestmodels.RequestModel;

public interface InteractorFactory<REQUEST extends RequestModel> {
	Interactor<REQUEST> create();
}