package fr.eni.bll;

import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Aliments;
import fr.eni.dal.AlimentsDAO;
import fr.eni.dal.alimentsDAOJdbcImpl;

public class AlimentsManager {
	private AlimentsDAO alimentsDAO;

	public AlimentsManager() {
		this.alimentsDAO = new alimentsDAOJdbcImpl();
	}
	
	public Aliments ajouterAliments(String nom, int id_repas) throws BusinessException {
		BusinessException exception = new BusinessException();
		Aliments aliments = new Aliments(nom, id_repas);
		
		if (!exception.hasErreurs()) {
			this.alimentsDAO.insertAliments(aliments);
		}
		if (exception.hasErreurs()) {
			throw exception;
		}
		
		return aliments;
				
	}
	
	public List<Aliments> getAliments(int id)throws BusinessException{
		try {
			return alimentsDAO.selectById(id);
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	
	
}
