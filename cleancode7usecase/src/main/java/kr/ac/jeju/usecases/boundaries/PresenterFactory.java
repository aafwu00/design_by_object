package kr.ac.jeju.usecases.boundaries;

public interface PresenterFactory<P extends Presenter<?>> {
	P create();
}
