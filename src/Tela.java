import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela {
    Cachorro[] c = new Cachorro[4];
    boolean sistema = false;
    
    
    public boolean getSistema() {
        return sistema;
    }
    
    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }
    
    //
    JComboBox<String> comboCachorros;
    
    JTextField texto;
   
    public Tela() {
        c[0] = new Cachorro("ALFREDO");
        c[1] = new Cachorro("BOLINHA");
        c[2] = new Cachorro("SPIKE");
        c[3] = new Cachorro("CARALHINHO");
        JFrame tela = new JFrame("janela");
        tela.setSize(300,500);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tela.setLayout(null);
        
        String[] nomeCachorros = new String[c.length];

        for (int i = 0; i < c.length; i++) {
            nomeCachorros[i] = c[i].getNome(); // pegando nome dos vetores de cachorro
            
        }
        comboCachorros = new JComboBox<>(nomeCachorros);
        comboCachorros.setBounds(10, 10, 150, 30);
        tela.add(comboCachorros);

        JButton botao1 = new JButton("LATIR");
        botao1.setFont(new Font("Arial", Font.BOLD, 20));
        botao1.setBounds(10, 60, 150, 50);
        botao1.setForeground(new Color(255, 255, 255));
        botao1.setBackground(new Color(255, 0, 0));

        JButton botao2 = new JButton("ABANAR");
        botao2.setFont(new Font("Arial", Font.BOLD, 20));
        botao2.setBounds(10, 130, 150, 50);
        botao2.setForeground(new Color(255, 255, 255));
        botao2.setBackground(new Color(255, 0, 0));

        JButton botao3 = new JButton("ROSNAR");
        botao3.setFont(new Font("Arial", Font.BOLD, 20));
        botao3.setBounds(10, 200, 150, 50);
        botao3.setForeground(new Color(255, 255, 255));
        botao3.setBackground(new Color(255, 0, 0));

        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        
        botao1.addActionListener(this::botao1);
        botao2.addActionListener(this::botao2);
        botao3.addActionListener(this::botao3);
        
        
        // cammpo de txto que é possivel usar cmmo input
        texto = new JTextField();
        texto.setBounds(10, 290, 268, 70);
        texto.setFont(new Font("Arial", Font.BOLD, 22));
        tela.add(texto);
        
        //label de display
        JLabel label = new JLabel("DISPLAY DE COMANDOS");
        label.setBounds(10, 266, 200, 30);
        
        JLabel label2 = new JLabel("SELECIONE O ANIMAL");
        label2.setBounds(160, 8, 200, 30);
        
        tela.add(label);
        tela.add(label2);
        

        JCheckBox checkbox = new JCheckBox("ATIVAR SISTEMA");
        checkbox.setBounds(10, 400, 300, 40);
        checkbox.setSelected(false);
        tela.add(checkbox);

        checkbox.addActionListener(this::ativar);

        tela.setVisible(true);
    
        

    }

    // Função para pegar o cachorro selecionado no JComboBox
    private Cachorro getCachorroSelecionado() {
        int index = comboCachorros.getSelectedIndex();
        return c[index];
    }

    private void botao1(ActionEvent e) {
        if (this.getSistema() == true){

            Cachorro cachorroSelecionado = getCachorroSelecionado();
            //JOptionPane.showMessageDialog(null, cachorroSelecionado.getNome() + " LATINDO....", "title", JOptionPane.ERROR_MESSAGE);
            cachorroSelecionado.latir();
            texto.setText(cachorroSelecionado.getNome() + " LATINDO");
        }
        else {
            texto.setText("SISTEMA OFFLINE.");
        }
        
    }

    private void botao2(ActionEvent e) {
        if (this.getSistema() == true){

            Cachorro cachorroSelecionado = getCachorroSelecionado();
            //JOptionPane.showMessageDialog(null, cachorroSelecionado.getNome() + "   ABANDO:)!", "title", JOptionPane.WARNING_MESSAGE);
            cachorroSelecionado.abanar();
            texto.setText(cachorroSelecionado.getNome() + " ABANANDO");
        }
        else {
            texto.setText("SISTEMA OFFLINE.");
        }    
    }
        

    private void botao3(ActionEvent e) {
        if (this.getSistema() == true){
            Cachorro cachorroSelecionado = getCachorroSelecionado();
            //JOptionPane.showMessageDialog(null, cachorroSelecionado.getNome() + " ROSNANDO..!!!!!", "TITLE", JOptionPane.INFORMATION_MESSAGE);
            cachorroSelecionado.rosnar();
            texto.setText(cachorroSelecionado.getNome() + " ROSNANDO");

        }
        else {
            texto.setText("SISTEMA OFFLINE.");
        }
        
    }

    private void ativar(ActionEvent e) {
        if (this.getSistema() == false){
            this.setSistema(true);

        }
        else {
            this.setSistema(false);
        }
        System.out.println("SISTEMA : " + this.getSistema());
    }
    
}
