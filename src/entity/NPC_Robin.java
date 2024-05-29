package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;


public class NPC_Robin extends Entity{

    public NPC_Robin(GamePanel gp)
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
        up1 = setup("/npc/robin_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/robin_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/robin_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/robin_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/robin_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/robin_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/robin_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/robin_right_2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue()
    {
        dialogues[0][0]= "If you have not talk with Batman yet.\nGo to Batman and talk with him first.\nBecause you can be confuse all situation !!!!!";

        dialogues[1][0]="\n                    Let's start the ADVENTURE !!!!";
        dialogues[1][1] ="Hello,I am Robin.I will help you!!\nDo not worry and everything will be good.\nJust LISTEN carefully.";
        dialogues[1][2] ="You know, you must kill all monsters.\n\nIt will be hard but you can do it !!!!.";
        dialogues[1][3] ="First, you have to take the axe then cut some trees\nAnd you will find lantern.Because the night is coming.\nAnd do not forget take the tent!!!.";
        dialogues[1][4] ="The lantern will help you under the dark and cave.\n\nWhen you took the lantern,come to me!!! ";

        dialogues[2][0]="Excellent!! By the way, I forgot to say on previous\nconversation.The lake is recover your life and mana.\nAnd quick trick, press X,Space and M on the keyboard. ";
        dialogues[2][1]="Okay,Next step is;\n -Go to kill small monsters and take all keys-\nWhen you kill monster,you will be strong and undefeated" ;
        dialogues[2][2]="And you will see dry tree you know what will you do\nJust in case I will say you cut these and go to hunk.\n                    There is big surprise for you.";
        dialogues[2][3]="\n                    After hunk ,come to me !!!";


        dialogues[3][0]="Commissioner Gordon being Commissioner Gordon.\nBut in my opinion, He is totally right.\nWhat is the point of playing if i tell you all the details?  ";
        dialogues[3][1]="\n                          Drink adventure in!!!! ";


    }
    public void setAction()
    {
        if(onPath == true)
        {
//           int goalCol = 12;
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
