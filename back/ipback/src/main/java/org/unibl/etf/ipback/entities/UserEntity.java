package org.unibl.etf.ipback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    private Integer id;
    private String name;
    private String surname;
    private String city;
    private String mail;
    private List<DiaryEntity> diaries;
    private List<MessageEntity> messages;
    private List<ProgrammsEntity> programms;
    private UserAccountEntity userAccount;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 45)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<DiaryEntity> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<DiaryEntity> diaries) {
        this.diaries = diaries;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<ProgrammsEntity> getProgramms() {
        return programms;
    }

    public void setProgramms(List<ProgrammsEntity> programms) {
        this.programms = programms;
    }

    @ManyToOne
    @JoinColumn(name = "user_account_username", referencedColumnName = "username", nullable = false)
    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }
}
