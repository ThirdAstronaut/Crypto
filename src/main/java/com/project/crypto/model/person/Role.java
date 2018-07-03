package com.project.crypto.model.person;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Rafał on 2017-09-06.
 */
@Entity
public class Role extends AbstractPersistable<Long> {

    private String name;

 /*   @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
