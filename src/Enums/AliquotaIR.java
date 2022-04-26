package Enums;

public enum AliquotaIR {

	TIPO1(100, 142.80), TIPO2(100, 354.80), TIPO3(100, 636.13), TIPO4(100, 869.36);

	private double aliquota;
	private double deduzir;

	private AliquotaIR(double aliquota, double deduzir) {
		this.aliquota = aliquota;
		this.deduzir = deduzir;
	}

	public double getAliquota() {
		return aliquota;
	}

	public double getDeduzir() {
		return deduzir;
	}

}
