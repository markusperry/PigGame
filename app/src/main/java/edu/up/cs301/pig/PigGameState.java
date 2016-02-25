package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by perryma18 on 2/24/2016.
 */
public class PigGameState extends GameState {

    protected int userTurn;
    protected int player0Score;
    protected int player1Score;
    protected int currentTotal;
    protected int die;

    public PigGameState()
    {
        userTurn=0;
        player0Score=0;
        player1Score=0;
        currentTotal=0;
        die=1;
    }

    public PigGameState(PigGameState p)
    {
        userTurn=p.userTurn;
        player0Score=p.player0Score;
        player1Score=p.player1Score;
        currentTotal=p.currentTotal;
        die=p.die;
    }

    public int getUserTurn()
    {
        return userTurn;
    }

    public int getPlayer0Score()
    {
        return player0Score;
    }

    public int getPlayer1Score()
    {
        return player1Score;
    }

    public int getCurrentTotal()
    {
        return currentTotal;
    }

    public int getDie()
    {
        return die;
    }

    public void setUserTurn(int turn)
    {
        userTurn = turn;
    }

    public void setPlayer0Score(int score)
    {
       player0Score=score;
    }

    public void setPlayer1Score(int score)
    {
      player1Score=score;
    }

    public void setCurrentTotal(int total)
    {
        currentTotal=total;
    }

    public void setDie(int num)
    {
        die=num;
    }
}
