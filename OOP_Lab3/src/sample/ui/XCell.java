package sample.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import sample.transport.vehicle.Vehicle;

import java.io.IOException;
import java.net.URL;

public class XCell extends ListCell<Vehicle> {
    public static Vehicle changeVehicle = null;
    HBox hbox = new HBox();
    Label type = new Label("");
    Label name = new Label("");
    Label speed = new Label("");
    Pane pane = new Pane();
    Button del = new Button("x");
    Button change = new Button("change");

    public XCell() {
        super();
        hbox.getChildren().addAll(type, name, speed, pane, change, del);
        HBox.setHgrow(pane, Priority.ALWAYS);
        change.setOnAction(event -> {
            try {
                changeVehicle = getItem();
                URL url = new URL("file:/Users/alesh/Desktop/oop/OOP_Lab3/src/sample/change.fxml");
                Parent root = FXMLLoader.load(url);
                Stage stage = new Stage();
                stage.setTitle("Change");
                stage.setScene(new Scene(root, 330, 101));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        del.setOnAction(event -> getListView().getItems().remove(getItem()));
    }

    @Override
    protected void updateItem(Vehicle item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);

        if (item != null && !empty) {
            type.setText(item.getVehicleType() + "   ");
            name.setText(item.getVehicleModel() + "   ");
            speed.setText("speed = " + item.getSpeed());
            setGraphic(hbox);
        }
    }
}