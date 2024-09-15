package com.example.xmlmanagementapp.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private List<Chapter> chapters;
    private Statistics statistics = new Statistics();
}
