package br.com.devpaulosouza.transformations;

import br.com.devpaulosouza.draw.Coordinates;

public interface Crop {

	void crop(Coordinates p0, Coordinates p1, Coordinates pIn, Coordinates pFin);

}
