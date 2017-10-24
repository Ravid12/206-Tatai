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
	
	
	
	/**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the MaoriNo StringProperty
	 */
	
	public String getMaoriNo() {
        return maoriNo.get();
    }

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the maoriNo StringProperty
	 */
	
    public void setMaoriNo(String i) {
        this.maoriNo.set(i);
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return MaoriNo StringProperty
	 */
    
    public StringProperty maoriNoProperty() {
        return maoriNo;
    }
    
    
    
    
    
    
    
    
    
    /**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the numberSymbol StringProperty
	 */
    
    public String getSymbol() {
        return numberSymbol.get();
    }

    
    
    /**
	 * Setter method required for a JavaFX TableView
	 * Sets the numberSymbol StringProperty
	 */
    
    public void setSymbol(String i) {
        this.numberSymbol.set(i);
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return numberSymbol StringProperty
	 */
    
    public StringProperty symbolProperty() {
        return numberSymbol;
    }
	
    
    
    
    
    
    
    
    
    /**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the correctness StringProperty
	 */
    
    public String getCorrectness() {
        return correctness.get();
    }

    
    
    /**
	 * Setter method required for a JavaFX TableView
	 * Sets the correctness StringProperty
	 */
    
    public void setCorrectness(String i) {
        this.correctness.set(i);
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return correctness StringProperty
	 */
    
    public StringProperty correctnessProperty() {
        return correctness;
    } 
}
