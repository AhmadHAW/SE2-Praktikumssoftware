package se2.praktikum.projekt.services.loginservice;

import org.springframework.web.servlet.ModelAndView;

import se2.praktikum.projekt.models.person.Angestellter;
import se2.praktikum.projekt.models.person.Person;
import se2.praktikum.projekt.models.person.Student;
import se2.praktikum.projekt.services.leistungenservice.LeistungenAnzSrv;
import se2.praktikum.projekt.services.leistungenservice.LeistungenCtrlAdmin;
import se2.praktikum.projekt.services.veranstaltungsservice.AnzeigerSrv;
import se2.praktikum.projekt.services.veranstaltungsservice.GruppVerwSrv;
import se2.praktikum.projekt.services.veranstaltungsservice.TeamVerwSrv;
import se2.praktikum.projekt.services.veranstaltungsservice.VeranstaltungsCtrlAdmin;
import se2.praktikum.projekt.services.veranstaltungsservice.VeranstaltungsVerwalterSrv;

public class LoginSrv {
	
	
	private Person user = null;
	

	/**Einen Benutzer anhand des Usernames und Passwortes aus der DB
	 * identifizieren und 
	 * @param username
	 * @param password
	 * @return
	 */
	public Person login(String username, String password) {

		// Authentifizieren
		
		Person user = null;
		
		// Userobject erzeugen
		
		this.user = user;  // Bei erfolg zuweisen
		
		return this.user; // und zurückgeben
		
	}
	
	
	/**
	 * Den aktuellen Benutzer abmelden
	 * @return 
	 * @return
	 */
	public ModelAndView logout(){
		
		setUser(null);
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
	
	/**
	 * Erzeugt alle nötigen Services bei erfolgreichem Login
	 */
	public void erzeugeServices(){
		
		
		// Erzeugen
		AnzeigerSrv veranAnzSrv = new AnzeigerSrv();
		//AnzeigerSrv veranAnzSrv = new AnzeigerSrv(this.user);
		GruppVerwSrv grVwSrv = new GruppVerwSrv(this.user);
		TeamVerwSrv tmVwSrv = new TeamVerwSrv(this.user);
		VeranstaltungsVerwalterSrv vVwSrv = new VeranstaltungsVerwalterSrv(this.user);
		LeistungenAnzSrv leistAnzSrv= new LeistungenAnzSrv(veranAnzSrv, this.user);
		
		// Initialisieren
		//VeranstaltungsCtrlAdmin.setAnzeigeSrv(veranAnzSrv);
		VeranstaltungsCtrlAdmin.setGruppVerwSrv(grVwSrv);
		VeranstaltungsCtrlAdmin.setTeamVerwSrv(tmVwSrv);
		VeranstaltungsCtrlAdmin.setVeranstVwSrv(vVwSrv);
		LeistungenCtrlAdmin.setLeistungenAnzSrv(leistAnzSrv);
	}


	/**
	 * Lädt das Panel, was dem User entspricht (Angestellter oder Student)
	 * HINWEIS: Erstmal wird für beide Benutzer die gleiche View geladen,
	 * da Studentpanel noch nicht erstellt
	 * @param user der angemeldete User
	 * @return View
	 */
	public ModelAndView ladePanel(Person user) {
		
		ModelAndView mv = null;
		
		if(user != null){
			// Panels je nach usertyp laden
			if(user instanceof Student){
				mv = new ModelAndView("main"); // Später anderer Parameter
			}else if(user instanceof Angestellter){
				mv = new ModelAndView("main"); // Später anderer Parameter
			}
		}else{
			mv = new ModelAndView("main"); // False passwort/user falsch -> null
		}								
		
		if(mv != null){
			erzeugeServices();
		}else{
			mv = new ModelAndView("fail");
			// informiere... (zb "fail"-View laden -> muss erst noch erstellt werden)
		}

		return mv;
	}

}