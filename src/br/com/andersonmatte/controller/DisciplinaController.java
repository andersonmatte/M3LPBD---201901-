package br.com.andersonmatte.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Instituto Federal de São Paulo - Campus Sertãozinho
 * Disciplina......: M3LPBD
 * Programação de Computadores e Dispositivos Móveis
 * Aluno...........: Anderson Matte Tamborim
 * 
 * Classe Controller onde contém toda a lógica do projeto.
 * 
 * Referências utilizadas:
 * 
 * https://docs.oracle.com/javase/8/docs/api/index.html
 * https://www.javatpoint.com/java-swing
 */
public class DisciplinaController extends JFrame{

	private ResourceBundle mensagens;
	private JFrame frame;
	private JButton incluirDisciplina;
	private JButton excluirDisciplina;
	private JLabel labelNomeDisciplina;
	private JLabel labelCargaHoraria; 
	private JLabel labelCursoPertence; 
	private JLabel labelNumeroVagas;
	private JLabel labelPeriodo;
	private JTextField textFieldNomeDisciplina;
	private JTextField textFieldCargaHoraria; 
	private JTextField textFieldCursoPertence; 
	private JTextField textFieldNumeroVagas;
	private JTextField textFieldPeriodo;
	
	/**
	 * Método construtor da classe DisciplinaController é aproveitada para
	 * carregar o arquivo de properties que contém as mensagens de interação com
	 * o usuário.
	 */
	public DisciplinaController() {
		this.mensagens = PropertyResourceBundle.getBundle("br.com.andersonmatte.mensagens.Mensagens");
	}

	/**
	 * Método principal que faz a inicialização do programa para cadastro,
	 * consulta e exclusão de disciplinas.
	 */
	public void inicializaPrograma() {
		// Frame
		this.frame = this.getjFrame();
		// Panel
		JPanel btnPnl = this.getjPanel();
		btnPnl.setBackground(Color.WHITE);
		// Table e Scroll
		JTable table = this.getjTable();
		JScrollPane tabelaComScroll = this.getScroll(table);
		tabelaComScroll.setPreferredSize(new Dimension(400,300));
		// Adicionando componentes ao Frame.
		this.frame.add(tabelaComScroll, BorderLayout.SOUTH);
		this.frame.add(btnPnl, BorderLayout.CENTER);
		this.frame.pack();
		//garante abertura no centro da tela.
		this.frame.setLocationRelativeTo(null);
		// Visibilidade.
		this.frame.setVisible(true);
	}

	/**
	 * Inicialização do frame e preferências tais como tamanho e nome.
	 * 
	 * @return JFrame
	 */
	private JFrame getjFrame() {
		JFrame frame = new JFrame(this.mensagens.getString("title.frame"));
		frame.setPreferredSize(new Dimension(700,550));
		return frame;
	}

	/**
	 * Inicialização dos panels para os botões.
	 * 
	 * @return
	 */
	private JPanel getjPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JPanel btnPnl = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
		panel.setLayout(new GridLayout(0, 1));
		this.getForm(panel);
		btnPnl.add(panel, BorderLayout.CENTER);
		// Adiciona os botões ao Painel.
		for (JButton registro : this.criarBotoes()) {
			btnPnl.add(registro);
		}
		btnPnl.setBackground(Color.WHITE);
		return btnPnl;
	}

	/**
	 * Método responsável pela criação dos campos e labels do formulário.
	 * @param panel
	 */
	private void getForm(JPanel panel) {
		this.labelNomeDisciplina = new JLabel("Nome Disciplina: ");
		this.labelCargaHoraria = new JLabel("Carga Horária: "); 
		this.labelCursoPertence = new JLabel("Curso Pertence: ");
		this.labelNumeroVagas = new JLabel("Número Vagas: ");
		this.labelPeriodo = new JLabel("Período: ");
		this.textFieldNomeDisciplina = new JTextField(15);
		this.textFieldCargaHoraria = new JTextField(15);
		this.textFieldCursoPertence = new JTextField(15);
		this.textFieldNumeroVagas = new JTextField(15);
		this.textFieldPeriodo = new JTextField(15);
		panel.add(this.labelNomeDisciplina);
		panel.add(this.textFieldNomeDisciplina);		
		panel.add(this.labelCargaHoraria);
		panel.add(this.textFieldCargaHoraria);
		panel.add(this.labelCursoPertence);
		panel.add(this.textFieldCursoPertence);
		panel.add(this.labelNumeroVagas);
		panel.add(this.textFieldNumeroVagas);
		panel.add(this.labelPeriodo);
		panel.add(this.textFieldPeriodo);
	}
	
	/**
	 * Método responsável pela criação dos botôes da tela de Disciplinas.
	 */
	private List<JButton> criarBotoes() {
		List<JButton> jButtons = new ArrayList<>();
		// Incluir
		this.incluirDisciplina = new JButton(this.mensagens.getString("botao.incluir"));
		//incluirDisciplina.setBounds(50,80,100,20);
		jButtons.add(incluirDisciplina);
		// Excluir
		this.excluirDisciplina = new JButton(this.mensagens.getString("botao.excluir"));
		//excluirDisciplina.setBounds(150, 100, 135, 30);
		jButtons.add(excluirDisciplina);
		return jButtons;
	}

	/**
	 * Inicialização o Scroll e adicionado na tabela de disciplinas.
	 * 
	 * @return JScrollPane
	 */
	private JScrollPane getScroll(JTable table) {
		JScrollPane tabelaComScroll = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tabelaComScroll.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				this.mensagens.getString("fieldset.disciplina")));
		return tabelaComScroll;
	}

	/**
	 * Inicialização da tabela, preferencias e estilos.
	 * 
	 * @return JTable
	 */
	private JTable getjTable() {
		String data[][] = {
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" },
				{ "Matemática", "60", "Matemática", "30", "Noturno" }};
		String column[] = { "Nome Disciplina", "Carga Horária",
				"Curso Pertence", "Número Vagas", "Período" };

		JTable table = new JTable(data, column);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(Font.getFont(Font.SANS_SERIF));
		table.setBackground(Color.WHITE);
		table.setGridColor(Color.BLACK);
		// Garante o preenchimento total das colunas dentro da tabela.
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		return table;
	}

	// Limpa os Campos
	public void limpar() {
		this.textFieldNomeDisciplina.setText("");
		this.textFieldCargaHoraria.setText(""); 
		this.labelCursoPertence.setText(""); 
		this.textFieldNumeroVagas.setText("");
		this.textFieldPeriodo.setText("");
	}
	
}