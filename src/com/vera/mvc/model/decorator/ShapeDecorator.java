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
public interface ShapeDecorator {
    void draw(Graphics2D g);
    void setParametr(int p);
    void setColor(Color c);
    void setFb(MyShape.FillBehavior f);
    void setShape(RectangularShape r);
    void setFrame(Point2D [] p);
    
    RectangularShape getShape();
    ShapeDecorator clone();
  
    
}
