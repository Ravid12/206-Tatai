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
	
	public Stat() {
	}
	
	public String getnumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(MaoriUtils.getMaoriNumber(number));
    }

    public StringProperty numberProperty() {
        return number;
    }
	
	public int getCorrect() {
        return correct.get();
    }

    public void addToCorrect(int i) {
        this.correct.set(getCorrect()+i);
    }

    public IntegerProperty correctProperty() {
        return correct;
    }
	
    public int getIncorrect() {
        return incorrect.get();
    }

    public void addToIncorrect(int i) {
        this.incorrect.set(getIncorrect()+i);
    }

    public IntegerProperty incorrectProperty() {
        return incorrect;
    }

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}
	
	public StringProperty dateProperty() {
		return date;
	}
	
	public String getEquation() {
		return equation.get();
	}

	public void setEquation(String equation) {
		this.equation.set(equation);
	}
	
	public StringProperty equationProperty() {
		return equation;
	}
	
	public String getResult() {
		return result.get();
	}

	public void setResult(String result) {
		this.result.set(result);
	}
	
	public StringProperty resultProperty() {
		return result;
	}
}
