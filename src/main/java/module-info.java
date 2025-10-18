module dk.easv.todoappexercise403 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.todoappexercise403 to javafx.fxml;
    exports dk.easv.todoappexercise403;
}