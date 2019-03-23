package com.example.Palindrom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PalindromController {
    @GetMapping("/")
    public String createModel(Model model) {
        model.addAttribute("text", new String());
        return "text";
    }

    @PostMapping("/")
    public String checkPalindrom(@ModelAttribute String text) {
            StringBuilder sb = new StringBuilder(text);
            String reverseWord = sb.reverse().toString();
            if (text.equals(reverseWord)) {
                return  text + " ist ein Palin" +
                        "drom";
            } else {
                return text + " ist kein Palindrom";
            }
    }
}
