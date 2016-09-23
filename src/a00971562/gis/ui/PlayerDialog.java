package a00971562.gis.ui;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;

import a00971562.gis.dao.PlayerDao;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class PlayerDialog extends JDialog {

	/**
	 * Create the dialog.
	 * 
	 * @throws ClassNotFoundException
	 */
	public PlayerDialog() throws SQLException, ClassNotFoundException {
		setTitle("Player List");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JButton btnPlayerClose = new JButton("Close");
		btnPlayerClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		DefaultListModel<String> playerModel = new DefaultListModel<String>();
		List<String> players = PlayerDao.getFullNames();
		for (int index = 0; index < players.size(); index++) {
			playerModel.addElement(players.get(index));
		}

		JList<String> playerList = new JList<String>(playerModel);
		playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getContentPane().add(new JScrollPane(playerList), "cell 0 0, grow");
		getContentPane().add(btnPlayerClose, "cell 0 1,alignx right");

	}

}
