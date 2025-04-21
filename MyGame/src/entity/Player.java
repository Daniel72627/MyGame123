package entity;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;	
		
		setDefaultValues();
		getPlayerImage();
		
		
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 3;
		direction = Direction.DOWN_IDLE;
		lastDirection = direction;
	}
	
	public void getPlayerImage() {

			
			loadImage("slime","up",3);
			loadImage("slime","left",3);
			loadImage("slime","down",3);
			loadImage("slime","right",3);
			
			loadImage("slime","up_idle",3);
			loadImage("slime","left_idle",3);
			loadImage("slime","down_idle",3);
			loadImage("slime","right_idle",3);
			

	}
	
	public void update() {
		
		if(keyH.upPressed) {
			direction = Direction.UP;
		    lastDirection = direction;
			y -= speed;
			moving = true;
		} else if(keyH.leftPressed) {
			direction = Direction.LEFT;
		    lastDirection = direction;
			x -= speed;
			moving = true;
		} else if(keyH.downPressed) {
			direction = Direction.DOWN;
		    lastDirection = direction;
			y += speed;
			moving = true;
		} else if(keyH.rightPressed) {
			direction = Direction.RIGHT;
		    lastDirection = direction;
			x += speed;
			moving = true;
		} else {
			moving = false;
		}

		
		spriteCounter++;
		if (spriteCounter > 10) {
		    spriteNum++;

		    if (!moving) {
		    	
			    idleSpriteNum++;
		        

		        switch (lastDirection) {
		            case UP: direction = Direction.UP_IDLE; break;
		            case DOWN: direction = Direction.DOWN_IDLE; break;
		            case LEFT: direction = Direction.LEFT_IDLE; break;
		            case RIGHT: direction = Direction.RIGHT_IDLE; break;
				default:
					break;
		        }

		        
		        if (idleSpriteNum > 2) idleSpriteNum = 0;
		        spriteNum = 0;
		        spriteCounter = 0;

		    } else {
		        if (spriteNum > 2) spriteNum = 0;
		        spriteCounter = 0;
		    }
		}

		
		
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		if(direction == Direction.UP) {
			if(spriteNum == 0) {
				image = up[0];
			} else if(spriteNum == 1) {
				image = up[1];
			} else if(spriteNum == 2) {
				image = up[2];
			}
		} else if(direction == Direction.DOWN) {
			if(spriteNum == 0) {
				image = down[0];
			} else if(spriteNum == 1) {
				image = down[1];
			} else if(spriteNum == 2) {
				image = down[2];
			}
		} else if(direction == Direction.LEFT) {
			if(spriteNum == 0) {
				image = left[0];
			} else if(spriteNum == 1) {
				image = left[1];
			} else if(spriteNum == 2) {
				image = left[2];
			}
		} else if(direction == Direction.RIGHT) {
			if(spriteNum == 0) {
				image = right[0];
			} else if(spriteNum == 1) {
				image = right[1];
			} else if(spriteNum == 2) {
				image = right[2];
			}
		} 
		
		// IDLE-----------------------------------------------------------------------------------
		
		
		if(direction == Direction.UP_IDLE) {
			if(idleSpriteNum == 0) {
				image = up_idle[0];
			} else if(idleSpriteNum == 1) {
				image = up_idle[1];
			} else if(idleSpriteNum == 2) {
				image = up_idle[2];
			}
		} else if(direction == Direction.DOWN_IDLE) {
			if(idleSpriteNum == 0) {
				image = down_idle[0];
			} else if(idleSpriteNum == 1) {
				image = down_idle[1];
			} else if(idleSpriteNum == 2) {
				image = down_idle[2];
			}
		} else if(direction == Direction.LEFT_IDLE) {
			if(idleSpriteNum == 0) {
				image = left_idle[0];
			} else if(idleSpriteNum == 1) {
				image = left_idle[1];
			} else if(idleSpriteNum == 2) {
				image = left_idle[2];
			}
		} else if(direction == Direction.RIGHT_IDLE) {
			if(idleSpriteNum == 0) {
				image = right_idle[0];
			} else if(idleSpriteNum == 1) {
				image = right_idle[1];
			} else if(idleSpriteNum == 2) {
				image = right_idle[2];
			}
		} 
		
		
		//------------------------------------------------------------------------
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}

}
