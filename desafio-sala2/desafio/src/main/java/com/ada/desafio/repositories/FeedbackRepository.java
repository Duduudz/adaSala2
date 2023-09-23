package com.ada.desafio.repositories;

import com.ada.desafio.entities.CustomeFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<CustomeFeedback, Long> {
    //CustomeFeedback é o domínio
    //Long é para o ID.
}
