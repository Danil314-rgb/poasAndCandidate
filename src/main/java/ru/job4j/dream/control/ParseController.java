package ru.job4j.dream.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import ru.job4j.dream.parse.Parse;
import ru.job4j.dream.service.CandidateService;
import ru.job4j.dream.service.PostService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@ThreadSafe
@Controller
public class ParseController {

    private final CandidateService candidateService;
    private final PostService postService;

    public ParseController(CandidateService candidateService, PostService postService) {
        this.candidateService = candidateService;
        this.postService = postService;
    }

    @GetMapping("/formParseXML")
    public String parseXml() {
        return "/parseXML";
    }

    @PostMapping("/parseAndAddXml")
    public String parseAndAddXml(@RequestParam("file") MultipartFile file) throws IOException, SAXException, ParserConfigurationException {
        var candidates = Parse.parserXml(file);
        candidateService.create(candidates.get(1));
        postService.create(candidates.get(2));
        return "redirect:/index";
    }
}
