package Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Exceptions.DependenteExceptions;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;
	private static List<Pessoa> pessoas = new ArrayList<>();

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static void adicionarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public static void verificaCPF(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				throw new DependenteExceptions("cpf igual");
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}

	/*
	 * @Override public String toString() { return "Pessoa [nome=" + nome + ", cpf="
	 * + cpf + ", dataNascimento=" + dataNascimento + "]"; }
	 */

	/*@Override
	public String toString() {
		return "nome: " + nome + " |  cpf:" + cpf + " | data de nascimento=" + dataNascimento + "\n";
	}*/
	public String toString() {
		return nome +";"+ cpf + ";";
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
