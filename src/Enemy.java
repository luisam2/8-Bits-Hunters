import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {

	private int x; 
	private int y; 
	private PImage enemy;
	private PApplet app;
    boolean validateBullet;
	
	
	public Enemy (int x, int y, PApplet app){
		this.x = x;
		this.y = y;
		this.app= app;
		
	this.enemy= app.loadImage("../img/marciano.png");
	}

	public void paint() {
		
      this.app.image(enemy, x, y, app.width/25, app.height/25);
		
	}
	
	public boolean validateBullet(int xBullet, int yBullet) {
		
		if(xBullet > x && xBullet < x + 70 &&
		   yBullet > y && yBullet < y + 70) {
			return true;	
		}
		return false;	
	}
	
	public void move() {
		
		y+= 1;
		
		if (y > 600) {
			y=0;
		} 
	}
	
   public void move1() {
		
		y-= 1;
		
		if (y <0) {
			y=900;
		} 
	}
   
   public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	//Gets
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
