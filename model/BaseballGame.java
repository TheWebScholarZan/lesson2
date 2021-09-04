/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @student ID *20465788
 * @create date 2021-09-04 12:07:06
 * @modify date 2021-09-04 12:07:06
 * @desc [OOP Lesson 2]
 */


package model;

import java.util.Random;

public class BaseballGame 
{
    private int[] key = new int[3];   //numbers between 0-9 random non repeating
    private int[] guess = new int[3]; //input numbers from user 
    private int ballCount = 0;            //detect end of game
    private int strikeCount = 0;          //detect end of game

    public BaseballGame()
    {
        generateKey();
    }

    public BaseballGame(int k0, int k1, int k2)
    {
        //not guess?

        key[0] = k0;
        key[1] = k1;
        key[2] = k2;
    }
    private void generateKey()
    {
        Random r = new Random();
        key[0] = r.nextInt(10);

        do
        {
            key[1] = r.nextInt(10);
        } while(key[1] == key[0]);

        do
        {
            key[2] = r.nextInt(10);
        } while(key[2] == key[0] || key[2] == key[1]);
    }

    public void setGuess(int pos, int value)
    {
        assert 0 <= pos && pos < 3 : "Set Guess out of range";
        guess[pos] = value; 
    }

    public void computeBallsStrikes()
    {
        strikeCount = 0;
        for(int i = 0; i < 3; i++)
        {
            if(key[i] == guess[i]) ++strikeCount;
        }

        ballCount = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int n = 0; n < 3; n++)
            {
                if(i == n) continue;
                if(key[i] == guess[n]) ballCount++;
            }
        }
    }

    public int getBallCount()
    {
        return ballCount;
    }

    public int getStrikeCount()
    {
        return strikeCount;
    }

    public int[] getKey()
    {
        return key;
    }


}
