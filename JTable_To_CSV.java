package myPackage;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentListener;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Adam Mitchell Varco
 */
public class JTable_To_CSV extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394160863695874427L;

	/**
	 * Creates new form Java_JTable_Update_Selected_Row_Using_TextBoxes
	 */
	public JTable_To_CSV() {
		initComponents();
  }

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jTextFieldFN = new javax.swing.JTextField();
		jTextFieldLN = new javax.swing.JTextField();
		jTextFieldAGE = new javax.swing.JTextField();
		btnUpdateRow = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTable1.setAutoCreateRowSorter(true);

		jLabel1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
		jLabel1.setText("Id :");

		jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
		jLabel2.setText("First Name :");

		jLabel3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
		jLabel3.setText("Last Name :");

		jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
		jLabel4.setText("Age :");

		btnUpdateRow.setText("Update Row");

		btnUpdateRow.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateRowActionPerformed(evt);
			}
		});

		jTable1.setModel(tableModel);

		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		JButton btnNewButton = new JButton("Update Database");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					printCSV();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNewButton_1 = new JButton("Refresh From DB");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel = (DefaultTableModel) readCSV();
			}
		});

		JButton btnNewButton_2 = new JButton("Add Row");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// jTable1.setModel(model);
				addRow();
			}
		});

		JButton btnNewButton_3 = new JButton("Delete Row");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = jTable1.getSelectedRow();
				tableModel.removeRow(i);
			}
		});

		btnNewButton_4 = new JButton("Delete All");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
			}
		});
	

		btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortTable();
			}
		});

		JLabel lblNewLabel = new JLabel("Search Word or ID");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton_6 = new JButton("Search");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchTable();

			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(jLabel3).addComponent(jLabel4))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(layout
																.createParallelGroup(Alignment.LEADING)
																.addComponent(jTextFieldAGE, GroupLayout.PREFERRED_SIZE,
																		101, GroupLayout.PREFERRED_SIZE)
																.addComponent(jTextFieldLN, GroupLayout.PREFERRED_SIZE,
																		101, GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(jLabel2).addComponent(jLabel1))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(jTextFieldFN, GroupLayout.PREFERRED_SIZE,
																		101, GroupLayout.PREFERRED_SIZE)
																.addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE,
																		101, GroupLayout.PREFERRED_SIZE))))
										.addGap(39))
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnUpdateRow, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 151,
												Short.MAX_VALUE))))
						.addGroup(layout.createSequentialGroup().addGap(8).addComponent(btnNewButton_1)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(btnNewButton_3).addGap(4))
								.addGroup(layout.createSequentialGroup().addComponent(btnNewButton_5)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(btnNewButton_4).addGap(157).addComponent(
								btnNewButton_6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(18).addComponent(btnNewButton_2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, 0, 0, Short.MAX_VALUE)))
				.addContainerGap(45, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(12)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
										.addComponent(btnNewButton_3))
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextFieldFN, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextFieldLN, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextFieldAGE, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout
												.createSequentialGroup().addGap(107).addComponent(btnNewButton_5)))
								.addGap(28)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnUpdateRow, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_2))
								.addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNewButton_4)))
						.addGroup(layout.createSequentialGroup().addGap(32)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(7).addComponent(btnNewButton_6)))
						.addContainerGap()));
		getContentPane().setLayout(layout);
		pack();

	}// </editor-fold>
    //business logic
	protected void addRow() {
		// increase the size of the model and then add a row to it
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.addRow(new Object[] { jTextFieldID.getText(), jTextFieldFN.getText(), jTextFieldLN.getText(),
				jTextFieldAGE.getText() });
	}

	private void btnUpdateRowActionPerformed(java.awt.event.ActionEvent evt) {

		int i = jTable1.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		if (i >= 0) {
			model.setValueAt(jTextFieldID.getText(), i, 0);
			model.setValueAt(jTextFieldFN.getText(), i, 1);
			model.setValueAt(jTextFieldLN.getText(), i, 2);
			model.setValueAt(jTextFieldAGE.getText(), i, 3);
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}

	}

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

		int selectedRow = jTable1.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		jTextFieldID.setText(model.getValueAt(selectedRow, 0).toString());
		jTextFieldFN.setText(model.getValueAt(selectedRow, 1).toString());
		jTextFieldLN.setText(model.getValueAt(selectedRow, 2).toString());
		jTextFieldAGE.setText(model.getValueAt(selectedRow, 3).toString());
	}
	private void searchTable() {
		String text = textField.getText().trim();
		List<String> numdata = new ArrayList<String>();
		for (int count = 0; count < tableModel.getRowCount(); count++) {
			numdata.add(tableModel.getValueAt(count, 0).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 1).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 2).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 3).toString());
			numdata.add("\n");
		}
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		StringBuilder stB = new StringBuilder();
		for (String s : numdata) {
			stB.append(s);
		}
		String[] s = stB.toString().split("\n");
		for (int i = 0; i < s.length; i++) {
			String[] y = s[i].split(",");
			String lower = s[i].toLowerCase();
			if (lower.contains(text.toLowerCase())){
				
				jTextFieldID.setText(y[0]);
				jTextFieldFN.setText(y[1]);
				jTextFieldLN.setText(y[2]);
				jTextFieldAGE.setText(y[3]);
				tableModel.addRow(new Object[] { jTextFieldID.getText(), jTextFieldFN.getText(),
						jTextFieldLN.getText(), jTextFieldAGE.getText() });

			}
		}
		
	}
	private void sortTable() {
		List<String> numdata = new ArrayList<String>();
		for (int count = 0; count < tableModel.getRowCount(); count++) {
			numdata.add(tableModel.getValueAt(count, 0).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 1).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 2).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 3).toString());
			numdata.add("\n");
		}
		StringBuilder stB = new StringBuilder();
		for (String s : numdata) {
			stB.append(s);
		}
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		// sorts based on the map
		Map<Integer, String> map = new TreeMap<Integer, String>();

		String[] s = stB.toString().split("\n");
		for (int i = 0; i < s.length; i++) {
			String[] y = s[i].split(",");
			int key = Integer.parseInt(y[0]);
			String value = y[1] + "," + y[2] + "," + y[3];
			map.put(key, value);
		}

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			String[] split = value.split(",");
			jTextFieldID.setText(key + "");
			jTextFieldFN.setText(split[0]);
			jTextFieldLN.setText(split[1]);
			jTextFieldAGE.setText(split[2]);
			tableModel.addRow(new Object[] { jTextFieldID.getText(), jTextFieldFN.getText(),
					jTextFieldLN.getText(), jTextFieldAGE.getText() });
		}
		
	}
	private void printCSV() throws Exception {
		StringBuilder stB = new StringBuilder();

		PrintWriter pw = new PrintWriter(new File(filepath));
		List<String> numdata = new ArrayList<String>();
		for (int count = 0; count < tableModel.getRowCount(); count++) {
			numdata.add(tableModel.getValueAt(count, 0).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 1).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 2).toString());
			numdata.add(",");
			numdata.add(tableModel.getValueAt(count, 3).toString());
			numdata.add("\n");
		}
		for (String s : numdata) {
			stB.append(s);
		}
		pw.write(stB.toString());
		pw.close();

	}

	private TableModel readCSV() {
		// remove all elements
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		BufferedReader br = null;
		String line = "";
		try {

			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
				String[] table = line.split(",");
				jTextFieldID.setText(table[0]);
				jTextFieldFN.setText(table[1]);
				jTextFieldLN.setText(table[2]);
				jTextFieldAGE.setText(table[3]);
				// add them back in
				tableModel.addRow(new Object[] { jTextFieldID.getText(), jTextFieldFN.getText(), jTextFieldLN.getText(),
						jTextFieldAGE.getText() });
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tableModel;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(JTable_To_CSV.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JTable_To_CSV().setVisible(true);
			}
		});
	}



	private final String filepath = System.getProperty("user.home") + File.separator + "Desktop"+File.separator+"CSVDatabae.csv";
	ArrayList<Object> arrList = new ArrayList<Object>();
	private javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(new Object[][] {
			{ "1", "DDFFD", "DGHYTGD", "344" }, { "2", "FGHTYH", "UYUYHF", "33" }, { "3", "JHGF", "JHGFD", "254" },
			{ "4", "WQER", "OUYREE", "38" }, { "5", "BSGH", "IYDGH", "22" }, { "6", "QSDTYKJH", "PIHGDX", "16" },
			{ "7", "DSZDD", "UTRFRT", "2567" }, { "8", "XCVBGR", "YTEUI", "56" }, { "9", "FGHJUY", "NGFDBNJ", "65" },
			{ "10", "WQAZR", "VXWG", "42" } }, new String[] { "Id", "First Name", "Last Name", "Age" });

	private javax.swing.JButton btnUpdateRow;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextFieldAGE;
	private javax.swing.JTextField jTextFieldFN;
	private javax.swing.JTextField jTextFieldID;
	private javax.swing.JTextField jTextFieldLN;
	private JButton btnNewButton_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JTextField textField;
}
