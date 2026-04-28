package se.iths.oscarp.googlegeminiapiassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.oscarp.googlegeminiapiassignment.model.AiChat;

@Repository
public interface AiChatRepository extends JpaRepository<AiChat, Long> {
}
