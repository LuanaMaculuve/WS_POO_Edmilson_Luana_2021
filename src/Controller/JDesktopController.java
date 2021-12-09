/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.DeleteBairroOuTipo;
import GUI.TelaAddProp;
import GUI.TelaAddTipoProp;
import GUI.TelaAddUser;
import GUI.TelaConfirmInquilino;
import GUI.TelaConta;
import GUI.TelaLista;
import GUI.TelaListaProps;
import GUI.TelaNovoInquilino;
import GUI.TelaPrincipal;
import static GUI.TelaPrincipal.perfil;
import GUI.TelaRelatorio;
import GUI.TelaSettings;
import static GUI.TelaSettings.t;
import Model.DAO.BairroDAO;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Edmilson Nhabinde
 */
public class JDesktopController {

    public void abreTelaNovoInquilinos() {
        TelaSettings.t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaNovoInquilino());
    }

    public void AbreTelaNovoInquilino2(String nome, String apelido, String bairro, String telefone, String BI, String tipo, String tempo) {
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.LONG);
        int preco = new TipoDePropriedadeController().preco(tipo);
        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaConfirmInquilino());
        TelaConfirmInquilino.Data.setText(formatador.format(data));
        TelaConfirmInquilino.NomeInq.setText(nome);
        TelaConfirmInquilino.NomeBairo.setText(bairro);
        TelaConfirmInquilino.NomeTipo.setText(tipo);
        TelaConfirmInquilino.tempo.setText(tempo + " meses");
        TelaConfirmInquilino.ValorMensal.setText(Integer.toString(preco) + ".00 MT");
        TelaConfirmInquilino.Valor_a_Pagar.setText(Integer.toString((Integer.parseInt(tempo)) * preco) + ".00 MT");
        TelaConfirmInquilino.telefone = telefone;
        TelaConfirmInquilino.bi = BI;
        TelaConfirmInquilino.apelido = apelido;
    }

    public void abreTelaAddProp() {
        TelaSettings.t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaAddProp());
    }

    public void abreTelaAddTipoProp() {
        t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaAddTipoProp());
    }

    public void abreTelaListaProos() {
        t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaListaProps());
    }

    public void abreTelaAddUser() {
        t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaAddUser());
    }

    public void abreTelaConta() {
        t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaConta());
    }

    public void abreTelaDeleteBairroOuTipo() {
        TelaSettings.t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new DeleteBairroOuTipo());
    }

    public void abreTelaLista() {
        TelaSettings.t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaLista());
    }

    public void abreTelaRelatorio() {
        TelaSettings.t.dispose();
        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaRelatorio());
    }

    public void abreTelaSettings() {
        TelaSettings.t.dispose();

        TelaPrincipal.jDesktopPane1.removeAll();
        TelaPrincipal.jDesktopPane1.add(new TelaSettings());
      if (!perfil.equals("admin")) {
            TelaSettings.jbDeleteBairro.setEnabled(false);
            TelaSettings.jbNovoBairro.setEnabled(false);
            TelaSettings.jbNovoUser.setEnabled(false);
            TelaSettings.jbNovoTipo.setEnabled(false);
            TelaSettings.ListPros.setEnabled(false);
        }
    }
}
