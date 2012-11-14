
# [Clean Code, Episode 7 - Architecture](http://www.cleancoders.com/codecast/clean-code-episode-7/show)

------

1. 의도
	1. 밥 아저씨가 Clean Code Cast 에서 제시한 Use Case 가 드러난 Architecture에 대한 구조를 생각 해 본다.
2. 흐름 
	1. Delivery Mechanism 으로 부터 Request Model 을 생성하여 Boundary 로 위임
	
		![Delivery Mechanism - Request Model](doc/cleancode7usecae-1.png)
	
	2. Interactor 는 실제 Entity 들과 상호 작용하여 Request Model 데이터를 처리
	
		![Interactor - Entity](doc/cleancode7usecae-2.png)
	
	3. Interactor 처리 결과를 Response Model(Result Model)로 취합한다.
	
		![Interactor - Response Model](doc/cleancode7usecae-3.png)
	
	4. Response Model 을 Boundary 를 통해 Delivery Mechanism 으로 보낸다.
	
		![Boundary - Delivery Mechanism](doc/cleancode7usecae-4.png)
3. 고민
	1.	Presenter, Response Model

		밥 아저씨는 Request Model 을 처리하는 Boundary 와 Response Model 을 보내는 Boundary 를 분리해서 만 드셨는데 어떻게 구현하는게 좋을까?(NodeJs 같은 비동기 메커니즘 사용?)

	2.	Use Case

		Create Order 에서 정말 주문을 넣는게 Use Case 인가?, Use Case 는 주문을 생성 하고, 아이템을 추가 수정 하는등 여러 Interactor 들의 조합이 아닐까?

------

## Use Case
>Create Order
>
>Data:
>
>		<Customer-id>. <Customer-contact-info>,
>		<Shipment-destination>, <Shipment-mechanism>, 
>		<Payment-information>
>
>Primary Course:
>
>	1. Order clerk issues "Create Order" command with the above data
>	2. System validates all data
>	3. System creates order and determines order-id
>	4. System delivers order-id to clerk.
>
>Exception Course: Validation Error
>
>	1. System delivers error message to clerk

------

## Tag
1. cleancode7usecase-try1

2. cleancode7usecase-try2
3. cleancode7usecase-try3

------

## 생각해보기
1. UseCaseFactory 구현체를 스프링 lookup-method 를 사용하여 줄여 볼수 있는 방법
	1. [기본 아이디어](http://blog.schauderhaft.de/2012/11/04/creating-new-spring-beans-on-demand/)
	2. [현재(3.1버전)에서 파라미터를 지원하지 않아서 제안 이 올라온 블로그](http://nurkiewicz.blogspot.kr/2010/08/creating-prototype-spring-beans-on.html)
		1. [SPR-7431, 이슈로 등제](https://jira.springsource.org/browse/SPR-7431)
