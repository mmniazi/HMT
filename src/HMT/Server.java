package HMT;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import java.io.IOException;

/**
 * Created by mohsin on 1/4/2015.
 */
public class Server {
    final WebClient webClient;
    HtmlPage page;
    final HtmlTextInput temperatureField;
    final HtmlButtonInput calculateButton;

    public Server() {
        webClient = new WebClient(BrowserVersion.CHROME);
        try {
            page = webClient.getPage("http://www.mhtl.uwaterloo.ca/properties.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        temperatureField = page.getElementByName("T");
        calculateButton = page.getElementByName("Calc");
    }

    public double getPr(double T) {
        temperatureField.setValueAttribute(String.valueOf(T));
        try {
            HtmlPage newPage = calculateButton.click();
            final HtmlTextInput prField = newPage.getElementByName("Pr");
            return Double.parseDouble(prField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getV(double T) {
        temperatureField.setValueAttribute(String.valueOf(T));
        try {
            HtmlPage newPage = calculateButton.click();
            final HtmlTextInput vField = newPage.getElementByName("nu");
            return Double.parseDouble(vField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
