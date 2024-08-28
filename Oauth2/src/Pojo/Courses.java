package Pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Courses {
	private List<webAutomation> webAutomation;
	//List<webAutomation> because webAutomation is an array.
	// under that array number of items are available.
	private List<api> api;
	private List<mobile> mobile;
	
	public List<webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<api> getApi() {
		return api;
	}
	public void setApi(List<api> api) {
		this.api = api;
	}
	public List<mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobile> mobile) {
		this.mobile = mobile;
	}
	

}
