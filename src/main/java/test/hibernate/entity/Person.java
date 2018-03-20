package test.hibernate.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(appliesTo = "person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Person implements Serializable {
    @Id
    @GenericGenerator(name = "auto_inc", strategy = "increment")
    @GeneratedValue(generator = "auto_inc")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
