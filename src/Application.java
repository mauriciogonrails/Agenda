import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        new AgendaGUI(agenda);
    }
}

class AgendaGUI {
    private Agenda agenda;
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField removeIndexField;
    private JTextArea outputArea;

    public AgendaGUI(Agenda agenda) {
        this.agenda = agenda;

        frame = new JFrame("Agenda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Nome:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Telefone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String email = emailField.getText();
                String telefone = phoneField.getText();

                if (agenda.verificarTelefoneExistente(telefone)) {
                    JOptionPane.showMessageDialog(frame, "Telefone já existe na agenda!");
                } else {
                    agenda.adicionar(nome, email, telefone);
                    atualizarLista();
                }
            }
        });
        inputPanel.add(addButton);

        inputPanel.add(new JLabel("Índice para Remover:"));
        removeIndexField = new JTextField();
        inputPanel.add(removeIndexField);

        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(removeIndexField.getText());
                    agenda.remover(index);
                    atualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Índice inválido!");
                }
            }
        });
        inputPanel.add(removeButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private void atualizarLista() {
        outputArea.setText("");
        String[] contatos = agenda.listar();
        for (String contato : contatos) {
            if (contato != null) {
                outputArea.append(contato + "\n");
            }
        }
    }
}

class Agenda {
    private final String[][] contatos = new String[1][3];

    public void adicionar(String nome, String email, String telefone) {
        int indice = buscarNovoIndice();
        if (indice < 0 || indice >= contatos.length) {
            System.out.println("Agenda cheia");
            return;
        }
        contatos[indice][0] = nome;
        contatos[indice][1] = email;
        contatos[indice][2] = telefone;
        System.out.println("Novo contato adicionado com sucesso");
        System.out.println();
    }

    public boolean verificarTelefoneExistente(String telefone) {
        for (String[] contato : contatos) {
            if (contato[2] != null && contato[2].equals(telefone)) return true;
        }
        return false;
    }

    public void remover(int contato) {
        contato--;
        if (contato < 0 || contato >= contatos.length || contatos[contato][0] == null) {
            System.out.println("Índice fora dos limites do array ou não existe");
            return;
        }

        contatos[contato][0] = null;
        contatos[contato][1] = null;
        contatos[contato][2] = null;

        for (int i = contato; i < contatos.length - 1; i++) {
            if (contatos[i + 1][0] != null) {
                contatos[i][0] = contatos[i + 1][0];
                contatos[i][1] = contatos[i + 1][1];
                contatos[i][2] = contatos[i + 1][2];
                contatos[i + 1][0] = null;
                contatos[i + 1][1] = null;
                contatos[i + 1][2] = null;
            } else {
                break;
            }
        }
        System.out.println("Contato removido");
        System.out.println();
    }

    public String[] listar() {
        String[] lista = new String[contatos.length];
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null) {
                lista[i] = i + 1 + ": " + contatos[i][0] + " - " + contatos[i][1] + " - " + contatos[i][2];
            }
        }
        return lista;
    }

    private int buscarNovoIndice() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] == null) {
                return i;
            }
        }
        return -1;
    }
}