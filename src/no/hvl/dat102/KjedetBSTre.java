package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBin�rS�keTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt bin�rt s�ketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et bin�rt s�ketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	
	/**********************************************************************
	 * Legger det spesifiserte elementet p� passende plass i BS-treet. Like
	 * elementer blir lagt til h�yre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if(p == null)
		{
			return new BinaerTreNode<T>(element);
		}
		else if(element.compareTo(p.getElement()) < 0)
		{
			p.setVenstre(leggTilRek(p.getVenstre(), element));
		}
		else if(element.compareTo(p.getElement()) > 0)
		{
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		}
		else
		{
			return p;
		}
		
		return p;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/

	public void leggTil2(T element) {
		
		do
		{
			if(rot == null)
			{
				rot.setElement(element);
			}
			else if(rot.getElement().compareTo(element) >= 0)
			{
				rot = rot.getHoyre();
			}
			else
			{
				rot = rot.getVenstre();
			}
		}
		while(rot != null);
		
	}
	
	@Override
	public T fjern(T element)
	{
		return fjernRek(rot, element);
	}
	
	//Hadde vært mye lettere med foreldre referanse, gav litt opp halveis siden det ikke sto i oppgaven at vi måtte gjore denne
	//Se fjernMin for hvordan det skal gjores
	private T fjernRek(BinaerTreNode<T> p, T element)
	{
		if(p == null)
		{
			return null;
		}
		if(element.compareTo(p.getElement()) >= 0)
		{
			return fjernRek(p.getHoyre(), element);
		}
		else if(element.compareTo(p.getElement()) < 0)
		{
			return fjernRek(p.getVenstre(), element);
		}
		else
		{
			if(p.getVenstre() == null)
			{
				T elem = p.getHoyre().getElement();
				p = p.getHoyre();
				return elem;
			}
			else if(p.getHoyre() == null)
			{
				T elem = p.getVenstre().getElement();
				p = p.getVenstre();
				return elem;
			}
			
			p.setElement(p.getHoyre().getElement());
			
			p.getHoyre().setElement(fjernRek(p.getHoyre(),p.getHoyre().getElement()));
		}
		
		return p.getElement();
		
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette bin�re s�ketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		
		return fjernMinRek(rot);
	}//
	
	//Refereanse til foreldre hadde gjort dette mye enklere!
	private T fjernMinRek(BinaerTreNode<T> p)
	{
		if(p == null)
		{
			return null;
		}
		
		if(p.getVenstre() == null)
		{
			T elem = p.getElement();
			rot = rot.getHoyre();
			return elem;
		}
		
		if(p.getVenstre().getVenstre() != null)
		{
			return fjernMinRek(p.getVenstre());
		}
		
		if(p.getVenstre().getHoyre() != null)
		{
			T elem = p.getVenstre().getElement();
			p.setVenstre(p.getVenstre().getHoyre());
			return elem;
		}
		else
		{
			T elem = p.getVenstre().getElement();
			p.setVenstre(null);
			return elem;
		}
	}
	

	/******************************************************************
	 * Fjerner noden med st�rste verdi fra dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		return fjernMaksRek(rot);
	}//
	
	private T fjernMaksRek(BinaerTreNode<T> p)
	{
		if(p == null)
		{
			return null;
		}
		
		if(p.getHoyre() == null)
		{
			T elem = p.getElement();
			rot = rot.getVenstre();
			return elem;
		}
		
		if(p.getHoyre().getHoyre() != null)
		{
			return fjernMaksRek(p.getHoyre());
		}
		
		if(p.getHoyre().getVenstre() != null)
		{
			T elem = p.getHoyre().getElement();
			p.setHoyre(p.getHoyre().getVenstre());
			return elem;
		}
		else
		{
			T elem = p.getHoyre().getElement();
			p.setHoyre(null);
			return elem;
		}
	}

	/******************************************************************
	 * Returnerer det minste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		if(rot == null)
		{
			return null;
		}
		
		while(rot.getVenstre() != null)
		{
			rot = rot.getVenstre();
		}
		return rot.getElement();
	}//

	/******************************************************************
	 * Returnerer det st�rste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		if(rot == null)
		{
			return null;
		}
		
		while(rot.getHoyre() != null)
		{
			rot = rot.getHoyre();
		}
		return rot.getElement();
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		
		return finnRek(element, rot);
	}
	
	private T finnRek(T element, BinaerTreNode<T> rot)
	{
		if(rot == null)
		{
			return null;
		}
		
		
		if(rot.getElement().compareTo(element) == 0)
		{
			return rot.getElement();
		}
		else if(rot.getElement().compareTo(element) > 0)
		{
			return finnRek(element, rot.getVenstre());
		}
		else if(rot.getElement().compareTo(element) < 0)
		{
			return finnRek(element, rot.getHoyre());
		}
		
		return null;
	}


	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		if(rot == null)
			return null;
		
			
		do
		{
			if(rot.getElement().compareTo(element) == 0)
			{
				return rot.getElement();
			}
			else if(rot.getElement().compareTo(element) > 0)
			{
				rot = rot.getHoyre();
			}
			else
			{
				rot = rot.getVenstre();
			}
		}
		while(rot != null);
		
		return null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}
	
	public int hoyde()
	{
		return hoydeRek(rot);
	}
	
	private int hoydeRek(BinaerTreNode<T> t)
	{
		if(t == null)
		{
			return 0;
		}
		
		int venstrehoyde = hoydeRek(t.getVenstre());
		int hoyreHoyde = hoydeRek(t.getHoyre());
		
		return Math.max(venstrehoyde, hoyreHoyde) + 1;
	}
	
	

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
		
	}
}// class
