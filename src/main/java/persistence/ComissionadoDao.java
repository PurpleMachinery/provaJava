package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Comissionado;

public class ComissionadoDao {
	private Connection conn;
	
	public ComissionadoDao(Connection conn) {
		this.conn = conn;
	}
	
	public void Salvar(Comissionado c) throws SQLException {
		String sql = "insert into Comissionado (nome, sobrenome, cpf, totalVenda, taxaComissao) values ('"+c.getNome()+"','"+c.getSobrenome()+"','"+c.getCpf()+"','"+c.getTotalVenda()+"','"+c.getTaxaComissao()+"')";
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}
}
