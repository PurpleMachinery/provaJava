package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Horista;

public class HoristaDao {
	private Connection conn;

	public HoristaDao(Connection conn) {
		this.conn = conn;
	}

	public void Salvar(Horista c) throws SQLException {
		String sql = "insert into Horistas (nome, sobrenome, cpf, precoHora, horasTrabalhadas) values ('" + c.getNome() + "','"
				+ c.getSobrenome() + "','" + c.getCpf() + "','" + c.getPrecoHora() + "','"+c.getHorasTrabalhadas()+"')";
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Apagar(Horista c) throws SQLException {
		String sql = "delete from Horistas where pk_idHorista = " + c.getId();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Alterar(Horista c) throws SQLException {
		String sql = "update from Horistas set nome = '" + c.getNome() + "', sobrenome = '" + c.getSobrenome()
				+ "', cpf = '" + c.getCpf() + "', precoHora = '" + c.getPrecoHora() + "', horasTrabalhadas = "+c.getHorasTrabalhadas()+"' where pk_idHorista = "+c.getId();
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();		
	}
	
	public ArrayList<Horista> Listar() throws SQLException{
		ArrayList<Horista> Horistas = new ArrayList<Horista>();
		PreparedStatement comando = this.conn.prepareStatement("select * from Horistas");
		ResultSet data = comando.executeQuery();
		while(data.next()) {
			Horista a = new Horista();
			a.setId(data.getInt("pk_idHorista"));
			a.setCpf(data.getString("cpf"));
			a.setNome(data.getString("nome"));
			a.setSobrenome(data.getString("sobrenome"));
			a.setPrecoHora(data.getDouble("precoHora"));
			a.setHorasTrabalhadas(data.getDouble("horasTrabalhadas"));
			Horistas.add(a);			
		}		
		return Horistas;
	}

}
