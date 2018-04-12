package view;

import java.sql.Connection;
import java.sql.SQLException;

import model.*;
import persistence.*;

public class App {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Connection conn = JdbcUtil.getConnection();
		Assalariado assalariado = new Assalariado();
		Comissionado comissionado = new Comissionado();
		Horista horista = new Horista();
		AssalariadoDao assalariadoDao = new AssalariadoDao(conn);
		ComissionadoDao comissionadoDao = new ComissionadoDao(conn);
		HoristaDao horistaDao = new HoristaDao(conn);
		String nome = "wesley";
		String sobrenome = "vieira";
		String cpf = "49004444444";
		assalariado.setNome(nome);
		assalariado.setSobrenome(sobrenome);
		assalariado.setCpf(cpf);
		assalariado.setSalario(1500.0);
		comissionado.setNome(nome);
		comissionado.setSobrenome(sobrenome);
		comissionado.setCpf(cpf);
		comissionado.setTaxaComissao(10.0);
		comissionado.setTotalVenda(10.0);
		horista.setCpf(cpf);
		horista.setNome(nome);
		horista.setSobrenome(sobrenome);
		horista.setHorasTrabalhadas(10.0);
		horista.setPrecoHora(15.0);
		assalariadoDao.Salvar(assalariado);
		comissionadoDao.Salvar(comissionado);
		horistaDao.Salvar(horista);
	}
}
