package demo001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BusinessSimulation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int spielen = 1;
		int taler = 0;
		
		System.out.println("Wirtschaftssimulation Programmierung II");
		
		Niederlassung niederlassungEinbeck = new Niederlassung("Einbeck", Warenart.BIER, 1);
		
		Lager lagerAugsburg = new Lager("Augsburg");
		
		/*ArrayList<Niederlassung> listeNiederlassung = new ArrayList<Niederlassung>();
		listeNiederlassung.add(niederlassungEinbeck);*/
		
		
		
				
		do{
			niederlassungEinbeck.anfordern();
			niederlassungEinbeck.produzieren();
			int produzierteMengeEinbeck = niederlassungEinbeck.abholen();
			Warenart produzierteWarenart = niederlassungEinbeck.getWarenart();
	
			System.out.println("Ort: "+niederlassungEinbeck.getOrt()+"\tWare: "
					+niederlassungEinbeck.getWarenartString()+"\tMenge: "+produzierteMengeEinbeck);
				
			lagerAugsburg.einlagern(produzierteWarenart, produzierteMengeEinbeck);
	
			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			}
			
			
			int verkaufsmenge;
			Scanner menge_scanner = new Scanner(System.in);
			
			do {
				System.out.println("Wieviel verkaufen?");
				verkaufsmenge = menge_scanner.nextInt();
			}while((verkaufsmenge<0)||(verkaufsmenge>lagerAugsburg.getBestand(niederlassungEinbeck.getWarenart())));
			
			
			int preis = 10;
			
			int erloes = lagerAugsburg.verkaufen(produzierteWarenart,verkaufsmenge , preis);
			
			taler = taler + erloes;
			
			
			System.out.println("Erl�s durch Verkauf: "+erloes);
			System.out.println("Aktueller Bestand im Lager:");
			
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			}
		
			System.out.println("Taler gesamt: " +taler );
			
			String weiterspielen;
			Scanner spielen_scanner = new Scanner(System.in);
			do {
				System.out.println("N�chste Runde?");
				weiterspielen = spielen_scanner.next();
				
				if( weiterspielen.equals ("j")) {
					spielen=1;
					System.out.println("====================================");
				}
				
				if( weiterspielen.equals ("n")) {
					spielen=0;
					System.out.println("====================================");
					System.out.println("=============Game=Over==============");
					System.out.println("====================================");
				
				}
				
			}while(!(weiterspielen.equals("j")) && !(weiterspielen.equals ("n")));
			
			
			
		}while(spielen==1);
		
		
		
		
		
		
	}

	

}
