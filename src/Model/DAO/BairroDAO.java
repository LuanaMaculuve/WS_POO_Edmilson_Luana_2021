/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import GUI.TelaAddProp;
import GUI.TelaAddTipoProp;
import GUI.TelaNovoInquilino;
import Model.Bairro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Edmilson Nhabinde
 */
public class BairroDAO implements ICRUD {

    private final EntityManager em;

    public BairroDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }

    @Override
    public boolean adicionar(Object obj) {
        Bairro bairro = (Bairro) obj;
        em.getTransaction().begin();
        em.persist(bairro);
        em.flush();
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Object> listar() {
        Query hql = em.createQuery("select b from Bairro b");
        List bairros = hql.getResultList();
        return (List<Object>) bairros;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        Bairro bairro = (Bairro) obj;
        em.getTransaction().begin();
        em.remove(bairro);
        em.getTransaction().commit();
        return false;
    }

    /**
     * um bairro geralmemnte adiciona-se ao sistema sem nenhum tipo e nenhuma
     * propriedade, sendo assim, existe uma variavel que me ajuda a controlar se
     * um determinado bairro esta vazio ou nao Essa variavel no inicio esta com
     * o valor logico (FALSE) e quando adiciona-se uma propriedade o valor muda
     * para (TRUE)
     *
     * @param nome do bairro
     */
    public void ja_nao_esta_vzio(String nome) {
        List lista = listar();

        for (int a = 0; a < lista.size(); a++) {
            Bairro p = (Bairro) lista.get(a);
            if (p.getNome().equals(nome)) {
                Bairro bairro = em.find(Bairro.class, p.getId());
                em.getTransaction().begin();
                bairro.setVazio(false);
                em.persist(bairro);
                em.flush();
                em.getTransaction().commit();
            }
        }
    }

    /*
     * Esse metodo recebe um parametro que me ajuda a verificar a combobox a ser
     * preenchida nesse momento. Se a==1 entao trata-se da combobox da adicao
     * dos inquilinos, Se a==2 entao trata-se da combobox da adicao dos tipos de
     * propriedade e se a==3 trata-se da combobox da adicao das propriedades
     *
     * @param a*/
    public void preencherComboboxBairros(int b) {
        Query hql = em.createQuery("select b from Bairro b");
        ArrayList<Bairro> lista = (ArrayList<Bairro>) hql.getResultList();
        /**
         * Essa variavel booleana abaixo verifica se a combobox dos tipos de
         * propriedades tem tem algum tipo ou nao.
         */
        boolean ja_tem = false;
        esvaziaCombobox(b);

        switch (b) {
            case 1:
                for (int a = 0; a < lista.size(); a++) {
                    if (lista.get(a).isVazio() == false) {
                        TelaNovoInquilino.jcbbairro.addItem(lista.get(a).getNome());
                        ja_tem = true;
                    } else if (a == lista.size() - 1 & !ja_tem) {
                        JOptionPane.showMessageDialog(null, "NAO HA PRPRIEDADES DISPONIVEIS");
                    }
                }
                break;
            case 2:
                lista.forEach((_item) -> {
                    TelaAddTipoProp.jcbBairro.addItem(_item.getNome());
                });
                break;
            case 3:
                lista.forEach((_item) -> {
                    TelaAddProp.jcbBairro.addItem(_item.getNome());
                });
                break;
        }

    }

    public void esvaziaCombobox(int a) {
        switch (a) {
            case 1:
                TelaNovoInquilino.jcbbairro.removeAllItems();
                break;
            case 2:
                TelaAddTipoProp.jcbBairro.removeAllItems();
                break;
            case 3:
                TelaAddProp.jcbBairro.removeAllItems();
                break;
        }
    }
}
