package org.example.exercicio15.repository;



import org.example.exercicio15.model.AiInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiInteractionRepository extends JpaRepository<AiInteraction, Long> {
}
