package a00971562.gis.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.miginfocom.swing.MigLayout;
import a00971562.gis.dao.PersonaDao;
import a00971562.gis.data.Persona;
import a00971562.gis.ui.PersonaDialog;

@SuppressWarnings("serial")
public class PersonaInformation extends JDialog {

	public static String dialogException;
	private JTextField txfID;
	private JTextField txfFirstName;
	private JTextField txfLastName;
	private JTextField txfEmailAddress;
	private JTextField txfGamertag;
	private JTextField txfBirthDate;
	private final JPanel contentPanel = new JPanel();
	private static final Logger LOG = LogManager.getLogger(PersonaInformation.class);

	/**
	 * Create the dialog.
	 * 
	 * @throws ClassNotFoundException
	 */
	public PersonaInformation() throws SQLException, ClassNotFoundException {
		Persona persona = PersonaDao.getPersonas(PersonaDialog.gamerTag);

		setTitle("Persona Information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		{
			JLabel lblID = new JLabel("ID");
			contentPanel.add(lblID, "cell 0 0,alignx trailing");
		}
		{
			txfID = new JTextField();
			txfID.setText(String.valueOf(persona.getId()));
			txfID.setEnabled(false);
			txfID.setEditable(false);
			contentPanel.add(txfID, "cell 1 0,growx");
			txfID.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First Name");
			contentPanel.add(lblFirstName, "cell 0 1,alignx trailing");
		}
		{
			txfFirstName = new JTextField();
			txfFirstName.setText(persona.getFirstName());
			contentPanel.add(txfFirstName, "cell 1 1,growx");
			txfFirstName.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			contentPanel.add(lblLastName, "cell 0 2,alignx trailing");
		}
		{
			txfLastName = new JTextField();
			txfLastName.setText(persona.getLastName());
			contentPanel.add(txfLastName, "cell 1 2,growx,aligny top");
			txfLastName.setColumns(10);
		}
		{
			JLabel lblEmailAddress = new JLabel("Email Address");
			contentPanel.add(lblEmailAddress, "cell 0 3,alignx trailing");
		}
		{
			txfEmailAddress = new JTextField();
			txfEmailAddress.setText(persona.getEmailAddress());
			contentPanel.add(txfEmailAddress, "cell 1 3,growx");
			txfEmailAddress.setColumns(10);
		}
		{
			JLabel lblGamerTag = new JLabel("Gamer Tag");
			contentPanel.add(lblGamerTag, "cell 0 4,alignx trailing");
		}
		{
			txfGamertag = new JTextField();
			txfGamertag.setText(persona.getGamerTag());
			contentPanel.add(txfGamertag, "cell 1 4,growx");
			txfGamertag.setColumns(10);
		}
		{
			JLabel lblBirthDate = new JLabel("Birth Date");
			contentPanel.add(lblBirthDate, "cell 0 5,alignx trailing");
		}
		{
			txfBirthDate = new JTextField();
			txfBirthDate.setText(persona.getBirthDate());
			contentPanel.add(txfBirthDate, "cell 1 5,growx");
			txfBirthDate.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							persona.setFirstName(txfFirstName.getText());
							persona.setLastName(txfLastName.getText());
							persona.setEmailAddress(txfEmailAddress.getText());
							persona.setGamerTag(txfGamertag.getText());
							persona.setBirthDate(txfBirthDate.getText());
							PersonaDao.update(persona);
							dispose();
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
