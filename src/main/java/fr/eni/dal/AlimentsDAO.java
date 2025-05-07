package fr.eni.dal;

import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Aliments;

public interface AlimentsDAO {
	
	public void insertAliments(Aliments aliments) throws BusinessException;
	
	public List<Aliments> selectById(int id)throws BusinessException;
}
