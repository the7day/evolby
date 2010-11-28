/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplet2;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import voteapplet2.Main;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;

/**
 * Nadefinovani hlavicky appletu.
 * @author Tomáš Čerevka
 */
var stageInitialX: Number;
var stageInitialY: Number;
public var header = Group {
            content: [
                Rectangle {
                    x: 0; y: 0;
                    width: bind Main.scene.width, height: bind Main.scene.height / 9,
                    blocksMouse: true,
                    fill: LinearGradient {
                        startX: 0.0, startY: 0.0,
                        endX: 0.0, endY: 1.0,
                        proportional: true,
                        stops: [
                            Stop { offset: 0.0, color: Color.web("#99ddff") },
                            Stop { offset: 1.0, color: Color.web("#337799") },
                        ] // fill - linear gradient - stops
                    }, // fill - linear gradient
                    effect: DropShadow {
                        color: Color.BLACK
                        radius: 10
                    }
                    onMousePressed: function(e: MouseEvent) {
                        stageInitialX = e.screenX - Main.stageX;
                        stageInitialY = e.screenY - Main.stageY;
                    }, // on mouse pressed
                    onMouseDragged: function(e: MouseEvent) {
                        Main.stageX = e.screenX - stageInitialX;
                        Main.stageY = e.screenY - stageInitialY;
                    } // on mouse dragged
                }, // rectangle
                HBox {
                    width: bind Main.scene.width, height: bind Main.scene.height / 9,
                    hpos: HPos.CENTER,
                    nodeVPos: VPos.CENTER,
                    content: Text {
                        font: Font {
                            size: 20,
                            name: "Arial Bold",
                        } // hbox - content - text - font                        
                        fill: Color.WHITE,
                        content: bind Main.stageTitle,
                    } // content - hbox
                } // hbox
            ] // content - group
        } // group

    


