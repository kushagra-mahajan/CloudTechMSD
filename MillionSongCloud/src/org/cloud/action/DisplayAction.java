package org.cloud.action;

import org.cloud.model.UIModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Kushagra Mahajan
 * @version 1.0.0.0
 *
 */
public class DisplayAction extends ActionSupport implements ModelDriven<UIModel> {

	/**
	 * serialVersionUID = 5232914905915558660L
	 */
	private static final long serialVersionUID = 5232914905915558660L;
	UIModel model = new UIModel();

	@Override
	public UIModel getModel() {
		return model;
	}

	/**
	 * Action_1 (displayHomePage)
	 * 
	 * @return homePage
	 */
	public String displayHomePage() {
		String resultPage = "homePage";
		return resultPage;
	}

	/**
	 * Action_2 (displaySearchPage)
	 * 
	 * @return searchPage
	 */
	public String displaySearchPage() {
		String resultPage = "searchPage";
		return resultPage;
	}

	/**
	 * Action_3 (displayVisualizationPage)
	 * 
	 * @return visualizationPage
	 */
	public String displayVisualizationPage() {
		String resultPage = "visualizationPage";
		return resultPage;
	}

	/**
	 * Action_4 (displayBlogPage)
	 * 
	 * @return blogPage
	 */
	public String displayBlogPage() {
		String resultPage = "blogPage";
		return resultPage;
	}

	/**
	 * Action_5 (displayContactPage)
	 * 
	 * @return contactPage
	 */
	public String displayContactPage() {
		String resultPage = "contactPage";
		return resultPage;
	}

	public void setModel(UIModel model) {
		this.model = model;
	}

}
