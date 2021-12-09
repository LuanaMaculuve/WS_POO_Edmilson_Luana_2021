/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Language;

import Controller.*;
import GUI.*;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Edmilson Nhabinde
 */
public class Controlllanguage {

    public static String lingua;

    public void trocaLingua() {
        if (Controlllanguage.lingua.equals("Portugues")) {
            Controlllanguage.lingua = "Ingles";
            try {
                MeteLingua();
                this.linguaTelaSettings();
                this.linguaTelPrincipal();
            } catch (IOException ex) {
                Logger.getLogger(TelaSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Controlllanguage.lingua = "Portugues";
            try {
                MeteLingua();
                this.linguaTelaSettings();
                this.linguaTelPrincipal();
            } catch (IOException ex) {
                Logger.getLogger(TelaSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void MeteLingua() throws IOException {
        FileWriter f = new FileWriter("C:\\LinguaControl.txt");
        BufferedWriter bfw = new BufferedWriter(f);

        if (lingua.equals("Portugues")) {
            bfw.write("Portugues");
        } else {
            bfw.write("Ingles");
        }
        bfw.close();
        f.close();
    }

    public void Tiralingua() throws IOException {
        FileReader f1 = new FileReader("C:\\LinguaControl.txt");
        BufferedReader bfr = new BufferedReader(f1);

        try {
            lingua = bfr.readLine();

            bfr.close();
            f1.close();
        } catch (IOException ex) {

        }
    }

    public void liguaRelatorio() {
        if (lingua.equals("Portugues")) {
            PagamentosController.PagamentosColunas[0] = "ID";
            PagamentosController.PagamentosColunas[1] = "Nome";
            PagamentosController.PagamentosColunas[2] = "Barrro";
            PagamentosController.PagamentosColunas[3] = "Tipo";
            PagamentosController.PagamentosColunas[4] = "Tempo";
            PagamentosController.PagamentosColunas[5] = "Valor Pago";
            PagamentosController.PagamentosColunas[6] = "Data";

            TelaRelatorio.lblPesquisar.setText("Pesquisar");
            TelaRelatorio.jbImprime.setText("Imprimir");
            TelaRelatorio.lblPropDisponiveis.setText("Propriedades disponivies:");
            TelaRelatorio.lblPropOcupadas.setText("Propriedades ocupadas:");
            TelaRelatorio.lblTakoFlats.setText("Dinheiro recebido Flats:");
            TelaRelatorio.lblTakoOutras.setText("Diheiro recebidos Outras Propriedades:");
            TelaRelatorio.lblTakoViv.setText("Dinheiro recebido Vivendas:");
            TelaRelatorio.lblTakpRecebido.setText("Dinheiro recebido:");
        } else {
            
            

            PagamentosController.PagamentosColunas[0] = "ID";
            PagamentosController.PagamentosColunas[1] = "Name";
            PagamentosController.PagamentosColunas[2] = "District";
            PagamentosController.PagamentosColunas[3] = "Type";
            PagamentosController.PagamentosColunas[4] = "Time";
            PagamentosController.PagamentosColunas[5] = "Paid value";
            PagamentosController.PagamentosColunas[6] = "Date";

            TelaRelatorio.lblPesquisar.setText("Search");
            TelaRelatorio.jbImprime.setText("Print out");
            TelaRelatorio.lblPropDisponiveis.setText("Available Properties:");
            TelaRelatorio.lblPropOcupadas.setText("Occupied Properties:");
            TelaRelatorio.lblTakoFlats.setText("Amount Received Flats:");
            TelaRelatorio.lblTakoOutras.setText("Amount Received Others Properties:");
            TelaRelatorio.lblTakoViv.setText("Amount Received Villas:");
            TelaRelatorio.lblTakpRecebido.setText("Amount Received:");
        }
    }

    public void linguaListaProps() {
        if (lingua.equals("Portugues")) {
            PropriedadesController.propsColunas[0] = "ID";
            PropriedadesController.propsColunas[1] = "Bairro";
            PropriedadesController.propsColunas[2] = "Tipo";
            PropriedadesController.propsColunas[3] = "Estado";
            PropriedadesController.propsColunas[4] = "Inquilino";
            PropriedadesController.propsColunas[5] = "Tempo";

            TelaListaProps.lblPesquisar.setText("Pesquisar");
            TelaListaProps.voltar.setText("Voltar");
        } else {
            PropriedadesController.propsColunas[0] = "ID";
            PropriedadesController.propsColunas[1] = "District";
            PropriedadesController.propsColunas[2] = "Type of Property";
            PropriedadesController.propsColunas[3] = "State";
            PropriedadesController.propsColunas[4] = "Renter";
            PropriedadesController.propsColunas[5] = "Time";

            TelaListaProps.lblPesquisar.setText("Search");
            TelaListaProps.voltar.setText("Back");
        }
    }

    public void linguaDeleteBairroOutipo() {
        if (lingua.equals("Portugues")) {
            BairroController.BairroColunas[0] = BairroController.TipoColunas[0] = "ID";
            BairroController.BairroColunas[1] = "Nome";
            BairroController.BairroColunas[2] = "Num. Tipos de Propriedades";
            BairroController.TipoColunas[1] = "Nome";
            BairroController.TipoColunas[2] = "Bairro";
            BairroController.TipoColunas[3] = "Num. Propriedades";

            DeleteBairroOuTipo.lblPesquisar.setText("Pesquisar  (Bairro/Tipo de Prop):");
            DeleteBairroOuTipo.lblNome.setText("Nome:");
            DeleteBairroOuTipo.lblBairros.setText("Bairros");
            DeleteBairroOuTipo.lblTipoimoveis.setText("Tipo de Imoveis");
            DeleteBairroOuTipo.jbVoltar.setText("VOLTAR");
        } else {
            BairroController.BairroColunas[0] = BairroController.TipoColunas[0] = "ID";
            BairroController.BairroColunas[1] = "Name";
            BairroController.BairroColunas[2] = "Num. Types of Properties";
            BairroController.TipoColunas[1] = "Name";
            BairroController.TipoColunas[2] = "District";
            BairroController.TipoColunas[3] = "Num. Properties";

            DeleteBairroOuTipo.lblPesquisar.setText("Search (District/ immobile):");
            DeleteBairroOuTipo.lblNome.setText("Name:");
            DeleteBairroOuTipo.lblBairros.setText("Districts");
            DeleteBairroOuTipo.lblTipoimoveis.setText("Immobile  Type");
            DeleteBairroOuTipo.jbVoltar.setText("BACK");
        }
    }

    public void linguaAddProp() {
        if (lingua.equals("Portugues")) {
            TelaAddProp.lblBairro.setText("Bairro");
            TelaAddProp.lblTipo.setText("Tipo");
            TelaAddProp.lblQuantidade.setText("Quantidade");
            TelaAddProp.lblNovasPropriedades.setText("NOVAS PROPRIEDADES");
            TelaAddProp.jbCancel.setText("Cancelar");
            TelaAddProp.jbContinuar.setText("continuar");
        } else {
            TelaAddProp.lblBairro.setText("District");
            TelaAddProp.lblTipo.setText("Type of Properties");
            TelaAddProp.lblQuantidade.setText("Amount");
            TelaAddProp.lblNovasPropriedades.setText("NEW PROPERTIES");
            TelaAddProp.jbCancel.setText("Cancel");
            TelaAddProp.jbContinuar.setText("continue");
        }
    }

    public void linguaAddTipoProp() {
        if (lingua.equals("Portugues")) {
            //     TelaAddTipoProp.lblNovoTipo.setText("NOVO TIPO DE PROPRIEDADE");
            TelaAddTipoProp.lblNome.setText("Nome");
            TelaAddTipoProp.lblBairro.setText("Bairro");
            TelaAddTipoProp.jLabel2.setText("NB: Tem que selecionar a categoria do tipo de imovel que esta a ser adicionado, no caso de residencia");
            TelaAddTipoProp.jLabel3.setText("tem que escolher o tipo de residencia");
            TelaAddTipoProp.jrbResidencia.setText("Residencia");
            TelaAddTipoProp.jrbOutro.setText("Outro");
            TelaAddTipoProp.jrbFlat.setText("Flat");
            TelaAddTipoProp.jrbVivenda.setText("Vivenda");
            TelaAddTipoProp.lblNumQuartos.setText("Num. de quartos");
            TelaAddTipoProp.lblRenda.setText("Valor da Renda");
            TelaAddTipoProp.jbContinuar.setText("Continuar");
            TelaAddTipoProp.jbCancel.setText("Cancelar");
        } else {
            //  TelaAddTipoProp.lblNovoTipo.setText("NEW PROPERTY TYPE");
            TelaAddTipoProp.lblNome.setText("Name");
            TelaAddTipoProp.lblBairro.setText("District");
            TelaAddTipoProp.jLabel2.setText("PS: You have to select the category of the type of property that is to be added, in the case of residence");
            TelaAddTipoProp.jLabel3.setText("you have to choose the type of residence");
            TelaAddTipoProp.jrbResidencia.setText("Residence");
            TelaAddTipoProp.jrbOutro.setText("Another");
            TelaAddTipoProp.jrbFlat.setText("Flat");
            TelaAddTipoProp.jrbVivenda.setText("Villa");
            TelaAddTipoProp.lblNumQuartos.setText("Num. of bedrooms");
            TelaAddTipoProp.lblRenda.setText("Income amount");
            TelaAddTipoProp.jbContinuar.setText("Continue");
            TelaAddTipoProp.jbCancel.setText("Cancel");
        }
    }

    public void linguaTelaUser() {
        if (lingua.equals("Portugues")) {
            TelaAddUser.jLabel2.setText("NOVO USUARIO");
            TelaAddUser.lblNome.setText("Nome");
            TelaAddUser.lblApelido.setText("Apelido");
            TelaAddUser.lblUser.setText("Email");
            TelaAddUser.lblBI.setText("B.I.");
            TelaAddUser.lblTelefone.setText("Telefone");
            TelaAddUser.jbContinuar.setText("Continuar");
            TelaAddUser.jbCancel.setText("Cancel");
        } else {
            TelaAddUser.jLabel2.setText("NEW USER");
            TelaAddUser.lblNome.setText("Name");
            TelaAddUser.lblApelido.setText("Surname");
            TelaAddUser.lblUser.setText("Email");
            TelaAddUser.lblBI.setText("I.D..");
            TelaAddUser.lblTelefone.setText("Phone");
            TelaAddUser.jbContinuar.setText("Continue");
            TelaAddUser.jbCancel.setText("Cancel");
        }
    }

    public void linguaBairro() {
        if (lingua.equals("Portugues")) {
            TelaBairro.lblNovoBairro.setText("NOVO BAIRRO");
            TelaBairro.jbCancel.setText("Cancelar");
            TelaBairro.jbSave.setText("Salvar");
        } else {
            TelaBairro.lblNovoBairro.setText("NEW DISTRICT");
            TelaBairro.jbCancel.setText("Cancel");
            TelaBairro.jbSave.setText("Save");
        }
    }

    public void linguaTelaConta() {
        if (lingua.equals("Portugues")) {
            TelaConta.lblMinhaConta.setText("MINHA CONTA");
            TelaConta.lblNome.setText("NOME");
            TelaConta.lblApelido.setText("APELIDO");
            TelaConta.lblNomeUser.setText("EMAIL");
            TelaConta.lblTelefone.setText("TELEFONE");
            TelaConta.lblSenha.setText("SENHA/ID");
            TelaConta.lblNovaSenha.setText("NOVA SENHA");
            TelaConta.lblConfirmNovaSenha.setText("CONFIRME NOVA SENHA");
            TelaConta.jbCancel.setText("Cancelar");
            TelaConta.jbSave.setText("Salvar");
        } else {
            TelaConta.lblMinhaConta.setText("MY ACCOUNT");
            TelaConta.lblNome.setText("NAME");
            TelaConta.lblApelido.setText("SUARNAME");
            TelaConta.lblNomeUser.setText("EMAIL");
            TelaConta.lblTelefone.setText("PHONE");
            TelaConta.lblSenha.setText("PASSWORD/ID");
            TelaConta.lblNovaSenha.setText("NEW PASSWORD");
            TelaConta.lblConfirmNovaSenha.setText("CONFIRM NEW PASSWORD");
            TelaConta.jbCancel.setText("Cancel");
            TelaConta.jbSave.setText("Save");
        }
    }

    public void linguaTelaLista() {
        if (lingua.equals("Portugues")) {
            InquilinoController.InquilinosColunas[0] = "ID";
            InquilinoController.InquilinosColunas[1] = "Nome";
            InquilinoController.InquilinosColunas[2] = "Apelido";
            InquilinoController.InquilinosColunas[3] = "Tipo";
            InquilinoController.InquilinosColunas[4] = "Bairro";
            InquilinoController.InquilinosColunas[5] = "Contacto";
            InquilinoController.InquilinosColunas[6] = "B.I.";
            InquilinoController.InquilinosColunas[7] = "Tempo (meses)";

            TelaLista.lblNome.setText("Nome");
            TelaLista.lblApelido.setText("Apelido");
            TelaLista.lblTelefone.setText("Telefone");
            TelaLista.lblPesq.setText("Pesquisar");
            TelaLista.jbDelete.setText("ELIMINAR");
            TelaLista.jbImprimir.setText("IMPRIMIR");
            TelaLista.jbCancel.setText("CANCELAR");
            TelaLista.jbSave.setText("SALVAR");
        } else {
            InquilinoController.InquilinosColunas[0] = "ID";
            InquilinoController.InquilinosColunas[1] = "Name";
            InquilinoController.InquilinosColunas[2] = "Surname";
            InquilinoController.InquilinosColunas[3] = "Type";
            InquilinoController.InquilinosColunas[4] = "District";
            InquilinoController.InquilinosColunas[5] = "Contact";
            InquilinoController.InquilinosColunas[6] = "I.Document";
            InquilinoController.InquilinosColunas[7] = "Time (months)";

            TelaLista.lblNome.setText("Name");
            TelaLista.lblApelido.setText("Surname");
            TelaLista.lblTelefone.setText("Phone");
            TelaLista.lblPesq.setText("Search");
            TelaLista.jbDelete.setText("DELETE");
            TelaLista.jbImprimir.setText("PRINT OUT");
            TelaLista.jbCancel.setText("CANCEL");
            TelaLista.jbSave.setText("SAVE");
        }
    }

    public void linguaTelLogin() {
        if (lingua.equals("Portugues")) {
            TelaLogin.lblSenha.setText("Senha");
            TelaLogin.lblUser.setText("Usuario");
            TelaLogin.jbEntrar.setText("Entrar");
            TelaLogin.lblEsqueceuSenha.setText("Esqueceu a senha?");
        } else {
            TelaLogin.lblSenha.setText("Password");
            TelaLogin.lblUser.setText("Username");
            TelaLogin.jbEntrar.setText("LogIn ");
            TelaLogin.lblEsqueceuSenha.setText("Forgot password?");
        }
    }

    public void linguaNovoInq() {
        if (lingua.equals("Portugues")) {
            TelaNovoInquilino.lblNovoInq.setText("NOVO INQUILINO");
            TelaNovoInquilino.lblApelido.setText("Apelido");
            TelaNovoInquilino.lblNome.setText("Nome");
            TelaNovoInquilino.lblBairro.setText("Bairro");
            TelaNovoInquilino.lblTelefone.setText("Telefone");
            TelaNovoInquilino.lblBI.setText("B.I.");
            TelaNovoInquilino.lblTipo.setText("Tipo");
            TelaNovoInquilino.lblTempo.setText("Tempo (meses)");
            TelaNovoInquilino.jbCancel.setText("Cancelar");
            TelaNovoInquilino.jbSave.setText("Continuar");
        } else {
            TelaNovoInquilino.lblNovoInq.setText("NEW RENTER");
            TelaNovoInquilino.lblApelido.setText("Surname");
            TelaNovoInquilino.lblNome.setText("Name");
            TelaNovoInquilino.lblBairro.setText("District");
            TelaNovoInquilino.lblTelefone.setText("Phone");
            TelaNovoInquilino.lblBI.setText("I.D.");
            TelaNovoInquilino.lblTipo.setText("Type");
            TelaNovoInquilino.lblTempo.setText("Time (months)");
            TelaNovoInquilino.jbCancel.setText("Cancel");
            TelaNovoInquilino.jbSave.setText("Continue");
        }
    }

    public void linguaTelPrincipal() {
        if (lingua.equals("Portugues")) {
            TelaPrincipal.jbNovoInq.setText("Novo");
            TelaPrincipal.jbLista.setText("Lista");
            TelaPrincipal.jbRelatorio.setText("Relatorio");
            TelaPrincipal.jbSettings.setText("Definicoes");
            TelaPrincipal.jButton5.setText("Sair");
        } else {
            TelaPrincipal.jbNovoInq.setText("New");
            TelaPrincipal.jbLista.setText("List");
            TelaPrincipal.jbRelatorio.setText("Report");
            TelaPrincipal.jbSettings.setText("Settings");
            TelaPrincipal.jButton5.setText("LogOut");
        }
    }

    public void linguaTelaSettings() {
        if (lingua.equals("Portugues")) {
            TelaSettings.jbNovoBairro.setText(" NOVO BAIRRO");
            TelaSettings.jbDeleteBairro.setText("    BAIRRO/TIPO");
            TelaSettings.jbNovoUser.setText("NOVO USUARIO");
            TelaSettings.jbNovoTipo.setText("      NOVO TIPO");
            TelaSettings.jbMinhaConta.setText(" MINHA CONTA");
            TelaSettings.jbTrocarLingua.setText("CHANGE LANGUAGE");
            TelaSettings.ListPros.setText("LISTAR PROPRIEDADES");
            TelaSettings.jbSobre.setText("SOBRE");
            TelaSettings.lblSettings.setText("DEFINICOES");
        } else {
            TelaSettings.jbNovoBairro.setText("NEW DISTRICT");
            TelaSettings.jbDeleteBairro.setText("DISTRICT/TYPE");
            TelaSettings.jbNovoUser.setText("         NEW USER");
            TelaSettings.jbNovoTipo.setText("        NEW TYPE");
            TelaSettings.jbMinhaConta.setText("   MY ACCOUNT");
            TelaSettings.jbTrocarLingua.setText("TROCAR IDIOMA");
            TelaSettings.ListPros.setText("LIST PROPERTIES");
            TelaSettings.jbSobre.setText("ABOUT");
            TelaSettings.lblSettings.setText("SETTINGS");

        }
    }

    public void lingaTelaWellcome() {
        if (lingua.equals("Portugues")) {
            TelaWellcome.lbl1.setText("Seja bem vindo ao Sistema");
            TelaWellcome.lbl2.setText("de Arrendamento Imobiliario");
            TelaWellcome.lblContinuar.setText("Continuar");
        } else {
            TelaWellcome.lbl1.setText("Welcome to the System");
            TelaWellcome.lbl2.setText("of Real Estate Lease");
            TelaWellcome.lblContinuar.setText("Continue");
        }
    }
}
