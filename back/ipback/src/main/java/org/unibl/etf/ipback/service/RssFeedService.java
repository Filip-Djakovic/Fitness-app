package org.unibl.etf.ipback.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.unibl.etf.ipback.entities.RssFeedEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
@Service
public class RssFeedService {
    private final String rssUrl = "https://feeds.feedburner.com/AceFitFacts";

    public List<RssFeedEntity> getRssFeeds(){
        List<RssFeedEntity> feedItems = new ArrayList<>();

        try {
            RestTemplate restTemplate = new RestTemplate();
            String rssData = restTemplate.getForObject(rssUrl, String.class);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new java.io.ByteArrayInputStream(rssData.getBytes()));

            NodeList items = doc.getElementsByTagName("item");

            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) item;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String link = element.getElementsByTagName("link").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    String pubDate = element.getElementsByTagName("category").item(0).getTextContent();

                    RssFeedEntity feedItem = new RssFeedEntity(title, link, description, pubDate);
                    feedItems.add(feedItem);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedItems;
    }
}
