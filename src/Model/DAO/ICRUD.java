/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.List;

/**
 *
 * @author Edmilson Nhabinde
 */
public interface ICRUD {
    
    boolean adicionar(Object obj);
    List<Object> listar();
    boolean update();
    boolean delete(Object obj);
}
