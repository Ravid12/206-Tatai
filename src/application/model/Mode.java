package application.model;

public enum Mode {
		SPEAKING("Speaking"), EQUATION("Equation");
	
		private String name;
		
		Mode(String string) {
			this.name = string;
		}
		
		public String toString() {
			return name;
		}
}