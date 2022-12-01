package com.soap.consumewsdl.entity;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="screening-ws-amlock")
public class ScreeningProducers {
	
	private List<ScreeningProducer> producerList;
	
	
	public List<ScreeningProducer> getProducerList() {
		return producerList;
	}
	
	public void setProducerList(List<ScreeningProducer> producerList) {
		this.producerList = producerList;
	}


	/**
	 * Class to refer the individual screening producer
	 * @author Amutha.Consultant
	 *
	 */
	public static class ScreeningProducer{
		private String url;
		private String contextPath;
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getContextPath() {
			return contextPath;
		}
		public void setContextPath(String contextPath) {
			this.contextPath = contextPath;
		}
		
		@Override
		public String toString() {
			return "ScreeningProducer [url=" + url + ", contextPath=" + contextPath + "]";
		}
		
		
	}

}
