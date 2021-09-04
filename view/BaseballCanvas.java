/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @email bschwarz2@uco.edu
 * @create date 2021-09-04 14:05:39
 * @modify date 2021-09-04 14:05:39
 * @desc [OOP Lesson ]
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BaseballCanvas extends JPanel
{
    public static int WIDTH  = 500;
    public static int HEIGHT = 500;

    //stores all the info from the baseball came
    private BaseballGamePanel panel;

    //keep cound so we get get the infor from the baseballgamepanel and fill the cricles made below
    private int balls;
    private int strikes;

    public BaseballCanvas(BaseballGamePanel panel)
    {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) //graphics is a sub class 
    {
        super.paintComponent(g); //custom drawing

        Graphics2D g2 = (Graphics2D) g;
        //ready to play
        BaseballGamePanel.GameState state = panel.getGameState(); //gains game state playing ready over so we can display various images
        if(state == BaseballGamePanel.GameState.READY)
        {
            //sets the opening screen 
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Click <Play> to Start", 70, 150);
        }
        else //if(state == BaseballGamePanel.GameState.PLAYING) 
        {

            if(state == BaseballGamePanel.GameState.OVER)
            {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier New", Font.BOLD, 30));
                g2.drawString("GAME OVER", 150, 160);
            }
            //shows current scrore strikes and balls
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier New", Font.BOLD, 14));
            //draw balls
            g2.drawString("Balls: " + balls, 20, 100);
            for(int i = 0; i < 3; i++)
            {
                if(i < balls) g2.fillOval(i * 140 + 100, 80, 50, 50);
                else g2.drawOval(i * 140 + 100, 80, 50, 50);
            }

            g2.drawString("Strikes: " + strikes, 20, 200);
            for(int i = 0; i < 3; i++)
            {
                if(i < strikes) g2.fillOval(i * 140 + 100, 180, 50, 50);
                else g2.drawOval(i * 140 + 100, 180, 50, 50);
            }
        }
        // else
        // {
        //     g2.setColor(Color.red);
        //     g2.setFont(new Font("Courier New", Font.BOLD, 30));
        //     g2.drawString("GAME OVER", 150, 160);

        //     // g2.setColor(Color.yellow);
        //     // g2.setFont(new Font("Courier New", Font.BOLD, 14));

        //     // g2.drawString("Balls: " + balls, 20, 100);
        //     // for(int i = 0; i < 3; i++)
        //     // {
        //     //     g2.drawOval(i * 140 + 100, 80, 50, 50);
        //     // }

        //     // g2.drawString("Strikes: " + strikes, 20, 200);
        //     // for(int i = 0; i < 3; i++)
        //     // {
        //     //     g2.drawOval(i * 140 + 100, 180, 50, 50);
        //     // }
        // }
    }
    
    //gets ball and strike info
    public void setBallStrikeCount(int balls, int strikes)
    {
        this.balls = balls;
        this.strikes = strikes;
    }
}
