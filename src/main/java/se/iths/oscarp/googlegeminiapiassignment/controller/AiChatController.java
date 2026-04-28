package se.iths.oscarp.googlegeminiapiassignment.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.oscarp.googlegeminiapiassignment.model.AiChat;
import se.iths.oscarp.googlegeminiapiassignment.service.AiChatService;

@Controller
@RequestMapping("/")
public class AiChatController {

    private final AiChatService aiChatService;

    public AiChatController(AiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @GetMapping
    public String showChatPage(Model model) {
        model.addAttribute("aiChat", new AiChat());
        return "ai-chat";
    }

    @PostMapping
    public String aiChat(@RequestParam String prompt, Model model) {

        Client client = new Client();

        GenerateContentResponse response =
                client.models.generateContent("gemini-3-flash-preview", prompt, null);

        // Create and save chat entry
        AiChat aiChat = new AiChat();
        aiChat.setPrompt(prompt);
        aiChat.setResponse(response.text());

        aiChatService.save(aiChat);

        // Send response back to page
        model.addAttribute("response", response.text());
        model.addAttribute("aiChat", new AiChat());

        return "ai-chat";
    }

    @GetMapping("/history")
    public String showChatHistory(Model model) {
        model.addAttribute("chatHistory", aiChatService.findAll());
        return "chat-history";
    }
}
