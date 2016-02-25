package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState state;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx==state.getUserTurn())
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction)
        {
            int total = state.currentTotal;
            int turn = state.userTurn;
            if (turn==0)
            {
                state.player0Score+=total;
                state.userTurn=1;
            }
            else
            {
                state.player1Score+=total;
                state.userTurn=0;
            }

            state.currentTotal=0;

            return true;
        }
        else if (action instanceof PigRollAction)
        {
            Random gen = new Random();
            int dieNum = gen.nextInt(6)+1;
            int turn = state.userTurn;
            state.die=dieNum;
            if (dieNum==1)
            {
                state.currentTotal=0;
                if (turn==0)
                {
                    state.userTurn=1;
                }
                else
                {
                    state.userTurn=0;
                }

            }
            else
            {

                state.currentTotal+=dieNum;

            }
            return true;
        }
        else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState updatedState = new PigGameState(state);
        p.sendInfo(updatedState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (state.player0Score>=50)
        {
            String name = this.playerNames[0];
            return name+" Wins with a Score of: "+state.player0Score;
        }
        else if (state.player1Score>=50)
        {
            String name = this.playerNames[1];
            return name+" Wins with a Score of: "+state.player1Score;
        }
        else {
            return null;
        }

    }

}// class PigLocalGame
