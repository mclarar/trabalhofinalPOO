package Enums;

public enum AliquotaINSS {
	TIPO1(0.075, 0), TIPO2(0.09, 18.18), TIPO3(0.12, 91), TIPO4(0.14, 163.82);

	private double aliquota;
	private double deduzir;

	private AliquotaINSS(double aliquota, double deduzir) {
		this.aliquota = aliquota;
		this.deduzir = deduzir;
	}

	public double getDeduzir() {
		return deduzir;
	}

	public double getAliquota() {
		return aliquota;
	}

}
