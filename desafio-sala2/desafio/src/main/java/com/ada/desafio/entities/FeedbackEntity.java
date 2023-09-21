package com.ada.desafio.entities;

import com.ada.desafio.entities.enums.FeedbackStatusEnum;
import com.ada.desafio.entities.enums.FeedbackTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Feedbacks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String message;
    private String status;
}
