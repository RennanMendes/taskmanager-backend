package br.com.abreu.taskmanager.infra.config;

import br.com.abreu.taskmanager.adapters.TarefaRepositoryService;
import br.com.abreu.taskmanager.application.tarefa.*;
import br.com.abreu.taskmanager.core.cases.projeto.BuscarProjetoPorId;
import br.com.abreu.taskmanager.core.cases.tarefa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TarefaConfig {

    @Autowired
    TarefaRepositoryService repository;

    @Bean
    public BuscarTarefaPorIdUseCase buscarTarefaPorIdUseCase(TarefaRepositoryService repository) {
        return new BuscarTarefaPorIdImpl(repository);
    }

    @Bean
    public BuscarTarefasPorProjetoUseCase buscarTarefasPorProjetoUseCase(TarefaRepositoryService repository) {
        return new BuscarTarefasPorProjetoUseCaseImpl(repository);
    }

    @Bean
    public CriarTarefaUseCase criarTarefaUseCase(TarefaRepositoryService repository, BuscarProjetoPorId buscarProjetoPorId) {
        return new CriarTarefaUseCaseImpl(repository, buscarProjetoPorId);
    }

    @Bean
    public ExcluirTarefaUseCase excluirTarefaUseCase(TarefaRepositoryService repository, BuscarTarefaPorIdUseCase buscarTarefaPorIdUseCase) {
        return new ExcluirTarefaUseCaseImpl(repository, buscarTarefaPorIdUseCase);
    }

    @Bean
    public FiltarTarefaPorStatusUseCase filtarTarefaPorStatusUseCase(TarefaRepositoryService repository) {
        return new FiltarTarefaPorStatusUseCaseImpl(repository);
    }
}