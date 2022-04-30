package Pessoa;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Calculos.MetodoCalculos;
import Enums.AliquotaINSS;
import Enums.AliquotaIR;
import Exceptions.DependenteExceptions;

public class Funcionario extends Pessoa implements MetodoCalculos {

	private double salarioBruto;
	private double descontoIR;
	private double descontoINSS;
	private int qtdDependentesValidos;
	private double descontoDependente;
	private double salarioLiquido;
	private Set<Dependente> dependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		dependentes = new HashSet<>();
	}

	public int getQtdDependentesValidos() {
		return qtdDependentesValidos;
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

	public double getDescontoDependente() {
		return descontoDependente;
	}
	

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public Set<Dependente> getDependentes() {
		return dependentes;
	}

	public void adicionarDependente(Dependente dependente) {
		dependentes.add(dependente);
	}

	public void verificaDependente(Dependente dependente) {
		LocalDate a;
		a = LocalDate.now();
		final Period periodo = Period.between(dependente.getDataNascimento(), a);
		if (periodo.getYears() < 18) {
			qtdDependentesValidos++;
		}
	}

	@Override
	public void calcularINSS() {
		if (salarioBruto <= 1212.00) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO1.getAliquota() - AliquotaINSS.TIPO1.getDeduzir();
		} else if (salarioBruto >= 1212.01 && salarioBruto <= 2427.35) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO2.getAliquota() - AliquotaINSS.TIPO2.getDeduzir();
		} else if (salarioBruto >= 2427.36 && salarioBruto <= 3641.03) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO3.getAliquota() - AliquotaINSS.TIPO3.getDeduzir();
		} else if (salarioBruto >= 3641.04 && salarioBruto <= 7087.22) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO4.getAliquota() - AliquotaINSS.TIPO4.getDeduzir();
		} else {
			descontoINSS = 7087.22 * AliquotaINSS.TIPO4.getAliquota() - AliquotaINSS.TIPO4.getDeduzir();
		}
	}

//	MÉTODOS
	@Override
	public void calcularIR() {
		if (salarioBruto >= 1903.98 && salarioBruto <= 2826.65) {
			descontoIR = (salarioBruto - descontoDependente - getDescontoINSS()) * AliquotaIR.TIPO1.getAliquota()
					- AliquotaIR.TIPO1.getDeduzir();
		} else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
			descontoIR = (salarioBruto - descontoDependente - getDescontoINSS()) * AliquotaIR.TIPO2.getAliquota()
					- AliquotaIR.TIPO2.getDeduzir();
		} else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
			descontoIR = (salarioBruto - descontoDependente - getDescontoINSS()) * AliquotaIR.TIPO3.getAliquota()
					- AliquotaIR.TIPO3.getDeduzir();
		} else if (salarioBruto >= 4664.68) {
			descontoIR = (salarioBruto - descontoDependente - getDescontoINSS()) * AliquotaIR.TIPO4.getAliquota()
					- AliquotaIR.TIPO4.getDeduzir();
		} else {
			descontoIR = 0;
		}
	}

	@Override
	public void calcularSalarioLiquido() {
		salarioLiquido = salarioBruto - descontoINSS - descontoIR;
	}

	@Override
	public void calcularValorDependente() {
		descontoDependente = getQtdDependentesValidos() * 189.59;
	}

	@Override
	public String toString() {
		return super.toString() + "Funcionario [salarioBruto=" + salarioBruto + "valor dependente" + descontoDependente
				+ ", descontoIR=" + descontoIR + ", descontoINSS=" + descontoINSS + "salario liquido " + salarioLiquido
				+ ", listaDependentes=" + dependentes + "]";
	}
}
