package org.example.exercicio16.service;


import org.example.exercicio16.exception.AlunoNotFoundException;
import org.example.exercicio16.model.Aluno;
import org.example.exercicio16.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno saveAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> getAllAluno() {
        return repository.findAll();
    }

    public Aluno getAluno(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno com ID " + id + " não encontrado."));
    }

    public void deleteAluno(Integer id) {
        if (!repository.existsById(id)) {
            throw new AlunoNotFoundException("Impossível deletar. Aluno com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
    }

    public Aluno updateAluno(Integer id, Aluno alunoDetails) {
        Aluno aluno = getAluno(id);

        aluno.setNome(alunoDetails.getNome());
        aluno.setCpf(alunoDetails.getCpf());
        aluno.setEmail(alunoDetails.getEmail());

        return repository.save(aluno);
    }
}