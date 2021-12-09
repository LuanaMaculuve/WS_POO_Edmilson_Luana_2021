/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.BairroController.TipoColunas;
import GUI.DeleteBairroOuTipo;
import static GUI.DeleteBairroOuTipo.jTabelaTipos;
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
public class TipoDePropriedadeController {

    /**
     * Recebe os dados dos textFields, combobox e dos radioButtons (true or
     * false) depois faz as verificacoes necessarias para que um novo tipo de
     * prop seja criado
     *
     * @param nome
     * @param bairro
     * @param residencia
     * @param outro
     * @param flat
     * @param vivenda
     * @param quartos
     * @param renda
     * @return
     */
    public boolean recebeTipo(String nome, String bairro, boolean residencia, boolean outro, boolean flat, boolean vivenda, String quartos, String renda) {
        if (nome.equals(" Ex: Joao") || renda.equals(" Ex: 5000")) {
            return false;
        } else {
            TipoDePropriedade novoTipo = new TipoDePropriedade();

            novoTipo.setBairro(bairro);
            novoTipo.setNome(nome);
            novoTipo.setJa_tem_casas(false);
            if (residencia) {
                if (quartos.equals(" Ex: 2")) {
                    return false;
                }
                novoTipo.setTipo_da_prop("Residencia");
                novoTipo.setQuartos(Integer.parseInt(quartos));
            }
            if (outro) {
                novoTipo.setTipo_da_prop("Outro");
            }
            if (flat) {
                novoTipo.setTipo_de_casa("Flat");
            }
            if (vivenda) {
                novoTipo.setTipo_de_casa("Vivenda");
            }
            novoTipo.setPreco(Integer.parseInt(renda));

            return new TipoDePropriedadeDAO().adicionar(novoTipo);
        }
    }

    /**
     * recebe o nome do tipo de propriedade que se deseja arrendar, procura o na
     * liata e depois de acha-lo retorna o valor da renda do mesmo
     *
     * @param tipo
     * @return
     */
    public int preco(String tipo) {
        List lista = new TipoDePropriedadeDAO().listar();

        for (int a = 0; a < lista.size(); a++) {
            TipoDePropriedade t = (TipoDePropriedade) lista.get(a);
            if (t.getNome().equals(tipo)) {
                return t.getPreco();
            }
        }
        return 0;
    }

    public void meteNaTabela() {
        DefaultTableModel model2 = (DefaultTableModel) DeleteBairroOuTipo.jTabelaTipos.getModel();
        List tipos = new TipoDePropriedadeDAO().listar();
        List lista2 = new PropriedadesDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[3];
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
                    rowData[3] = contadorDeProps;
                }
                model2.addRow(rowData);
            }
        }
    }

    public void personalizeTable() {

        DefaultTableModel model2;
        model2 = new DefaultTableModel();

        model2.setColumnIdentifiers(TipoColunas);
        jTabelaTipos.setModel(model2);
        jTabelaTipos.setDefaultEditor(Object.class, null);
        jTabelaTipos.setRowHeight(30);
        jTabelaTipos.setFocusable(false);
        jTabelaTipos.setFont(new Font("serif", Font.PLAIN, 18));
        meteNaTabela();
    }
}
