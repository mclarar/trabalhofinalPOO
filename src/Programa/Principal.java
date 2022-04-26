package Programa;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import Pessoa.Funcionario;

public class Principal {

	public static void main(String[] args) {

		String path = "d:\\trabalho\\Funcionarios.csv";

		List<Funcionario> list = new ArrayList<Funcionario>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				String nome = vect[0];
				String cpf = vect[1];
				Integer idade = Integer.parseInt(vect[2]);
				Double salario = Double.parseDouble(vect[3]);

				Funcionario f = new Funcionario(nome, cpf, 0, null, 0, 0, 0);
				list.add(f);

				line = br.readLine();
			}

			System.out.println("FUNCIONÁRIOS: ");
			for (Funcionario funcionario : list) {
				System.out.println(funcionario);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
