package kr.ac.jeju.usecases.controllers;

import kr.ac.jeju.usecases.boundaries.Interactor;
import kr.ac.jeju.usecases.boundaries.InteractorFactory;
import kr.ac.jeju.usecases.boundaries.PresenterFactory;
import kr.ac.jeju.usecases.presenters.CreateOrderPresenter;
import kr.ac.jeju.usecases.requestmodels.CreateOrderRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	private PresenterFactory<CreateOrderPresenter> presenterFactory;

	private InteractorFactory<CreateOrderRequestModel> interactorFactory;

	@Autowired
	public void setPresenterFactory(final PresenterFactory<CreateOrderPresenter> presenterFactory) {
		this.presenterFactory = presenterFactory;
	}

	@Autowired
	public void setInteractorFactory(final InteractorFactory<CreateOrderRequestModel> interactorFactory) {
		this.interactorFactory = interactorFactory;
	}

	@RequestMapping("home")
	public void home() {
	}

	@RequestMapping("create")
	public void create(final Model model, @ModelAttribute final CreateOrderRequestModel request) {
		final CreateOrderPresenter presenter = presenterFactory.create();
		presenter.setModel(model);

		final Interactor<CreateOrderRequestModel> interactor = interactorFactory.create();
		interactor.accept(request);
		interactor.execute();
	}

}
