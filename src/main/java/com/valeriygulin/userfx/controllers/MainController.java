package com.valeriygulin.userfx.controllers;

import com.valeriygulin.userfx.App;
import com.valeriygulin.userfx.model.User;
import com.valeriygulin.userfx.repository.UserRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    public ComboBox<User> comboBoxUsers;
    public ListView<User> listViewUsers;

    private UserRepository userRepository = new UserRepository();

    public File fileSaver;

    @FXML
    public void initialize() {
        /*try {
            UserRepository userRepository = new UserRepository(Constants.USERS_URL);
            this.comboBoxUsers.setItems(FXCollections.observableList(userRepository.getUserList()));
            this.listViewUsers.setItems(FXCollections.observableList(
                    new UserRepository().getUserList()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


    @FXML
    public void buttonSave(ActionEvent actionEvent) {
        try {
            User selectedItem = this.comboBoxUsers.getSelectionModel().getSelectedItem();
            if (selectedItem == null) {
                App.showAlert("Error!", "Select user", Alert.AlertType.ERROR);
                return;
            }
            this.listViewUsers.getItems().add(selectedItem);
            this.userRepository.add(selectedItem);
            this.comboBoxUsers.getItems().remove(selectedItem);

        } catch (NumberFormatException e) {
            App.showAlert("Error!", "Incorrect format number", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void buttonInfo(ActionEvent actionEvent) {
        User selectedItem = this.listViewUsers.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            App.showAlert("Error!", "Select user", Alert.AlertType.ERROR);
            return;
        }
        App.showAlert("Info!", selectedItem.toString(), Alert.AlertType.INFORMATION);
    }

    @FXML
    public void buttonDelete(ActionEvent actionEvent) {
        User selectedItem = this.listViewUsers.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            App.showAlert("Error!", "Select user", Alert.AlertType.ERROR);
            return;
        }
        new UserRepository().delete(selectedItem);
        this.listViewUsers.getItems().remove(selectedItem);
        this.userRepository.delete(selectedItem);
        App.showAlert("Info!", "User successfully deleted!", Alert.AlertType.INFORMATION);

    }

    @FXML
    public void menuButtonOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter2);
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter3);
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            System.out.println(file);
        }
        try {
            UserRepository userRepository1 = new UserRepository(file);
            this.comboBoxUsers.setItems(FXCollections.observableList(userRepository1.getUserList()));
            this.listViewUsers.setItems(FXCollections.observableList(new UserRepository().getUserList()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void menuButtonSave(ActionEvent actionEvent) throws IOException {
        if (this.fileSaver == null) {
            this.menuButtonSaveAs(actionEvent);
        } else {
            this.userRepository.save(this.fileSaver);
        }
    }

    @FXML
    public void menuButtonSaveAs(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter2);
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter3);
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            this.userRepository.save(file);
            this.fileSaver = file;
        }
    }


    @Override
    public String toString() {
        return "MainController{" +
                "comboBoxUsers=" + comboBoxUsers +
                '}';
    }

    public void buttonInfo2(ActionEvent actionEvent) throws IOException {
        User selectedItem = this.listViewUsers.getSelectionModel().getSelectedItem();
        App.openWindowAndWait("second.fxml", "UserInfoController", selectedItem);
        App.showAlert("Info!", "User was checked", Alert.AlertType.INFORMATION);

    }
}
