package voteapplet2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import voteapplet2.CandidateNode;
import voteapplet2.Header;
import voteapplet2.Footer;

/**
 * Applet pro elektronicke volby.
 * @author Tomáš Čerevka
 */
// Nastaveni promennych prostedi.
public var stageTitle: String = "Volební lístek";
public var stageX: Number = 100;
public var stageY: Number = 100;
public var scene: Scene;
public var sendButton: String = "Odeslat";
public var exitButton: String = "Zavřít";

/**
 * Metoda ridici spusteni appletu.
 */
public function run() {

    // Prectou se vstupni parametry od webove aplikace
    var voter = "voter2"; //FX.getArgument("voter").toString();
    var event = "51"; //FX.getArgument("event").toString();

    // Zahaji se komunikace s beanou.
    var communication = new Communication(voter.toString(), Integer.parseInt(event));
    communication.recieveCandidates();
    var candidates = for (i in [0..communication.getCount() - 1]) {
                println(communication.getCandidates().get(i).getLogin());
                CandidateNode {
                    login: communication.getCandidates().get(i).getLogin(),
                    firstName: communication.getCandidates().get(i).getFirstName();
                    surname: communication.getCandidates().get(i).getSurname();
                }

            };

    Stage {
        x: bind stageX, y: bind stageY,
        title: bind stageTitle,
        style: StageStyle.DECORATED,
        scene: scene = Scene {
            fill: Color.WHITE,
                    width: 320,
                    height: 480,
                    content: [
                        Header.header,
                        Footer.footer
                    ]
                }
    }

}

