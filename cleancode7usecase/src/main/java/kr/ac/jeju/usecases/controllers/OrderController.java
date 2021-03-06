package kr.ac.jeju.usecases.controllers;

import kr.ac.jeju.usecases.interactors.UseCaseFactory;
import kr.ac.jeju.usecases.interactors.UseCaseInteractor;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	private UseCaseFactory<CreateOrderRequestModel, CreateOrderResponseModel> useCaseFactory;

	@Autowired
	public void setUseCaseFactory(final UseCaseFactory<CreateOrderRequestModel, CreateOrderResponseModel> useCaseFactory) {
		this.useCaseFactory = useCaseFactory;
	}

	@RequestMapping("home")
	public void home() {
	}

	@RequestMapping("create")
	public void create(final Model model, @ModelAttribute final CreateOrderRequestModel request) {
		final UseCaseInteractor<CreateOrderResponseModel> interactor = useCaseFactory.create(request);
		final CreateOrderResponseModel response = interactor.execute();
		model.addAttribute("order", response.getOrder());
	}

}
