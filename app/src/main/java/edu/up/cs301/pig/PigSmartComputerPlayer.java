package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by perryma18 on 2/24/2016.
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {
    private PigGameState state;
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PigSmartComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        state = (PigGameState) info;
        if (state.userTurn==this.playerNum)
        {
            int player = this.playerNum;
            int ourScore=0;
            int theirScore=0;
            int curTotal = state.currentTotal;
            if (player==0)
            {
                ourScore=state.player0Score;
                theirScore=state.player1Score;
            }
            else
            {
                ourScore=state.player1Score;
                theirScore=state.player0Score;
            }
            if (ourScore>50)
            {
                 sendHold();
            }
            else if( theirScore - (ourScore + curTotal) > 10)
            {
                sendRoll();
            }
            else if (curTotal<10)
            {
                sendRoll();
            }
            else
            {
                sendHold();
            }

        }
        else
        {
            return;
        }
    }

    public void sendRoll()
    {
        PigRollAction roll = new PigRollAction(this);
        this.game.sendAction(roll);
    }

    public void sendHold()
    {
        PigHoldAction hold = new PigHoldAction(this);
        this.game.sendAction(hold);
    }
}
