import java.util.ArrayList;

public class Controller {
	public int turno;
	public int punteggio1;
	public int punteggio2;
	public ArrayList<Giocatore> giocatori;
	
	public Controller(String _nominativo1, String _nickname1, String _nominativo2, String _nickname2) {
		this.turno=1;
		
		this.giocatori=new ArrayList<Giocatore>();
		
		Giocatore g1 = new Giocatore(_nominativo1, _nickname1);
		Giocatore g2 = new Giocatore(_nominativo2, _nickname2);
		giocatori.add(g1);
		giocatori.add(g2);
	}
	
	public void UI() {
		System.out.println("Turno: "+this.turno+" |"+this.giocatori.get(0).getNickname()+": "+this.punteggio1+" |"+this.giocatori.get(1).getNickname()+": "+this.punteggio2);
	}
	
	public void simulaTurno() {
		int punteggio1, punteggio2;
		
		punteggio1= this.giocatori.get(0).calcolaPunteggio();
		punteggio2= this.giocatori.get(1).calcolaPunteggio();
		if(punteggio1<punteggio2) {
			System.out.println(this.giocatori.get(1).getNickname()+" ha vinto");
			this.punteggio2++;
		} else if(punteggio1>punteggio2) {
			System.out.println(this.giocatori.get(0).getNickname()+" ha vinto");
			this.punteggio1++;
		} else {
			System.out.println("Pareggio");
		}
		this.turno++;
	}
}
