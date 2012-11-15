package kr.ac.jeju.usecases.boundaries;

import kr.ac.jeju.usecases.requestmodels.RequestModel;

public interface Interactor<R extends RequestModel> extends Boundary<R> {
	@Override
	void accept(final R request);
}
