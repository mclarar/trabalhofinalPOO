package Enums;

public enum AliquotaINSS {
	TIPO1(0.075), TIPO2(0.09), TIPO3(0.12), TIPO4(0.14);
	
	private double aliquota;

	private AliquotaINSS(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getAliquota() {
		return aliquota;
	}
	
	
}
