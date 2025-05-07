package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.BusinessException;
import fr.eni.bll.AlimentsManager;
import fr.eni.bll.RepasManager;
import fr.eni.bo.Aliments;
import fr.eni.bo.Repas;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVisualisationRepas
 */
public class ServletVisualisationRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualisationRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepasManager repasManager = new RepasManager();
		AlimentsManager aliManager = new AlimentsManager();
		try {
			List<Repas> listeRepas = repasManager.getCatalogue();
			List<Aliments> listeAliments  = new ArrayList<Aliments>();
			for (int i = 0; i <= listeRepas.size() ;i++) {
				listeAliments = aliManager.getAliments(i);
			}
		System.out.println(listeRepas);
		System.out.println(listeAliments);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
