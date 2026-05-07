package org.example.exercicio15.service;



import org.example.exercicio15.exception.AiGenerationException;
import org.example.exercicio15.model.AiInteraction;
import org.example.exercicio15.repository.AiInteractionRepository;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class GeminiInteractionService {

    private final ChatModel chatModel;
    private final AiInteractionRepository repository;

    public GeminiInteractionService(ChatModel chatModel, AiInteractionRepository repository) {
        this.chatModel = chatModel;
        this.repository = repository;
    }

    public AiInteraction processAndSave(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new AiGenerationException("O prompt não pode estar vazio.");
        }

        try {
            String response = chatModel.call(prompt);

            AiInteraction interaction = new AiInteraction(prompt, response);
            return repository.save(interaction);

        } catch (Exception e) {
            throw new AiGenerationException("Falha ao comunicar com a IA do Google Gemini.", e);
        }
    }
}