package com.robosoft.Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class HappyFortuneService implements FortuneService {


	public HappyFortuneService() {
	}

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
