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

import beans.Administrador;
import negocio.Fachada;

public class TelaCadastroAdm extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaNome = new JTextField(50);
	private JTextField caixaIdade = new JTextField(50);
	private JTextField caixaEmail = new JTextField(50);
	private JTextField caixaLogin = new JTextField(50);
	private JTextField caixaSenha = new JTextField(50);

	JButton botaoConfirma = new JButton("Confirmar");
	JButton botaoVolta = new JButton("Voltar");

	ImageIcon imagem = new ImageIcon(getClass().getResource("Cadastros_Busca.png"));

	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoConfirma) {
			if (caixaNome.getText().equals("") || caixaIdade.getText().equals("") || caixaEmail.getText().equals("")
					|| caixaLogin.getText().equals("") || caixaSenha.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} else {
				int i = Integer.parseInt(caixaIdade.getText());
				if(i < 18){
					JOptionPane.showMessageDialog(null, "Desculpe, você é de menor, não pode se cadastrar");
				}else{
				Administrador adm = new Administrador(caixaNome.getText(), caixaEmail.getText(), caixaLogin.getText(),
						caixaSenha.getText(), i);
				Fachada fachada = Fachada.getInstance();
				fachada.cadastarAdm(adm);

				JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso");

				TelaMenuInicial menuInicial = new TelaMenuInicial();
				menuInicial.setResizable(false);
				menuInicial.setLocationRelativeTo(null);
				menuInicial.setVisible(true);
				janela.dispose();
				}
			}
		} else {
			TelaC1 telaC1 = new TelaC1();
			telaC1.setResizable(false);
			telaC1.setLocationRelativeTo(null);
			telaC1.setVisible(true);
			janela.dispose();
		}

	}

	public TelaCadastroAdm() {

		botaoConfirma.addActionListener(this);
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

		JLabel nome = new JLabel("Digite seu nome: ");
		nome.setFont(grande);
		nome.setBounds(new Rectangle(20, 50, 120, 17));
		painelPrincipal.add(nome);

		caixaNome.setBounds(new Rectangle(150, 50, 120, 17));
		painelPrincipal.add(caixaNome);

		JLabel idade = new JLabel("Digite sua idade: ");
		idade.setFont(grande);
		idade.setBounds(new Rectangle(20, 100, 120, 17));
		painelPrincipal.add(idade);

		caixaIdade.setBounds(new Rectangle(150, 100, 120, 17));
		painelPrincipal.add(caixaIdade);

		JLabel email = new JLabel("Digite seu email: ");
		email.setFont(grande);
		email.setBounds(new Rectangle(20, 150, 120, 17));
		painelPrincipal.add(email);

		caixaEmail.setBounds(new Rectangle(150, 150, 120, 17));
		painelPrincipal.add(caixaEmail);

		JLabel login = new JLabel("Crie seu login: ");
		login.setFont(grande);
		login.setBounds(new Rectangle(20, 200, 120, 17));
		painelPrincipal.add(login);

		caixaLogin.setBounds(new Rectangle(150, 200, 120, 17));
		painelPrincipal.add(caixaLogin);

		JLabel senha = new JLabel("Crie sua senha: ");
		senha.setFont(grande);
		senha.setBounds(new Rectangle(20, 250, 120, 17));
		painelPrincipal.add(senha);

		label.setBounds(0, 0, 500, 400);
		caixaSenha.setBounds(new Rectangle(150, 250, 120, 17));
		painelPrincipal.add(caixaSenha);

		botaoConfirma.setBounds(150, 300, 100, 20);
		botaoVolta.setBounds(250, 300, 80, 20);

		painelPrincipal.add(botaoConfirma);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaCadastroAdm();
	}

}
