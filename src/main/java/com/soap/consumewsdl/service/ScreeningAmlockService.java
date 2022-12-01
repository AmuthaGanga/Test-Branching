package com.soap.consumewsdl.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.soap.consumewsdl.amlock.stub.ObjectFactory;
import com.soap.consumewsdl.amlock.stub.OnBordingScanning;
import com.soap.consumewsdl.amlock.stub.OnBordingScanningResponse;
import com.soap.consumewsdl.entity.ScreeningProducers;
import com.soap.consumewsdl.entity.ScreeningProducers.ScreeningProducer;
import com.soap.consumewsdl.helper.SoapClient;

@Service
public class ScreeningAmlockService {
	
	@Autowired
	private ScreeningProducers screeningProducers;
	
	@Autowired
	private SoapClient soapClient;
	
	private Jaxb2Marshaller marshaller;
	
	private List<ScreeningProducer> screeningProducerList;
	
	private String clientURI;
	
	private String contextPath;
	
	 @PostConstruct
	 public void init() {
		 screeningProducerList = screeningProducers.getProducerList();
     }
	 
	 public void getScreeningProducersAmlock() {
		 screeningProducerList.stream().forEach(System.out::println);
	 }
	 
	 public OnBordingScanningResponse getAmlockScreeningResponse(OnBordingScanning scanning) {
		 OnBordingScanningResponse response = null;
		 
		// convert java POJO to WS element
		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<OnBordingScanning> requestElement = objectFactory.createOnBordingScanning(scanning);
		
		if(null != screeningProducerList && screeningProducerList.size()>0) {
			clientURI = screeningProducerList.get(0).getUrl();
			contextPath = screeningProducerList.get(0).getContextPath();
			
			marshaller = new Jaxb2Marshaller();
			marshaller.setContextPath(contextPath);
			
			soapClient = new SoapClient();
			soapClient.setDefaultUri(clientURI);
			soapClient.setMarshaller(marshaller);
			soapClient.setUnmarshaller(marshaller);
			
			response = soapClient.getBoardingScanning(clientURI, requestElement);
		}
			
		return response;
	 }


}
