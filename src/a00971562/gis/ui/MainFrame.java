package a00971562.gis.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.Gis;
import a00971562.gis.dao.ScoreDao;
import a00971562.gis.data.Game;
import a00971562.gis.data.Score;
import a00971562.gis.util.GenerateGameTotals;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JCheckBoxMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public static String dialogException;
	public static boolean descending = false;
	public static boolean gtCondition = false;
	public static String gtQuery;
	public static String gamertag;
	private JPanel contentPane;
	private static final Logger LOG = LogManager.getLogger(MainFrame.class);

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception exception) {
			LOG.error(exception);
			dialogException = ErrorDialog.getStackTrace(exception);
			ErrorDialog.produceErrorDialog();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnuFile = new JMenu("File");
		mnuFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnuFile);

		JMenuItem mtmQuit = new JMenuItem("Quit");
		mtmQuit.setMnemonic(KeyEvent.VK_Q);
		mtmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(mtmQuit);

		JMenu mnuLists = new JMenu("Lists");
		mnuLists.setMnemonic(KeyEvent.VK_L);
		menuBar.add(mnuLists);

		JMenuItem mtmPlayers = new JMenuItem("Players");
		mtmPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PlayerDialog dialog = new PlayerDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
			}
		});
		mtmPlayers.setMnemonic(KeyEvent.VK_P);
		mnuLists.add(mtmPlayers);

		JMenuItem mtmPersonas = new JMenuItem("Personas");
		mtmPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PersonaDialog dialog = new PersonaDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
			}
		});
		mtmPersonas.setMnemonic(KeyEvent.VK_N);
		mnuLists.add(mtmPersonas);

		JMenuItem mtmScores = new JMenuItem("Scores");
		mtmScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ScoreDialog dialog = new ScoreDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
			}
		});
		mtmScores.setMnemonic(KeyEvent.VK_S);
		mnuLists.add(mtmScores);

		JMenu mnuReports = new JMenu("Reports");
		mnuReports.setMnemonic(KeyEvent.VK_R);
		menuBar.add(mnuReports);

		JMenuItem mtmTotal = new JMenuItem("Total");
		mtmTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gameInfo = "";
					List<Game> gamesList = Gis.games;
					List<Score> scoresList = ScoreDao.getScoresData();
					GenerateGameTotals.count(gamesList, scoresList);
					for (Game game : gamesList)
						gameInfo += game.getName() + " " + game.getPlayed() + "\n";
					JOptionPane.showMessageDialog(MainFrame.this, gameInfo, "Score Totals", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exception) {
					LOG.error(exception);
					dialogException = ErrorDialog.getStackTrace(exception);
					ErrorDialog.produceErrorDialog();
				}
			}
		});
		mtmTotal.setMnemonic(KeyEvent.VK_T);
		mnuReports.add(mtmTotal);

		JCheckBoxMenuItem mtmDescending = new JCheckBoxMenuItem("Descending");
		mtmDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mtmDescending.isSelected()) {
					descending = true;
				} else {
					descending = false;
				}
			}
		});
		mtmDescending.setMnemonic(KeyEvent.VK_D);
		mnuReports.add(mtmDescending);

		JMenuItem mtmByGame = new JMenuItem("By Game");
		mtmByGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GameDialog dialog = new GameDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
			}
		});
		mtmByGame.setMnemonic(KeyEvent.VK_G);
		mnuReports.add(mtmByGame);

		JMenuItem mtmByCount = new JMenuItem("By Count");
		mtmByCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CountDialog dialog = new CountDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				});
			}
		});
		mtmByCount.setMnemonic(KeyEvent.VK_C);
		mnuReports.add(mtmByCount);

		JCheckBoxMenuItem mtmGamertag = new JCheckBoxMenuItem("Gamertag");
		mtmGamertag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gtQuery = JOptionPane.showInputDialog(MainFrame.this, "Please enter a gamertag:", "Filter by Gamertag", JOptionPane.QUESTION_MESSAGE);
				if (gtQuery != null) {
					if (gtQuery.equals("")) {
						mtmGamertag.setSelected(false);
						gtCondition = false;
					} else {
						try {
							if (ScoreDao.checkGamerTag(gtQuery)) {
								mtmGamertag.setSelected(true);
								gtCondition = true;
								gamertag = gtQuery;
							} else {
								mtmGamertag.setSelected(false);
								gtCondition = false;
								JOptionPane.showMessageDialog(MainFrame.this, "Gamertag does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception exception) {
							LOG.error(exception);
							dialogException = ErrorDialog.getStackTrace(exception);
							ErrorDialog.produceErrorDialog();
						}
					}
				} else {
					mtmGamertag.setSelected(false);
					gtCondition = false;
				}
			}
		});
		mtmGamertag.setMnemonic(KeyEvent.VK_A);
		mnuReports.add(mtmGamertag);

		JMenu mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnuHelp);

		JMenuItem mtmAbout = new JMenuItem("About");
		mtmAbout.setMnemonic(KeyEvent.VK_A);
		mtmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "GIS - Gamer Information System\nBy Rei Ruiz A00971562", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnuHelp.add(mtmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));

		setTitle("GIS - Gamer Information System");

		contentPane.setFocusable(true);
		contentPane.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F1) {
					JOptionPane.showMessageDialog(MainFrame.this, "GIS - Gamer Information System\nBy Rei Ruiz A00971562", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

	}

}
