/*
 * PlusButton.fx
 *
 * Created on 24.10.2009, 14:15:48
 */

package voteapplet;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.CustomNode;

/**
 * @author lordondrak
 */

public class PlusButton extends CustomNode{

    public var yPos: Number;
    public var xPos: Number;
    public var icon: String;
    public override function create(): Node{
        return Group{
            translateX: xPos
            translateY: yPos - 5
            content: [
                Rectangle {
                    x: 200,
                    y: 58
                    width: 15,
                    height: 15
                    arcHeight: 5
                    arcWidth: 5
                    fill: Color.TRANSPARENT
                    stroke: Color.GRAY
                    strokeWidth:2
                },
                Text {
                    fill: Color.WHITE
                    font: Font {
                        size: 12
                        name: "Arial Bold"
                    }
                    x: 205,
                    y: 70
                    content: bind icon;
                },
            ]
        }
    }
}
