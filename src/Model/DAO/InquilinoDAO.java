/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Inquilino;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Edmilson Nhabinde
 */
public class InquilinoDAO implements ICRUD {
    
    private EntityManager em;
    
    public InquilinoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public boolean adicionar(Object obj) {
        Inquilino inquilino = (Inquilino) obj;
        em.getTransaction().begin();
        em.persist(inquilino);
        em.flush();
        em.getTransaction().commit();
        new PagamentosDAO().adicionar();
        return true;
    }
    
    @Override
    public List<Object> listar() {
        Query hql = em.createQuery("select b from Inquilino b");
        List lista = hql.getResultList();
        return lista;
    }
    
    public boolean Update(int id, String nome, String apelido, String telefone) {
        List lista = listar();
        
        for (int a = 0; a < lista.size(); a++) {
            Inquilino p = (Inquilino) lista.get(a);
            if (p.getId()==id) {
                Inquilino inq = em.find(Inquilino.class, p.getId());
                em.getTransaction().begin();
                if (!nome.isEmpty()) {
                    inq.setNome(nome);
                }
                
                if (!apelido.isEmpty()) {
                    inq.setApelido(apelido);
                }
                
                if (!telefone.isEmpty()) {
                    inq.setTelefone(telefone);
                }
                em.persist(inq);
                em.flush();
                em.getTransaction().commit();
                
                return true;
            }
        }
        
        return false;
        
    }
    
    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean delete(Object obj) {
        return false;
    }
    
    public boolean logicDelete(int id) {
        List lista = listar();
        
        for (int a = 0; a < lista.size(); a++) {
            Inquilino p = (Inquilino) lista.get(a);
            if (p.getId() == id) {
                new PropriedadesDAO().DesocupaProps(Integer.parseInt(p.getCodProp()));
                
                Inquilino inq = em.find(Inquilino.class, p.getId());
                em.getTransaction().begin();
                inq.setVisible(false);
                em.persist(inq);
                em.flush();
                em.getTransaction().commit();
                
                return true;
            }
        }
        return false;
    }
    
}
