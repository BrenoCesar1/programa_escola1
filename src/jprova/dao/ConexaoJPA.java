/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jprova.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
/*Método que cria uma conexão com a unidade de persistência criada e irá retornar o EntityManager para manipulação*/
public class ConexaoJPA {
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("JProvaPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}
