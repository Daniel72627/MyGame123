package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {

	public int x,y;
	public int speed;

	public Direction lastDirection; // <-- NEW

	
	public BufferedImage[] up;
	public BufferedImage[] down;
	public BufferedImage[] left;
	public BufferedImage[] right;
	public BufferedImage[] up_idle;
	public BufferedImage[] down_idle;
	public BufferedImage[] left_idle;
	public BufferedImage[] right_idle;
	

	public Direction direction;
	public enum Direction {
	    UP, DOWN, LEFT, RIGHT, UP_IDLE, DOWN_IDLE, LEFT_IDLE, RIGHT_IDLE;
	}
	
	public int spriteCounter = 0;
	public int spriteNum = 0;
	public int idleSpriteNum = 0;
	boolean moving = false;
	
    public void loadImage(String sprite, String direction, int index) {
    	
    	
        try {
        	
    		for(int i = 0; i < index; i++) {
    			
    			
    			//---------------------------MOVEMENT--------------------------------------
    			if(direction == "up") {
    				if(this.up == null) {
    				this.up = new BufferedImage[index];
    				}
    				this.up[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "down") {
    				if(this.down == null) {
    				this.down = new BufferedImage[index];
    				}
    				this.down[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "left") {
    				if(this.left == null) {
    				this.left = new BufferedImage[index];
    				}
    				this.left[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "right") {
    				if(this.right == null) {
    				this.right = new BufferedImage[index];
    				}
    				this.right[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			}
    			
    			//-----------------------------IDLE-----------------------------------
    			
    			if(direction == "up_idle") {
    				if(this.up_idle == null) {
    					this.up_idle = new BufferedImage[index];
    				}
    				this.up_idle[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "down_idle") {
    				if(this.down_idle == null) {
    				this.down_idle = new BufferedImage[index];
    				}
    				this.down_idle[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "left_idle") {
    				if(this.left_idle == null) {
    				this.left_idle = new BufferedImage[index];
    				}
    				this.left_idle[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			} else if(direction == "right_idle") {
    				if(this.right_idle == null) {
    				this.right_idle = new BufferedImage[index];
    				}
    				this.right_idle[i] = ImageIO.read(getClass().getResourceAsStream("/" + sprite + "/sprite_" + direction + "_" + i + ".png"));
    			}
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    		}

    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
