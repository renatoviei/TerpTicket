package gui;

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
import javax.swing.border.BevelBorder;

import beans.Evento;
import beans.Local;
import negocio.Fachada;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class TelaEditEvent extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaBusca = new JTextField(50);
	private JTextField caixaNome = new JTextField(50);
	private JTextField caixaPreco = new JTextField(50);
	private JTextField caixaCasa = new JTextField(50);
	private JTextField caixaEndereco = new JTextField(50);
	private JTextField caixaDataHora = new JTextField(50);
	private JTextField caixaCapacidade = new JTextField(50);
	private JTextField caixaBandas = new JTextField(50);
	private JTextField caixaCodigo = new JTextField(50);

	JButton botaoBusca = new JButton("Buscar");
	JButton botaoVolta = new JButton("Voltar");
	JButton botaoConfirmar = new JButton("Confirmar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Cadastros_Busca.png"));

	JLabel label = new JLabel(imagem);
	String aux;
     Evento even;
     private final JList list = new JList();
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoBusca) {
			Fachada fachada = Fachada.getInstance();
             
			if (fachada.existe(caixaBusca.getText())) {
				even = fachada.buscarEvento(caixaBusca.getText());

				caixaNome.setText(even.getNome());

				aux = even.getNome();

				caixaPreco.setText(Integer.toString(even.getPreco()));

				caixaCasa.setText(even.getLocal().getCasaDeShow());

				caixaEndereco.setText(even.getLocal().getEndereco());

				caixaDataHora.setText(even.getLocal().getDataHorario());

				caixaCapacidade.setText(Integer.toString(even.getLocal().getCapacidade()));

				caixaBandas.setText(even.getBandas());

				caixaCodigo.setText(String.valueOf(even.getIngressos().getCodigo()));
				caixaCodigo.setEditable(false);

				System.out.println(caixaNome.getText());
				System.out.println(caixaCasa.getText());
				System.out.println(caixaEndereco.getText());
				System.out.println(caixaDataHora.getText());
				System.out.println(caixaCapacidade.getText());
				System.out.println(caixaBandas.getText());
				System.out.println(caixaCodigo.getText());

			} else {
				JOptionPane.showMessageDialog(null, "Evento não existe ou nome está incorreto");
			}

		} else if (e.getSource() == botaoConfirmar) {

			Fachada fachada = Fachada.getInstance();
			if (caixaBusca.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Busque o evento antes de comprar");
			} else if (fachada.existe(aux)) {
				try {
					int i = Integer.parseInt(caixaPreco.getText());
					int j = Integer.parseInt(caixaCapacidade.getText());

					

					

					Local local = new Local(caixaCasa.getText(), caixaEndereco.getText(), caixaDataHora.getText(), j);
					fachada.atualiza(even, caixaNome.getText(), i, local, caixaBandas.getText());

					System.out.println(caixaNome.getText());
					System.out.println(caixaCasa.getText());
					System.out.println(caixaEndereco.getText());
					System.out.println(caixaDataHora.getText());
					System.out.println(caixaCapacidade.getText());
					System.out.println(caixaBandas.getText());
					System.out.println(caixaCodigo.getText());

					JOptionPane.showMessageDialog(null, "Evento editado!");

					TelaEspacoAdm espaco = new TelaEspacoAdm();
					espaco.setResizable(false);
					espaco.setLocationRelativeTo(null);
					espaco.setVisible(true);
					dispose();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,
							"Você deve estar digitando, uma letra em algum campo numerico, tente novamente!");
				}
			}

		}

		else {

			TelaEspacoAdm espaco = new TelaEspacoAdm();
			espaco.setResizable(false);
			espaco.setLocationRelativeTo(null);
			espaco.setVisible(true);
			dispose();

		}
	}

	public TelaEditEvent() {

		botaoBusca.addActionListener(this);
		botaoVolta.addActionListener(this);
		botaoConfirmar.addActionListener(this);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painelPrincipal = new JPanel();

		getContentPane().add(painelPrincipal);

		painelPrincipal.setLayout(null);

		Font grande = new Font("Serif", Font.BOLD, 13);

		JLabel busca = new JLabel("Busque o evento: ");
		busca.setFont(grande);
		busca.setBounds(new Rectangle(20, 13, 180, 17));
		painelPrincipal.add(busca);

		caixaBusca.setBounds(new Rectangle(120, 13, 150, 17));
		painelPrincipal.add(caixaBusca);

		JLabel nome = new JLabel("Nome do evento: ");
		nome.setFont(grande);
		nome.setBounds(new Rectangle(20, 33, 250, 17));
		painelPrincipal.add(nome);
		list.setBounds(300, 43, 184, 247);
		painelPrincipal.add(list);
		list.setModel(new AbstractListModel() {
			Fachada fachada = Fachada.getInstance();
			String[] listaEventos = fachada.retornaTudo();

			public int getSize() {
				return listaEventos.length;
			}

			public Object getElementAt(int index) {
				return listaEventos[index];
			}
		});
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("Tahoma", Font.BOLD, 13));

		caixaNome.setBounds(new Rectangle(20, 53, 250, 17));
		painelPrincipal.add(caixaNome);

		caixaPreco.setBounds(new Rectangle(40, 75, 50, 17));
		painelPrincipal.add(caixaPreco);

		JLabel cifrao = new JLabel("R$");
		cifrao.setFont(grande);
		cifrao.setBounds(new Rectangle(20, 75, 30, 17));
		painelPrincipal.add(cifrao);

		JLabel centavos = new JLabel(",00");
		centavos.setFont(grande);
		centavos.setBounds(new Rectangle(93, 75, 60, 17));
		painelPrincipal.add(centavos);

		JLabel casa = new JLabel("Casa de show: ");
		casa.setFont(grande);
		casa.setBounds(new Rectangle(20, 113, 250, 17));
		painelPrincipal.add(casa);

		caixaCasa.setBounds(new Rectangle(20, 133, 250, 17));
		painelPrincipal.add(caixaCasa);

		JLabel endereco = new JLabel("Endereço: ");
		endereco.setFont(grande);
		endereco.setBounds(new Rectangle(20, 153, 250, 17));
		painelPrincipal.add(endereco);

		caixaEndereco.setBounds(new Rectangle(20, 173, 250, 17));
		painelPrincipal.add(caixaEndereco);

		JLabel dataHora = new JLabel("Data e horário: ");
		dataHora.setFont(grande);
		dataHora.setBounds(new Rectangle(20, 193, 300, 17));
		painelPrincipal.add(dataHora);

		caixaDataHora.setBounds(new Rectangle(20, 213, 250, 17));
		painelPrincipal.add(caixaDataHora);

		JLabel capacidade = new JLabel("Ingressos disposníveis: ");
		capacidade.setFont(grande);
		capacidade.setBounds(new Rectangle(20, 233, 450, 17));
		painelPrincipal.add(capacidade);

		caixaCapacidade.setBounds(new Rectangle(20, 253, 250, 17));
		painelPrincipal.add(caixaCapacidade);

		JLabel nomeBandas = new JLabel("Bandas: ");
		nomeBandas.setFont(grande);
		nomeBandas.setBounds(new Rectangle(20, 273, 250, 17));
		painelPrincipal.add(nomeBandas);

		caixaBandas.setBounds(new Rectangle(20, 293, 250, 17));
		painelPrincipal.add(caixaBandas);

		JLabel codigo = new JLabel("Codigo do  evento: ");
		codigo.setFont(grande);
		caixaCodigo.setEditable(false);
		codigo.setBounds(new Rectangle(20, 313, 250, 17));
		painelPrincipal.add(codigo);

		caixaCodigo.setBounds(new Rectangle(20, 330, 250, 17));
		painelPrincipal.add(caixaCodigo);
		System.out.println(caixaCodigo.getText());
		botaoBusca.setBounds(300, 13, 75, 17);
		botaoConfirmar.setBounds(150, 350, 100, 20);
		botaoVolta.setBounds(250, 350, 80, 20);

		painelPrincipal.add(botaoBusca);
		painelPrincipal.add(botaoConfirmar);
		painelPrincipal.add(botaoVolta);
		
				label.setBounds(0, 0, 500, 400);
				painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaEditEvent();
	}

}
