import processing.core.PApplet;
import processing.core.PImage;

public class Hero {
	
	private int x; 
	private int y; 
	int numberBullets;//number of bullets
	Bullet bullet;
	private PImage theHero;
	private PApplet app;

	
	public Hero(int x, int y, int numberBullets, PApplet app){
		this.x = x;
		this.y = y;
		this.app = app;
	

		this.theHero= app.loadImage("../img/hero.png");
		this.numberBullets = numberBullets;
		
		}

	public void paint(PApplet app) {
		
		 this.app.image(theHero, x, y, 30, 30);
		 
		
		if(bullet != null) {
			bullet.paint(app);
			bullet.move();
		}
		
	}
	
	public void move(int tecla) {
		switch(tecla) {
		
		case 'a':
			x-=5;
			break;
		
		case 'd':
			x+=5;
			break;
		}
		
	}
	
	public void shot() {	
		bullet = new Bullet(x, y);
	
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
	
	public Bullet getBullet() {
		return bullet;
	}
	

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}


	

}
