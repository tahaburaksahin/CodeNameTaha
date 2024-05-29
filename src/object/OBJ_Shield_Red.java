package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Red extends Entity {

    public static final String objName = "Red Shield";

    public OBJ_Shield_Red(GamePanel gp) {
        super(gp);

        type = type_shield;
        name = objName;
        down1 = setup("/objects/shield_red",gp.tileSize,gp.tileSize);
        defenseValue = 2;
        description = "[" + name + "]\nA shiny red shield.";
        price = 150;
    }
}
