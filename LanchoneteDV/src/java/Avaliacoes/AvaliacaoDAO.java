/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaliacoes;


import Lanchonetes.Lanchonete;
import Usuarios.Usuario;
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
public class AvaliacaoDAO {
    public static void salvar( int atendimento, int qualidade, int preco, int tempo_espera, int ambiente, String comentario, String usuario, String estabelecimento){
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres", "postgres");
            
            PreparedStatement ps = conexao.prepareStatement("insert into criterios_avaliacao ( atendimento, qualidade, preco, tempo_espera, ambiente, comentario, usuario, estabelecimento) values (?, ?, ?, ?, ?, ?, ?, ?)");
             
            ps.setInt(1, atendimento);
            ps.setInt(2, qualidade);
            ps.setInt(3, preco);
            ps.setInt(4, tempo_espera);
            ps.setInt(5, ambiente);
            ps.setString(6, comentario);
            ps.setString(7, usuario);
            ps.setString(8, estabelecimento);
            
                        
            ps.executeUpdate();
            ps.close();
            conexao.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    
        
    public static ArrayList<Avaliacao> listar(String estabelecimento) {
        ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lanchonete","postgres","postgres");
            
            PreparedStatement ps = conexao.prepareStatement("select criterios_avaliacao.*, cad_usuario.nome_sobrenome as usuario,estabelecimento.nome as estabelecimento from criterios_avaliacao join cad_usuario on cad_usuario.email=criterios_avaliacao.usuario join estabelecimento on estabelecimento.email=criterios_avaliacao.estabelecimento where estabelecimento=?");
            ps.setString(1, estabelecimento);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.codigo = rs.getInt("codigo");
            avaliacao.atendimento = rs.getInt("atendimento");
            avaliacao.qualidade = rs.getInt("qualidade");
            avaliacao.preco = rs.getInt("preco");
            avaliacao.tempo_espera = rs.getInt("tempo_espera");
            avaliacao.ambiente = rs.getInt("ambiente");
            avaliacao.comentario = rs.getString("comentario");
            
            Lanchonete lanchonete = new Lanchonete();
              lanchonete.nome = rs.getString("estabelecimento");
              avaliacao.estabelecimento = lanchonete;
              
              Usuario usuario = new Usuario();
              usuario.nome_sobrenome = rs.getString("usuario");
              avaliacao.usuario = usuario;                
               
                
                
                
             avaliacoes.add(avaliacao);
            }
            
            rs.close();
            ps.close();
            conexao.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avaliacoes;
    }

    

    
    
}
    
    
    

