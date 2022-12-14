package advent.of.code.day10;

public class Sprite {
    private int spritePosition = 2;

    public void moveSpritePosition(int positionToMove){
        spritePosition += positionToMove;
    }

    public boolean isInSprite(int cycle){
        return  (spritePosition == cycle || spritePosition -1 == cycle || spritePosition + 1 == cycle);
    }
}
