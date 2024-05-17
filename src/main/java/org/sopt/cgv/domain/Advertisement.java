package org.sopt.cgv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Advertisement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    public Advertisement(String url) {
        this.url = url;
    }

}
