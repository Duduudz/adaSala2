package com.ada.desafio.repositories;

import com.ada.desafio.entities.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
    //FeedbackEntity é o domínio
    //Long é para o ID.
}
