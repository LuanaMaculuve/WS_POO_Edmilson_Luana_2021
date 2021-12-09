/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Propriedades;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Edmilson Nhabinde
 */
public class PropriedadesDAO implements ICRUD {

    private final EntityManager em;
    ArrayList<Propriedades> array;

    public PropriedadesDAO() {
        array = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_Job_SemestralPU");
        em = emf.createEntityManager();
    }

    /**
     * Recebe atributos da nova propriedade a ser adicionada isso porque para
     * adicionar n objctos na base de dados usando hibernate, os objectos devem
     * ser criados n vezes
     *
     * @param bairro
     * @param tipo
     * @param qtd
     */
    public void recebe(String bairro, String tipo, int qtd) {
        List Lista = listar();

        for (int a = 1; a <= qtd; a++) {
            Propriedades p = new Propriedades();

            p.setBairro(bairro);
            p.setTipo(tipo);
            p.setDisponivel(true);
            int b = fazerVerificacao(Lista);
            p.setCodigo(b);
            adicionar(p);
        }
        new TipoDePropriedadeDAO().temCasa(tipo);
    }

    /**
     * Metodo que faz a verificacao dos codigos das propriedades: Pega cada
     * elemento da lista de propriedades e compara com um codigo que foi gerado,
     * caso os codigos sejam iguai, o metodo vai gerar um novo codigo e fara a
     * comparacao ate que nao hajam codigos iguais
     *
     * @param lista
     * @return
     */
    public int fazerVerificacao(List lista) {
        Random rand = new Random();
        int novoCod = rand.nextInt(1000000000);
        for (int a = 0; a < lista.size(); a++) {
            Propriedades p = (Propriedades) lista.get(a);
            if (p.getCodigo() == novoCod) {
                fazerVerificacao(lista);
            }
        }
        return novoCod;
    }

    /**
     * recebe e faz a persitencia da propriedade
     *
     * @param obj
     * @return
     */
    @Override
    public boolean adicionar(Object obj) {
        Propriedades prop = (Propriedades) obj;
        em.getTransaction().begin();
        em.persist(prop);
        em.flush();
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Object> listar() {
        Query hql = em.createQuery("select b from Propriedades b");
        List lista = hql.getResultList();
        return lista;
    }

    public String OcupaProps(String tipo) {
        List lista = listar();

        for (int a = 0; a < lista.size(); a++) {
            Propriedades p = (Propriedades) lista.get(a);
            if (p.getTipo().equals(tipo) & p.isDisponivel()) {
                Propriedades prop = em.find(Propriedades.class, p.getCodigo());
                em.getTransaction().begin();
                prop.setDisponivel(false);

                em.persist(prop);
                em.flush();
                em.getTransaction().commit();
                return Integer.toString(prop.getCodigo());
            }
        }
        return "";
    }

    public void DesocupaProps(int id) {
        List lista = listar();

        for (int a = 0; a < lista.size(); a++) {
            Propriedades p = (Propriedades) lista.get(a);
            if (p.getCodigo() == id) {
                Propriedades prop = em.find(Propriedades.class, p.getCodigo());
                em.getTransaction().begin();
                prop.setDisponivel(true);

                em.persist(prop);
                em.flush();
                em.getTransaction().commit();
            }
        }
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
