/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplet2;

import javafx.scene.shape.Rectangle;
import voteapplet2.Main;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;
import javafx.stage.Alert;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;

/**
 * Nadefinovani paticky appletu.
 * @author Tomáš Čerevka
 */
public var footer = HBox {
            width: bind Main.scene.width, height: bind Main.scene.height / 10,
            translateY: bind Main.scene.height - Main.scene.height / 10,
            spacing: bind Main.scene.width / 8,
            hpos: HPos.CENTER,
            nodeVPos: VPos.CENTER,
            content: [
                Group {
                    var button: Node,
                    content: [
                        button = Rectangle {
                                    width: bind Main.scene.width / 3, height: bind Main.scene.height / 15,
                                    arcWidth: 20, arcHeight: 20,
                                    cursor: Cursor.HAND,
                                    fill: LinearGradient {
                                        startX: 0.0, startY: 0.0,
                                        endX: 0.0, endY: 1.0,
                                        proportional: true,
                                        stops: [
                                            Stop { offset: 0.0, color: Color.web("#99ddff") },
                                            Stop { offset: 0.5, color: Color.web("#337799") },
                                            Stop { offset: 1.0, color: Color.web("#99ddff") },
                                        ] // stops
                                    }, // fill  
                                    effect: DropShadow {
                                        color: Color.BLACK,
                                        radius: 4,
                                    },

                                    onMouseClicked: function(e: MouseEvent) {
                                        if (Main.communication.sendVoteCard()) {
                                            Alert.inform("Hlas byl odeslan.");
                                        } else {
                                            Alert.inform("Ups, neco je spatne.");
                                        }

                                    }
                                }, // rectangle
                        HBox {
                            width: bind Main.scene.width / 3, height: bind Main.scene.height / 15,
                            hpos: HPos.CENTER, nodeVPos: VPos.CENTER,
                            content: Text {
                                font: Font {
                                    size: 14,
                                    name: "Arial Bold"
                                }
                                fill: Color.WHITE,
                                content: bind Main.sendButton,
                            }
                        }
                    ] // content - group
                }, // group
                Group {
                    content: [
                        Rectangle {
                            width: bind Main.scene.width / 3, height: bind Main.scene.height / 15,
                            arcWidth: 20, arcHeight: 20,
                            cursor: Cursor.HAND,
                            fill: LinearGradient {
                                startX: 0.0, startY: 0.0,
                                endX: 0.0, endY: 1.0,
                                proportional: true,
                                stops: [
                                    Stop { offset: 0.0, color: Color.web("#99ddff") },
                                    Stop { offset: 0.5, color: Color.web("#337799") },
                                    Stop { offset: 1.0, color: Color.web("#99ddff") },
                                ] // stops
                            }, // fill
                            effect: DropShadow {
                                color: Color.BLACK,
                                radius: 4,
                            }
                            onMouseClicked: function(e: MouseEvent) {
                                FX.exit();
                            }
                        }, // rectangle
                        HBox {
                            width: bind Main.scene.width / 3, height: bind Main.scene.height / 15,
                            hpos: HPos.CENTER, nodeVPos: VPos.CENTER,
                            content: Text {
                                font: Font {
                                    size: 14,
                                    name: "Arial Bold"
                                }
                                fill: Color.WHITE,
                                content: bind Main.exitButton,
                            }
                        }
                    ] // content - group
                } // group
            ], // hbox - conten
        } // hbox



