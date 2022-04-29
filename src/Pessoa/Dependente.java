package Pessoa;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	private Funcionario funcionario;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Funcionario funcionario) {
		super(nome, cpf, dataNascimento);
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Dependente [funcionario=" + funcionario + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
