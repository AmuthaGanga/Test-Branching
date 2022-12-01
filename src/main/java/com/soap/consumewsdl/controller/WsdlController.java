package com.soap.consumewsdl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soap.consumewsdl.amlock.stub.OnBordingScanning;
import com.soap.consumewsdl.amlock.stub.OnBordingScanningResponse;
import com.soap.consumewsdl.service.ScreeningAmlockService;


@RestController
@RequestMapping("/responses")
public class WsdlController {
	
private Logger log = LoggerFactory.getLogger(WsdlController.class);
	
	@Autowired
	private ScreeningAmlockService amlockService;
	
	@GetMapping("/amlock")
	public OnBordingScanningResponse getStatus(@RequestBody OnBordingScanning scanning) {
		log.info("In the method to request SOAP Response for AMLOCK");
		
		OnBordingScanningResponse response = amlockService.getAmlockScreeningResponse(scanning);
		
		return response;
	}

}
