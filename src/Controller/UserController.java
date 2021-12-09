/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.TelaPrincipal;
import Model.DAO.UsuarioDAO;
import Model.Usuarios;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Edmilson Nhabinde
 */
public class UserController {

    public boolean recebeGestor(String nome, String apelido, String email, String senha, String senha2) {
        if (nome.isEmpty() || apelido.isEmpty() || email.isEmpty() || senha.isEmpty() || senha2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            return false;
        } else if (nome.equals(" Ex: Joao") || apelido.equals(" Ex: Metambo") || email.equals(" Ex: jmetambo@gmail.com")
                || senha.equals(" Ex: 123456") || senha2.equals(" Ex: 123456")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INSIRA VALORES VALIDOS");
            return false;
        } else if (!senha.equals(senha2)) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, CONFIRME A PALAVRA PASSE");
            return false;
        } else if (email.length() == 10 || !email.substring(email.length() - 10).equals("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR DIGITE UM EMAIL VALIDO");
            return false;
        } else {
            Usuarios user = new Usuarios();
            user.setApelido(apelido);
            user.setNome(nome);
            user.setEmail(email);
            user.setPerfil("admin");
            user.setSenha(senha);
            return new UsuarioDAO().adicionar(user);
        }
    }

    public boolean recebeUser(String nome, String apelido, String email, String perfil, String bi, String telefone) {
        if (nome.isEmpty() || apelido.isEmpty() || email.isEmpty() || bi.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            return false;
        } else if (nome.equals(" Ex: Joao") || apelido.equals(" Ex: Metambo") || email.equals(" Ex: jmetambo@gmail.com")
                || bi.equals(" Ex: 110101747696A") || telefone.equals(" Ex: 841234567")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INSIRA VALORES VALIDOS");
            return false;
        } else if (email.length() == 10 || !email.substring(email.length() - 10).equals("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR DIGITE UM EMAIL VALIDO");
            return false;
        } else {
            Usuarios user = new Usuarios();
            user.setApelido(apelido);
            user.setNome(nome);
            user.setEmail(email);
            user.setBi(bi);
            user.setTelefone(telefone);
            user.setPerfil("Trabalhador");
            return new UsuarioDAO().adicionar(user);
        }
    }

    public String login(String email, String password) {
        List lista = new UsuarioDAO().listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (user.getEmail().equals(email) & user.getCodUser().equals(password) || user.getSenha().equals(password)) {
                return email;
            }
        }
        return null;
    }

    public String Login(String email, String password) {
        List lista = new UsuarioDAO().listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (user.getEmail().equals(email) & user.getCodUser().equals(password)) {
                return user.getPerfil();
            } else if (user.getSenha().equals(password) || user.getEmail().equals(email)) {
                return user.getPerfil();
            }
        }
        return null;
    }

    public String[] dados() {
        List lista = new UsuarioDAO().listar();
        for (int a = 0; a < lista.size(); a++) {
            Usuarios user = (Usuarios) lista.get(a);
            if (user.getEmail().equals(TelaPrincipal.email)) {
                String[] dados = new String[4];
                dados[0] = user.getNome();
                dados[1] = user.getApelido();
                dados[2] = user.getEmail();
                dados[3] = user.getTelefone();
                return dados;
            }
        }
        return null;
    }

    public boolean update(String email, String telefone, String senha, String nova_senha, String ConfirmNovaSenha) {

        if (!senha.isEmpty()) {
            if (email.isEmpty() & telefone.isEmpty() & nova_senha.isEmpty() & ConfirmNovaSenha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PRIMEIRO IF");
                return false;
            } else if (email.length() == 10 || !email.substring(email.length() - 10).equals("@gmail.com")) {
                JOptionPane.showMessageDialog(null, "INSIRA UM EMAIL VALIDO");
                return false;
            } else if (!nova_senha.isEmpty() || !ConfirmNovaSenha.isEmpty()) {
                if (!nova_senha.equals(ConfirmNovaSenha)) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR CONFIRME A SENHA");
                    return false;
                } else if (nova_senha.length() < 8) {
                    JOptionPane.showMessageDialog(null, "A SENHA TEM QUE TER NO MINIMO 8 CARACTERES");
                    return false;
                }
            } else if (telefone.length() < 8 || !telefone.substring(0, 2).equals("82")
                    & !telefone.substring(0, 2).equals("83")
                    & !telefone.substring(0, 2).equals("84")
                    & !telefone.substring(0, 2).equals("85")
                    & !telefone.substring(0, 2).equals("86")
                    & !telefone.substring(0, 2).equals("87")) {
                JOptionPane.showMessageDialog(null, "DIGITE UM NUMERO DE TELEFONE VALIDO");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null,"POR FAVOR, DIGITE A SENHA ANTIGA OU O SEU ID");
            return false;
        }
        System.out.print(nova_senha);
        return new UsuarioDAO().actualizar(senha, email, telefone, nova_senha);

    }
}
