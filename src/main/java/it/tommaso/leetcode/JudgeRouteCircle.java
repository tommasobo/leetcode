package it.tommaso.leetcode;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tommaso Bonato
 *
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 */
class JudgeRouteCircle {

    private Point position = new Point();


    /**
     * We simply check if the final point is (0,0) after calculating each move.
     * Space complexity: O(1) -> No additionals structures required
     * Time complexity: O(n) -> Obviously we need to iterate each move once
     *
     * @param moves Moves of the robot
     * @return whether it goes back to the starting point (0,0)
     */
    boolean backToOriginSimple(String moves){
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                position.setLocation(position.getX(), position.getY() + 1);
            } else if (c == 'D') {
                position.setLocation(position.getX(), position.getY() - 1);
            } else if (c == 'R') {
                position.setLocation(position.getX() + 1, position.getY());
            } else if (c == 'L') {
                position.setLocation(position.getX() - 1, position.getY());
            }
        }

        return position.getX() == 0 && position.getY() == 0;
    }


    /**
     * We store each move in an hashmap and see if at the end there is an equal number of opposite moves.
     * Probably slow for small cases since it requires an additional data structure.
     * Space complexity: O(n) -> Worst case we need a hashmap of size n
     * Time complexity: O(n) -> Obviously we need to iterate each move once
     *
     * @param moves Moves of the robot
     * @return whether it goes back to the starting point (0,0)
     */
    boolean backToOrigin(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }

        Map<Character, Integer> setMoves = new HashMap<>();
        setMoves.put('D', 0); setMoves.put('U', 0); setMoves.put('L', 0); setMoves.put('R', 0);
        for (char c : moves.toCharArray()) {
            setMoves.put(c, setMoves.get(c) + 1);
        }

        return (setMoves.get('U').equals(setMoves.get('D'))) && (setMoves.get('L').equals(setMoves.get('R')));
    }
}
