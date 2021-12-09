/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import GUI.TelaConfirmInquilino;
import Model.Pagamentos;
import Model.TipoDePropriedade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Edmilson Nhabinde
 */
public class PagamentosDAO {
    
    private final EntityManager em;
    
    public PagamentosDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }
    
    public void adicionar() {
        List lista = new TipoDePropriedadeDAO().listar();
        
        Pagamentos paga = new Pagamentos();
        
        paga.setBairro(TelaConfirmInquilino.NomeBairo.getText());
        paga.setData("");
        paga.setNome(TelaConfirmInquilino.NomeInq.getText());
        paga.setTempo(TelaConfirmInquilino.tempo.getText());
        paga.setTako(TelaConfirmInquilino.Valor_a_Pagar.getText());
        paga.setTipo(TelaConfirmInquilino.NomeTipo.getText());
        
        for (int a = 0; a < lista.size(); a++) {
            TipoDePropriedade tipo = (TipoDePropriedade) lista.get(a);
            if (tipo.getNome().equals(paga.getTipo())) {
                paga.setTipo_de_casa(tipo.getTipo_de_casa());
            }
        }
        
        em.getTransaction().begin();
        em.persist(paga);
        em.flush();
        em.getTransaction().commit();
    }
    
    public List<Pagamentos> listar() {
        Query hql = em.createQuery("select b from Pagamentos b");
        List lista = hql.getResultList();
        return (List<Pagamentos>) lista;
    }
}
