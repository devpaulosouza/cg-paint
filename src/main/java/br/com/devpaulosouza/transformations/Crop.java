package br.com.devpaulosouza.transformations;

import br.com.devpaulosouza.draw.Coordinates;

public interface Crop {

	void crop(long x0, long y0, long x1, long y1);

	void crop(Coordinates p0, Coordinates p1);

}
