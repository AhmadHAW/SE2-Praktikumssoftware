package se2.praktikum.projekt.models.veranstaltung;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeName;

import se2.praktikum.projekt.models.person.AbstrPerson;
import se2.praktikum.projekt.models.person.AbstrPerson;
import se2.praktikum.projekt.models.person.Professor;

/**
 * Repräsentiert ein Pflichtpraktikum
 * @author Jan
 *
 */
@JsonTypeName("praktikum")
public class Praktikum extends AbstrVeranstaltung {
	
	
	
	/**
	 * Default-Konstruktor
	 * Initialisiert ein neues Praktikum ohne Parameter
	 * Felder können seperat über Setter festgelegt werden
	 */
	public Praktikum() {
		
		this(null, null);
		
	}
	
	
	/**
	 * Initialisiert ein neues Praktikum mit den wichtigsten Parametern
	 * Restliche Felder können separat über Setter festgelegt werden.
	 * @param fach
	 * @param prof
	 * @param assist
	 */
	public Praktikum(Fach fach, Professor prof)			{
		
		this(fach, prof, 0, 0, 0, 0);
		
	}
	
	
	/**
	 * Initialsiert ein neues Praktikum mit übergebenen Parametern
	 * @param fach : Das Fach
	 * @param prof : Der Verantwortliche Professor
	 * @param assist : Assistent des Professors
	 * @param anzTm : aktuelle Anzahl Teilnehmer
	 * @param anzGr : aktuelle Anzahl Gruppen
	 * @param maxGr : aktuelle max. möglche Gruppenzahl.
	 */
	public Praktikum(Fach fach, Professor prof, 
					 int anzTm, int maxTm, 
					 int anzGr, int maxGr)					{
		
		this.fach = fach;
		this.professor = prof;
		this.anzTm = anzTm;
		this.anzGr = anzGr;
		this.maxGr = maxGr;
	}

}
