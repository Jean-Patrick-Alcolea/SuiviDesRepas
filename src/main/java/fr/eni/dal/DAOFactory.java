package fr.eni.dal;

public abstract class DAOFactory {

	public static RepasDAO getRepasDAO() {
		return new repasDAOJdbcImpl();
	}
	
	public static AlimentsDAO getAlimentsDAO() {
		return new alimentsDAOJdbcImpl();
	}
}
