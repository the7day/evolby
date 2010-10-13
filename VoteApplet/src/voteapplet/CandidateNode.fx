/*
 * CandidateNode.fx
 *
 * Created on 24.10.2009, 13:33:58
 */

package voteapplet;

import javafx.scene.CustomNode;

import javafx.scene.Node;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import javafx.scene.input.MouseEvent;


/**
 * @author lordondrak
 */

public class CandidateNode extends CustomNode {

        public var firstName: String;
        public var lastName: String;
        public var login:String;
        var xPos: Number;
        public var yPos: Number;
        public var visibility: Boolean = false;
        public var vote: Boolean = false;
        var opacYes:Number = 0.3;
        var opacNo:Number = 1;
        var opacTextYes:Number = 0.7;
        var opacTextNo:Number = 1;

        var votingButtons: Group = Group {
            // buttosns YES NO , default NO
            visible: bind visibility
            content:[ YesButton {
                        yPos: 50
                        opac: bind opacYes
                        opacText: bind opacTextYes
                        onMouseClicked: function( e: MouseEvent ):Void {
                            vote = true;
                            opacYes = 1;
                            opacNo = 0.3;
                            opacTextYes = 1;
                            opacTextNo = 0.7;
                        }
                    },
                      NoButton {
                        yPos: 50
                        opac: bind opacNo
                        opacText: bind opacTextNo
                        onMouseClicked: function( e: MouseEvent ):Void {
                            vote = false;
                            opacYes = 0.3;
                            opacNo = 1;
                            opacTextYes = 0.7;
                            opacTextNo = 1;
                        }
                    }
                    ]

        }

        public override function create(): Node {
                return Group {
                    translateX: xPos
                    translateY: yPos - 5
                    content: [
                        votingButtons,
                        Rectangle {
                            x: 5,
                            y: 50
                            opacity: 0.7
                            width: 220,
                            height: 30
                            fill: LinearGradient {
                                startX: 0.0
                                startY: 0.0
                                endX: 0.0
                                endY: 1.0
                                stops: [
                                Stop {
                                    color: Color.DARKGREEN
                                    offset: 0.0
                                },
                                Stop {
                                    color: Color.YELLOWGREEN
                                    offset: 0.3
                                },
                                Stop {
                                    color: Color.DARKGREEN
                                    offset: 1.0
                                },
                            ]
                        }
                        stroke: Color.GRAY
                    },
                    Text {
                        fill: Color.WHITE
                        font: Font {
                            size: 12
                            name: "Arial Bold"
                        }
                        x: 20,
                        y: 70
                        content: firstName.concat(" ").concat(lastName)
                    }
                ]
            };
        }


}
