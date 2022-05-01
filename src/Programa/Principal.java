package Programa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enums.Parentesco;
import Exceptions.DependenteExceptions;
import Pessoa.Dependente;
import Pessoa.Funcionario;
import Pessoa.Pessoa;

public class Principal {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			Scanner leitor = new Scanner(new File("planilha_funcionarios_dependentes.csv"));

			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] dadosLinhas = linha.split(";");
				String nome = dadosLinhas[0];
				String cpf = dadosLinhas[1];
				LocalDate dataNascimento = LocalDate.parse(dadosLinhas[2].toString(), DateTimeFormatter.BASIC_ISO_DATE);
				Double salario = Double.parseDouble(dadosLinhas[3]);
				Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, salario);
				funcionarios.add(funcionario);
				Pessoa.adicionarPessoa(funcionario);
				while (leitor.hasNext()) {
					linha = leitor.nextLine();
					if (linha.isEmpty()) {
						break;
					} else {
						dadosLinhas = linha.split(";");
						nome = dadosLinhas[0];
						cpf = dadosLinhas[1];

						dataNascimento = LocalDate.parse(dadosLinhas[2].toString(), DateTimeFormatter.BASIC_ISO_DATE);
						String parentesco = dadosLinhas[3];
						try {
							Pessoa.verificaCPF(cpf);
							final Parentesco parente;
							parente = funcionario.verificaParentesco(parentesco);
							Dependente dependente = new Dependente(nome, cpf, dataNascimento, parente);
							Pessoa.adicionarPessoa(dependente);
							funcionario.calcularValorDependente();
							funcionario.adicionarDependente(dependente);
							funcionario.verificaDependente(dependente);
						} catch (DependenteExceptions e) {
							System.out.println(e.getMessage());
						}
					}
				}
				funcionario.calcularINSS();
				funcionario.calcularValorDependente();
				funcionario.calcularIR();
				funcionario.calcularSalarioLiquido();
			}
			leitor.close();
			System.out.println("leitura realizada com sucesso");
		} catch (Exception e) {
			System.out.println("Deu ruim na leitura!");
		}

		FileWriter caminho;
		try {
			caminho = new FileWriter("saida.csv");
			PrintWriter gravar = new PrintWriter(caminho);

			for (Funcionario funcionario : funcionarios) {
				gravar.println(funcionario);
				System.out.println(funcionario);
			}
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
