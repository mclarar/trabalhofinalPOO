package Pessoa;

import java.time.LocalDate;
import java.time.Period;

import Enums.Parentesco;
import Exceptions.DependenteExceptions;

public class Dependente extends Pessoa {
	private Parentesco parentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	@Override
	public String toString() {
		return "Dependente [  nome=" + nome + ", cpf=" + cpf + "parentesco " + parentesco.getParentesco() + "]"
				+ super.getDataNascimento();
	}

}
