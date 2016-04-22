package org.cloud.action;

import org.cloud.dao.UsersDAO;
import org.cloud.model.UsersModel;
import org.cloud.pojo.Users;
import org.cloud.utilities.ApplicationUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UsersQueryAction extends ActionSupport implements ModelDriven<UsersModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsersModel model = new UsersModel();

	@Override
	public UsersModel getModel() {
		return model;
	}

	public void setModel(UsersModel model) {
		this.model = model;
	}

	public String submitUserDetails() {
		String resultPage = "";
		UsersDAO daoObject = new UsersDAO();
		Users users = new Users();
		users.setName(getModel().getName());
		users.setEmail(getModel().getEmail());
		users.setMessage(getModel().getMessage());
		daoObject.saveUser(users);
		resultPage = "success";
		addActionMessage("We have received your query, give us some time to process your request.");
		return resultPage;
	}

	@Override
	public void validate() {
		if (ApplicationUtil.isNull(model.getName())) {
			addFieldError("name", "Please enter your name");
		}
		if (ApplicationUtil.isNull(model.getEmail())) {
			addFieldError("email", "Please enter your Email ID");
		}
		if (ApplicationUtil.isNull(model.getMessage())) {
			addFieldError("message", "For helping you better, kindly let us know your query");
		}
	}

}
