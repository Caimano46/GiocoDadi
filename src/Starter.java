import java.util.ArrayList;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		String nominativo1, nickname1, nominativo2, nickname2;
		String risposta;
		int n, min, max;
		Boolean continua=true;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Inserire Nome di giocatore 1:");
		nominativo1=sc.next();
		System.out.println("Inserire Nick di giocatore 1:");
		nickname1=sc.next();
		
		System.out.println("Inserire Nome di giocatore 2:");
		nominativo2=sc.next();
		System.out.println("Inserire Nick di giocatore 2:");
		nickname2=sc.next();
		
		
		
		Controller c1 = new Controller(nominativo1, nickname1, nominativo2, nickname2);
		
		/*for (Giocatore g : c1.giocatori) {
			System.out.println(g.getNominativo());
			System.out.println(g.getNickname());
		}*/
		Dado d=null;
		ArrayList<Dado> temp = new ArrayList<Dado>();
        boolean valido = false;
		
		do {
		    System.out.println("Inserire il numero di dadi di giocatore 1");
		    n = sc.nextInt();

		    for (int i = 1; i <= n; i++) {
		        valido=false;
		        while (!valido) {
		            System.out.println("Inserire il numero min del dado numero " + i);
		            min = sc.nextInt();
		            System.out.println("Inserire il numero max del dado numero " + i);
		            max = sc.nextInt();

		            try {
		                d = new Dado(min, max);
		                temp.add(d);
		                valido = true; 
		            } catch (MaxIsLessThanMinException e) {
		                System.out.println("Errore: il valore massimo e' minore del minimo");
		            }
		        }
		    }

		    c1.giocatori.get(0).dadi = temp; 
		} while (c1.giocatori.get(0).dadi.isEmpty()); 
		
		min = 0;
		max = 0;
        valido = false;
        temp=new ArrayList<Dado>();
		
		do {
		    System.out.println("Inserire il numero di dadi di giocatore 2");
		    n = sc.nextInt();

		    for (int i = 1; i <= n; i++) {
		    	valido=false;
		        
		        while (!valido) {
		            System.out.println("Inserire il numero min del dado numero " + i);
		            min = sc.nextInt();
		            System.out.println("Inserire il numero max del dado numero " + i);
		            max = sc.nextInt();

		            try {
		                d = new Dado(min, max);
		                temp.add(d);
		                valido = true; 
		            } catch (MaxIsLessThanMinException e) {
		                System.out.println("Errore: il valore massimo e' minore del minimo");
		            }
		        }
		    }

		    c1.giocatori.get(1).dadi = temp; 
		} while (c1.giocatori.get(1).dadi.isEmpty()); 
		
		/*System.out.println("Dadi giocatore 1: ");
		c1.giocatori.get(0).stampaDadi();
		System.out.println("Dadi giocatore 2: ");
		c1.giocatori.get(1).stampaDadi();*/
		
		do {
			
			c1.UI();
			c1.simulaTurno();
			
			System.out.println("Continuare? (s/n)");
			risposta=sc.next();
			if(risposta.contains("s")) {
				continua=true;
			}else {
				continua=false;
			}
			
		} while(continua);
		sc.close();
	}

}
