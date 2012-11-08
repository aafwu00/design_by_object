package kr.ac.jeju.usecases.controllers;

import javax.annotation.Resource;

import kr.ac.jeju.usecases.interactors.UseCaseFactory;
import kr.ac.jeju.usecases.interactors.UseCaseInterator;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;
import kr.ac.jeju.usecases.responsemodels.CreateOrderResponseModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

	@Resource
	private UseCaseFactory useCaseFactory;

	public void setUseCaseFactory(final UseCaseFactory useCaseFactory) {
		this.useCaseFactory = useCaseFactory;
	}

	@RequestMapping("create")
	public void create(final Model model, @ModelAttribute final CreateOrderRequestModel request) {
		final UseCaseInterator<CreateOrderResponseModel> interactor = useCaseFactory.create(request);
		final CreateOrderResponseModel response = interactor.execute();
		model.addAttribute("order", response.getOrder());
	}
}
