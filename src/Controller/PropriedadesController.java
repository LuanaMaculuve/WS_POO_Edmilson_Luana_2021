/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.TelaListaProps;
import static GUI.TelaListaProps.TabelaProps;
import Model.DAO.InquilinoDAO;
import Model.DAO.PropriedadesDAO;
import Model.Inquilino;
import Model.Propriedades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edmilson Nhabinde
 */
public class PropriedadesController {

    public static String[] propsColunas = new String[6];

    public boolean recebeProp(String bairro, String tipo, String quantidade, String password) {
        Propriedades p = new Propriedades();

        p.setBairro(bairro);
        p.setTipo(tipo);
        int qtd = Integer.parseInt(quantidade);

        new PropriedadesDAO().recebe(bairro, tipo, qtd);
        return true;
    }

    /**
     * procura verificar na lista de propriedades se existem propriedades do
     * tipo escolhido e se estao disponiveis
     *
     * @param tipo
     * @return
     */
    public ArrayList<Propriedades> lista(){
       return null; 
    }
    
    public boolean verifyProps(String tipo) {
        List lista = new PropriedadesDAO().listar();

        for (int a = 0; a < lista.size(); a++) {
            Propriedades p = (Propriedades) lista.get(a);
            if (p.getTipo().equals(tipo) & p.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public void meteNaTabela() {
        DefaultTableModel model2 = (DefaultTableModel) TelaListaProps.TabelaProps.getModel();
        List<Object> lista = new PropriedadesDAO().listar();
        List<Object> listaInq = new InquilinoDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[6];
        for (int a = 0; a < lista.size(); a++) {
            Propriedades b = (Propriedades) lista.get(a);
            if (b != null) {
                rowData[0] = b.getCodigo();
                rowData[1] = b.getBairro();
                rowData[2] = b.getTipo();
                if (b.isDisponivel()) {
                    rowData[3] = "DISPONIVEL";
                    rowData[4] = "    ---";
                    rowData[5] = "    ---";
                } else {
                    rowData[3] = "OCUPADO";
                    for (int c = 0; c < listaInq.size(); c++) {
                        Inquilino inq = (Inquilino) listaInq.get(c);
                        if (inq.getCodProp().equals(Integer.toString(b.getCodigo()))) {
                            rowData[4]=inq.getNome();
                            rowData[5]=inq.getTempo();
                        }
                    }
                }
                model2.addRow(rowData);
            }
        }
    }

    public void personalizeTable() {

        DefaultTableModel model;
        model = new DefaultTableModel();

        model.setColumnIdentifiers(propsColunas);
        TabelaProps.setModel(model);
        TabelaProps.setDefaultEditor(Object.class, null);
        TabelaProps.setRowHeight(30);
        TabelaProps.setFocusable(false);
        meteNaTabela();
    }
}
