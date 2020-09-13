package br.com.devpaulosouza.draw.algorithm;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.shape.Line;

public interface DrawLine extends Drawer {

	void draw(long x1, long y1, long x2, long y2);

	void draw(Coordinates p0, Coordinates p1);

	void draw(Line line);

}
