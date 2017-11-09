package controller;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.ValidationObject.AbstractComponentValidationObject;
import com.github.jlarrieux.main.ValidationObject.JavaFXValidationObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Cryptographer;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.util.ArrayList;



@Log
public class Controller {
    private JFXTextField inputTextField, keyTextField, resultTextField;
    private JFXButton encrypt, decrypt;
    private JFXComboBox algorithmComboBox;
    private Stage stage;
    private String input, key, algorithm;


    public Controller(Stage primaryStage){
        this.stage = primaryStage;
        initialize();
    }


    private void initialize(){
        inputTextField = (JFXTextField) lookup("#inputTextField");
        keyTextField = (JFXTextField) lookup("#keyTextField");
        resultTextField = (JFXTextField) lookup("#resultTextField");

        algorithmComboBox = (JFXComboBox) lookup("#algorithmComboBox");
        algorithmComboBox.getItems().addAll(Cryptographer.CIPHER.BLOWFISH.toString());
//        algorithmComboBox.getItems().addAll(Cryptographer.CIPHER.class.getEnumConstants());
        algorithmComboBox.getSelectionModel().selectFirst();

        encrypt = (JFXButton) lookup("#encryptButton");
        decrypt = (JFXButton) lookup("#decryptButton");

        encrypt.addEventHandler(ActionEvent.ACTION, event -> encrypt());
        decrypt.addEventHandler(ActionEvent.ACTION, event -> decrypt());
    }


    private Node lookup(String name){
        return stage.getScene().lookup(name);
    }

    private void encrypt(){

        if( !validate()){
            populate();
            resultTextField.setText(Cryptographer.encrypt(input,key,algorithm));
        }

    }


    private void decrypt(){
        if(!validate()){
            populate();
            resultTextField.setText(Cryptographer.decrypt(input, key, algorithm));
        }
    }


    private boolean validate(){
        NumericValidator validator = new NumericValidator();
        ArrayList<AbstractComponentValidationObject> validationObjects = new ArrayList<>();
        validationObjects.add(new JavaFXValidationObject(inputTextField,"Input Text Field", NumericValidator.NumberType.Plain));
        validationObjects.add(new JavaFXValidationObject(keyTextField, "Key Text Field", NumericValidator.NumberType.Plain));

        return validator.validate(validationObjects);
    }



    private void populate(){
        input = inputTextField.getText();
        key = keyTextField.getText();
        algorithm =  algorithmComboBox.getSelectionModel().getSelectedItem().toString();

    }

}
