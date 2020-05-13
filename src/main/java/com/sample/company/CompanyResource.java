package com.sample.company;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.serializers.StringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResource {
    @JsonSerialize(using = StringSerializer.class)
    private String companyName;

    @JsonSerialize(using = StringSerializer.class)
    private String companyAddress;

    @JsonSerialize(using = StringSerializer.class)
    private String companyState;

    @JsonSerialize(using = StringSerializer.class)
    private String companyCity;

    private Integer companyZip;
}
