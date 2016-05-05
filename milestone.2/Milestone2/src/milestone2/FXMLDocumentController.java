/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

/**
 *
 * @author evanjhopkins
 */
public class FXMLDocumentController implements Initializable {
    
    //state constants
    private static final int Q1 = 1;
    private static final int Q2 = 2;
    private static final int Q3 = 3;
    private static final int Q4 = 4;
    private static final int Q5 = 5;
    private static final int Q6 = 6;
    private static final int Q7 = 7;
    private static final int Q8 = 8;
    private static final int Q9 = 9;
    private static final int Q10 = 10;
    private static final int Q11 = 11;
    private static final int Q12 = 12;
    private static final int Q13 = 13;
    private static final int Q14 = 14;
    private static final int Q15 = 15;
    private static final int Q16 = 16;
    private static final int Q17 = 17;
    private static final int Q18 = 18;
    private static final int Q19 = 19;
    private static final int Q20 = 20;
    private static final int Q21 = 21;
    private static final int Q22 = 22;
    private static final int Q23 = 23;
    
    private static final int Q24 = 24;
    private static final int Q25 = 25;
    private static final int Q26 = 26;
    private static final int Q27 = 27;
    private static final int Q28 = 28;
    private static final int Q29 = 29;
    private static final int Q30 = 30;
    private static final int Q31 = 31;
    private static final int Q32 = 32;
    private static final int Q33 = 33;
    private static final int Q34 = 34;
    private static final int Q35 = 35;
    private static final int Q36 = 36;
    private static final int Q37 = 37;
    private static final int Q38 = 38;
    private static final int Q39 = 39;
    private static final int Q40 = 40;
    private static final int Q41 = 41;
    private static final int Q42 = 42;
    private static final int QE = 43;

    //transition table
    private static final int[][] delta = {
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 Q37,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q3},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q4,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q5},
        {Q11,	 Q12,	 Q12,	 Q12,	 Q12,	 Q12,	 Q12,	 Q12,	 Q12,	 QE,	 QE,	 QE,	 QE,	 Q6,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q7},
        {QE,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q7},
        {QE,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 Q8,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q9},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q13,	 QE,	 QE,	 Q9},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q4,	 QE,	 QE,	 QE,	 QE},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q10},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q15,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 Q16,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q17},
        {QE,	 Q18,	 Q18,	 Q18,	 Q18,	 Q18,	 Q18,	 Q18,	 Q18,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 Q20,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 Q21,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 Q22,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q23,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q24},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q25,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q26},
        {Q27,	 Q29,	 Q29,	 Q29,	 Q29,	 Q29,	 Q29,	 Q29,	 Q29,	 QE,	 QE,	 QE,	 QE,	 Q31,	 QE,	 QE,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q28},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q36,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q30},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q36,	 QE},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q32},
        {QE,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q32},
        {QE,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q34},
        {QE,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 Q33,	 QE,	 QE,	 QE,	 QE,	 Q35,	 QE,	 QE,	 Q34},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q30},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 Q37,	 QE,	 QE,	 QE,	 QE,	 Q10},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q38,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE},	 	 	 	 	 	
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q39},
        {QE,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q40},
        {QE,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 Q39,	 QE,	 Q41,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q41},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q42,	 QE,	 QE,	 QE,	 QE,	 QE},
        {QE,	 Q2,	 Q19,	 Q2,	 Q2,	 Q2,	 Q2,	 Q14,	 Q2,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 Q10},
        {QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE,	 QE}
    };
      
    //ui elements
    @FXML
    private BorderPane borderPane;
    private MenuItem close;
    private MenuItem save;
    private MenuItem open;
    private MenuItem colorScheme;
    
    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void handleSave(ActionEvent event) {

    }
    
    @FXML
    //open a file and write it to the text area
    private void handleOpen(ActionEvent event) throws FileNotFoundException, IOException {
        HTMLEditor textArea = (HTMLEditor) borderPane.getScene().lookup("#textArea");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        File file = fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        
        Reader fileReader = new FileReader(file.getPath());

        String fileContent = "";
        int data = fileReader.read();
        while(data != -1) {
            fileContent = fileContent + ((char) data);
            data = fileReader.read();
        }
        fileReader.close(); 
        //parse the text
        textArea.setHtmlText(parseText(fileContent));
    }
    
    //iterate over a string and return a color coded version
    private String parseText(String text) {        
        String formattedText = "";
        int line = 0;
        int charCt = 0;
        int currentState = Q1;
        //changes depending on what color the char should be
        String color = "red";
        String numbers = "0123456789";
        String otherLetters = "bcdefghjklmoqsuwxyz";
       
        //parse all characters
        for (char ch: text.toCharArray()) { 
            //map incoming char on the current state to the next state
            System.out.println(currentState + " <-- '"+ch+"'");
            switch(""+ch) {
                case "p":
                   currentState = delta[currentState-1][2];
                   break;
                case "r":
                   currentState = delta[currentState-1][3];
                   break;
                case "i":
                   currentState = delta[currentState-1][4];
                   break;
                case "n":
                   currentState = delta[currentState-1][5];
                   break;
                case "t":
                   currentState = delta[currentState-1][6]; 
                   break;
                case "v":
                   currentState = delta[currentState-1][7];
                   break;
                case "a":
                   currentState = delta[currentState-1][8];
                   break;
                case "=":
                    currentState = delta[currentState-1][9];
                    break;
                case "-":
                    currentState = delta[currentState-1][10];
                    break;
                case "*":
                    currentState = delta[currentState-1][11];
                    break;
                case "+":
                    currentState = delta[currentState-1][12];
                    break;
                case "\"":
                    currentState = delta[currentState-1][13];
                    break;
                case "(":
                    currentState = delta[currentState-1][14];
                    break;
                case ")":
                    currentState = delta[currentState-1][15];
                    break;
                case " ":
                    currentState = delta[currentState-1][16];
                    break;
                default:
                    //is the char a number?
                    if (otherLetters.indexOf(""+ch) >= 0 ){
                        currentState = delta[currentState-1][1];
                        
                    //is the char one of the non-special characters?    
                    }else if(numbers.indexOf(""+ch) >= 0 ){
                        currentState = delta[currentState-1][0];
                        
                    //is the char a line break (special case)
                    }else if(ch=='\n' || ch=='\r'){//treat line break as space
                        line++;//increment line
                        charCt = 0;//reset char count
                        formattedText += "</br>";//break line in editor
                        break;//no state change
                    }else{
                         System.out.println("Unhandled character: '"+ch+"'");
                        currentState = QE;
                    }          
                    break;
            }
            //handle error 
            if (currentState == QE){
                //print line and char numbers
                System.out.println("Error on line "+line+" at char "+charCt);
                //break loop, no point in continuing;
                break;
            }
            //set approprite color for character based on state
            switch(currentState) {
                case QE://error
                    color = "red";
                    break;
                case Q1://actions
                case Q19:
                case Q20:
                case Q21:
                case Q22:
                case Q23:
                case Q14:
                case Q15:
                case Q16:
                    color = "blue";
                    break;
                case Q18://variables
                case Q2:
                case Q29:
                    color= "orange";
                    break;
                case Q11://hard coded numbers
                case Q35:
                case Q31:
                    color="green";
                    break;
                case Q37:
                case Q38:
                case Q39:
                case Q40:
                case Q41:
                case Q42:
                    color="gray";
                    break;
                default://other
                    color= "black";
                    break;
            }
            //append the charater to our string of formatted text
            formattedText = formattedText + "<span><font color=\""+color+"\">"+ch+"</font></span>";
            //keeping track of char for clear error reporting
            charCt++;
        }
        return formattedText;
    }
    
    //Grab the content from the text area, parse it, color it, and write it back
    @FXML
    private void parse(ActionEvent event) {
        //create reference to htmlEditor in gui
        HTMLEditor textArea = (HTMLEditor) borderPane.getScene().lookup("#textArea");
        //parse the text
        String plainText = textArea.getHtmlText().replaceAll("\\<[^>]*>","");
        //write formatted text to text area
        textArea.setHtmlText(parseText(plainText));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
