/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.TelaRelatorio;
import Model.DAO.PagamentosDAO;
import Model.DAO.PropriedadesDAO;
import Model.Pagamentos;
import Model.Propriedades;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Edmilson Nhabinde
 */
public class PagamentosController {

    public static String[] PagamentosColunas = new String[7];
    Connection conexao = null;

    public PagamentosController() {
        conexao = ModuloConexao.conector();
    }

    public void personalizeTable() {

        DefaultTableModel model;
        model = new DefaultTableModel();

        model.setColumnIdentifiers(PagamentosColunas);
        TelaRelatorio.TablelaPaga.setModel(model);
        TelaRelatorio.TablelaPaga.setDefaultEditor(Object.class, null);
        TelaRelatorio.TablelaPaga.setRowHeight(30);
        TelaRelatorio.TablelaPaga.setFocusable(false);
        TelaRelatorio.TablelaPaga.setFont(new Font("serif", Font.PLAIN, 18));

        meteNaTabela();
    }

    public void meteNaTabela() {
        DefaultTableModel model2 = (DefaultTableModel) TelaRelatorio.TablelaPaga.getModel();
        List<Pagamentos> pagamentos = new PagamentosDAO().listar();

        // Buscando dados no array de Inquilinos
        Object rowData[] = new Object[7];
        for (int a = 0; a < pagamentos.size(); a++) {

            rowData[0] = pagamentos.get(a).getId();
            rowData[1] = pagamentos.get(a).getNome();
            rowData[2] = pagamentos.get(a).getBairro();
            rowData[3] = pagamentos.get(a).getTipo();
            rowData[4] = pagamentos.get(a).getTempo();
            rowData[5] = pagamentos.get(a).getTako();
            rowData[6] = pagamentos.get(a).getData();

            model2.addRow(rowData);
        }
        fazEstatistica();
    }

    public void fazEstatistica() {
        List<Pagamentos> pagamentos = new PagamentosDAO().listar();

        int flats = 0, vivendas = 0, outros = 0;
        for (int a = 0; a < pagamentos.size(); a++) {

            if (pagamentos.get(a).getTipo_de_casa() != null) {
                switch (pagamentos.get(a).getTipo_de_casa()) {
                    /**
                     * para dar valores aos atributos da classe pagamentos, eu
                     * carrego directamente o texto das labels da
                     * telaConfirmInquilino. La por exemplo o alor pago vem com
                     * mais 6 letras/caracteres acrescentados por questoes de
                     * estetica, sendo assim, na hora dos calculos aqui eu tenho
                     * que remove-las
                     */
                    case "Flat":
                        flats += Integer.parseInt(pagamentos.get(a).getTako().substring(0, pagamentos.get(a).getTako().length() - 6));
                        break;
                    case "Vivenda":
                        vivendas += Integer.parseInt(pagamentos.get(a).getTako().substring(0, pagamentos.get(a).getTako().length() - 6));
                        break;
                }
            } else {
                outros += Integer.parseInt(pagamentos.get(a).getTako().substring(0, pagamentos.get(a).getTako().length() - 6));
            }

        }

        TelaRelatorio.DinheiroDeFlats.setText(Integer.toString(flats) + ".00 MT");
        TelaRelatorio.DinheiroDeVivendas.setText(Integer.toString(vivendas) + ".00 MT");
        TelaRelatorio.DinheiroOutras.setText(Integer.toString(outros) + ".00 MT");
        TelaRelatorio.DinheiroTotal.setText(Integer.toString(flats + vivendas + outros) + ".00 MT");

        List<Object> lista = new PropriedadesDAO().listar();
        int ocupadas = 0, disponiveis = 0;

        for (int a = 0; a < lista.size(); a++) {
            Propriedades b = (Propriedades) lista.get(a);
            if (b.isDisponivel()) {
                disponiveis++;
            } else {
                ocupadas++;
            }
        }

        TelaRelatorio.PropsDisponivesi.setText(Integer.toString(disponiveis));
        TelaRelatorio.PropsOcupadas.setText(Integer.toString(ocupadas));
    }

    public void iReport() {

        try {
            JasperPrint print = JasperFillManager.fillReport("C:/Reports/Pagamentos.jasper", null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
        }
    }
}
