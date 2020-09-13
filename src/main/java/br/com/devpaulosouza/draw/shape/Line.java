package br.com.devpaulosouza.draw.shape;

import br.com.devpaulosouza.draw.Coordinates;

@SuppressWarnings("unused")
public class Line {

	private Coordinates p0;

	private Coordinates p1;

	public Line(Coordinates p0, Coordinates p1) {
		this.p0 = p0;
		this.p1 = p1;
	}

	public Line(long x0, long y0, long x1, long y1) {
		this.p0 = new Coordinates(x0, y0);
		this.p1 = new Coordinates(x1, y1);
	}

	public Coordinates getP0() {
		return p0;
	}

	public void setP0(Coordinates p0) {
		this.p0 = p0;
	}

	public Coordinates getP1() {
		return p1;
	}

	public void setP1(Coordinates p1) {
		this.p1 = p1;
	}

}
