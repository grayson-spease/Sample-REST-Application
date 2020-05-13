package com.sample.company;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.serializers.StringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dbo", name = "sample")
public class CompanyDao {
    @Id
    @Column(name = "idnum")
    private Integer companyId;

    @Column(name = "company")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private Integer zip;
}
