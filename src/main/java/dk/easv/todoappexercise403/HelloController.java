package dk.easv.todoappexercise403;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;

public class HelloController {
    @FXML
    private ListView<String> lvTodo;
    
    @FXML
    private ListView<String> lvInProgress;
    
    @FXML
    private ListView<String> lvDone;
    
    @FXML
    private Button btnAddNew;
    
    @FXML
    private Button btnMoveToProgress;
    
    @FXML
    private Button btnMoveBackToTodo;
    
    @FXML
    private Button btnMoveToDone;
    
    @FXML
    private Button btnMoveBackToProgress;
    
    private int todoCounter = 1;
    
    @FXML
    public void initialize() {
        // Make the Todo ListView editable
        lvTodo.setEditable(true);
        lvTodo.setCellFactory(TextFieldListCell.forListView());
        
        // Add some sample todos
        lvTodo.getItems().addAll(
            "Buy groceries",
            "Finish homework",
            "Clean the house"
        );
        todoCounter = 4;
    }
    
    @FXML
    protected void onAddNewTodo() {
        String newTodo = "New Todo Item " + todoCounter;
        lvTodo.getItems().add(newTodo);
        todoCounter++;
        
        // Select and edit the new item
        lvTodo.getSelectionModel().selectLast();
        lvTodo.edit(lvTodo.getItems().size() - 1);
    }
    
    @FXML
    protected void onMoveToInProgress() {
        String selectedItem = lvTodo.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lvTodo.getItems().remove(selectedItem);
            lvInProgress.getItems().add(selectedItem);
        }
    }
    
    @FXML
    protected void onMoveBackToTodo() {
        String selectedItem = lvInProgress.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lvInProgress.getItems().remove(selectedItem);
            lvTodo.getItems().add(selectedItem);
        }
    }
    
    @FXML
    protected void onMoveToDone() {
        String selectedItem = lvInProgress.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lvInProgress.getItems().remove(selectedItem);
            lvDone.getItems().add(selectedItem);
        }
    }
    
    @FXML
    protected void onMoveBackToInProgress() {
        String selectedItem = lvDone.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lvDone.getItems().remove(selectedItem);
            lvInProgress.getItems().add(selectedItem);
        }
    }
}
