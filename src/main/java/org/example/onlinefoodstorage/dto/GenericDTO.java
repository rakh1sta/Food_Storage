package org.example.onlinefoodstorage.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenericDTO implements BaseDTO {
    @Id
    private Long id;
}
