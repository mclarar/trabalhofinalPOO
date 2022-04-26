package Pessoa;

import java.time.LocalDate;

import Calculos.MetodoCalculos;
import Enums.AliquotaIR;

public class Funcionario extends Pessoa implements MetodoCalculos {

	private double salarioBruto;
	private double descontoIR;
	private double descontoINSS;

	public Funcionario(String nome, String cpf, int idade, LocalDate dataNascimento, double salarioBruto,
			double descontoIR, double descontoINSS) {
		super(nome, cpf, idade, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoIR = descontoIR;
		this.descontoINSS = descontoINSS;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(double descontoIR) {
		this.descontoIR = descontoIR;
	}

	public double getDescontoINSS() {
		return descontoINSS;
	}

	public void setDescontoINSS(double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}

	@Override
	public void calcularINSS() {
		// TODO Auto-generated method stub

	}

//	MÉTODOS
	@Override
	public void calcularIR() {
		if (salarioBruto >= 2000 && salarioBruto <= 3000) {
			descontoIR = salarioBruto * AliquotaIR.TIPO1.getAliquota();
		}

	}

	@Override
	public void calcularSalarioLiquido() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcularValorDependente() {
		// TODO Auto-generated method stub

	}

}
