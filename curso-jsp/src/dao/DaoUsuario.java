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
		String sql = "INSERT INTO usuario (login, senha, nome) values (?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getNome());
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
				beanCursoJsp.setId(resultSet.getLong("id"));
				beanCursoJsp.setLogin(resultSet.getString("login"));
				beanCursoJsp.setNome(resultSet.getString("nome"));
				beanCursoJsp.setSenha(resultSet.getString("senha"));
				
				list.add(beanCursoJsp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deletarUsuario(String id) {
		String sql = "DELETE FROM usuario WHERE id = " + id;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
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
	
	public BeanCursoJsp consultarUsuario(String id) {
		String sql = "SELECT * FROM usuario WHERE id = " + id;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
				beanCursoJsp.setId(resultSet.getLong("id"));
				beanCursoJsp.setLogin(resultSet.getString("login"));
				beanCursoJsp.setNome(resultSet.getString("nome"));
				beanCursoJsp.setSenha(resultSet.getString("senha"));
				return beanCursoJsp;
			}
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BeanCursoJsp editarUsuario(BeanCursoJsp usuario) {
		String sql = "UPDATE usuario SET login=?, nome=?, senha=? WHERE id = " + usuario.getId();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getSenha());
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return usuario;		
	}
}
