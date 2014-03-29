package com.thirdageopen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdageopen.domain.Card;
import com.thirdageopen.service.CardService;

@Controller
@RequestMapping(value = "/api/card")
public class CardApi {

	
	@Autowired
	private CardService cardService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/all")
	@ResponseBody
	private List<Card> getAll(){
		return cardService.retrieve();
	}
	
}
