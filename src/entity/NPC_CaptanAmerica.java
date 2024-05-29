package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;


public class NPC_CaptanAmerica extends Entity{

    public NPC_CaptanAmerica(GamePanel gp)
    {
        super(gp);
        direction = "up";
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
        up1 = setup("/npc/npc2_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/npc2_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/npc2_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/npc2_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/npc2_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/npc2_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/npc2_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/npc2_right_2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue()
    {
        dialogues[0][0] = "How can we ever repay you? Thank you.";
        dialogues[0][1] = "But we do not have time for this";
        dialogues[0][2] = "Your mother is waiting for you.\nYou should get going before it gets too late.\nYou know the path.\nGood luck little kitty.";

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
