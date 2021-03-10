import processing.core.PApplet;

public class Bullet {

    private int xBullet;
    private int yBullet;
	
   Bullet (int xBullet, int yBullet){
	   this.xBullet = xBullet;
	   this.yBullet = yBullet;
	  
   }
   
   void paint (PApplet app) {
	   app.fill (255);
	   app.stroke(255);
	   app.rect(xBullet,yBullet,8,18);
	   app.stroke(255);
	   
   }
   
   void move () {
			yBullet-=8;
	}
   
   public void setXBullet(int x) {
		this.xBullet = x;
	}
	public void setYBullet(int y) {
		this.yBullet = y;
	}
	
	
	//Gets
	public int getXBullet() {
		return xBullet;
	}
	public int getYBullet() {
		return yBullet;
	}

}
