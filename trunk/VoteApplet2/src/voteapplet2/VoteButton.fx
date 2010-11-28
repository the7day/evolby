package voteapplet2;

import javafx.scene.Node;
import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import voteapplet2.Main;

/**
 * @author Tomáš Čerevka
 */
/**
 * Tlacitko pro volbu kandidata.
 */
public class VoteButton extends CustomNode {

    public var elected: Boolean;
    public var candidate: CandidateNode;
    def yes: Node = Group {
                content: [
                    Circle {
                        radius: 15,
                        fill: RadialGradient {
                            stops: [
                                Stop { color: Color.web("#79CE75"), offset: 0.2 },
                                Stop { color: Color.web("#067A00"), offset: 0.8 }
                            ]
                        }
                    },
                    Text {
                        content: Main.yesButton,
                        fill: Color.WHITE,
                        translateX: -10,
                        translateY: 4,
                        font: Font {
                            name: "Arial Bold"
                        }

                    }


                ]
            };
    def no: Node = Group {
                content: [
                    Circle {
                        radius: 15,
                        fill: RadialGradient {
                            stops: [
                                Stop { color: Color.web("#D94444"), offset: 0.2 },
                                Stop { color: Color.web("#970000"), offset: 0.8 }
                            ]
                        }
                    },
                    Text {
                        content: Main.noButton,
                        fill: Color.WHITE,
                        translateX: -7,
                        translateY: 4,
                        font: Font {
                            name: "Arial Bold"
                        }

                    }

                ]
            };

    /**
     * Vytvoreni tlacitka pro volbu kandidata.
     */
    public override function create(): Node {
        return Group {
                    blocksMouse: true;
                    content: bind if (elected) {
                        yes
                    } else {
                        no
                    }
                    onMouseClicked: function(e: MouseEvent) {
                        elected = not elected;
                        candidate.elected = elected;
                    }
                } // group
    }

}
