package voteapplet2;

import javafx.scene.CustomNode;
import javafx.scene.Node;
import javafx.geometry.HPos;
import javafx.scene.text.Text;
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
                    content: [
                        Text {
                            content: this.firstName.concat(" ").concat(this.surname),
                            font: Font {
                                size: 16
                            }
                        }, // Text                       
                        VoteButton {
                            elected: false,
                            candidate: this
                        }
                    ] // HBox content
                } // HBox
    }

}
