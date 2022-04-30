package Pessoa;

import java.time.LocalDate;
import java.time.Period;

import Exceptions.DependenteExceptions;

public class Dependente extends Pessoa {


	public Dependente(String nome, String cpf, LocalDate dataNascimento) {
		super(nome, cpf, dataNascimento);
		Period dif = dataNascimento.until(LocalDate.now());
		if (dif.getYears() >= 18) {
			throw new DependenteExceptions("Dependente invalido");
		}
	}
	

	@Override
	public String toString() {
		return "Dependente [  nome=" + nome + ", cpf=" + cpf + "]" + super.getDataNascimento();
	}
	


}
