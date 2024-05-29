package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BlueHeart extends Entity {

    GamePanel gp;
    public static final String objName = "Blue Heart";
    public OBJ_BlueHeart(GamePanel gp)
    {
        super(gp);

        this.gp = gp;

        type = type_pickupOnly;
        name = objName;
        down1 = setup("/tiles/036", gp.tileSize, gp.tileSize);
        setDialogues();
    }
    public void setDialogues()
    {
        dialogues[0][0] = "\n                YOU SAVED ALL HEROES!!! AMAZING!!!.";
        dialogues[0][1] = "\n  You will find the hero who is the love of your LIFE !";
        dialogues[0][2] = "\n  Do not forget Your mom and Uncle Taha are waiting you!";
    }
    public boolean use(Entity entity) //when pickup this method will be called
    {
        gp.gameState = gp.cutsceneState;
        gp.csManager.sceneNum = gp.csManager.ending;
        return true;
    }

}
