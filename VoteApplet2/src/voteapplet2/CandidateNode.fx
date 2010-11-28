package voteapplet2;

import javafx.scene.CustomNode;
import javafx.scene.Node;
import javafx.geometry.HPos;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.layout.Tile;
import voteapplet2.VoteButton;
import voteapplet2.Main;

/**
 * Trida tvorici uzly jednotlivych kandidatu.
 * @author Tomáš Čerevka
 */
public class CandidateNode extends CustomNode {

    public var i: Integer;
    public var login: String;
    public var firstName: String;
    public var surname: String;
    public var elected: Boolean = false on replace old {
        println("Kandidat {firstName} {surname} ({login}) změněn na stav: {if (elected) "zvolen" else "nezvolen"}");
        Main.communication.setElected(this.i, this.elected);
    };

    /**
     * Vytvoreni noveho uzlu kandidata.
     */
    public override function create(): Node {
        super.create();
        return Tile {
                    columns: 2, rows: 1,

                    nodeHPos: HPos.RIGHT,
                    //hgap: 100
                    //width: bind scene.width - 15, height: bind scene.height - 15,
                    //hpos: HPos.CENTER;
                    //nodeVPos: VPos.CENTER,
                    content: [
                        Text {
                            content: this.firstName.concat(" ").concat(this.surname),
                            font: Font {
                                size: 16
                            }
                        }, // Text
                        /*
                        Circle {
                        radius: 15,
                        //translateX: bind scene.width - 130,
                        } // Circle
                         */
                        VoteButton {
                            elected: false,
                            candidate: this
                        }
                    ] // HBox content
                } // HBox
    }

}
