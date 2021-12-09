/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import GUI.TelaAddProp;
import GUI.TelaNovoInquilino;
import java.util.*;
import javax.persistence.EntityManager;
import Model.TipoDePropriedade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Edmilson Nhabinde
 */
public class TipoDePropriedadeDAO implements ICRUD {

    private EntityManager em;

    public TipoDePropriedadeDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }

    /**
     * Metdodo que adiciona os dados no BD Se tiver sucesso na execucao retorna
     * true caso contrario false
     *
     * @param Tipo
     * @return true or false
     */
    @Override
    public boolean adicionar(Object Tipo) {
        TipoDePropriedade tipo = (TipoDePropriedade) Tipo;
        em.getTransaction().begin();
        em.persist(tipo);
        em.flush();
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Object> listar() {
        Query hql = em.createQuery("select b from TipoDePropriedade b");
        List lista = hql.getResultList();
        return lista;
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Esse metodo muda o estado de um certo tipo de propriedae. Os tipos por
     * defeito vem sem nenhuma casa/propriedade, entao ao se adicionar uma prop
     * esse indicador e mudado de modo a fazer com que o programa sauba que o
     * tipo ja tem propriedades. O metodo e chamado sempre que se adiciona uma
     * propriedade
     *
     * @param nome
     */
    public void temCasa(String nome) {
        List lista = listar();

        for (int a = 0; a < lista.size(); a++) {
            TipoDePropriedade p = (TipoDePropriedade) lista.get(a);
            if (p.getNome().equals(nome)) {
                TipoDePropriedade prop = em.find(TipoDePropriedade.class, p.getId());
                em.getTransaction().begin();
                prop.setJa_tem_casas(true);

                em.persist(prop);
                em.flush();
                em.getTransaction().commit();
            }
            if (a == lista.size() - 1) {
                new BairroDAO().ja_nao_esta_vzio(p.getBairro());
            }
        }
    }

    /**
     * Esse metodo recebe um parametro que me ajuda a verificar a combobox a ser
     * preenchida nesse momento. Se a==2 entao trata-se da combobox da adicao
     * dos inquilinos e se a==1 trata-se da combobox da adicao das propriedades
     *
     * @param bairro
     * @param a
     *
     */
    public void preencherComboboxTipos(String bairro, int a) {
        Query hql = em.createQuery("select b from TipoDePropriedade b");
        List<TipoDePropriedade> Lista = (List<TipoDePropriedade>) hql.getResultList();

        /**
         * Essa variavel booleana abaixo verifica se a combobox dos tipos de
         * propriedades tem tem algum tipo ou nao.
         */
        boolean ja_tem = false;
        esvaziaCombobox(a);

        if (a == 1) {
            for (int b = 0; b < Lista.size(); b++) {
                if (Lista.get(b).getBairro().equals(bairro)) {
                    TelaAddProp.jcbTipos.addItem(Lista.get(b).getNome());
                }
            }
        } else {
            for (int b = 0; b < Lista.size(); b++) {
                if (Lista.get(b).getBairro().equals(bairro) & Lista.get(b).isJa_tem_casas()) {
                    TelaNovoInquilino.jcbTipo.addItem(Lista.get(b).getNome());
                    ja_tem = true;

                }
            }
        }
    }

    public void esvaziaCombobox(int a) {
        if (a == 1) {
            TelaAddProp.jcbTipos.removeAllItems();
        } else {
            TelaNovoInquilino.jcbTipo.removeAllItems();
        }
    }

}
