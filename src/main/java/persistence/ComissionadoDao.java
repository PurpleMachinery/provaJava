package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comissionado;

public class ComissionadoDao {
	private Connection conn;
	
	public ComissionadoDao(Connection conn) {
		this.conn = conn;
	}
	
	public void Salvar(Comissionado c) throws SQLException {
		String sql = "insert into Comissionados (nome, sobrenome, cpf, totalVenda, taxaComissao) values ('"+c.getNome()+"','"+c.getSobrenome()+"','"+c.getCpf()+"','"+c.getTotalVenda()+"','"+c.getTaxaComissao()+"')";
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}
	
	public void Apagar(Comissionado c) throws SQLException{
		String sql = "delete from Comissionados where pk_idComissionado = '"+c.getId()+"'";
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}
	
	public void Alterar(Comissionado c) throws SQLException{
		String sql = "update from Comissionados set nome = '"+c.getNome()+"', sobrenome = '"+c.getSobrenome()+"', cpf = '"+c.getCpf()+"',totalVenda = '"+c.getTotalVenda()+"', taxaComissao = '"+c.getTaxaComissao()+"' where pk_idComissionado = "+c.getId();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}
	
	public ArrayList<Comissionado> Listar() throws SQLException {
		String sql = "select * from Comissionados";
		ArrayList<Comissionado> Comissionados = new ArrayList<Comissionado>();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		ResultSet data = comando.executeQuery();
		while(data.next()){
			Comissionado c = new Comissionado();
			c.setId(data.getInt("pk_idAssalariado"));
			c.setCpf(data.getString("cpf"));
			c.setNome(data.getString("nome"));
			c.setSobrenome(data.getString("sobrenome"));
			c.setTaxaComissao(data.getDouble("taxaComissao"));
			c.setTotalVenda(data.getDouble("totalVenda"));
			Comissionados.add(c);
		}
		return Comissionados;
	}
}
