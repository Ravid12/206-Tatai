package application.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Result {
	private StringProperty maoriNo;
	private StringProperty numberSymbol;
	private StringProperty correctness;
	
	public Result(String mN, String i, String cor) {
        this.maoriNo = new SimpleStringProperty(mN);
        this.numberSymbol = new SimpleStringProperty(i);
        this.correctness = new SimpleStringProperty(cor);
	}
	
	public String getMaoriNo() {
        return maoriNo.get();
    }

    public void setMaoriNo(String i) {
        this.maoriNo.set(i);
    }

    public StringProperty maoriNoProperty() {
        return maoriNo;
    }
    
    public String getSymbol() {
        return numberSymbol.get();
    }

    public void setSymbol(String i) {
        this.numberSymbol.set(i);
    }

    public StringProperty symbolProperty() {
        return numberSymbol;
    }
	
    public String getCorrectness() {
        return correctness.get();
    }

    public void setCorrectness(String i) {
        this.correctness.set(i);
    }

    public StringProperty correctnessProperty() {
        return correctness;
    }
    
    
}
