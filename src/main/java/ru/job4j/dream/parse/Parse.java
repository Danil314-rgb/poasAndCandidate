package ru.job4j.dream.parse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class Parse {

    public static Map<Integer, ArrayList> parserXml(MultipartFile file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File convFile = new File(file.getOriginalFilename());
        /*var created = convFile.createNewFile();*/
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        Document document = builder.parse(convFile);

        Map<Integer, ArrayList> map = new HashMap<>();
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();

        /*TODO can*/
        NodeList candidatesElements = document.getDocumentElement().getElementsByTagName("candidate");
        for (int i = 0; i < candidatesElements.getLength(); i++) {
            Node item = candidatesElements.item(i);
            NamedNodeMap attributes = item.getAttributes();
            Candidate candidate = new Candidate(
                    Integer.parseInt(attributes.getNamedItem("id").getNodeValue()),
                    attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("description").getNodeValue(),
                    LocalDateTime.now(),
                    new byte[0]
            );
            candidates.add(candidate);
        }

        /*TODO post*/
        NodeList postsElements = document.getDocumentElement().getElementsByTagName("post");
        for (int i = 0; i < postsElements.getLength(); i++) {
            Node item = postsElements.item(i);
            NamedNodeMap attributes = item.getAttributes();
            Post post = new Post(
                    Integer.parseInt(attributes.getNamedItem("id").getNodeValue()),
                    attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("description").getNodeValue(),
                    new City(Integer.parseInt(attributes.getNamedItem("city_id").getNodeValue()))
            );
            posts.add(post);
        }

        map.put(1, candidates);
        map.put(2, posts);
        return map;
    }
}