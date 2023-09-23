package com.ada.desafio;
import com.ada.desafio.entities.CustomerFeedback;
import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import com.ada.desafio.repositories.FeedbackRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.util.logging.Logger;

@Configuration
class LoadMockTestDB {

    private static final Logger log = LoggerFactory.getLogger(LoadMockTestDB.class);


    @Bean
    CommandLineRunner initFeedbackDB(FeedbackRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new CustomerFeedback(FeedbackTypeEnum.CRITICA, FeedbackStatusEnum.EM_PROCESSAMENTO, "ISSO É UMA CRÍTICA")));
            log.info("Preloading " + repository.save(new CustomerFeedback(FeedbackTypeEnum.SUGESTAO,FeedbackStatusEnum.EM_PROCESSAMENTO, "ISSO É UMA SUGESTÃO")));
            log.info("Preloading " + repository.save(new CustomerFeedback(FeedbackTypeEnum.ELOGIO, FeedbackStatusEnum.EM_PROCESSAMENTO, "ISSO É UM ELOGIO")));
        };
    }
}