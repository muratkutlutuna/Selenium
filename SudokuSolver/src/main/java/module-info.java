module kutlu.sudokusolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens kutlu.sudokusolver to javafx.fxml;
    exports kutlu.sudokusolver;
}