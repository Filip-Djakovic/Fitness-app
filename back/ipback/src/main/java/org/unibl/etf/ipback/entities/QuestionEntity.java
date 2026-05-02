package org.unibl.etf.ipback.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String text;

    private String response;

    @ManyToOne
    @JoinColumn(name = "programms_id", referencedColumnName = "id", nullable = false)
    private ProgrammsEntity programm;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ProgrammsEntity getProgramm() {
        return programm;
    }

    public void setProgramm(ProgrammsEntity programm) {
        this.programm = programm;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

