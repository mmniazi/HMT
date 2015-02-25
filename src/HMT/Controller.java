package HMT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    Enclosure enclosure;

    @FXML
    private Label PercDifference;

    @FXML
    private TextField HRoof;

    @FXML
    private TextField WWidnow;

    @FXML
    private TextField TInside;

    @FXML
    private Label LRoof;

    @FXML
    private Label LWindow;

    @FXML
    private TextField HWindow;

    @FXML
    private TextField WRoof;

    @FXML
    private Label DGazedLoss;

    @FXML
    private Label SGazedLoss;

    @FXML
    private TextField TOutside;

    @FXML
    private void calculateController(ActionEvent event) {
        if (validInput()) {
            double roofOptimumL =enclosure.
                    roofOptimumL(Double.valueOf(TInside.getText()), Double.valueOf(TOutside.getText()));
            if (roofOptimumL == -1) LRoof.setText("Any Length");
            else LRoof.setText(String.format("%.5f",roofOptimumL));

            double windowOptimumL =enclosure.
                    windowOptimumL(Double.valueOf(TInside.getText()), Double.valueOf(TOutside.getText()),
                            Double.valueOf(HWindow.getText()));
            if (windowOptimumL == -1) LWindow.setText("Any Length");
            else LWindow.setText(String.format("%.5f",windowOptimumL));
        }
    }

    private boolean validInput(){
        return !TInside.getText().isEmpty() && !TOutside.getText().isEmpty() && !HWindow.getText().isEmpty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enclosure = new Enclosure();
    }
}
