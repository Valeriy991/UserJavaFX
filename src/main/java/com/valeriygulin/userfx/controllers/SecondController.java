package com.valeriygulin.userfx.controllers;

import com.valeriygulin.userfx.App;
import com.valeriygulin.userfx.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class SecondController implements ControllerData<User> {
    private User value;
    public TextField textFieldID;
    public TextField textFieldName;
    public TextField textFieldUsrName;
    public TextField textFieldEMail;
    public TextField textFieldAddress;
    public TextField textFieldPhone;
    public TextField textFieldWebsite;
    public TextField textFieldCompany;

    @Override
    public void initData(User value) {
        this.value = value;
        textFieldID.setText(String.valueOf(value.getId()));
        textFieldName.setText(value.getName());
        textFieldUsrName.setText(value.getUsername());
        textFieldEMail.setText(value.getEmail());
        textFieldAddress.setText(String.valueOf(value.getAddress()));
        textFieldPhone.setText(value.getPhone());
        textFieldWebsite.setText(value.getWebsite());
        textFieldCompany.setText(String.valueOf(value.getCompany()));
    }

    public void buttonClose(ActionEvent actionEvent) {
        App.closeWindow(actionEvent);
    }
}
