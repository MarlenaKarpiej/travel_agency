package com.sda.travel_agency.entity;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    @ManyToMany()
    private Set<UserRole> roles;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Bill> bills;
}
