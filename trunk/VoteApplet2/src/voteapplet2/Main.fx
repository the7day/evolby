/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package voteapplet2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author tom
 */

Stage {
    title: "Application title"
    scene: Scene {
        width: 250
        height: 80
        content: [
            Text {
                font: Font {
                    size: 16
                }
                x: 10
                y: 30
                content: "Application content"
            }
        ]
    }
}