package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void cadastrarUsuario (BeanCursoJsp usuario) {
		String sql = "INSERT INTO usuario (login, senha) values (?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public List<BeanCursoJsp> listarUsuario () {
		List<BeanCursoJsp> list = new ArrayList<BeanCursoJsp>();
		String sql = "SELECT * FROM usuario";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
				beanCursoJsp.setLogin(resultSet.getString("login"));
				beanCursoJsp.setSenha(resultSet.getString("senha"));
				
				list.add(beanCursoJsp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
