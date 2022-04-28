package Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Calculos.MetodoCalculos;
import Enums.AliquotaINSS;
import Enums.AliquotaIR;

public class Funcionario extends Pessoa implements MetodoCalculos {

	private double salarioBruto;
	private double descontoIR;
	private double descontoINSS;
	private List<Dependente>listaDependentes;
	
	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto)
			{
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		listaDependentes = new ArrayList<>();
	} 

	public List<Dependente> getListaDependentes() {
		return listaDependentes;
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
		if (salarioBruto <= 1212.00) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO1.getAliquota();
		}else if (salarioBruto >= 1212.01 && salarioBruto <= 2427.35) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO2.getAliquota();
		}else if (salarioBruto >= 2427.36 && salarioBruto <= 3641.03) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO3.getAliquota();
		}else if (salarioBruto >= 3641.04 && salarioBruto <= 7087.22) {
			descontoINSS = salarioBruto * AliquotaINSS.TIPO4.getAliquota();
		}else {
			descontoINSS = 7087.22 * AliquotaINSS.TIPO4.getAliquota();
		}

	}

//	MÉTODOS
	@Override
	public void calcularIR() {
		if (salarioBruto >= 1903.98 && salarioBruto <= 2826.65) {
			descontoIR = salarioBruto * AliquotaIR.TIPO1.getAliquota();
		}else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) { 
			descontoIR = salarioBruto * AliquotaIR.TIPO2.getAliquota();
		}else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) { 
			descontoIR = salarioBruto * AliquotaIR.TIPO3.getAliquota();
		}else if (salarioBruto >= 4664.68) { 
			descontoIR = salarioBruto * AliquotaIR.TIPO4.getAliquota();
		}else {
			descontoIR = 0;
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

	@Override
	public String toString() {
		return "Funcionario [salarioBruto=" + salarioBruto + ", descontoIR=" + descontoIR + ", descontoINSS="
				+ descontoINSS + ", listaDependentes=" + listaDependentes + "]";
	}
	
	public void listar() {
		System.out.println();
	}
}
