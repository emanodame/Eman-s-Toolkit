package NewsGrabber;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Eman on 29/06/2016.
 */
public class RSSReader {
    private FlowPane rssReaderLayout = new FlowPane(Orientation.VERTICAL);
    private Scene rssReaderScene = new Scene(rssReaderLayout, 600, 300);
    private String bbcRSSURL = "http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk";
    private String guardianRSSURL = "";
    private String telegraphRSSURL ="";
    private Text newsText = new Text("cool");

    public Scene getRssReaderScene() {
        rssReaderSetup();
        return rssReaderScene;
    }

    private void rssReaderSetup() {
        Text titleText = new Text("News");
        titleText.setFont(new Font(36));

        titleText.setTextAlignment(TextAlignment.CENTER);

        rssReaderLayout.getChildren().add(titleText);
        rssReaderLayout.setAlignment(Pos.TOP_CENTER);
        rssReaderLayout.getChildren().add(newsText);
        newsText.setText(readRSS(bbcRSSURL));
        newsText.wrappingWidthProperty().bind(rssReaderScene.widthProperty());
    }

    public static String readRSS(String urlAddress){

        URL rssURL = null;
        try {
            rssURL = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                int titleEndIndex = 0;
                int titleStartIndex = 0;
                while (titleStartIndex >= 0) {
                    titleStartIndex = line.indexOf("<title>", titleEndIndex);
                    if (titleStartIndex >= 0) {
                        titleEndIndex = line.indexOf("</title>", titleStartIndex);
                        sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
                    }
                }
            }
            in.close();
            return sourceCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
