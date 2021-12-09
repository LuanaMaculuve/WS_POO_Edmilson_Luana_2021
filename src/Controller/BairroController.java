/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.DeleteBairroOuTipo;
import static GUI.DeleteBairroOuTipo.jTabelaTipos;
import static GUI.DeleteBairroOuTipo.jtableBairros;
import Model.Bairro;
import Model.DAO.BairroDAO;
import Model.DAO.PropriedadesDAO;
import Model.DAO.TipoDePropriedadeDAO;
import Model.Propriedades;
import Model.TipoDePropriedade;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edmilson Nhabinde
 */
public class BairroController {

    public static String[] BairroColunas = new String[3];
    public static String[] TipoColunas = new String[4];

    /**
     * faz a verificacao do nome do bairro se esta vazio ou nao e entrega o
     * mesmo a classe da persistencia se tudo estiver certo
     * 
     *
     * @param nomeBairro
     * @return true or false
     */
    int numeros;
    
    public boolean controlBairro(String nomeBairro) {
        if (nomeBairro.isEmpty() || nomeBairro.equals(" Ex: George Dimitrov")) {
            return false;
        } else {
            Bairro bairro = new Bairro();
            bairro.setNome(nomeBairro);
            bairro.setVazio(true);
            return new BairroDAO().adicionar(bairro);
        }
    }

    public void personalizeTable() {

        DefaultTableModel model;
        model = new DefaultTableModel();

        model.setColumnIdentifiers(BairroColunas);
        jtableBairros.setModel(model);
        jtableBairros.setDefaultEditor(Object.class, null);
        jtableBairros.setRowHeight(30);
        jtableBairros.setFocusable(false);
        jtableBairros.setFont(new Font("serif", Font.PLAIN, 18));

        DefaultTableModel model2;
        model2 = new DefaultTableModel();

        model2.setColumnIdentifiers(TipoColunas);
        jTabelaTipos.setModel(model2);
        jTabelaTipos.setDefaultEditor(Object.class, null);
        jTabelaTipos.setRowHeight(30);
        jTabelaTipos.setFocusable(false);
        jTabelaTipos.setFont(new Font("serif", Font.PLAIN, 18));
        meteNaTabela();
        meteNaTabela2();
    }

    public void meteNaTabela() {
        DefaultTableModel model2 = (DefaultTableModel) DeleteBairroOuTipo.jtableBairros.getModel();
        List<Object> bairros = new BairroDAO().listar();
        List tipos = new TipoDePropriedadeDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[3];
        for (int a = 0; a < bairros.size(); a++) {
            
            int contadorDeTipos = 0;
            
            Bairro b = (Bairro) bairros.get(a);

            if (bairros.get(a) != null) {

                rowData[0] = b.getId();
                rowData[1] = b.getNome();
                for (int c = 0; c < tipos.size(); c++) {
                    TipoDePropriedade Tipo = (TipoDePropriedade) tipos.get(c);
                    if (Tipo.getBairro().equals(b.getNome())) {
                        contadorDeTipos++;
                    }
                }
                rowData[2] = contadorDeTipos;
                model2.addRow(rowData);
            }
        }
    }

    public void meteNaTabela2() {
        DefaultTableModel model2 = (DefaultTableModel) DeleteBairroOuTipo.jTabelaTipos.getModel();
        List tipos = new TipoDePropriedadeDAO().listar();
        List lista2 = new PropriedadesDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[4];
        for (int a = 0; a < tipos.size(); a++) {

            int contadorDeProps = 0;

            TipoDePropriedade b = (TipoDePropriedade) tipos.get(a);

            if (tipos.get(a) != null) {

                rowData[0] = b.getId();
                rowData[1] = b.getNome();
                rowData[2] = b.getBairro();
                for (int c = 0; c < lista2.size(); c++) {
                    Propriedades p = (Propriedades) lista2.get(c);
                    if (p.getTipo().equals(b.getNome())) {
                        contadorDeProps++;
                    }
                }
                rowData[3] = contadorDeProps;
                model2.addRow(rowData);
            }
        }
    }
}
