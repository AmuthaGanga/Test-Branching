package com.soap.consumewsdl.helper;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soap.consumewsdl.amlock.stub.OnBordingScanningResponse;

@Component
public class SoapClient extends WebServiceGatewaySupport{

	public OnBordingScanningResponse getBoardingScanning(String url, Object request) {
		JAXBElement<OnBordingScanningResponse> response = (JAXBElement)getWebServiceTemplate().marshalSendAndReceive(url, request);
		return (OnBordingScanningResponse)response.getValue();
	}

}
