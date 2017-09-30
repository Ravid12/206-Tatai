package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stat {
	private IntegerProperty number;
	private IntegerProperty correct;
	private IntegerProperty incorrect;
	
	public Stat(int number) {
        this.number = new SimpleIntegerProperty(number);
        this.correct = new SimpleIntegerProperty(0);
        this.incorrect = new SimpleIntegerProperty(0);
	}
	
	public int getnumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public IntegerProperty numberProperty() {
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
}
