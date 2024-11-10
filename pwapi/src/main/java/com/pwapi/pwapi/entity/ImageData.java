package com.pwapi.pwapi.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "image_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String about;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

}
