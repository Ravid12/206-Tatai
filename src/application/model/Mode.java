package application.model;

public enum Mode {
		SPEAKING("Speaking"), EQUATION("Equation");

		private int min;
		private int max;
			
		private String name;
		
		Mode(String string) {
			this.name = string;
		}
		
		public String toString() {
			return name;
		}
}