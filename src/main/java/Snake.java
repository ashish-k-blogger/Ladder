class Snake {
	int start;
	int end;
	
	public Snake(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean isExist( int pos ) {
		return this.start == pos;
		
	}
	
	public int bite(){
		return this.end;
	}
}
