package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.DesignerDao;
import model.Designer;

public class DesignerService {
	private DesignerDao designerDao;

	public DesignerService() {
		try {
			designerDao = new DesignerDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addDesigner(DesignerDao newDesigner) {
		
	}

	public void updateDesigner(DesignerDao updatedDesigner) {
		
	}

	public List<DesignerDao> getAllDesigners() {
		return null;
	
	}
}
