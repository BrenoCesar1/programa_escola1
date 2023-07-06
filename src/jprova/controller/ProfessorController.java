/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jprova.controller;

import java.util.List;
import jprova.dao.ProfessorDAO;
import jprova.model.Professor;

/**
 *
 * @author Administrador
 */
public class ProfessorController {
    /* Método para inserir dados ao banco*/ 
    public void inserir(String nome, String telefone, String disciplina) throws Exception {
        Professor professor = new Professor();
         professor.setNome(nome);
         professor.setDisciplina(disciplina);
         professor.setTelefone(telefone);
         new ProfessorDAO().create(professor);
    }
    /* Método para alteração de Dados*/
     public void alterar (Integer id, String nome, String telefone, String disciplina) throws Exception{
     }
     
    /*Método para excluir dados do banco*/
    public void excluir(Integer id)
           throws Exception{
    }
    /*Método para buscar os dados no Banco*/   
   
    public List<Professor> buscar(String nome, String telefone)
            /*Tratamento de exceção caso não busque nada no banco de dados*/
            throws Exception{
        return new ProfessorDAO().
       getlistaDeProfessores(nome, telefone);
    }
    }
    

