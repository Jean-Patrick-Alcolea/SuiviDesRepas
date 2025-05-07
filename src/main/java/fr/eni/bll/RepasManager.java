package fr.eni.bll;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Repas;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.RepasDAO;

public class RepasManager {
	private RepasDAO repasDAO;

	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}
	
	public Repas ajouterRepas(Date date_repas, Time heure_repas) throws BusinessException{
		
		BusinessException exception = new BusinessException();
		
		Repas repas = new Repas(date_repas, heure_repas);
		
		if (!exception.hasErreurs()) {
			this.repasDAO.insertRepas(repas);
		}
		if (exception.hasErreurs()) {
			throw exception;
		}
				
		return repas;
		
	}
	
	public List<Repas> getCatalogue() throws BusinessException{
		try {
			return repasDAO.selectAll();
			
		} catch (Exception e) {
			throw new BusinessException();
		}

	}


}
