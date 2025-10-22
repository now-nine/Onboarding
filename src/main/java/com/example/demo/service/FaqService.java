package com.example.demo.service;

import com.example.demo.domain.Faq;
import com.example.demo.domain.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public List<Faq> findAllFaqs() {
        return faqRepository.findAll();
    }
}