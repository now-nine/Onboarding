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

    @GetMapping("/main")
    public String mainPage(Model model, @AuthenticationPrincipal OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

        model.addAttribute("user", Map.of("name", profile.get("nickname")));
        return "main";
    }

    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "User ID or Name is incorrect.");
        }
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String id, @RequestParam String name, Model model) {
        boolean success = customUserDetailsService.resetPassword(id, name);
        if (success) {
            model.addAttribute("message", "Password has been reset to 1234. Please log in.");
            return "login";
        } else {
            return "redirect:/reset-password?error";
        }
    }
}
