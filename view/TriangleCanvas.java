/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @email bschwarz2@uco.edu
 * @create date 2021-09-05 13:43:05
 * @modify date 2021-09-05 13:43:05
 * @desc [OOP Lesson 2]
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Triangle;

public class TriangleCanvas extends JPanel
{
    private TriangleDrawingPanel panel;
    private ArrayList<Triangle> shapes = new ArrayList<>();

    public TriangleCanvas(TriangleDrawingPanel panel)
    {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(var s: shapes)
        {
            s.render(g2);
        }
    }

    public ArrayList<Triangle> getShapes()
    {
        return shapes;
    }
}