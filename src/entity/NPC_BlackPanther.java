package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;


public class NPC_BlackPanther extends Entity{

    public NPC_BlackPanther(GamePanel gp)
    {
        super(gp);
        direction = "down";
        speed = 1;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        solidAreaDefaultX = 8;
        solidAreaDefaultY = 16;

        dialogueSet = -1; //For first dialogueSet(= 0)

        getImage();
        setDialogue();
    }
    public void getImage()
    {
        // stay= setup("/npc/stay_npc",gp.tileSize,gp.tileSize);
        up1 = setup("/npc/black_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/black_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/black_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/black_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/black_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/black_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/black_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/black_right_2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue()
    {
        dialogues[0][0] = "Thank you so much, you saved our lives.";

    }
    public void setAction()
    {
        if(onPath == true)
        {
//            int goalCol = 12;
//            int goalRow = 9;

            int goalCol = (gp.player.worldX + gp.player.solidArea.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y) / gp.tileSize;
            searchPath(goalCol, goalRow);

        }
        else
        {
            actionLockCounter++;

            if(actionLockCounter == 120)
            {
                Random random = new Random();
                int i = random.nextInt(100) + 1;  // pick up  a number from 1 to 100
                if(i <= 25)
                {
                    direction = "up";
                }
                if(i>25 && i <= 50)
                {
                    direction = "down";
                }
                if(i>50 && i <= 75)
                {
                    direction = "left";
                }
                if(i>75 && i <= 100)
                {
                    direction = "right";
                }
                actionLockCounter = 0; // reset
            }
        }
    }
    public void speak()
    {


        facePlayer();
        startDialogue(this,dialogueSet);

        dialogueSet++;
        if(dialogues[dialogueSet][0] == null)
        {
            //dialogueSet = 0;
            dialogueSet--; //displays last set
        }

    }
}
