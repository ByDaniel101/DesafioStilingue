package br.com.stlingue.dao;

import br.com.stilingue.connectFactory.PostgreConnetionFactory;
import br.com.stilingue.model.Mensagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MensagemDao {


    public Mensagem insert(Mensagem msg) {
        try {
            Connection connection = PostgreConnetionFactory.getConnection();
            String sql = "INSERT INTO mensagens (data, status, mensagem) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, msg.getData());
            ps.setString(2, msg.getStatus());
            ps.setString(3, msg.getTexto());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            msg.setId(rs.getInt("id"));

            connection.close();
            return msg;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Mensagem msg) {
        try {
            Connection connection = PostgreConnetionFactory.getConnection();
            String sql = "DELETE FROM mensagens where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, msg.getId());

            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Mensagem update(Mensagem msg) {
        try {
            Connection connection = PostgreConnetionFactory.getConnection();
            String sql = "DELETE FROM mensagens where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, msg.getId());

            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Mensagem searchById(int id) {
        Mensagem msg = null;
        try {
            Connection connection = PostgreConnetionFactory.getConnection();
            String sql = "SELECT id, data, status, mensagem FROM mensagens where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                     msg = new Mensagem(   rs.getInt("id"),
                                rs.getDate("data"),
                                rs.getString("status"),
                                rs.getString("mensagem"));
            }
            connection.close();
            return msg;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mensagem> searchAll() {
        List<Mensagem> msgs = new ArrayList<Mensagem>();
        try {
            Connection connection = PostgreConnetionFactory.getConnection();
            String sql = "SELECT id, data, status, mensagem FROM mensagens";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                msgs.add(
                        new Mensagem(   rs.getInt("id"),
                                        rs.getDate("data"),
                                        rs.getString("status"),
                                        rs.getString("mensagem")));
            }
            connection.close();
            return msgs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
