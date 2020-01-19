package Main;




public class Launcher {
	//starts the game
		public static int resX;
		public static int resY;
		public static void main(String[] args) {
		    resX = 800;
		    resY = 600;
		    
			Engine En = new Engine("Pixel Editor",(int)resX,(int) resY);
			En.start();
		}
		public static int getResX() {
			return resX;
		}
		public static int getResY() {
			return resY;
		}

	}