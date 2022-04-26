package Pessoa;

import java.time.LocalDate;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected int idade;
	protected LocalDate dataNascimento;

	public Pessoa(String nome, String cpf, int idade, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
