package EJB;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import Service.IuserService;

@Model
public class Login {
	@Inject
	private IuserService myService;
	private String name="";
	private String pswd="";
	private String result="";
	
	public Login(){
		
	}
	
	public String valide(){
		myService.authorize("name","ok",name,pswd);
		return "index";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
