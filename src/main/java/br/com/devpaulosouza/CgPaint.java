package br.com.devpaulosouza;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.algorithm.DrawCircle;
import br.com.devpaulosouza.draw.algorithm.DrawLine;
import br.com.devpaulosouza.draw.algorithm.strategies.DrawCircleBresenham;
import br.com.devpaulosouza.draw.algorithm.strategies.DrawLineBresenham;
import br.com.devpaulosouza.draw.algorithm.strategies.DrawLineDda;
import br.com.devpaulosouza.plotter.debug.DebugPlotter;
import br.com.devpaulosouza.transformations.Crop;
import br.com.devpaulosouza.transformations.strategies.CropCohenSutherland;

public class CgPaint {

    public static void main(String[] args) {

//        DrawCircle drawCircle = new DrawCircleBresenham(new DebugPlotter(","));

//        drawCircle.draw(3,4,6);

        DrawLine drawLine = new DrawLineDda(new DebugPlotter());

        Crop crop = new  CropCohenSutherland(new DebugPlotter());


        Coordinates c1 = new Coordinates(0, 1);
        Coordinates c2 = new Coordinates(8, 7);
        Coordinates cin = new Coordinates(-1, -2);
        Coordinates cFin = new Coordinates(6, 7);

        crop.crop(c1, c2, cin, cFin);

//
//        drawLine.draw(-1, -2, 6, 7);
//        drawLine.draw( 5, 7,-1, 4);
//        drawLine.draw(-1, 4, 3, 8);
//        drawLine.draw(2, 0, 6, 0);
//        drawLine.draw(1, 3, 1, 6);

    }

}
