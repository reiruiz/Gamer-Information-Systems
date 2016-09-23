package a00971562.gis.ui;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;

import a00971562.gis.dao.PersonaDao;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class PersonaDialog extends JDialog {

	public static String dialogException;
	public static String gamerTag;
	private static final Logger LOG = LogManager.getLogger(PersonaDialog.class);

	/**
	 * Create the dialog.
	 */
	public PersonaDialog() throws SQLException, ClassNotFoundException {
		setTitle("Gamertag List");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow][]"));

		JLabel lblDescription = new JLabel("Select a 'Gamertag' by double-clicking.");
		getContentPane().add(lblDescription, "cell 0 0");

		DefaultListModel<String> personaModel = new DefaultListModel<String>();
		List<String> players = PersonaDao.getGamertags();
		for (int index = 0; index < players.size(); index++) {
			personaModel.addElement(players.get(index));
		}

		JList<String> personaList = new JList<String>(personaModel);
		personaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(new JScrollPane(personaList), "cell 0 1, grow");

		listSelection(personaList);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnClose, "cell 0 2,alignx right");

	}

	private void listSelection(JList<String> list) {
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				gamerTag = list.getSelectedValue();
				if (mouseEvent.getClickCount() == 2) {
					try {
						PersonaInformation dialog = new PersonaInformation();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception exception) {
						LOG.error(exception);
						dialogException = ErrorDialog.getStackTrace(exception);
						ErrorDialog.produceErrorDialog();
					}
				}
			}
		};
		list.addMouseListener(mouseListener);
	}

}
