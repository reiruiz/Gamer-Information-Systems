package a00971562.gis.ui;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.Gis;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ErrorDialog extends JDialog {

	public static String dialogException;
	private static final Logger LOG = LogManager.getLogger(ErrorDialog.class);

	/**
	 * Create the dialog.
	 */
	public ErrorDialog() {
		setTitle("Exception");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JTextPane txtpnTest = new JTextPane();
		txtpnTest.setText(Gis.dialogException);
		txtpnTest.setEditable(false);
		getContentPane().add(txtpnTest, "cell 0 0,grow");

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnClose, "cell 0 1,alignx right");

	}

	public static void produceErrorDialog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorDialog dialog = new ErrorDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception exception) {
					LOG.error(exception);
					dialogException = getStackTrace(exception);
					produceErrorDialog();
				}
			}
		});
	}

	public static String getStackTrace(Exception exception) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter, true);
		exception.printStackTrace(printWriter);
		return stringWriter.getBuffer().toString();
	}

}
