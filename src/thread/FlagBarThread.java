package thread;

import model.FlagBar;
import ui.FlagBarUI;

public class FlagBarThread extends Thread{
	private FlagBar fb;
	private FlagBarUI fbu;
	private long sleep;
	
	public FlagBarThread(long sleep, FlagBar fb, FlagBarUI fbu) {
		this.sleep = sleep;
		this.fb = fb;
		this.fbu = fbu;		
	}
	
	@Override
	public void run() {
		while (!fb.getFinished()) {
			fb.advance();
			fbu.refresh();
			
			try {
				sleep(sleep);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
