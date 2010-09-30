/*
 * Footer.fx
 *
 * Created on 24.10.2009, 14:05:34
 */
package voteapplet;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import voteapplet.Main;

/**
 * @author lordondrak
 */
var dialog1 = Dialog {
            x: 150
            y: 320
            title: "Voting card has benn successfully send to server"
            content: [
                Rectangle { x: 20 y: 20 width: 50 height: 50 fill: Color.RED }
            ]
        }
public var buttonEnabled: Boolean = true;
public var footer: Group = Group {
            translateY: 300
            content: [
                Rectangle {
                    blocksMouse: true
                    height: 20
                    width: 238
                    fill: Color.BLACK
                },
                dialog1,
                Rectangle {
                    opacity: 0.5
                    x: 10,
                    y: 2
                    width: 100,
                    height: 16
                    arcHeight: 5
                    arcWidth: 5
                    cursor: Cursor.HAND
                    blocksMouse: true
                    fill: LinearGradient {
                        startX: 0.0
                        startY: 0.0
                        endX: 0.0
                        endY: 1.0
                        stops: [
                            Stop {
                                color: Color.AQUA
                                offset: 0.0
                            },
                            Stop {
                                color: Color.DARKBLUE
                                offset: 0.5
                            },
                            Stop {
                                color: Color.AQUA
                                offset: 1.0
                            },
                        ]
                    }
                    onMouseClicked: function (e: MouseEvent): Void {
                        FX.exit();
                    }
                },
                Text {
                    fill: Color.WHITE
                    font: Font {
                        name: "Arial Bold"
                        size: 12
                    }
                    x: 50,
                    y: 15
                    content: "Exit"
                },
                // second footer button
                Rectangle {
                    opacity: 0.5
                    x: 120,
                    y: 2
                    width: 100,
                    height: 16
                    arcHeight: 5
                    arcWidth: 5
                    cursor: Cursor.HAND
                    blocksMouse: true
                    fill: LinearGradient {
                        startX: 0.0
                        startY: 0.0
                        endX: 0.0
                        endY: 1.0
                        stops: [
                            Stop {
                                color: Color.AQUA
                                offset: 0.0
                            },
                            Stop {
                                color: Color.DARKBLUE
                                offset: 0.5
                            },
                            Stop {
                                color: Color.AQUA
                                offset: 1.0
                            },
                        ]
                    }
                    onMouseClicked: function (e: MouseEvent): Void {
                        //send voting card
                        var results = new ResultSet();
                        for (i in [0..Main.LIST_LENGTH]) {
                            results.add(Main.candidates[i].login, Main.candidates[i].firstName,
                            Main.candidates[i].lastName, Main.candidates[i].vote);
                        }
                        if (sendResults(results))
                            FX.exit();

                    }
                },
                Text {
                    fill: Color.WHITE
                    font: Font {
                        size: 12
                        name: "Arial Bold"
                    }
                    x: 155,
                    y: 15
                    content: "Send"
                }
            ]
        }

function sendResults(results: ResultSet): Boolean {
    var sender = new Sender(results, Main.eventId, Main.token, Main.login);
    sender.send();
    return true;
}

