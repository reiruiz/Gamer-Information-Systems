package a00971562.gis.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import a00971562.gis.dao.ScoreDao;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ScoreDialog extends JDialog {

	/**
	 * Create the dialog.
	 * 
	 * @throws ClassNotFoundException
	 */
	public ScoreDialog() throws SQLException, ClassNotFoundException {
		setTitle("Score List");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		List<String> personas = ScoreDao.getScoresPersonas();
		List<String> gameNames = ScoreDao.getScoresGameNames();
		List<String> winLose = ScoreDao.getScoresWinLose();

		JTable scoreTable = new JTable();
		DefaultTableModel scoreModel = new DefaultTableModel(0, 0);
		String scoreHeader[] = new String[] { "Persona", "Game Name", "Win/Lose" };
		scoreModel.setColumnIdentifiers(scoreHeader);
		scoreTable.setModel(scoreModel);
		for (int index = 0; index < personas.size(); index++) {
			scoreModel.addRow(new Object[] { personas.get(index), gameNames.get(index), winLose.get(index) });
		}

		getContentPane().add(new JScrollPane(scoreTable));

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnClose, "cell 0 1,alignx right");

	}

}
