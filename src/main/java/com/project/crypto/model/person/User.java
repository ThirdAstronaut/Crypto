package com.project.crypto.model.person;

import com.project.crypto.model.publication.Comment;
import com.project.crypto.validators.Validate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends AbstractPersistable<Long> {

    private String userId;

    @OneToMany(targetEntity = Address.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(targetEntity = Comment.class, mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "name")
    @Validate(min = 3, max = 40, regexp = ConstantUtils.CHAR_PATTERN, message = "Please enter between {min}-{max} characters and no digits")
    private String name;

    @Column(name = "surname")
    @Size(min = 2, max = 70, message = "{Size.User.surname}")
    @NotNull(message = "Provide your valid last name")
    private String surname;

    @Column(name = "email", unique = true, nullable = false)
    @NotNull
    @Validate(min = 4, max = 100, regexp = ConstantUtils.EMAIL_PATTERN, message = "Please enter between {min}-{max} characters and valid input")
    private String email;
    @Column(name = "age")
    @NotNull(message = "Provide valid age")
    // @Validate(min = 0, max = 3, message = "podaj wiek",regexp = ConstantUtils.AGE_PATTERN)
    private int age;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Column(name = "password")
    @Size(min = 5, max = 70)//TODO validate email via annotation

    @Transient  //Object Mapper does not include this value when converting from Java Object to JSON.
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
/*

    Optional< String > phoneNumber = Optional.ofNullable( null );
    void getPhone() {
        phoneNumber.isPresent();
        phoneNumber.orElseGet(() -> "[none]");
        phoneNumber.map(s -> "Hey " + s + "!").orElse("Hey Stranger!");
    }
*/

