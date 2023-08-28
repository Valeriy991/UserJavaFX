module com.valeriygulin.userfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsonschema2pojo.core;
    requires codemodel;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.valeriygulin.userfx to javafx.fxml;
    exports com.valeriygulin.userfx;
    exports com.valeriygulin.userfx.controllers;
    opens com.valeriygulin.userfx.controllers to javafx.fxml;
    exports com.valeriygulin.userfx.repository;
    opens com.valeriygulin.userfx.repository to javafx.fxml;
    exports com.valeriygulin.userfx.model to com.fasterxml.jackson.databind;

}