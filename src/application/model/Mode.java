package application.model;

public enum Mode {
		NUMBER("Number Mode"), EQUATION("Equation Mode"), PRACTICE("Practice Mode");
	
		private String name;
		
		Mode(String string) {
			this.name = string;
		}
		
		public String toString() {
			return name;
		}
}