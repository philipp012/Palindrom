package com.example.Palindrom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PalindromController {
    @GetMapping("/index")
    public String createModel(Model model) {
        model.addAttribute("palindrom", new Palindrom());
        return "/index";
    }

    @PostMapping("/index")
    public String checkPalindrom(@ModelAttribute Palindrom palindrom, Model model) {
        StringBuilder sb = new StringBuilder(palindrom.getText());
        String reverseWord = sb.reverse().toString();
        if (palindrom.getText().equals(reverseWord)) {
            palindrom.setOutput(palindrom.getText() + " ist ein Palindrom");
        } else {
            palindrom.setOutput(palindrom.getText() + " ist kein Palindrom");
        }
        model.addAttribute("palindrom", palindrom);
        return "/index";
    }
}
