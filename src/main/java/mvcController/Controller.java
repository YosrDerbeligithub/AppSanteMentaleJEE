package mvcController;

import jakarta.servlet.RequestDispatcher;
import jakarta.ejb.EJB;
import mvcModel.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entities.Etudiant;
import entities.Institut;
import entities.Psychiatre;
import entities.Rdv;
import entities.Session;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private EtudiantService etudiantService;
	@EJB
	private SessionService sessionService;
	@EJB
	private RdvService rdvService;
	@EJB
	private InstitutServive institutService;
	@EJB
	private PsychiatreService psychiatreService;
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btnValue = request.getParameter("myBtn");
		RequestDispatcher rd;
		if(btnValue==null)
		{
			rd = request.getRequestDispatcher("SignIn.html");
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("LoginPsy")) {
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			Psychiatre psy= null;
			psy=psychiatreService.getPsyByLoginAndPwd(login, pwd);
			if(psy!=null) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(300);
				session.setAttribute("activePsy", psy);
				response.getWriter().append("User found" +psy.getPrenom()+""+psy.getNom());
				rd = request.getRequestDispatcher("HomePsy.html");
				rd.forward(request, response);
				
			}
		}
		if(btnValue!=null && btnValue.equals("Login")) {
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			Etudiant std = null;
			std = etudiantService.getStudentByLoginAndPwd(login,pwd);
			if(std!=null) {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(300);
			session.setAttribute("activeUser", std);
			response.getWriter().append("User found" +std.getPrenom()+""+std.getNom());
			rd = request.getRequestDispatcher("HomeF.html");
			rd.forward(request, response);
			}
			}
		if(btnValue!=null && btnValue.equals("rdv")) {
			List<Session> sessions= sessionService.getAllSessionAvailable();
			request.setAttribute("sessions", sessions);
			List<Rdv> rdv= rdvService.getAllRdvAvailablee();
			request.setAttribute("rdv", rdv);
			rd = request.getRequestDispatcher("NewFile.jsp");//rdv
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("rdvP")) {
			String value=(String)request.getParameter("selectedValue");
			Integer idSession = Integer.parseInt(value);
			Etudiant etd=etudiantService.getStudentById(1);
			Session sess=sessionService.getSessionByIdd(idSession);
			rdvService.insertRdv(etd, sess);
			rd = request.getRequestDispatcher("HomeF.html");
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("rdvA")) {
			String value2=(String)request.getParameter("selectedValue2");
			Integer idRdv = Integer.parseInt(value2);
			rdvService.deleteRdv(idRdv);
			rd = request.getRequestDispatcher("HomeF.html");
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("SignUp")) {
			String prenom=request.getParameter("prenom");
			String nom=request.getParameter("nom");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String filiere=request.getParameter("filiere");
			String niveau=request.getParameter("niv");
			Integer id_fac=Integer.parseInt(request.getParameter("fac"));
			Institut institut=institutService.getInstitutByIdd(id_fac);
			String pwd=request.getParameter("pwd");
			etudiantService.addEtudiant(email, prenom, nom, username, institut, filiere, niveau, pwd);
			rd = request.getRequestDispatcher("SignIn.html");
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("creerSession")) {
			String date=request.getParameter("dateValue");
			String time=request.getParameter("timeValue");
			Psychiatre P=psychiatreService.getPsyById(1);
			sessionService.insertSession(date, time, P);
			rd = request.getRequestDispatcher("Trdvjsp.jsp");
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("Trdv")) {
			List<Rdv> rdvs= rdvService.getAllRdvAvailablee();
			request.setAttribute("rdvs", rdvs);
			rd = request.getRequestDispatcher("Trdvjsp.jsp");//
			rd.forward(request, response);
			
		}
		if(btnValue!=null && btnValue.equals("detailConsultation")) {
			Integer id_rdv=Integer.parseInt(request.getParameter("selectedValue"));
			Rdv r=rdvService.getRdvById(id_rdv);
			request.setAttribute("rdv", r);
			rd = request.getRequestDispatcher("detailRdv.jsp");//
			rd.forward(request, response);
			
			
		}
		if(btnValue!=null && btnValue.equals("updateRdvv")) {
			Rdv r=rdvService.getRdvById(Integer.parseInt(request.getParameter("idRdv")));
			String lien=request.getParameter("lien");
			String note=request.getParameter("note");
			rdvService.updateRdv(note, lien, r);
			List<Rdv> rdvs= rdvService.getAllRdvAvailablee();
			request.setAttribute("rdvs", rdvs);
			rd = request.getRequestDispatcher("Trdvjsp.jsp");//
			rd.forward(request, response);
			
			
			
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
