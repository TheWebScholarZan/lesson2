/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @email bschwarz2@uco.edu
 * @create date 2021-09-04 14:22:41
 * @modify date 2021-09-04 14:22:41
 * @desc [OOP Lesson ]
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.BaseballGame;
import view.BaseballGamePanel;
import view.MenuScreen;
import view.BaseballGamePanel.GameState;

public class BaseballKeyListener implements ActionListener
{
    private BaseballGamePanel panel;

    private int clicks = 0;

    public BaseballKeyListener(BaseballGamePanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());

        if(button == panel.getPlayButton())
        {
            var baseball = new BaseballGame();
            panel.setBaseball(baseball);
            panel.setGameState(BaseballGamePanel.GameState.PLAYING); //I wass able to call is as GameState.PLAYING
            int[] keys = baseball.getKey();
            String keyString = "" + keys[0] + keys[1] + keys[2];
            panel.getKeyField().setText(keyString);
            // baseball.keyField.setVisable(false);
            panel.getGuessField().setText("");
            for(var b: panel.getDigitButtons())
            {
                b.setEnabled(true);
            }
            panel.getCanvase().setBallStrikeCount(0, 0);
            panel.getCanvase().repaint();
        }
        else if(button == panel.getExitButton())
        {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.setVisible(true);
        }
        //can only be digit buttons 0-9
        else
        {
            button.setEnabled(false);  //we cannot have 2 balls/1 strike or 2 strikes/1 ball

            JTextField guessField = panel.getGuessField();
            if(clicks == 0) guessField.setText("");

            BaseballGame baseball = panel.getBaseballGame();
            String n = button.getText();
            guessField.setText(guessField.getText() + n);
            baseball.setGuess(clicks, n.charAt(0) - '0');
            clicks++;

            if(clicks == 3)
            {
                baseball.computeBallsStrikes();
                int balls = baseball.getBallCount();
                int strikes = baseball.getStrikeCount();
                panel.getCanvase().setBallStrikeCount(balls, strikes);

                if(strikes == 3)
                {
                    panel.setGameState(BaseballGamePanel.GameState.OVER);
                    for(var b: panel.getDigitButtons())
                    {
                        b.setEnabled(false);
                    }
                }
                else
                {
                    for(var b: panel.getDigitButtons())
                    {
                        b.setEnabled(true);
                    }
                }

                clicks = 0;
                panel.getCanvase().repaint();
            }
        }
    }
    
}
