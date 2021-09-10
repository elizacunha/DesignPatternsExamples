package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Cachorro;
import entity.Contato;
import entity.Vacina;
import factory.ConnectionFactory;

public class CarteiraVacinacaoDAO {
	private Connection connection;

	public CarteiraVacinacaoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Cachorro cachorro, Vacina vacina) throws RuntimeException {
		String sql = "insert into carteira_vacinacao (nome,email,endereco,dataNascimento) values (?,?,?,?)";

		try {
			PreparedStatement stmt = getConnection().prepareStatement(sql);

			/*stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
			getConnection().commit();*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void remove(Contato contato) throws RuntimeException {
		//delete from contatos where contato = contato.getId();
	}
	
	public void altera(Long id, Contato novoContato) throws RuntimeException {
		//update contatos set nome=novoContato.getNome() where id = id
	}
}
