package com.example.demo.config;

import com.example.demo.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Value("${app.dataloader.enabled:true}")
    private boolean dataloaderEnabled;

    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;
    private final FaqRepository faqRepository;
    private final QnaRepository qnaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!dataloaderEnabled) {
            return; // Skip data loading if disabled
        }

        // Create a default user for testing ID/password login
        if (userRepository.findByUserId("testuser").isEmpty()) {
            User testUser = new User("testuser", "Test User", "test@example.com", passwordEncoder.encode("password"));
            userRepository.save(testUser);
        }

        // Add sample notices
        if (noticeRepository.count() == 0) {
            noticeRepository.save(new Notice(null, "첫 번째 공지사항", "안녕하세요! 첫 번째 공지사항입니다.", LocalDateTime.now()));
            noticeRepository.save(new Notice(null, "두 번째 공지사항", "시스템 점검 안내입니다.", LocalDateTime.now().plusDays(1)));
        }

        // Add sample FAQs
        if (faqRepository.count() == 0) {
            faqRepository.save(new Faq(null, "Q: 회원가입은 어떻게 하나요?", "A: 로그인 페이지에서 회원가입 링크를 통해 진행할 수 있습니다."));
            faqRepository.save(new Faq(null, "Q: 비밀번호를 잊어버렸어요.", "A: 로그인 페이지의 '비밀번호 찾기' 링크를 이용해주세요."));
        }

        // Add sample QnAs
        if (qnaRepository.count() == 0) {
            qnaRepository.save(new Qna(null, "Q: 서비스 이용 중 오류가 발생했어요.", "A: 고객센터로 문의해주시면 신속하게 처리해드리겠습니다."));
            qnaRepository.save(new Qna(null, "Q: 제안하고 싶은 기능이 있어요.", "A: 언제든지 제안해주시면 적극 검토하겠습니다."));
        }
    }
}