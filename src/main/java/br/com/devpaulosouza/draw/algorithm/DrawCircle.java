package br.com.devpaulosouza.draw.algorithm;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.shape.Circle;

public interface DrawCircle extends Drawer {

	void draw(long xc, long yc, long r);

	void draw(Coordinates center, long r);

	void draw(Circle circle);

}
