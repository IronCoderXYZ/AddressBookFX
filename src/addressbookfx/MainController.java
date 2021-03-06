package addressbookfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML TableView<Person> tableView;
    @FXML TableColumn<Person, String> fNameCol;
    @FXML TableColumn<Person, String> lNameCol;
    @FXML Label fNameLabel, lNameLabel, phoneLabel, cityLabel, zipLabel;
    
    private AddressBookFX addressBookFX;
    
    public void initialize() {
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldVal, newVal) -> showDetails(newVal));
    }
    
    public void setMain(AddressBookFX addressBookFX) {
        this.addressBookFX = addressBookFX;
        tableView.setItems(addressBookFX.getContactList());
    }
    
    public void refreshTableView() {
        tableView.setItems(null);
        tableView.layout();
        tableView.setItems(addressBookFX.getContactList());
    }
    
    public void showDetails(Person person) {
        fNameLabel.setText(person.getFirstName());
        lNameLabel.setText(person.getLastName());
        phoneLabel.setText(person.getPhone());
        cityLabel.setText(person.getCity());
        zipLabel.setText(person.getZIP());
    }
    
    @FXML
    public void addPressed() {
        addressBookFX.addWindow(null);
    }
    
    @FXML
    public void editPressed() {
        Person person = tableView.getSelectionModel().getSelectedItem();
        Boolean addPressed = addressBookFX.addWindow(person);
        if (addPressed) {
            refreshTableView();
        }
    }
    
    @FXML
    public void deletePressed() {
        int index = tableView.getSelectionModel().getSelectedIndex();
        addressBookFX.getContactList().remove(index);
    }
}
