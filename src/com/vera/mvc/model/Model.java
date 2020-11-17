/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import com.vera.mvc.model.decorator.MyShape;
import com.vera.mvc.model.decorator.ShapeDecorator;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Wera
 */
public class Model extends Observable {

    ShapeDecorator currentShape;
    ShapeDecorator sampleShape;
    ArrayList<ShapeDecorator> list;

    public void setSampleShape(ShapeDecorator sampleShape) {
        this.sampleShape = sampleShape;
    }

    public Model() {
        list = new ArrayList<>();
    }

    public Model(ShapeDecorator sampleShape) {
        this.sampleShape = sampleShape;
        list = new ArrayList<>();
    }

    public void inintCurrentShape() {
        currentShape = sampleShape.clone();
        list.add(currentShape);
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        if (list != null) {
            for (ShapeDecorator s : list) {
                s.draw(g);
            }
        }
    }

}
