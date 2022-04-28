package Programa;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.metadata.IIOMetadataFormatImpl;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Pessoa.Funcionario;

public class Principal {

	public static void main(String[] args) {

		// String path = "/trabalhofinalPOO/planilha_funcionarios_dependentes.csv";

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		try {
			Scanner leitor = new Scanner(new File("planilha_funcionarios_dependentes.csv"));

			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] dadosLinhas = linha.split(";");
				String nome = dadosLinhas[0];
				String cpf = dadosLinhas[1];
				LocalDate dataNascimento = LocalDate.parse(dadosLinhas[2]);
				Double salario = Double.parseDouble(dadosLinhas[3]);
				listaFuncionarios.add(new Funcionario(nome,cpf,dataNascimento,salario));

				while (leitor.hasNext()) {
					linha = leitor.nextLine();
					if (linha.isEmpty()) {
						break;
					}

					String dadosLinhasDependente[] = linha.split(";");
					String nomeDependente = dadosLinhasDependente[0];
					String cpfDependente = dadosLinhasDependente[1];
					LocalDate.parse(dadosLinhasDependente[2]);
					String parentesco = dadosLinhasDependente[3];
				}
			}
			leitor.close();
		} catch (Exception e) {
			System.out.println("Deu ruim na leitura!");
		}
		for (Funcionario funcionario : listaFuncionarios) {
			System.out.println(funcionario);
		}
	}
}
