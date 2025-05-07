package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Repas;

public class repasDAOJdbcImpl implements RepasDAO{
	private static final String INSERT ="INSERT INTO REPAS(date_repas, heure_repas) VALUES (?,?);";
	private static final String sqlSelectAll = "SELECT date_repas, heure_repas FROM REPAS;";
	
	@Override
	public void insertRepas(Repas repas)throws BusinessException {
		if (repas == null) 
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, repas.getDate_repas());
			pstmt.setTime(2, repas.getHeure_repas());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				repas.setIdentity(rs.getInt(1));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public List<Repas> selectAll() throws BusinessException {
		List<Repas> liste = new ArrayList<Repas>();
		
		try (Connection cnx = ConnectionProvider.getConnection();
			Statement rqt = cnx.createStatement();) 
		{
			try (ResultSet rs =  rqt.executeQuery(sqlSelectAll);){
				Repas rep = null;
				while(rs.next()) {
					rep = mapping(rs);
					liste.add(rep);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}

	private Repas mapping(ResultSet rs) throws SQLException {
		Repas rep = null;
		Date date  = rs.getDate("date_repas");
		Time time = rs.getTime("heure_repas");
		
		rep = new Repas(date, time);
		return rep;
	}
	
	
	
}
