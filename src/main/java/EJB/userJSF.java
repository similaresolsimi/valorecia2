package EJB;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import Service.IuserService;

@Model
public class userJSF {
	@Inject
	private IuserService myService;
	private String name="";
	private String surname="";
	private String login="";
	private String pswd="";
	private String result="";
	
	private ArrayList<userBean> lst;
	
	public String saveAction() {
	    for (userBean b : lst){
	      b.setEditable(false);
	    }
	    return null;
	  }
		
	public String editAction(userBean ub){
	  ub.setEditable(true);
	  return null;
	}
	
	public String delete(userBean ub){
		myService.remove(ub);
		 return null;
	}
	
	public String persist(){
		myService.persist(name,surname,login,pswd);
		return null;
	}
	
	public ArrayList<userBean> getLst() {
		return myService.finAll();
	}

	public void setLst(ArrayList<userBean> lst) {
		this.lst = lst;
	}

	public userJSF(){}
	
	public String valide(){
		String result= myService.authorize(name,pswd);
		return result;
	}
	
	public ArrayList<userBean> findAll(){
		lst = myService.finAll();
		return null;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
