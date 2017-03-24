package gui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.Evento;
import exceptions.IngInsuficienteException;
import negocio.Fachada;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;

public class TelaBuscarEvento extends JFrame implements ActionListener {

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
	private JTextField caixaQuant = new JTextField(50);

	JButton botaoBusca = new JButton("Buscar");
	JButton botaoVolta = new JButton("Voltar");
	JButton botaoComprar = new JButton("Comprar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Cadastros_Busca.png"));

	JLabel label = new JLabel(imagem);
	// JList lista;
	DefaultListModel modelo = new DefaultListModel();
	private final JList list = new JList();
	private final JScrollPane scrollPane = new JScrollPane();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoBusca) {
			Fachada fachada = Fachada.getInstance();
			if (fachada.existe(caixaBusca.getText())) {
				Evento even = fachada.buscarEvento(caixaBusca.getText());

				caixaNome.setText(even.getNome());
				caixaNome.setEditable(false);

				caixaPreco.setText(Integer.toString(even.getPreco()));
				caixaPreco.setEditable(false);

				caixaCasa.setText(even.getLocal().getCasaDeShow());
				caixaCasa.setEditable(false);

				caixaEndereco.setText(even.getLocal().getEndereco());
				caixaEndereco.setEditable(false);

				caixaDataHora.setText(even.getLocal().getDataHorario());
				caixaDataHora.setEditable(false);

				caixaCapacidade.setText(Integer.toString(even.getLocal().getCapacidade()));
				caixaCapacidade.setEditable(false);

				caixaBandas.setText(even.getBandas());
				caixaBandas.setEditable(false);

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

		} else if (e.getSource() == botaoComprar) {

			Fachada fachada = Fachada.getInstance();
			if (caixaBusca.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Busque o evento antes de comprar");
			} else if (fachada.buscarEvento(caixaNome.getText()).getLocal().getCapacidade() > 0) {

				int i = Integer.parseInt(caixaQuant.getText());
				if (i <= fachada.buscarEvento(caixaNome.getText()).getLocal().getCapacidade()) {
					
					try {
						Evento even = fachada.buscarEvento(caixaBusca.getText());
						fachada.venderIngrClien(i, caixaNome.getText());
						
						caixaNome.setText(even.getNome());
						caixaNome.setEditable(false);

						caixaPreco.setText(Integer.toString(even.getPreco()));
						caixaPreco.setEditable(false);

						caixaCasa.setText(even.getLocal().getCasaDeShow());
						caixaCasa.setEditable(false);

						caixaEndereco.setText(even.getLocal().getEndereco());
						caixaEndereco.setEditable(false);

						caixaDataHora.setText(even.getLocal().getDataHorario());
						caixaDataHora.setEditable(false);

						caixaCapacidade.setText(Integer.toString(even.getLocal().getCapacidade()));
						caixaCapacidade.setEditable(false);

						caixaBandas.setText(even.getBandas());
						caixaBandas.setEditable(false);

						caixaCodigo.setText(String.valueOf(even.getIngressos().getCodigo()));
						caixaCodigo.setEditable(false);

						System.out.println(caixaNome.getText());
						System.out.println(caixaCasa.getText());
						System.out.println(caixaEndereco.getText());
						System.out.println(caixaDataHora.getText());
						System.out.println(caixaCapacidade.getText());
						System.out.println(caixaBandas.getText());
						System.out.println(caixaCodigo.getText());

						JOptionPane.showMessageDialog(null, "Ingressos comprados!");

						TelaEspacoCliente espaco = new TelaEspacoCliente();
						espaco.setResizable(false);
						espaco.setLocationRelativeTo(null);
						espaco.setVisible(true);
						dispose();
					}  catch (IngInsuficienteException iee) {
						JOptionPane.showMessageDialog(null, "Ingressos insuficientes");
						
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingressos egostados!");
				TelaEspacoCliente espaco = new TelaEspacoCliente();
				espaco.setResizable(false);
				espaco.setLocationRelativeTo(null);
				espaco.setVisible(true);
				dispose();

			}

		} else {

			TelaEspacoCliente espaco = new TelaEspacoCliente();
			espaco.setResizable(false);
			espaco.setLocationRelativeTo(null);
			espaco.setVisible(true);
			dispose();

		}

	}

	public TelaBuscarEvento() {

		botaoBusca.addActionListener(this);
		botaoVolta.addActionListener(this);
		botaoComprar.addActionListener(this);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painelPrincipal = new JPanel();

		getContentPane().add(painelPrincipal);

		painelPrincipal.setLayout(null);

		Font grande = new Font("Serif", Font.BOLD, 13);
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
		list.setBounds(300, 41, 184, 189);
		painelPrincipal.add(list);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel busca = new JLabel("Busque o evento: ");
		busca.setFont(grande);
		busca.setBounds(new Rectangle(20, 13, 180, 17));
		painelPrincipal.add(busca);

		caixaBusca.setBounds(new Rectangle(120, 13, 150, 17));
		painelPrincipal.add(caixaBusca);
		scrollPane.setBounds(444, 93, -111, 117);

		painelPrincipal.add(scrollPane);

		JLabel nome = new JLabel("Nome do evento: ");
		nome.setFont(grande);
		nome.setBounds(new Rectangle(20, 33, 250, 17));
		painelPrincipal.add(nome);

		caixaNome.setBounds(new Rectangle(20, 53, 250, 17));
		painelPrincipal.add(caixaNome);
		caixaNome.setEditable(false);

		caixaPreco.setBounds(new Rectangle(40, 75, 50, 17));
		painelPrincipal.add(caixaPreco);
		caixaPreco.setEditable(false);

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
		caixaCasa.setEditable(false);

		JLabel endereco = new JLabel("Endereço: ");
		endereco.setFont(grande);
		endereco.setBounds(new Rectangle(20, 153, 250, 17));
		painelPrincipal.add(endereco);

		caixaEndereco.setBounds(new Rectangle(20, 173, 250, 17));
		painelPrincipal.add(caixaEndereco);
		caixaEndereco.setEditable(false);

		JLabel dataHora = new JLabel("Data e horário: ");
		dataHora.setFont(grande);
		dataHora.setBounds(new Rectangle(20, 193, 300, 17));
		painelPrincipal.add(dataHora);

		caixaDataHora.setBounds(new Rectangle(20, 213, 250, 17));
		painelPrincipal.add(caixaDataHora);
		caixaDataHora.setEditable(false);

		JLabel capacidade = new JLabel("Ingressos disposníveis: ");
		capacidade.setFont(grande);
		capacidade.setBounds(new Rectangle(20, 233, 450, 17));
		painelPrincipal.add(capacidade);

		caixaCapacidade.setBounds(new Rectangle(20, 253, 250, 17));
		painelPrincipal.add(caixaCapacidade);
		caixaCapacidade.setEditable(false);

		JLabel nomeBandas = new JLabel("Bandas: ");
		nomeBandas.setFont(grande);
		nomeBandas.setBounds(new Rectangle(20, 273, 250, 17));
		painelPrincipal.add(nomeBandas);

		caixaBandas.setBounds(new Rectangle(20, 293, 250, 17));
		painelPrincipal.add(caixaBandas);
		caixaBandas.setEditable(false);

		JLabel codigo = new JLabel("Codigo do  evento: ");
		codigo.setFont(grande);
		codigo.setBounds(new Rectangle(20, 313, 250, 17));
		painelPrincipal.add(codigo);

		caixaCodigo.setBounds(new Rectangle(20, 330, 250, 17));
		painelPrincipal.add(caixaCodigo);
		caixaCodigo.setEditable(false);
		System.out.println(caixaCodigo.getText());

		JLabel quantIng = new JLabel("Quantidade: ");
		quantIng.setFont(grande);
		quantIng.setBounds(new Rectangle(300, 233, 450, 17));
		painelPrincipal.add(quantIng);

		caixaQuant.setBounds(new Rectangle(300, 253, 65, 17));
		painelPrincipal.add(caixaQuant);

		label.setBounds(0, 0, 500, 400);
		botaoBusca.setBounds(300, 13, 75, 17);
		botaoComprar.setBounds(150, 350, 100, 20);
		botaoVolta.setBounds(250, 350, 80, 20);

		painelPrincipal.add(botaoBusca);
		painelPrincipal.add(botaoComprar);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaBuscarEvento();
	}

}
