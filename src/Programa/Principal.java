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

import Exceptions.DependenteExceptions;
import Pessoa.Dependente;
import Pessoa.Funcionario;

public class Principal {

	public static void main(String[] args) {

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

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
				listaFuncionarios.add(funcionario);
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
							Dependente dependente = new Dependente(nome, cpf, dataNascimento);
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
			caminho = new FileWriter("C:\\Users\\kappa\\eclipse-workspace\\trabalhofinalPOO\\saida.txt");
			PrintWriter gravar = new PrintWriter(caminho);

			for (Funcionario funcionario : listaFuncionarios) {
				gravar.println(funcionario);
				System.out.println(funcionario);
			}
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
