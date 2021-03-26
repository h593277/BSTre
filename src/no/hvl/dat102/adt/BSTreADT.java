package no.hvl.dat102.adt;

public interface BSTreADT<T extends Comparable<T>> {
	// Burde hatt javadoc her
	// Anbefaler at du fyller ut med javadoc her som kan vaere en del av 
	// �vingen. Flere metoder m� fylles ut i implementasjonsfilen.
	//Legg merke til at i denne imlementasjonen er det ikke brukt exceptions som
	// vi kunne hatt og som vi har brukt for i flere av de andre samlingene.

	/*****************************************************************
	 * @return sann hvis dette binaere treet er tomt og usann ellers.
	 *****************************************************************/

	public int antall();

	/*****************************************************************
	 * @return sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	public boolean erTom();

	/******************************************************************
	 * @param spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/
	public void leggTil(T element);

	/**********************************************************************
	 * @Return Referanse til det spesifiserte elementet hvis det fins i dette
	 * bin�re treet ellers @return null @param element som skal soekes etter
	 ************************************************************************/
	public T finn(T element);
	
	/*****************************************************************
	 * @return en referanse til minste elementet, null viss tre er tomt.
	 *****************************************************************/
	public T finnMin();
	
	/*****************************************************************
	 * @return en referanse til st�rste elementet, null viss tre er tomt.
	 *****************************************************************/
	public T finnMaks();

	/************************************************************************
	 * @remove et element fra dette treet hvis det fins, ellers @return null
	 ************************************************************************/
	
	 public T fjern( T element);
	
	
	/************************************************************************
	 * @return minste elementet fra dette treet hvis det fins, ellers @return null
	 ************************************************************************/
	public T fjernMin();
	
	/************************************************************************
	 * @return st�rste elementet fra dette treet hvis det fins, ellers @return null
	 ************************************************************************/
	public T fjernMaks();
}
