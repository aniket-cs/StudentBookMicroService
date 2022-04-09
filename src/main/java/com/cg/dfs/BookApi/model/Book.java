package com.cg.dfs.BookApi.model;
import lombok.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull private Integer bookId;

    @NotNull(message = "You should provide proper book name")
    @NotEmpty(message = "Book name can't be empty")
    private String bookName;

    @NotNull(message = "You should provide proper book cost")
    private Double bookCost;



}
