package voteapplet2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Applet pro elektronicke volby.
 * @author Tomáš Čerevka
 */
// Prectou se vstupni parametry od webove aplikace
var voter = "voter2"; //FX.getArgument("voter").toString();
var event = "51"; //FX.getArgument("event").toString();
// Telo appletu.
var scene: Scene;

Stage {
    title: "Hlasovací lístek"
    style: StageStyle.DECORATED,
    scene: scene = Scene {
                width: 320
                height: 480
                content: [
                    VBox {
                        width: bind scene.width, height: bind scene.height,
                        // kazdy uzel zarovna horizontalne na stred
                        nodeHPos: HPos.CENTER,
                        // cely sloupec uzlu umisti na vertikalni stred
                        vpos: VPos.CENTER,
                        content: Group {
                            content: [
                                // Oramovani celeho obsahu.
                                Rectangle {
                                    width: bind scene.width - 10; height: bind scene.height - 10,
                                    fill: Color.WHITE, stroke: Color.BLACK, strokeWidth: 1,
                                    arcHeight: 20, arcWidth: 20
                                } // Rectangle
                                // Nadpis appletu.
                                Text {
                                    font: Font {
                                        size: 20
                                    }
                                    x: 10
                                    y: 30

                                    content: "Hlasovací lístek"
                                },
                                // Zarovnavani kandidatu do sloupce.
                                VBox {
                                    spacing: 10,
                                    content: [
                                        // Ukazkovy uzel s kandidatem.
                                        HBox {
                                            translateY: 50,
                                            width: bind scene.width - 15, height: bind scene.height - 15,
                                            hpos: HPos.CENTER;
                                            //nodeVPos: VPos.CENTER;
                                            content: [
                                                Text {
                                                    content: "Text";
                                                }, // Text
                                                Circle {
                                                    radius: 20
                                                } // Circle
                                            ] // HBox content
                                        } // HBox
                                        // Ukazkovy uzel s kandidatem.
                                        HBox {
                                            translateY: 50,
                                            width: bind scene.width - 15, height: bind scene.height - 15,
                                            hpos: HPos.CENTER;
                                            //nodeVPos: VPos.CENTER;
                                            content: [
                                                Text {
                                                    content: "Text";
                                                }, // Text
                                                Circle {
                                                    radius: 20
                                                } // Circle
                                            ] // HBox content
                                        } // HBox
                                    ] // VBox content
                                } // VBox
                            ] // Group content
                        } // Group
                    } // VBox                    
                ]
            }
}
