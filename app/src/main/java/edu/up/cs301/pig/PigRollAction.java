package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by perryma18 on 2/24/2016.
 */
public class PigRollAction extends GameAction {


    private int diceRoll;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PigRollAction(GamePlayer player) {
        super(player);
    }
}
