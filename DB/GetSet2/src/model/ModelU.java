package model;

public class ModelU extends Model {
	
	private int codice;
	
	private double prezzo; 

	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "ModelU [codice=" + codice + ", getName()=" + getName() + "]";
	}

	
	
}
