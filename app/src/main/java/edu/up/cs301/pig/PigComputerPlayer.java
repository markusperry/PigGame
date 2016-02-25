package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    private PigGameState state;
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
       state = (PigGameState) info;
        if (state.userTurn==this.playerNum)
        {
            Random gen = new Random();
            int rand = gen.nextInt(2);
            if (rand==0)
            {
                PigHoldAction hold = new PigHoldAction(this);
                this.game.sendAction(hold);
            }
            else
            {
                PigRollAction roll = new PigRollAction(this);
                this.game.sendAction(roll);
            }
        }
        else
        {
            return;
        }
    }//receiveInfo

}
