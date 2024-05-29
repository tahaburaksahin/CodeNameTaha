package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;


public class NPC_Batman extends Entity{

    public NPC_Batman(GamePanel gp)
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
        up1 = setup("/npc/batman_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/batman_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/batman_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/batman_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/batman_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/batman_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/batman_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/batman_right_2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue()
    {
        dialogues[0][0] = "Finally, Our hero has come!!!\nThere are BIG PROBLEMS in the Gotham City!!\nAll heroes was kidnapped by Skeleton King";
        dialogues[0][1] = "THE ONLY HOPE IS YOU!!!\n\n                     You will save all heroes!!!";
        dialogues[0][2] = "I used to be a great fighter but now... \n\nI'm a bit too old for taking an adventure.";
        dialogues[0][3] = "You can talk with Robin before the start adventure.\n\nHe will say all details.";
        dialogues[0][4] = "\n                       Well, good luck on you.";
        dialogues[0][5] = "I have no doubt that you will succeed in this.\nDo not forget\nThe Gotham needs you <3!!!";

        dialogues[0][6] = "\n                      Go to save heroes Little kitty";

        dialogues[0][7] ="(\\__/)\n" +
                "(>'.'<)\n" +
                "(\")_(\")";
        dialogues[0][8] ="╔══╗\n" +
                "╚╗╔╝\n" +
                "╔╝(¯`v´¯)\n" +
                "╚══`.¸.[Kasia]";
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
        //ENTITY CLASS SPEAK()
        //Do this character specific stuff

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
