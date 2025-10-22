package com.example.demo.service;

import com.example.demo.domain.Qna;
import com.example.demo.domain.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaRepository qnaRepository;

    public List<Qna> findAllQnas() {
        return qnaRepository.findAll();
    }
}