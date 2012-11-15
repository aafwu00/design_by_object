package kr.ac.jeju.usecases.presenters;

import kr.ac.jeju.usecases.boundaries.Presenter;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

import org.springframework.ui.Model;

public class CreateOrderPresenter implements Presenter<CreateOrderResponseModel> {

	private CreateOrderResponseModel response;
	private Model model;

	@Override
	public void execute() {
		// TODO: 해당 Delivery Mechanism 에서 필요한 View Model(DTO)로 변환 필요
		model.addAttribute("order", response.getOrder());
	}

	@Override
	public void accept(final CreateOrderResponseModel response) {
		this.response = response;
	}

	public void setModel(final Model model) {
		this.model = model;
	}

}
