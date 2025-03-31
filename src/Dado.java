import java.util.Random;

public class Dado {
	
	public int min;
	public int max;
	
	public Dado(int _min, int _max) throws MaxIsLessThanMinException {
		if (_min<_max) {
			this.min=_min;
			this.max=_max;
		} else {
			throw new MaxIsLessThanMinException();
		}
	}
	
	public void stampaInfo() {
		System.out.println(this.min + " " + this.max);
	}
	
	public int lanciaDado() {
		Random r=new Random();
		int d = this.max-this.min;
		int a = r.nextInt(d) + min;
		System.out.println("Il dado lanciato ha generato: "+ a);
		return a;
	}
	
}
