package Enums;

public enum AliquotaIR {

	TIPO1(0.075, 142.80), TIPO2(0.15, 354.80), TIPO3(0.225, 636.13), TIPO4(0.275, 869.36);

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
