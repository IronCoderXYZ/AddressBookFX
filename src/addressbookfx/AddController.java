package addressbookfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {
    
    @FXML private TextField fNameTF, lNameTF, phoneTF, cityTF, zipTF;
    
    private AddressBookFX addressBookFX;
    private Stage stage;
    private Person person;
    
    private Boolean addPressed = false;
    
    public void setMain(AddressBookFX addressBookFX, Stage stage, Person person) {
        this.addressBookFX = addressBookFX;
        this.stage = stage;
        this.person = person;
        
        if (person != null) {
            inEditMode();
        }
    }
    
    public Boolean addFinished() {
        return addPressed;
    }
    
    public void inEditMode() {
        fNameTF.setText(person.getFirstName());
        lNameTF.setText(person.getLastName());
        phoneTF.setText(person.getPhone());
        cityTF.setText(person.getCity());
        zipTF.setText(person.getZIP());
    }
     
     @FXML
     public void addPressed() {
         if (person != null) {
            person.setFirstName(fNameTF.getText());
            person.setLastName(lNameTF.getText());
            person.setPhone(phoneTF.getText());
            person.setCity(cityTF.getText());
            person.setZIP(zipTF.getText());
            addPressed = true;
         } else {
            Person person = new Person(
            fNameTF.getText(),
            lNameTF.getText(),
            phoneTF.getText(),
            cityTF.getText(),
            zipTF.getText()
            );
            addressBookFX.getContactList().add(person);
         }
         stage.close();
     }
     
     @FXML
     public void cancelPressed() {
         stage.close();
     }
     
}
