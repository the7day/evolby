package voteapplet;


import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.scene.Group;
import javafx.scene.control.ScrollBar;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



def PLUS: String = "+" ;
def MINUS: String = "-";

public var app_title: String = "";
public var app_title1: String = "";
public var token: String = "";
public var eventId: String = "";
public var login: String = "";
public var buttonEnabled = false ;
public var stageX: Number = 100;
public var stageY: Number = 100;
var receiver = new Receiver();

public var candidates: CandidateNode[];
var plusButton: PlusButton[];
var isExpanded: Boolean;
var expandedIndex: Number = -1;
var extraTranslate = 0;
public var LIST_LENGTH: Integer;



function changeIcon(curIcon: String, index: Integer){
    plusButton[index].icon = curIcon;
}

/* expanding contact details */
function expandContact(currentIndex: Integer){
    candidates[currentIndex].visibility = true;
    changeIcon(MINUS, currentIndex);
 // push all the contacts down
    for(j in [
    currentIndex + 1..LIST_LENGTH]) {
        candidates[j].translateY = 70;
        plusButton[j].translateY = 70;
    }
}

/* contracting contact details */
function shrinkContact(index: Integer){
    candidates[index].visibility = false;
    changeIcon(PLUS, index);
    for(j in [
    index + 1..LIST_LENGTH]) {
        candidates[j].translateY = 0;
        plusButton[j].translateY = 0;
    }
}
function showDetails(index: Integer){
    candidates[index].firstName = receiver.getCandidates().get(index).getFirstName();
    candidates[index].lastName = receiver.getCandidates().get(index).getLastName();
    if(index == expandedIndex ){
        shrinkContact(expandedIndex);
        buttonEnabled = false;
        expandedIndex = -1;
        extraTranslate = 0;
    }else if (expandedIndex > - 1) {
        shrinkContact(expandedIndex);
        expandContact(index);
        buttonEnabled = true;
        expandedIndex = index;
        extraTranslate = 2;
    }else {
        expandContact(index);
        expandedIndex = index;
        extraTranslate = 2;
        buttonEnabled = true;
    }
}

public var gp: Group = Group{visible: bind vis};

public var vis = false;

/* Close button in title bar */
var opacity = 0.6;
var cross = Rectangle {
    blocksMouse: true
    visible: true
    x: 215
    y: 3
    arcHeight: 4
    arcWidth: 4
    width: 20,
    height: 20
    stroke: Color.GRAY
    strokeWidth: 2
    opacity: bind opacity

    onMouseClicked: function( e: MouseEvent ):Void {
        vis = false;
    }
    onMouseMoved: function( e: MouseEvent ):Void {
        opacity = 1.0
    }
    onMouseExited: function( e: MouseEvent ):Void {
        opacity = 0.6
    }
};
/* close button 'x' in title bar */
var crosst = Text {
    visible: true
    fill: Color.WHITE
    font: Font {
        name: "Arial Bold"
        size: 18
    }
    x: 220,
    y: 19
    content: "x"
}

public function run() {
    token = FX.getArgument("token").toString();
    login = FX.getArgument("login").toString();
    eventId = FX.getArgument("eventId").toString();
    app_title = "JavaFX";
    app_title1 = "Voting card";
    receiver.setEventId(eventId);
    receiver.receive();
    LIST_LENGTH = receiver.getCount() - 1;
    for (i in [0..LIST_LENGTH]) {
        insert
            CandidateNode {
                firstName: receiver.getCandidates().get(i).getFirstName()
                lastName: receiver.getCandidates().get(i).getLastName()
                login: receiver.getCandidates().get(i).getLogin()
                yPos: i * 32
            } into candidates
        };

    for (i in [0..LIST_LENGTH]) {
        insert
            PlusButton {
                yPos: i * 32
                icon: PLUS
                onMouseClicked: function( e: MouseEvent ):Void {
                    showDetails(i);
                }
            } into plusButton
        };


    /* scroll bar on right side in contact list */
    var scroll = ScrollBar {
        translateX: 230
        translateY: 44
        height: 255
        scaleX: 0.5
        blockIncrement: 16
        clickToPosition: false
        min: 0
        max: bind LIST_LENGTH + extraTranslate
        vertical: true
    };

    var rect_height: Integer = 32;
    var candidateList: Group = Group {
        translateY: bind 0 - scroll.value * rect_height
        content: [ candidates, plusButton ]
    } ;

    Stage {
        x: bind stageX
        y: bind stageY
        title: "Voting card"
        width: 240
        height: 320
        style: StageStyle.TRANSPARENT
        scene: Scene {
            fill: Color.BLACK
            content: [
                candidateList, scroll,
                Footer.footer,  Header.header
            ]
        }
    }
}
