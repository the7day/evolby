/*
 * Header.fx
 *
 * Created on 24.10.2009, 14:03:18
 */

package voteapplet;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


var stageDragInitialX: Number;
var stageDragInitialY: Number;

public var header: Group = Group {
    content: [
        Rectangle{
            fill: Color.BLACK
            height: 40
            width: 240
        },
        Rectangle {
            x: 0,
            y: 0
            width: 240,
            height: 30
            blocksMouse: true
            fill: LinearGradient {
                startX: 0.0
                startY: 0.0
                endX: 0.0
                endY: 1.0
                stops: [
                    Stop {
                        color: Color.GRAY
                        offset: 0.0
                    },
                    Stop {
                        color: Color.BLACK
                        offset: 1.0
                    },
                ]
            }

            onMousePressed: function(e: MouseEvent): Void {
                stageDragInitialX = e.screenX - Main.stageX;
                stageDragInitialY = e.screenY - Main.stageY;
            }

            onMouseDragged: function(e: MouseEvent): Void {
                Main.stageX = e.screenX - stageDragInitialX;
                Main.stageY = e.screenY - stageDragInitialY;
            }
        },
        Text {
            fill: Color.WHITE
            font: Font {
                name: "Arial Bold"
                size: 14
            }
            x: 44,
            y: 24
            content: bind Main.app_title
        }
        Text {
            fill: Color.ORANGE
            font: Font {
                name: "Arial Bold"
                size: 14
            }
            x: 100,
            y: 24
            content: bind Main.app_title1
        }
    ]

}

