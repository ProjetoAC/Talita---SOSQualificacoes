/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lanchonetes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilvan Honorato
 */
public class LanchoneteDAO {

    public static void salvar(String nome, String rua, String numero, String bairro, String cidade, String telefone, String email, String senha, String confirmacao_senha) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete", "postgres", "postgres");

            PreparedStatement ps = conexao.prepareStatement("insert into estabelecimento (nome, rua, numero, bairro, cidade, telefone, email, senha, confirmacao_senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, nome);
            ps.setString(2, rua);
            ps.setString(3, numero);
            ps.setString(4, bairro);
            ps.setString(5, cidade);
            ps.setString(6, telefone);
            ps.setString(7, email);
            ps.setString(8, senha);
            ps.setString(9, confirmacao_senha);

            ps.executeUpdate();
            ps.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Lanchonete buscar(String email) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete", "postgres", "postgres");

            PreparedStatement ps = conexao.prepareStatement("select * from estabelecimento where email = ?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            rs.next();

            Lanchonete lanchonete = new Lanchonete();
            lanchonete.nome = rs.getString("nome");
            lanchonete.rua = rs.getString("rua");
            lanchonete.numero = rs.getString("numero");
            lanchonete.bairro = rs.getString("bairro");
            lanchonete.cidade = rs.getString("cidade");
            lanchonete.telefone = rs.getString("telefone");
            lanchonete.email = rs.getString("email");
            lanchonete.senha = rs.getString("senha");
            lanchonete.confirmacao_senha = rs.getString("confirmacao_senha");

            rs.close();
            ps.close();
            conexao.close();

            return lanchonete;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void atualizar(String nome, String rua, String numero, String bairro, String cidade, String telefone, String email, String senha, String confirmacao_senha) {

        try {

            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete", "postgres", "postgres");

            PreparedStatement ps = conexao.prepareStatement("update estabelecimento set nome = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, telefone = ?, email = ?, senha = ?, confirmacao_senha = ?");

            ps.setString(1, nome);
            ps.setString(2, rua);
            ps.setString(3, numero);
            ps.setString(4, bairro);
            ps.setString(5, cidade);
            ps.setString(6, telefone);
            ps.setString(7, email);
            ps.setString(8, senha);
            ps.setString(9, confirmacao_senha);

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Lanchonete> listar() {
        ArrayList<Lanchonete> lanchonetes = new ArrayList<Lanchonete>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete", "postgres", "postgres");

            PreparedStatement ps = conexao.prepareStatement("select * from estabelecimento");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lanchonete lanchonete = new Lanchonete();
                lanchonete.nome = rs.getString("nome");
                lanchonete.rua = rs.getString("rua");
                lanchonete.numero = rs.getString("numero");
                lanchonete.bairro = rs.getString("bairro");
                lanchonete.cidade = rs.getString("cidade");
                lanchonete.telefone = rs.getString("telefone");
                lanchonete.email = rs.getString("email");
                lanchonete.senha = rs.getString("senha");
                lanchonete.confirmacao_senha = rs.getString("confirmacao_senha");

                lanchonetes.add(lanchonete);
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LanchoneteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lanchonetes;
    }

}
