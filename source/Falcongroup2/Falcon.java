import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Falcon {
	private static TimerTask myTask = null;
	private static TimerTask myTask1 = null;
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer("My Timer", false);
	    Timer timer1 = new Timer("My Timer", false);
	    int count = 5;//Countime 1 min 60000 = 60 Second
	    long delay = 1000L;
	    myTask = new MyTimerTask(count, new Runnable() {
	    	 
	         public void run() {
	        	
	            System.exit(0);
	         }
	      });
	      myTask1 = new MyTimerTask(count, new Runnable() {
	     	 
	          public void run() {
	         	
	             System.exit(0);
	          }
	       });
	        
			timer.scheduleAtFixedRate(myTask, delay, delay);
			
			Scanner Sc = new Scanner(System.in);
			Thread.currentThread();
			System.out.print("Code Start : " );
			
			String start = Sc.nextLine();
			timer.cancel();
			timer1.scheduleAtFixedRate(myTask1, delay, delay);
			System.out.print("Start (Yes or No) : ");
			String choose = Sc.nextLine();
			timer1.cancel();
			if (choose.equals("Yes") || choose.equals("YES") || choose.equals("yes")) {
				// lattitud and longtitude
				System.out.print("Coordinate: ");
				double Co = Sc.nextDouble();
			} else if (choose.equals("No") || choose.equals("NO") || choose.equals("no")) {
				System.out.print("End of program");
			} else {
				System.out.print("Error!");
			}
	      
	   }
		// Readfile();
	
	


	/*
	 * private static void Readfile() { //give path for read file String path = "";
	 * File file = new File(path); try { BufferedReader br = new BufferedReader(new
	 * FileReader(file)); String line; while ((line = br.readLine()) != null) {
	 * System.out.println(line); } br.close(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
}
class MyTimerTask extends TimerTask {
	   private int count;
	   private Runnable doWhenDone;

	   public MyTimerTask(int count, Runnable doWhenDone) {
	      this.count = count;
	      this.doWhenDone = doWhenDone;
	   }

	   @Override
	   public void run() {
	      count--;
	      
	      System.out.println("Count is: " + count);
	      if (count == 0) {
	    	 System.out.println("End");
	         cancel();
	         doWhenDone.run();
	         
	      }
	   }
	   
	   
	}