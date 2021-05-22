package model;

public class FlagBar {
	private int rowss;
	private long sleep;
	private String color;
	private String[] rows;
	private int current = 1;
	
	public FlagBar(int rowss, String color) {
		this.rowss = rowss;		
		this.color = color;
		this.rows = new String[rowss];
		
		createFlag();
	}
	
	//------------------GETTERS N SETTERS BEGINNING------------------
	
	public int getRowss() {
		return rowss;
	}

	public void setRowss(int rowss) {
		this.rowss = rowss;
	}

	public long getTime() {
		return sleep;
	}

	public void setTime(long sleep) {
		this.sleep = sleep;
	}

	public String getColor() {
		return color;
	}

	public void setFill(String color) {
		this.color = color;
	}

	public String[] getRows() {
		return rows;
	}

	public void setRows(String[] rows) {
		this.rows = rows;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	
	public String getState() {
		String s = "";
		
		for (int i = 0; i < rows.length; i++) {
			s += rows[i] + "\u001b[m\r\n";
		}
		
		return s;
	}
	
	public boolean getFinished() {
		boolean f = false;
		
		if(rows[rows.length-1].length() < 100) {
			f = false;
		}else {
			f = true;
		}
		
		return f;
	}

	//------------------GETTERS N SETTERS END------------------

	
	//------------------OTHER METHODS BEGINNING------------------
	
	public void createFlag() {
		for(int i = 0; i < rows.length; i++) {
			rows[i] = color;
		}
		
		current = 2;
	}
	
	public void advance() {
		boolean a = false;
		
		if(!a) {
			current++;
			
			int k = 0;
			while(!a) {
				if(rows[k].length() < current + 6) {
					rows[k] += " ";
					a = true;
				}
				k++;
			}
		}
		
		int i = 0;
		while(!a) {
			if(rows[i].length() < current + 6) {
				rows[i] += " ";
				a = true;
			}
			i++;
		}
	}
	
	//------------------OTHER METHODS END------------------
}
