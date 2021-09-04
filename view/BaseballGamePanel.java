/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @student ID *20465788
 * @create date 2021-09-04 12:21:09
 * @modify date 2021-09-04 12:21:09
 * @desc [OOP Lesson 2]
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BaseballKeyListener;
import model.BaseballGame;

public class BaseballGamePanel 
{
    public enum GameState {READY, PLAYING, OVER}

    private JFrame window;
    private BaseballCanvas canvas;
    private BaseballGame baseballGame;

    private JTextField keyField   = new JTextField(10);
    private JTextField guessField = new JTextField(10);
    private JButton[]  digitButtons;
    private JButton    playButton = new JButton("Play Ball~~");
    private JButton    exiButton = new JButton("Exit");

    private GameState gameState = GameState.READY;

    public BaseballGamePanel(JFrame window)
    {
        this.window = window;
        window.setTitle("Baseball Game");
    }

    public void init()
    {
        Container cp = window.getContentPane();
        // var scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setPreferredSize(new Dimension(500, 500));
        // cp.add(scrollPane, BorderLayout.CENTER);

        JPanel northPanel = new JPanel();
        // cp.add(BorderLayout.NORTH, northPanel);
        northPanel.setLayout( new GridLayout(2, 1));
        northPanel.add(new JLabel("Secret Game Key; "));
        northPanel.add(keyField);
        northPanel.add(new JLabel("Your Guess: "));
        northPanel.add(guessField);
        guessField.setEditable(false);
        keyField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new BaseballCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();//can only add one item so make a panel to add more parts
        southPanel.setLayout( new GridLayout(4, 3) );

        
        BaseballKeyListener keyListener = new BaseballKeyListener(this);
        digitButtons = new JButton[10];
        for(int i = 0; i < 10; i++)
        {
            digitButtons[i] = new JButton(""+i);
            southPanel.add(digitButtons[i]);
            digitButtons[i].addActionListener(keyListener);
            //digitButtons[i].setEnabled(false);
        };
        playButton.addActionListener(keyListener);
        exiButton.addActionListener(keyListener);
        southPanel.add(playButton);
        southPanel.add(exiButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for(var b: digitButtons)
        {
            b.setEnabled(false);
        }
    }

    public BaseballGame getBaseballGame()
    {
        return baseballGame;
    }

    public void setBaseball(BaseballGame baseballGame)
    {
        this.baseballGame = baseballGame;
    }

    public JFrame getWindow()
    {
        return window;
    }

    public BaseballCanvas getCanvase()
    {
        return canvas;
    }

    public JTextField getKeyField()
    {
        return keyField;
    }

    public JTextField getGuessField()
    {
        return guessField;
    }

    public JButton[] getDigitButtons()
    {
        return digitButtons;
    }

    public JButton getPlayButton()
    {
        return playButton;
    }

    public JButton getExitButton()
    {
        return exiButton;
    }

    public GameState getGameState()
    {
        return gameState;
    }

    public void setGameState(GameState state)
    {
        this.gameState = state;
    }

}