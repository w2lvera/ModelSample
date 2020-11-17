/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class MyShape implements ShapeDecorator{

    Color color;
    RectangularShape shape;
    FillBehavior fb;
    

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.BLUE;
        fb = FillBehavior.NO_FILL;
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb =  FillBehavior.NO_FILL;;
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    @Override
    public void draw(Graphics2D g) {
        fb.draw(g,color,shape);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyShape.FillBehavior getFb() {
        return fb;
    }

    public ShapeDecorator clone() {
        ShapeDecorator s = new MyShape();       
        RectangularShape s1 = (RectangularShape) shape.clone();      
        ((MyShape)s).setColor(color);
       ((MyShape)s).setShape(s1);
       ((MyShape)s).fb = this.fb; 
        return s;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void setParametr(int p) {
        
    }

    @Override
    public RectangularShape getShape() {
        return shape;
    }

    
   

    /////////////////////inner enum/////////////////////////////////////
    
    public enum FillBehavior {
        FILL {
            @Override
            public void draw(Graphics2D g,  Color c, RectangularShape sh) {
                  Paint paint = g.getPaint();
                  g.setPaint(c);
                  g.fill(sh);
                  g.setPaint(paint);
            }
        } ,
        NO_FILL {
            @Override
            public void draw(Graphics2D g, Color c, RectangularShape sh) {
                 Paint paint = g.getPaint();
                 g.setPaint(c);
                 g.draw(sh);
                 g.setPaint(paint);
            }
        };
        public abstract void  draw(Graphics2D g, Color c, RectangularShape sh);        
        
    }

    
}
