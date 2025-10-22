package com.example.demo.controller;

import com.example.demo.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String homePage() {
        return "login";
    }


    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "User ID or Name is incorrect.");
        }
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String userId, @RequestParam String name, Model model) {
        boolean success = customUserDetailsService.resetPassword(userId, name);
        if (success) {
            model.addAttribute("message", "Password has been reset to 1234. Please log in.");
            return "login";
        } else {
            return "redirect:/reset-password?error";
        }
    }

    @GetMapping("/qna")
    public String qnaPage() {
        return "qna";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/notice")
    public String noticePage() {
        return "notice";
    }
}
