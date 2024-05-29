package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;


public class NPC_Cop extends Entity{

    public NPC_Cop(GamePanel gp)
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
        up1 = setup("/npc/cop_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/cop_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/cop_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/cop_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/cop_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/cop_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/cop_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/cop_right_2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue()
    {
        dialogues[0][0] = "                    I am Commissioner Gordon,\n                          Nice to meet you!\n           OMG!!! you are so fast!! I am proud of you!!";
        dialogues[0][1] = "You can buy in there what you need and sell.\n\nAfter this, I have to talk with you.I will wait you.";

        dialogues[1][0] ="Listen,You have to open all door with key.After the\nfirst door,there is a big monster.The monster has helped \nkidnap our heroes.Kill this one !!!";
        dialogues[1][1] ="Then You have to open the other door.After this door\nyou will go to cave.Do not forget using lantern.\nBecause, Inside of cave is so dark.";
        dialogues[1][2] ="In the cave,There are lots of chests.You have to\nFIRST find pickaxe.I do not know which one.\nBut without this, you can not find OUR HEREOS. ";
        dialogues[1][3] ="Also there are big rock.If you move the rock wrongly\nYou will be STUCK in the cave forever.\nTherefore, Find first the pickaxe !!!";
        dialogues[1][4] ="WAIT A MINUTE!!! I was gonna say you all thing.\nI can not help you anymore.\nIt is your adventure and mission.";
        dialogues[1][5] ="GO TO SAVE YOUR HEROES !!!  No doubt you will !!!!\n\n I LOVE YOU Kasia <3     I LOVE YOU Innie <3 !!!";
    }
    public void setAction()
    {
        if(onPath == true)
        {
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
