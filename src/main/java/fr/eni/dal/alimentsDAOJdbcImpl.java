package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bo.Aliments;

public class alimentsDAOJdbcImpl implements AlimentsDAO {
	private static final String INSERT ="INSERT INTO ALIMENTS(nom,id_repas) VALUES(?,?);";
	private static final String sqlSelectById = "SELECT * FROM ALIMENTS WHERE id_repas = ?";

	@Override
	public void insertAliments(Aliments aliments) throws BusinessException {
		if (aliments == null) 
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, aliments.getNom());
			pstmt.setInt(2, aliments.getIdRepas());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				aliments.setId(rs.getInt(1));
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
	public List<Aliments> selectById(int id) throws BusinessException {
		List <Aliments> liste = new ArrayList<Aliments>();
		try (Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(sqlSelectById);)
		{
			rqt.setInt(1, id);
			try(ResultSet rs = rqt.executeQuery();){
				Aliments ali = null;
				while(rs.next()) {
					ali = mapping(rs);
					liste.add(ali);
				}

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return liste;
	}

	private Aliments mapping(ResultSet rs) throws SQLException {
		Aliments ali = null;
		String nom = rs.getString("nom");
		int id = rs.getInt("id_repas");
		
		ali = new Aliments(nom, id);
		return ali;
	}
	
	
}
