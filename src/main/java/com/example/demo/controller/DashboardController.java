package com.example.demo.controller;

import com.example.demo.service.FaqService;
import com.example.demo.service.NoticeService;
import com.example.demo.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final NoticeService noticeService;
    private final FaqService faqService;
    private final QnaService qnaService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // For now, just return the dashboard view. Content will be added later.
        return "dashboard";
    }

    @GetMapping("/notice-list")
    public String noticeList(Model model) {
        model.addAttribute("notices", noticeService.findAllNotices());
        return "notice-list";
    }

    @GetMapping("/faq-list")
    public String faqList(Model model) {
        model.addAttribute("faqs", faqService.findAllFaqs());
        return "faq-list";
    }

    @GetMapping("/qna-list")
    public String qnaList(Model model) {
        model.addAttribute("qnas", qnaService.findAllQnas());
        return "qna-list";
    }
}