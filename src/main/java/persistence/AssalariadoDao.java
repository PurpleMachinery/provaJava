package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Assalariado;

public class AssalariadoDao {
	private Connection conn;

	public AssalariadoDao(Connection conn) {
		this.conn = conn;
	}

	public void Salvar(Assalariado c) throws SQLException {
		String sql = "insert into Assalariados (nome, sobrenome, cpf, salario) values ('" + c.getNome() + "','"
				+ c.getSobrenome() + "','" + c.getCpf() + "','" + c.getSalario() + "')";
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Apagar(Assalariado c) throws SQLException {
		String sql = "delete from Assalariados where pk_idAssalariado = " + c.getId();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Alterar(Assalariado c) throws SQLException {
		String sql = "update from Assalariados set nome = '" + c.getNome() + "', sobrenome = '" + c.getSobrenome()
				+ "', cpf = '" + c.getCpf() + "', salario = '" + c.getSalario() + "' where pk_idAssalariado = "+c.getId();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();		
	}
	
	public ArrayList<Assalariado> Listar() throws SQLException{
		ArrayList<Assalariado> assalariados = new ArrayList<Assalariado>();
		PreparedStatement comando = this.conn.prepareStatement("select * from Assalariados");
		ResultSet data = comando.executeQuery();
		while(data.next()) {
			Assalariado a = new Assalariado();
			a.setId(data.getInt("pk_idAssalariado"));
			a.setCpf(data.getString("cpf"));
			a.setNome(data.getString("nome"));
			a.setSobrenome(data.getString("sobrenome"));
			a.setSalario(data.getDouble("salario"));
			assalariados.add(a);			
		}		
		comando.close();
		return assalariados;
	}
}
