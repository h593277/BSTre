package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import no.hvl.dat102.KjedetBSTre;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KjedetBSTre bstre = new KjedetBSTre();

		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		
		
		System.out.println("Tester hoyde funksjon: " + bstre.hoyde());

		// Tester p� sortert utskrift
		System.out.println("Skriver ut elementene sortert i bs-treet");
		bstre.visInorden();

		// Tester p� om et bestemt element fins
		int element = 8;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}

		element = 1;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}
		
		//treGenerator(100, 1023);
		treGenerator(10, 8192);
		
		System.out.println("Minste elementet skal være 3, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 4, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 5, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 6, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 7, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 8, faktisk tall: " + bstre.fjernMin());
		System.out.println("Minste elementet skal være 9, faktisk tall: " + bstre.fjernMin());
	}
	
	
	
	public static List<KjedetBSTre> treGenerator(int trer, int noder)
	{
		System.out.println("Antall noder:" + noder);
		
		int minsteHoyde = 0;
		int maksHoyde = 0;
		int snittHoyde = 0;
		List<KjedetBSTre> trear = new ArrayList<KjedetBSTre>();
		
		for(int t = 0; t < trer; t++)
		{
			KjedetBSTre<Integer> tret = new KjedetBSTre();
			for(int n = 0; n < noder; n++)
			{
				Random terning = new Random();
				int tall = terning.nextInt();
				
				tret.leggTil(tall);
			}
			trear.add(tret);
			if(minsteHoyde == 0 || tret.hoyde() < minsteHoyde)
			{
				minsteHoyde = tret.hoyde();
			}
			
			if(maksHoyde == 0 || tret.hoyde() > maksHoyde)
			{
				maksHoyde = tret.hoyde();
			}
			snittHoyde += tret.hoyde();
		}
		
		System.out.println("Minimum hoyde paa tre: " + minHoyde(noder));
		System.out.println("Maksimum hoyde paa tre: " + maksHoyde(noder));
		System.out.println("Laveste tre var: " + minsteHoyde);
		System.out.println("Hoyeste tre var: " + maksHoyde);
		System.out.println("Gjennomsnitt hoyde var: " + snittHoyde/trer);
		
		
		return trear;
	}
	
	public static int maksHoyde(int n)
	{
		return n-1;
	}
	
	public static int minHoyde(int n)
	{
		return (int) (Math.log((double)n)-1);
	}
	

}
