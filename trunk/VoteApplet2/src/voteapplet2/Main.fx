package voteapplet2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import voteapplet2.CandidateNode;
import voteapplet2.Header;
import voteapplet2.Footer;
import javafx.scene.layout.VBox;

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
public var yesButton: String = "Ano";
public var noButton: String = "Ne";
public var communication: Communication;

/**
 * Metoda ridici spusteni appletu.
 */
public function run() {

    // Prectou se vstupni parametry od webove aplikace
    var voter: String = "voter2"; //FX.getArgument("voter").toString();
    var event = "153"; //FX.getArgument("event").toString();
    var host: String = "127.0.0.1"; //FX.getArgument("host").toString();
    var port: String = "3700"; //FX.getArgument("port").toString();

    // Zahaji se komunikace s beanou.    
    communication = new Communication(voter, Integer.parseInt(event), host, port);
    communication.recieveCandidates();
    var candidates = for (i in [0..communication.getCount() - 1]) {                
                CandidateNode {
                    i: i;
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
                        VBox {
                            translateY: bind scene.height / 8,
                            spacing: 10,
                            content: [
                                candidates
                            ]
                        },
                        Footer.footer,
                    ]
                }
    }

}

