package org.jbp.psh.vo;

public class PageVO {
	
	private int start, end;
	
	public PageVO() {
		// TODO Auto-generated constructor stub
	}
	
	public Object get(String name) {
		switch(name) {
			case "start":return start;
			case "end":return end;
		}
		return null;
	}
	
	public PageVO(int page, int numPage) {
		end = page * numPage;
		start = end-numPage+1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	

}
