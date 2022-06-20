package demo001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class BusinessSimulation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int spielen = 1;
		int taler = 0;
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Wirtschaftssimulation Programmierung II");
		
		//Niederlassung niederlassungEinbeck = new Niederlassung("Einbeck", Warenart.BIER, 1);
		
		Lager lagerAugsburg = new Lager("Augsburg");
	
		ArrayList<Niederlassung> listeNiederlassung = new ArrayList<Niederlassung>();
		listeNiederlassung.add(new Niederlassung("Einbeck", Warenart.BIER, 1));
		listeNiederlassung.add(new Niederlassung("Wien", Warenart.WEIN, 2));
		listeNiederlassung.add(new Niederlassung("Nordhausen", Warenart.KORN, 2));
		              
				
		do{
			System.out.println("Produdktion hochfahren?");
			String userInput = myScanner.nextLine();
			
			if (userInput.equals("j")) {
				for(int i = 0; i < listeNiederlassung.size(); i++) {
					listeNiederlassung.get(i).anfordern();
					listeNiederlassung.get(i).produzieren();
				}
			} 
			
			
			// niederlassungEinbeck.anfordern();
			// niederlassungEinbeck.produzieren();
			
			for(int i = 0; i < listeNiederlassung.size(); i++) {
				int produzierteMenge = listeNiederlassung.get(i).abholen();
				Warenart produzierteWarenart = listeNiederlassung.get(i).getWarenart();
				
				System.out.println("Ort: "+listeNiederlassung.get(i).getOrt()+"\tWare: "
					+produzierteWarenart+"\tMenge: "+produzierteMenge);
				lagerAugsburg.einlagern(produzierteWarenart, produzierteMenge);
			}
			
			//int produzierteMengeEinbeck = niederlassungEinbeck.abholen();
			//Warenart produzierteWarenart = niederlassungEinbeck.getWarenart();
	
			//System.out.println("Ort: "+niederlassungEinbeck.getOrt()+"\tWare: "
			//		+niederlassungEinbeck.getWarenartString()+"\tMenge: "+produzierteMengeEinbeck);
				
		
	
			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
			
				 System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			}
			
			
			int verkaufsmenge;
			Scanner menge_scanner = new Scanner(System.in);
			
			
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart)+": "+lagerAugsburg.getBestand(warenart));
			
				do {
					System.out.println("Wieviel verkaufen?");
					verkaufsmenge = menge_scanner.nextInt();
				}while((verkaufsmenge<0)||(verkaufsmenge>lagerAugsburg.getBestand(warenart)));
				
				
				int preis = 10;
				
				int erloes = lagerAugsburg.verkaufen(warenart ,verkaufsmenge , preis);
				
				taler = taler + erloes;
				
				
				System.out.println("Erl�s durch Verkauf: "+erloes);
			}
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
