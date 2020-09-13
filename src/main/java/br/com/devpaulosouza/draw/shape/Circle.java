package br.com.devpaulosouza.draw.shape;

import br.com.devpaulosouza.draw.Coordinates;

@SuppressWarnings("unused")
public class Circle {

	private Coordinates point;

	private long radius;

	public Circle(Coordinates point, long radius) {
		this.point = point;
		this.radius = radius;
	}

	public Circle(long xc, long yc, long radius) {
		this.point = new Coordinates(xc, yc);
		this.radius = radius;
	}

	public Coordinates getPoint() {
		return point;
	}

	public void setPoint(Coordinates point) {
		this.point = point;
	}

	public long getRadius() {
		return radius;
	}

	public void setRadius(long radius) {
		this.radius = radius;
	}
}
