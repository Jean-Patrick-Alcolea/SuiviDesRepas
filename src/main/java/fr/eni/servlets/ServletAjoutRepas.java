package fr.eni.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.eni.BusinessException;
import fr.eni.bll.AlimentsManager;
import fr.eni.bll.RepasManager;
import fr.eni.bo.Repas;

/**
 * Servlet implementation class ServletAjoutRepas
 */
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutRepas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.Date dateRepasJava;
		Date dateRepas;
		Time heureRepas;
		SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm");
		String aliments;
		SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-mm-dd");

		
		try {
			dateRepasJava = formatDate.parse(request.getParameter("date"));
			dateRepas = new Date(dateRepasJava.getTime());
			java.util.Date timeRecup = formatHeure.parse(request.getParameter("time"));
			heureRepas = new Time(timeRecup.getTime());
			
			RepasManager repasManager = new RepasManager();
			Repas repas = repasManager.ajouterRepas(dateRepas, heureRepas);
			aliments = request.getParameter("aliments");
			String[] listeAliments = aliments.split("\\s*,\\s*");
			AlimentsManager aliManager = new AlimentsManager();
			
			for (String ali : listeAliments) {
				aliManager.ajouterAliments(ali, repas.getIdentity());
			}
			
			
		} catch (ParseException | BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
