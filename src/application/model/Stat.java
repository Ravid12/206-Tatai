package application.model;

import application.utils.MaoriUtils;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// This class exists to display statistics in a Tabular format.
public class Stat {
	
	private StringProperty equation = new SimpleStringProperty(null);
	private StringProperty date = new SimpleStringProperty(null);
	private StringProperty result = new SimpleStringProperty(null);
	private StringProperty number = new SimpleStringProperty(null);
	private IntegerProperty correct = new SimpleIntegerProperty(0);
	private IntegerProperty incorrect = new SimpleIntegerProperty(0);
	
	
	/**
	 * Constructor for a Stat Object
	 */
	public Stat() {
	}
	
	
	
	
	
	
	/**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "number" StringProperty
	 */
	
	public String getnumber() {
        return number.get();
    }

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the "number" StringProperty
	 */
	
    public void setNumber(String number) {
        this.number.set(MaoriUtils.getMaoriNumber(number));
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "number" StringProperty
	 */
    
    public StringProperty numberProperty() {
        return number;
    }
	
    
    
    
    
    
    
    
    
    /**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "correct" StringProperty
	 */
    
	public int getCorrect() {
        return correct.get();
    }

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the "correct" StringProperty
	 */
	
    public void addToCorrect(int i) {
        this.correct.set(getCorrect()+i);
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "correct" IntegerProperty
	 */
    
    public IntegerProperty correctProperty() {
        return correct;
    }
	
    
    
    
    
    
    
    
    
    /**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "incorrect" StringProperty
	 */
    
    public int getIncorrect() {
        return incorrect.get();
    }

    
    
    /**
	 * Setter method required for a JavaFX TableView
	 * Sets the "incorrect" StringProperty
	 */
    
    public void addToIncorrect(int i) {
        this.incorrect.set(getIncorrect()+i);
    }

    
    
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "incorrect" IntegerProperty
	 */
    
    public IntegerProperty incorrectProperty() {
        return incorrect;
    }

    
    
    
    
    
    
    
    
    /**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "date" StringProperty
	 */
    
	public String getDate() {
		return date.get();
	}

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the "date" StringProperty
	 */
	
	public void setDate(String date) {
		this.date.set(date);
	}
	
	
	
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "date" StringProperty
	 */
	
	public StringProperty dateProperty() {
		return date;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "equation" StringProperty
	 */
	
	public String getEquation() {
		return equation.get();
	}

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the "equation" StringProperty
	 */
	
	public void setEquation(String equation) {
		this.equation.set(equation);
	}
	
	
	
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "equation" StringProperty
	 */
	
	public StringProperty equationProperty() {
		return equation;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Getter method required for a JavaFX TableView
	 * @return String representation of the "result" StringProperty
	 */
	
	public String getResult() {
		return result.get();
	}

	
	
	/**
	 * Setter method required for a JavaFX TableView
	 * Sets the "result" StringProperty
	 */
	
	public void setResult(String result) {
		this.result.set(result);
	}
	
	
	
    /**
	 * Property getter method required for for a JavaFX TableView
	 * @return "result" StringProperty
	 */
	
	public StringProperty resultProperty() {
		return result;
	}
}
