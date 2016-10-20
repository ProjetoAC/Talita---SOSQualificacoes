/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaliacoes;

import Lanchonetes.Lanchonete;
import Usuarios.Usuario;

/**
 *
 * @author Gilvan Honorato
 */
public class Avaliacao {
    public int codigo; 
    public int atendimento; 
    public int qualidade;
    public int preco;
    public int tempo_espera;
    public int ambiente;
    public String comentario;
    public Usuario usuario;
    public Lanchonete estabelecimento;
    
}
