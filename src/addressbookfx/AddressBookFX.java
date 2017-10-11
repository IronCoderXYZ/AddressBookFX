package addressbookfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddressBookFX extends Application {

    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(AddressBookFX.class.getResource("MainView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            
            MainController controller = loader.getController();
            controller.setMain(this);
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private ObservableList<Person> contactList = FXCollections.observableArrayList();
    public ObservableList<Person> getContactList() { return contactList; }
    
    public AddressBookFX() {
        contactList.add(new Person("Mike", "Bowser", "524-111-2323", "Amsterdam", "3423FD"));
        contactList.add(new Person("Anna", "Smith", "234-343-432", "Amsterdam", "3423FD"));
        contactList.add(new Person("Joe", "Harbor", "122-111-3231", "Amsterdam", "3423FD"));
        contactList.add(new Person("Marika", "Ruze", "323-222-2323", "Amsterdam", "3423FD"));
        contactList.add(new Person("Sandra", "Malik", "456-444544", "Amsterdam", "3423FD"));
        contactList.add(new Person("Jack", "Vale", "666-111-4566", "Amsterdam", "3423FD"));
        contactList.add(new Person("Felix", "Corston", "444-111-4666", "Amsterdam", "3423FD"));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
