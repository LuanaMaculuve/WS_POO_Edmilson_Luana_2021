/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.TelaLista;
import static GUI.TelaLista.TablelaCli;
import Model.DAO.InquilinoDAO;
import Model.Inquilino;
import java.awt.Font;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Edmilson Nhabinde
 */
public class InquilinoController {

    public static String[] InquilinosColunas = new String[8];

    Connection conexao = null;

    public InquilinoController() {
        conexao = ModuloConexao.conector();
    }

    public boolean controlInquilino(String nome, String apelido, String bairro, String telefone, String BI, String tipo, String tempo, String cod) {

        if (nome.equals(" Ex: Joao") || apelido.equals(" Ex: Metambo") || telefone.equals(" Ex: 840000000")
                || BI.equals(" Ex: 110101747696A")) {
            return false;
        } else {
            Inquilino q = new Inquilino();
            q.setNome(nome);
            q.setApelido(apelido);
            q.setBairro(bairro);
            q.setTelefone(telefone);
            q.setBi(BI);
            q.setTipo(tipo);
            q.setTempo(tempo);
            q.setCodProp(cod);
            q.setVisible(true);
            return new InquilinoDAO().adicionar(q);
        }

    }

    public void updateInq(int id, String nome, String apelido, String telefone) {
        if (new InquilinoDAO().Update(id, nome, apelido, telefone)) {
            personalizeTable();
        }
    }

    public void eliminarInq(int id) {
        if (new InquilinoDAO().logicDelete(id)) {
            personalizeTable();
        }
    }

    public void meteNaTabela() {
        DefaultTableModel model2 = (DefaultTableModel) TelaLista.TablelaCli.getModel();
        List<Object> lista = new InquilinoDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[8];
        for (int a = 0; a < lista.size(); a++) {
            Inquilino b = (Inquilino) lista.get(a);

            if (b != null & b.isVisible()) {
                rowData[0] = b.getId();
                rowData[1] = b.getNome();
                rowData[2] = b.getApelido();
                rowData[3] = b.getTipo();
                rowData[4] = b.getBairro();
                rowData[5] = b.getTelefone();
                rowData[6] = b.getBi();
                rowData[7] = b.getTempo();

                model2.addRow(rowData);
            }
        }
    }

    public void personalizeTable() {

        DefaultTableModel model;
        model = new DefaultTableModel();

        model.setColumnIdentifiers(InquilinosColunas);
        TablelaCli.setModel(model);
        TablelaCli.setDefaultEditor(Object.class, null);
        TablelaCli.setRowHeight(30);
        TablelaCli.setFocusable(false);
        TablelaCli.setFont(new Font("serif", Font.PLAIN, 18));
        meteNaTabela();
    }

    public void iReport() {
        try {
            JasperPrint print = JasperFillManager.fillReport("C:/Reports/Inquilinos.jasper", null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
        }
    }
}
