import java.util.ArrayList;

public class Giocatore {
	
	private String nominativo;
	private String nickname;
	public ArrayList<Dado> dadi;
	
	public Giocatore(String _nominativo, String _nickname) {
		this.dadi=new ArrayList<Dado>();
		
		this.setNominativo(_nominativo);
		this.setNickname(_nickname);
	}

	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void stampaDadi() {		
		//System.out.println("Numero di dadi nella lista: " + this.dadi.size());
		for (int i = 0; i < this.dadi.size(); i++) {
		    System.out.print("Dado n " + (i + 1) + ": ");
		    this.dadi.get(i).stampaInfo();
		}
	}
	
	public int calcolaPunteggio() {
		int a = 0;
		
		for(Dado d : this.dadi) {
			a += d.lanciaDado();
		}
		System.out.println("Somma: "+a);
		
		return a;
	}
}
