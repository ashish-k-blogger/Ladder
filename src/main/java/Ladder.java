class Ladder {
	
	int start;
	int end;
	
	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean isExist( int pos ) {
		return this.start == pos;
		
	}
	
	public int climb(){
		return this.end;
	}
}
