/*
 * YesButton.fx
 *
 * Created on 24.10.2009, 15:04:58
 */

package voteapplet;

import javafx.scene.CustomNode;

import javafx.scene.Node;

import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.shape.Circle;

/**
 * @author lordondrak
 */

public class YesButton extends CustomNode{

        public var yPos: Number;
        public var xPos: Number;
        public var color: Color;
        public var opac: Number;
        public var opacText: Number;

         public override function create(): Node{

             return Group{
                translateX: xPos
                translateY: yPos
                content: [
                    Circle {
                        centerX: 78 centerY: 66 radius: 25
                        fill: Color.LIGHTGREEN
                        stroke: Color.DARKGREEN
                        strokeWidth: 4
                        opacity: bind opac
                    },
                    Text {
                        fill: Color.GREEN
                        opacity: bind opacText
                        font: Font {
                            size: 15
                            name: "Arial Bold"
                        }
                        x: 63,
                        y: 72
                        content: "YES"
                        },
                    ]
                }

         }

}
