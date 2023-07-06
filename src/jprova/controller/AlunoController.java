/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jprova.controller;

import java.util.List;
import jprova.dao.AlunoDAO;
import jprova.model.Aluno;
/**
 *
 * @author Administrador
 */
public class AlunoController {
    /* Método para inserir dados ao banco*/ 
    
    public void inserir(String nome, String telefone, String curso)     
            throws Exception {   
         Aluno aluno = new Aluno();
         aluno.setNome(nome);
         aluno.setCurso(curso);
         aluno.setTelefone(telefone);
         new AlunoDAO().create(aluno);
    }
    public void alterar (Integer id, String nome, String telefone, String curso) throws Exception{
        
    }
     
    /*Método para excluir dados do banco*/
    public void excluir(Integer id)
           throws Exception{
        new AlunoDAO().destroy(id);
    /*Método para buscar os dados no Banco*/   
   }
    public List<Aluno> buscar(String nome, String telefone)
            /*Tratamento de exceção caso não busque nada no banco de dados*/
            throws Exception{
       return new AlunoDAO().
       getlistaDeAlunos(nome, telefone);
    }
   
}
        
    
    
    

