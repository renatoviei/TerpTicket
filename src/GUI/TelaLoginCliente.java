package GUI;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Fachada;

public class TelaLoginCliente extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaLogin = new JTextField(50);
	private JTextField caixaSenha = new JTextField(50);
	JButton botaoEntra = new JButton("Entrar");
	JButton botaoVolta = new JButton("Voltar");

	ImageIcon imagem = new ImageIcon(getClass().getResource("Logins.png"));
	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoEntra) {
			Fachada fachada = Fachada.getInstance();
			if (fachada.loginCliente(caixaLogin.getText(), caixaSenha.getText()) == true) {
				TelaEspacoCliente espaco = new TelaEspacoCliente();
				espaco.setResizable(false);
				espaco.setLocationRelativeTo(null);
				espaco.setVisible(true);
				janela.dispose();
				espaco.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "LOGIN NÃO REALIZADO. CONTA NAO EXISTE!");
			}

		} else {
			TelaL1 telaL1 = new TelaL1();
			telaL1.setResizable(false);
			telaL1.setLocationRelativeTo(null);
			telaL1.setVisible(true);
			janela.dispose();
			telaL1.dispose();
		}

	}

	public TelaLoginCliente() {

		botaoEntra.addActionListener(this);
		botaoVolta.addActionListener(this);

		janela = new JFrame("TerpTickets");
		janela.setSize(500, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

		JPanel painelPrincipal = new JPanel();

		janela.add(painelPrincipal);

		painelPrincipal.setLayout(null);

		Font grande = new Font("Serif", Font.BOLD, 16);

		JLabel login = new JLabel("Digite seu login: ");
		login.setFont(grande);
		login.setBounds(new Rectangle(20, 50, 120, 17));
		painelPrincipal.add(login);

		caixaLogin.setBounds(new Rectangle(150, 50, 120, 17));
		painelPrincipal.add(caixaLogin);

		JLabel senha = new JLabel("Digite sua senha: ");
		senha.setFont(grande);
		senha.setBounds(new Rectangle(20, 100, 120, 17));
		painelPrincipal.add(senha);

		caixaSenha.setBounds(new Rectangle(150, 100, 120, 17));
		painelPrincipal.add(caixaSenha);

		label.setBounds(0, -13, 500, 400);
		botaoEntra.setBounds(150, 300, 100, 20);
		botaoVolta.setBounds(250, 300, 80, 20);
		painelPrincipal.add(botaoEntra);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaLoginCliente();
	}

}
