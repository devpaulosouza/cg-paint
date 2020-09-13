package br.com.devpaulosouza.draw;

@SuppressWarnings("unused")
public class Coordinates {

	private long x;

	private long y;

	public Coordinates(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}
}
