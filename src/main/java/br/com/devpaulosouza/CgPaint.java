package br.com.devpaulosouza;

import br.com.devpaulosouza.draw.algorithm.DrawCircle;
import br.com.devpaulosouza.draw.algorithm.strategies.DrawCircleBresenham;
import br.com.devpaulosouza.plotter.debug.DebugPlotter;

public class CgPaint {

    public static void main(String[] args) {

        DrawCircle drawCircle = new DrawCircleBresenham(new DebugPlotter(","));

    drawCircle.draw(50,50,25);

//        DrawLine drawLine = new DrawLineBresenham(new DebugPlotter());
//
//        drawLine.draw(5, 2, 100, 70);

    }

}
