/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jprova;

import jprova.view.TelaPrincipal;

/**
 *
 * @author Administrador
 */
public class JProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Código para inserção de formulário no painel tabulado */
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.validate();
        telaPrincipal.pack();
        telaPrincipal.setVisible(true);
    }
    
}
