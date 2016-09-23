package a00971562.gis.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import a00971562.gis.Gis;
import a00971562.gis.dao.ScoreDao;
import a00971562.gis.data.Game;
import a00971562.gis.data.Score;
import a00971562.gis.util.CompareScoreByGameName;
import a00971562.gis.util.GenerateGameTotals;
import a00971562.gis.util.UpdateList;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class GameDialog extends JDialog {

	/**
	 * Create the dialog.
	 * 
	 * @throws ClassNotFoundException
	 */
	public GameDialog() throws SQLException, ClassNotFoundException {
		setTitle("Score List (By Game)");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		JTable gameTable = new JTable();
		DefaultTableModel gameModel = new DefaultTableModel(0, 0);
		String gameHeader[] = new String[] { "Win:Lose", "Game Name", "Gamertag", "Platform" };
		gameModel.setColumnIdentifiers(gameHeader);
		gameTable.setModel(gameModel);

		List<Game> gamesList = Gis.games;
		List<Score> scoresList = ScoreDao.getScoresData();
		GenerateGameTotals.count(gamesList, scoresList);

		if (MainFrame.descending == true) {
			if (MainFrame.gtCondition == true) {
				UpdateList.filterGamerTag(scoresList, MainFrame.gamertag);
				Collections.sort(scoresList, Collections.reverseOrder(new CompareScoreByGameName()));
			} else {
				Collections.sort(scoresList, Collections.reverseOrder(new CompareScoreByGameName()));
			}
		} else if (MainFrame.gtCondition == true) {
			UpdateList.filterGamerTag(scoresList, MainFrame.gamertag);
			Collections.sort(scoresList, new CompareScoreByGameName());
		} else {
			Collections.sort(scoresList, new CompareScoreByGameName());
		}

		for (int index = 0; index < scoresList.size(); index++) {
			gameModel.addRow(new Object[] { scoresList.get(index).getWinTotal() + ":" + scoresList.get(index).getLostTotal(), scoresList.get(index).getName(),
					scoresList.get(index).getGamerTag(), scoresList.get(index).getPlatform() });
		}

		getContentPane().add(new JScrollPane(gameTable));

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnClose, "cell 0 1,alignx right");
	}

}
