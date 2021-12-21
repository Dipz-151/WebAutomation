package oAuth;

import java.util.List;

public class SubCourse {

	private List<WebAutomation> webAutomation;
	private List<ApiCourses> api;
	private List<MobileCourses> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<ApiCourses> getApi() {
		return api;
	}
	public void setApi(List<ApiCourses> api) {
		this.api = api;
	}
	public List<MobileCourses> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileCourses> mobile) {
		this.mobile = mobile;
	}
	
	
}
