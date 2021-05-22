package ui;

import model.FlagBar;
import thread.FlagBarThread;

public class FlagBarUI {
	private FlagBar fb1;
	private FlagBar fb2;
	private FlagBar fb3;
	private FlagBarThread fbth1;
	private FlagBarThread fbth2;
	private FlagBarThread fbth3;
	
	public FlagBarUI() {
		fb1 = new FlagBar(5, "\033[41m");
		fb2 = new FlagBar(5, "\033[44m");
		fb3 = new FlagBar(10, "\033[43m");
		
		fbth1 = new FlagBarThread(200, fb1, this);
		fbth2 = new FlagBarThread(500, fb2, this);
		fbth3 = new FlagBarThread(50, fb3, this);
	}
	
	public void begin() {
		fbth1.start();
		fbth2.start();
		fbth3.start();
	}
	
	public synchronized void refresh() {
		String aux = "\033" + "[2J" + fb1.getState() + fb2.getState() + fb3.getState();
		System.out.println(aux);
	}
}
