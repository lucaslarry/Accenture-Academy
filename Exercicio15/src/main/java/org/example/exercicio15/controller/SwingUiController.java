package org.example.exercicio15.controller;

import org.example.exercicio15.exception.AiGenerationException;
import org.example.exercicio15.model.AiInteraction;
import org.example.exercicio15.service.GeminiInteractionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.JOptionPane;

@Component
public class SwingUiController implements CommandLineRunner {

    private final GeminiInteractionService service;

    public SwingUiController(GeminiInteractionService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        while (true) {
            String prompt = JOptionPane.showInputDialog(
                    null,
                    "Escreve a tua pergunta para o Gemini\n(ou clica em Cancelar para sair):",
                    "Desafio Spring AI",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (prompt == null || prompt.trim().isEmpty()) {
                break;
            }

            try {
                System.out.println("A processar o prompt: " + prompt);

                AiInteraction result = service.processAndSave(prompt);

                JOptionPane.showMessageDialog(
                        null,
                        result.getResponse(),
                        "Resposta do Gemini",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (AiGenerationException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro: " + e.getMessage(),
                        "Erro de Processamento",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        System.exit(0);
    }
}