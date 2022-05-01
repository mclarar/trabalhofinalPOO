package Enums;

public enum Parentesco {
//	SOBRINHO, FILHO, OUTROS;
	TIPO1("SOBRINHO"),TIPO3("FILHO"),TIPO2("OUTROS");
	private String parentesco;

	private Parentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getParentesco() {
		return parentesco;
	}

	
}
