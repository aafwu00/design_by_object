package kr.ac.jeju.usecases.boundaries;

import kr.ac.jeju.usecases.responsemodels.ResponseModel;

public interface Presenter<R extends ResponseModel> extends Boundary<R> {
	@Override
	void accept(final R response);
}
