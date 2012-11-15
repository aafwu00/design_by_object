package kr.ac.jeju.usecases.boundaries;

public interface Boundary<M> {
	void accept(final M model);

	void execute();
}
