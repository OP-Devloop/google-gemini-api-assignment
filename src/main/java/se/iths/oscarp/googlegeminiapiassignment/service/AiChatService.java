package se.iths.oscarp.googlegeminiapiassignment.service;

import org.springframework.stereotype.Service;
import se.iths.oscarp.googlegeminiapiassignment.model.AiChat;
import se.iths.oscarp.googlegeminiapiassignment.repository.AiChatRepository;

import java.util.List;

@Service
public class AiChatService {
    private final AiChatRepository aiChatRepository;

    public AiChatService(AiChatRepository aiChatRepository) {
        this.aiChatRepository = aiChatRepository;
    }

    public AiChat save(AiChat aiChat) {
        return aiChatRepository.save(aiChat);
    }

    public List<AiChat> findAll() {
        return aiChatRepository.findAll();
    }
}
