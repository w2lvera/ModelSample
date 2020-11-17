/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class BorderDecorator implements ShapeDecorator{
    ShapeDecorator shape;
    int borderWidth;
    public BorderDecorator(ShapeDecorator shape) {
        this.shape = shape;
    }
    
    @Override
    public void draw(Graphics2D g) {
        RectangularShape border = (RectangularShape) shape.getShape().clone();
        Point2D left = new Point2D.Double(border.getMinX()-borderWidth, 
                border.getMinY()- borderWidth);
        Point2D right = new Point2D.Double(border.getMaxX()+borderWidth, 
                border.getMaxY()+borderWidth);
        border.setFrameFromDiagonal(left, right);
        shape.draw(g);
        g.draw(border);
    }

    @Override
    public void setParametr(int p) {
        borderWidth = p;
    }

    @Override
    public RectangularShape getShape() {
       return  shape.getShape();
    }

    @Override
    public ShapeDecorator clone() {
        BorderDecorator bd = new BorderDecorator(shape.clone());
        bd.borderWidth = borderWidth;
        return bd;
    }

    @Override
    public void setColor(Color c) {
        shape.setColor(c);
    }

    @Override
    public void setFb(MyShape.FillBehavior f) {
        shape.setFb(f);
    }

    @Override
    public void setShape(RectangularShape r) {
        shape.setShape(r);
    }

    @Override
    public void setFrame(Point2D[] p) {
        shape.setFrame(p);
    }

    
    
}
