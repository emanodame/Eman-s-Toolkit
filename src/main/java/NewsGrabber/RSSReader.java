package NewsGrabber;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Eman on 29/06/2016.
 */
public class RSSReader {
    final private FlowPane rssReaderLayout = new FlowPane(Orientation.VERTICAL);
    final private Scene rssReaderScene = new Scene(rssReaderLayout, 750, 650);
    final private Text newsText = new Text();
    private int headlineCounter = 0;
    private Hyperlink[] hyperlinkStorage = new Hyperlink[21];


    public Scene getRssReaderScene() {
        rssReaderSetup();
        return rssReaderScene;
    }

    private void rssReaderSetup() {
        Hyperlink x = new Hyperlink("www.google.com");



        StringBuilder newsFinalLayout = new StringBuilder("");
        final String bbcRSSURL = "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk";
        final String guardianRSSURL = "https://www.theguardian.com/world/rss";

          /*  readRSS(bbcRSSURL).stream()
                    .skip(1)
                    .forEach(newsStringElement -> newsFinalLayout
                            .append(newsStringElement)
                            .append("\n"));*/


        newsText.setText(newsFinalLayout.toString());
        newsText.wrappingWidthProperty().bind(rssReaderScene.widthProperty());
        rssReaderLayout.getChildren().add(x);
        rssReaderLayout.getChildren().add(newsText);

        x.fire();
    }

    private ArrayList<String> readRSS(String urlAddress){
        ArrayList<String> rssInfo = new ArrayList<>();
        ArrayList<String> urlInfo = new ArrayList<>();

        String currentLine;

        try {
            URL rssURL = new URL(urlAddress);
            BufferedReader inputRss = new BufferedReader(new InputStreamReader(rssURL.openStream()));

            while ((currentLine = inputRss.readLine()) != null) {
                int titleStartIndex = 0;
                int titleEndIndex = 0;
                int urlStartIndex;
                int urlEndIndex = 0;

                while (titleStartIndex >= 0 && headlineCounter <= 20) {
                    titleStartIndex = currentLine.indexOf("<title><![CDATA[", titleEndIndex);
                    urlStartIndex = currentLine.indexOf("<link>", urlEndIndex);

                    if(urlStartIndex >= 0){
                        urlEndIndex = currentLine.indexOf("</link",urlEndIndex);
                        urlInfo.add(currentLine.substring(urlStartIndex + "<link>".length(), urlEndIndex) + "\n");
                    }

                        if (titleStartIndex >= 0) {
                            titleEndIndex = currentLine.indexOf("]]></title>", titleStartIndex);
                            rssInfo.add(headlineCounter + ": " + currentLine.substring(titleStartIndex + "<title><![CDATA[".length(), titleEndIndex)  + "\n" );
                            headlineCounter++;
                    }
                }
            }
            for(int i = 2; i < urlInfo.size(); i++){
                hyperlinkStorage[i] = new Hyperlink(urlInfo.get(i));
            }



           // System.out.println(urlInfo);
            inputRss.close();
           return rssInfo;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

/*
TODO:
Add right/left key button to show different news outlets
Add number buttons that open up the URL for each corressponding line.
 */