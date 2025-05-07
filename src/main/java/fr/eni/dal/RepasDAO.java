package fr.eni.dal;

import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Repas;

public interface RepasDAO {

	public void insertRepas(Repas repas)throws BusinessException;
	
	public List<Repas> selectAll()throws BusinessException;
	
}
