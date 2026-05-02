package org.unibl.etf.ipback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diary")
public class DiaryEntity {
    private Integer id;
    private String text;
    private Integer oldWeight;
    private Integer newWeight;
    private UserEntity user;

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
    @Column(name = "text", nullable = false, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "old_weight", nullable = false)
    public Integer getOldWeight() {
        return oldWeight;
    }

    public void setOldWeight(Integer oldWeight) {
        this.oldWeight = oldWeight;
    }

    @Basic
    @Column(name = "new_weight", nullable = false)
    public Integer getNewWeight() {
        return newWeight;
    }

    public void setNewWeight(Integer newWeight) {
        this.newWeight = newWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaryEntity that = (DiaryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (oldWeight != null ? !oldWeight.equals(that.oldWeight) : that.oldWeight != null) return false;
        if (newWeight != null ? !newWeight.equals(that.newWeight) : that.newWeight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (oldWeight != null ? oldWeight.hashCode() : 0);
        result = 31 * result + (newWeight != null ? newWeight.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
