package kr.ac.jeju.usecases.boundaries;

import java.util.UUID;

public interface CreateOrderBoundary {

	void execute();

	UUID deliverOrderId();

}