package EJB;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import Entity.userEntity;
import Service.IuserService;

@Model
@ApplicationScoped
public class Login {
	@Inject
	private IuserService myService;
	private String name="";
	private String pswd="";
	private String result="";
	private ArrayList<userBean> lst;
	
	public String saveAction() {
	    for (userBean b : getLst()){
	      b.setEditable(false);
	    }
	    return null;
	  }
		
	public String editAction(userBean ub){
	  ub.setEditable(true);	
	  return null;
	}
	
	public ArrayList<userBean> getLst() {
		return lst;
	}

	public void setLst(ArrayList<userBean> lst) {
		this.lst = lst;
	}

	public Login(){

	}
	
	public String valide(){
		String result= myService.authorize(name,pswd);
		return result;
	}
	
	public ArrayList<userBean> getUserLst(){
		lst = myService.finAll();
		setLst(lst);
		return lst;
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
