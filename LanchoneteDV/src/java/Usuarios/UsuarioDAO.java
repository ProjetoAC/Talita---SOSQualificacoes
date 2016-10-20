/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilvan Honorato
 */
public class UsuarioDAO {
    
    public static void salvar( String nome_sobrenome, String data_nascimento, String rua, String numero, String bairro, String cidade, String telefone, String email, String senha, String confirmacao_senha){
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres", "postgres");
            
            PreparedStatement ps = conexao.prepareStatement("insert into cad_usuario (nome_sobrenome, data_nascimento, rua, numero, bairro, cidade, telefone, email, senha, confirmacao_senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            Date data = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(data_nascimento).getTime()); 
            ps.setString(1, nome_sobrenome);
            ps.setDate(2, data);
            ps.setString(3, rua);
            ps.setString(4, numero);
            ps.setString(5, bairro);
            ps.setString(6, cidade);
            ps.setString(7, telefone);
            ps.setString(8, email);
            ps.setString(9, senha);
            ps.setString(10, confirmacao_senha);
            
            ps.executeUpdate();
            ps.close();
            conexao.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
      public static Usuario login(String email, String senha) {
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres","postgres");
            
            PreparedStatement ps = conexao.prepareStatement("select * from cad_usuario where email = ? and senha=?");
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                        
            Usuario usuario = new Usuario();
            usuario.nome_sobrenome = rs.getString("nome_sobrenome");
            usuario.data_nascimento = rs.getDate("data_nascimento");
            usuario.rua = rs.getString("rua");
            usuario.numero = rs.getString("numero");
            usuario.bairro = rs.getString("bairro");
            usuario.cidade = rs.getString("cidade");
            usuario.telefone = rs.getString("telefone");
            usuario.email = rs.getString("email");
            usuario.senha = rs.getString("senha");
            usuario.confirmacao_senha = rs.getString("confirmacao_senha");
            
            
            
            rs.close();
            ps.close();
            conexao.close();
            
            return usuario;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
     public static Usuario buscar(String email) {
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres","postgres");
            
            PreparedStatement ps = conexao.prepareStatement("select * from cad_usuario where email = ?");
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            Usuario usuario = new Usuario();
            usuario.nome_sobrenome = rs.getString("nome_sobrenome");
            usuario.data_nascimento = rs.getDate("data_nascimento");
            usuario.rua = rs.getString("rua");
            usuario.numero = rs.getString("numero");
            usuario.bairro = rs.getString("bairro");
            usuario.cidade = rs.getString("cidade");
            usuario.telefone = rs.getString("telefone");
            usuario.email = rs.getString("email");
            usuario.senha = rs.getString("senha");
            usuario.confirmacao_senha = rs.getString("confirmacao_senha");
            
            
            
            rs.close();
            ps.close();
            conexao.close();
            
            return usuario;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void atualizar(String nome_sobrenome, String data_nascimento, String rua, String numero, String bairro, String cidade, String telefone, String email, String senha, String confirmacao_senha) {
        
        try {
            
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres","postgres");
            
            PreparedStatement ps = conexao.prepareStatement("update cad_usuario set nome_sobrenome = ?, data_nascimento = ?, rua, numero, bairro, cidade, telefone, email, senha, confirmacao_senha");
            Date data = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(data_nascimento).getTime());
            ps.setString(1, nome_sobrenome);
            ps.setDate(2, data);
            ps.setString(3, rua);
            ps.setString(4, numero);
            ps.setString(5, bairro);
            ps.setString(6, cidade);
            ps.setString(7, telefone);
            ps.setString(8, email);
            ps.setString(9, senha);
            ps.setString(10, confirmacao_senha);
            
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
                    
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
        
    public static ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres","postgres");
            
            PreparedStatement ps = conexao.prepareStatement("select * from cad_usuario");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            Usuario usuario = new Usuario();
            usuario.nome_sobrenome = rs.getString("nome_sobrenome");
            usuario.data_nascimento = rs.getDate("data_nascimento");
            usuario.rua = rs.getString("rua");
            usuario.numero = rs.getString("numero");
            usuario.bairro = rs.getString("bairro");
            usuario.cidade = rs.getString("cidade");
            usuario.telefone = rs.getString("telefone");
            usuario.email = rs.getString("email");    
                
              
                
                
                
             usuarios.add(usuario);
            }
            
            rs.close();
            ps.close();
            conexao.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }

    
    
}
    
    

