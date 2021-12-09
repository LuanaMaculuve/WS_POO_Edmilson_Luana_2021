/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Usuarios;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Edmilson Nhabinde
 */
public class UsuarioDAO implements ICRUD {

    private final EntityManager em;
    Random rand;

    public UsuarioDAO() {
        rand = new Random();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }

    @Override
    public boolean adicionar(Object obj) {
        Usuarios prop = (Usuarios) obj;
        List lista = listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (prop.getEmail().equals(user.getEmail())) {
                JOptionPane.showMessageDialog(null, "O EMAIL INTRODUZINHO CONSTA NA BASE DE DADOS");
                return false;
            }
        }
        prop.setCodUser(prop.getNome().substring(0, 3) + prop.getApelido().substring(0, 3) + rand.nextInt(1000));
        em.getTransaction().begin();
        em.persist(prop);
        em.flush();
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "O SEU ID E: " + prop.getCodUser());
        return true;
    }

    @Override
    public List<Object> listar() {
        Query hql = em.createQuery("select b from Usuarios b");
        List lista = hql.getResultList();
        return lista;
    }

    public boolean actualizar(String senha, String email, String telefone, String nova_senha) {
        List lista = listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (user.getSenha() != null) {
                if (user.getSenha().equals(senha) || user.getCodUser().equals(senha)) {
                    Usuarios prop = em.find(Usuarios.class, user.getId());
                    em.getTransaction().begin();
                    prop.setSenha(nova_senha);
                    prop.setEmail(email);
                    prop.setTelefone(telefone);
                    em.persist(prop);
                    em.flush();
                    em.getTransaction().commit();
                    return true;
                }
            } else {
                if (user.getCodUser().equals(senha)) {
                    Usuarios prop = em.find(Usuarios.class, user.getId());
                    em.getTransaction().begin();
                    prop.setSenha(nova_senha);
                    prop.setEmail(email);
                    prop.setTelefone(telefone);
                    em.persist(prop);
                    em.flush();
                    em.getTransaction().commit();
                    return true;
                }
            }

        }
        JOptionPane.showMessageDialog(null, "A SENHA OU O ID INSERIDO NAO CONSTA NA BASE DE DADOS");
        return false;
    }

    public String procuraPassword(String id) {
        List lista = listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (user.getCodUser().equals(id)) {
                if (user.getSenha() != null) {
                    return user.getSenha();
                } else {
                    return user.getCodUser();
                }
            }
        }
        return null;
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
