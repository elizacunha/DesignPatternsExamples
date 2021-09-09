package controller;

import java.util.Calendar;

import dao.ContatoDAO;
import entity.Contato;

public class ContatoController {

	public static void main(String[] args) {
		try {
		  Contato contato = new Contato();
		  contato.setNome("Eliza Bomfim");
		  contato.setEmail("elizacunha@gmail.com");
		  contato.setEndereco("R. César Vergueiro 3185 cj57");
		  contato.setDataNascimento(Calendar.getInstance());

		  ContatoDAO dao = new ContatoDAO();

		  dao.adiciona(contato);

		  System.out.println("Gravado!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
