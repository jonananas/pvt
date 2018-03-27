package se.pvt.ehandel.produkt.domain;

public class Produkt {
	
	String produktId;
    private String namn;

    private Produkt() {
	}

	private Produkt(String produktId, String namn) {
		setProduktId(produktId);
		setNamn(namn);
	}

	public static Produkt av(String produktId, String namn) {
		return new Produkt(produktId, namn);
	}

	public String getProduktId() {
		return this.produktId;
	}

    public String getNamn() {
        return namn;
    }

    private void setProduktId(String produktId) {
		this.produktId = produktId;
	}

	private void setNamn(String namn) {
	    this.namn = namn;
    }
}
