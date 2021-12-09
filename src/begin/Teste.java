/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package begin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edmilson Nhabinde
 */
public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
    }
}
