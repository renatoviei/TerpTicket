package GUI;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.Evento;
import beans.Ingresso;
import beans.Local;
import negocio.Fachada;

public class TelaEspacoCriarEven extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaNome = new JTextField(50);
	private JTextField caixaPreco = new JTextField(50);

	private JTextField caixaCasa = new JTextField(50);
	private JTextField caixaEndereco = new JTextField(50);
	private JTextField caixaDataHora = new JTextField(50);
	private JTextField caixaCapacidade = new JTextField(50);
	private JTextField caixaBandas = new JTextField(50);
	private JTextField caixaCodigo = new JTextField(50);
	private Ingresso ingressos = null;

	JButton botaoCriar = new JButton("Criar");
	JButton botaoVolta = new JButton("Voltar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Cadastros_Busca.png"));

	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoCriar) {
			if (caixaNome.getText().equals("") || caixaPreco.getText().equals("") || caixaCasa.getText().equals("")
					|| caixaEndereco.getText().equals("") || caixaDataHora.getText().equals("")
					|| caixaCapacidade.getText().equals("") || caixaBandas.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campops");
			} else {
				int i = Integer.parseInt(caixaCapacidade.getText());
				int k = Integer.parseInt(caixaPreco.getText());
				Local local = new Local(caixaCasa.getText(), caixaEndereco.getText(), caixaDataHora.getText(), i);

				Evento even = new Evento(caixaNome.getText(), k, local, caixaBandas.getText(), ingressos);

				Fachada fachada = Fachada.getInstance();
				fachada.cadastarEvento(even);

				JOptionPane.showMessageDialog(null, "Evento criado com sucesso");

				TelaEspacoAdm espaco = new TelaEspacoAdm();
				espaco.setResizable(false);
				espaco.setLocationRelativeTo(null);
				espaco.setVisible(true);
				janela.dispose();
			}
		} else {
			TelaEspacoAdm espaco = new TelaEspacoAdm();
			espaco.setResizable(false);
			espaco.setLocationRelativeTo(null);
			espaco.setVisible(true);
			janela.dispose();
		}

	}

	public TelaEspacoCriarEven() {

		botaoCriar.addActionListener(this);
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

		Font grande = new Font("Serif", Font.BOLD, 14);

		JLabel nome = new JLabel("Digite o nome do evento: ");
		nome.setFont(grande);
		nome.setBounds(new Rectangle(20, 15, 250, 17));
		painelPrincipal.add(nome);

		caixaNome.setBounds(new Rectangle(20, 35, 250, 17));
		painelPrincipal.add(caixaNome);

		JLabel preco = new JLabel("Digite o preço do ingresso: ");
		preco.setFont(grande);
		preco.setBounds(new Rectangle(20, 55, 250, 17));
		painelPrincipal.add(preco);

		caixaPreco.setBounds(new Rectangle(40, 75, 50, 17));
		painelPrincipal.add(caixaPreco);

		JLabel cifrao = new JLabel("R$");
		cifrao.setFont(grande);
		cifrao.setBounds(new Rectangle(20, 75, 30, 17));
		painelPrincipal.add(cifrao);

		JLabel centavos = new JLabel(",00");
		centavos.setFont(grande);
		centavos.setBounds(new Rectangle(90, 75, 60, 17));
		painelPrincipal.add(centavos);

		JLabel casa = new JLabel("Digite o nome da casa de show: ");
		casa.setFont(grande);
		casa.setBounds(new Rectangle(20, 95, 250, 17));
		painelPrincipal.add(casa);

		caixaCasa.setBounds(new Rectangle(20, 115, 250, 17));
		painelPrincipal.add(caixaCasa);

		JLabel endereco = new JLabel("Digite o endereço da casa de show: ");
		endereco.setFont(grande);
		endereco.setBounds(new Rectangle(20, 135, 250, 17));
		painelPrincipal.add(endereco);

		caixaEndereco.setBounds(new Rectangle(20, 155, 250, 17));
		painelPrincipal.add(caixaEndereco);

		JLabel dataHora = new JLabel("Digite a data e horário do evento no modelo 'DD/MM/AA HH:MM': ");
		dataHora.setFont(grande);
		dataHora.setBounds(new Rectangle(20, 175, 450, 17));
		painelPrincipal.add(dataHora);

		caixaDataHora.setBounds(new Rectangle(20, 195, 250, 17));
		painelPrincipal.add(caixaDataHora);

		JLabel capacidade = new JLabel("Digite a capacidadde de lotação(quantidade de ingressos): ");
		capacidade.setFont(grande);
		capacidade.setBounds(new Rectangle(20, 215, 450, 17));
		painelPrincipal.add(capacidade);

		caixaCapacidade.setBounds(new Rectangle(20, 235, 250, 17));
		painelPrincipal.add(caixaCapacidade);

		JLabel nomeBandas = new JLabel("Digite o nome das bandas: ");
		nomeBandas.setFont(grande);
		nomeBandas.setBounds(new Rectangle(20, 255, 250, 17));
		painelPrincipal.add(nomeBandas);

		caixaBandas.setBounds(new Rectangle(20, 275, 250, 17));
		painelPrincipal.add(caixaBandas);

		JLabel codigo = new JLabel("Codigo do  evento: ");
		codigo.setFont(grande);
		codigo.setBounds(new Rectangle(20, 295, 250, 17));
		painelPrincipal.add(codigo);

		Random radom = new Random();
		long codigoRandom = 0;
		for (int j = 0; j < 10; j++) {
			codigoRandom = radom.nextInt(1000000001);
			if (codigoRandom >= 99999999) {
				break;
			}
		}
		ingressos = new Ingresso(codigoRandom);
		String str = String.valueOf(ingressos.getCodigo());
		caixaCodigo.setText(str);

		caixaCodigo.setBounds(new Rectangle(20, 315, 250, 17));
		painelPrincipal.add(caixaCodigo);
		System.out.println(caixaCodigo.getText());

		label.setBounds(0, 0, 500, 400);
		botaoCriar.setBounds(150, 350, 100, 20);
		botaoVolta.setBounds(250, 350, 80, 20);

		painelPrincipal.add(botaoCriar);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaEspacoCriarEven();
	}

}
