package esercizioA;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;


public class ThreadCollaborative implements Runnable {    
	private static AtomicInteger current = new AtomicInteger(1);
    private static int N;
    
    public ThreadCollaborative(int N) {        
    	ThreadCollaborative.N = N;
    }
    
    @Override    
    public void run() {
        while (true) {            
        	int num = current.getAndIncrement();  
            if (num > N) {                
            	break;  
            }            
            System.out.println(Thread.currentThread().getName() + " printed: " + num);
        }    
    }
    
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
		 
		System.out.print("Scrivi quanti thread vuoi realizzare ");
        int T = scanner.nextInt();
        
        System.out.print("Scrivi fino a quanto deve contare ogni thread ");
        int n = scanner.nextInt();
    	
       
        for (int i = 0; i < T; i++) {
            Thread thread = new Thread(new ThreadCollaborative(N));            
            thread.start();
        }    
    }
}