import processing.core.PApplet;
import processing.core.PImage;



public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");	
	}

	
	public void settings() {
		size(1000, 600);
	}
	
		//VARIABLES
		private int screen;
		//screens 
		private PImage image0;
		private PImage image1;
		private PImage image2;
		private PImage image3;
		private PImage image4;
		//lives
		private PImage live1;
		private PImage live2;
		private PImage live3;
		//player
		Hero hero;
		//enemies
		Enemy[] enemies = new Enemy[6];
		Enemy[] enemies1 = new Enemy[6];
		int BulletCounter;
		
		
	public void setup() {
		
		screen = 0;
		
		this.image0 = loadImage("../img/start.jpg");
		this.image1 = loadImage("../img/wellcome.jpg");
		this.image2 = loadImage("../img/instructions.jpg");
		this.image3 = loadImage("../img/gamescreen.jpg");
		this.image4 = loadImage("../img/sumary.jpg");
		
		this.live1 = loadImage("../img/heart.png");
		this.live2 = loadImage("../img/heart.png");
		this.live3 = loadImage("../img/heart.png");
		
		
		///////////////////////////////
		hero = new Hero(width/2, 520, 6, this);
		
		 for ( int i= 0; i < 6; i++){
			 enemies[i] = new Enemy(100*i+30,60,this);
			}
		 
		 for ( int i= 0; i < 6; i++){
			 enemies1[i] = new Enemy(100*i+300,200,this);
		    }
	}
	
	
	public void draw() {
		background(255);
		
		//switch for screens and sensitive areas for the buttons
		switch (screen) {
		
		//Start 
		case 0: {
			image(this.image0, 0, 0, 1000, 600);
			//buttons sensitive areas
			if ((mouseX > 441 && mouseX < 441 + 118 && mouseY > 316 && mouseY < 316 + 132) 
				|| (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116)) {
					cursor(HAND);
				} else {
					cursor(ARROW);
			}
		}
		break;
		
		//Welcome
		case 1: {
			image(this.image1, 0, 0, 1000, 600);
			//button sensitive area
			if (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116) {
				cursor(HAND);
			  } else {
				cursor(ARROW);
			}
		}
		break;
		
		//instructions
		case 2: {
			image(this.image2, 0, 0, 1000, 600);
			//button sensitive area
			if (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
		}
		break;
		
		//GAME SCREEN
		case 3: {
			
			image(this.image3, 0, 0, 1000, 600);
			cursor(ARROW); //sensitive area
			
			//paint player
			 hero.paint(this);
			 
			//paint lives
			image(this.live1, 110, 30, 50, 45);
			image(this.live2, 170, 30, 50, 45);
			image(this.live3, 230, 30, 50, 45);
			
			
/////////////////////////for////////////////////////
			 for ( int i= 0; i < 6; i++){
				   if(enemies[i] !=null) {
					   enemies[i].paint();
					   enemies[i].move();
					   
				 if(hero.getBullet() !=null){	   
				 if(enemies[i].validateBullet(hero.getBullet().getXBullet(),hero.getBullet().getYBullet())) {
				 enemies[i]=null;
				 BulletCounter+=1;
				 hero.setBullet(null);
					}	
				  }
				}
				  
			   }
			   
			   for ( int i= 0; i < 6; i++){
				   if(enemies1[i] !=null) {
				   enemies1[i].paint();
				   enemies1[i].move1();
				   
				   
			       if(hero.getBullet() !=null){
			  	if(enemies1[i].validateBullet(hero.getBullet().getXBullet(),hero.getBullet().getYBullet())) {
					  enemies1[i]=null;
					  BulletCounter+=1;
					  hero.setBullet(null);
					  System.out.println(enemies1[i]);
					  }	
				   }  
			     }
		       }	
//////////////////////end for /////////////////////////////	   
	
		//if player wins go to summary
		if(BulletCounter==12) {
			screen = 4; //goes to summary screen
			}	 
		
		
		//score
		
		
		
		//Player/ Hero dies
		
		
		}//end of case 3
		break;
		case 4: {
			
			image(this.image4, 0, 0, 1000, 600);
		}
		
		break;
		default:
		}
	}
    
	public void mousePressed() {

		switch (screen) {
		//switch for screens buttons
		//Start screen
		case 0: {
			if (mouseX > 441 && mouseX < 441 + 118 && mouseY > 316 && mouseY < 316 + 132) {
				screen = 3;	//goes to game screen
					}
			
			if (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116) {
				screen = 1; //goes to welcome screen
					}
		}
		break;
		
		//Welcome screen
		case 1: {
			if (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116) {
				screen = 2; //goes to instructions screen
					}
		}
		break; 
		
		//Instructions screen
		case 2: {
			if (mouseX > 885 && mouseX < 885 + 104 && mouseY > 443 && mouseY < 443 + 116) {
				screen = 3; //goes to game screen
					}
		}
		break; 
		
		//GAME SCREEN
		case 3: {
		//the hero shots here	
			hero.shot();
			
		}
		
		break; 
		default:
			}
	}
	
	
public void keyPressed() {
		
		hero.move(key);
	
	}
	
	
	

	
}//FINAL
