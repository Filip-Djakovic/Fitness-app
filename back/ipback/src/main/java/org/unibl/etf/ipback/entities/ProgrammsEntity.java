package org.unibl.etf.ipback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "programms")
public class ProgrammsEntity {
    private Integer id;
    private Double price;
    private Integer level;
    private Integer time;
    private String name;
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "LONGBLOB")
    private byte[] picture;
    private String contact;
    private Integer isParticipated;
    private Integer isActivated;
    private Integer isFinished;
    private CategoryEntity category;
    private LocationEntity location;
    private InstructorEntity instructor;
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
    @Column(name = "price", nullable = false, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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
    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picture", nullable = false)
    @JsonIgnore
    public byte[] getPicture() {
        return picture;
    }

    @Transient
    @JsonProperty("picture") // Maps the JSON property to this field
    private String pictureBase64;

    public String getPictureBase64() {
        return pictureBase64;
    }

    public void setPictureBase64(String pictureBase64) {
        this.pictureBase64 = pictureBase64;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "contact", nullable = false, length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "is_participated", nullable = false)
    public Integer getIsParticipated() {
        return isParticipated;
    }

    public void setIsParticipated(Integer isParticipated) {
        this.isParticipated = isParticipated;
    }

    @Basic
    @Column(name = "is_activated", nullable = false)
    public Integer getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Integer isActivated) {
        this.isActivated = isActivated;
    }

    @Basic
    @Column(name = "is_finished", nullable = false)
    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgrammsEntity that = (ProgrammsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (isParticipated != null ? !isParticipated.equals(that.isParticipated) : that.isParticipated != null)
            return false;
        if (isActivated != null ? !isActivated.equals(that.isActivated) : that.isActivated != null) return false;
        if (isFinished != null ? !isFinished.equals(that.isFinished) : that.isFinished != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (isParticipated != null ? isParticipated.hashCode() : 0);
        result = 31 * result + (isActivated != null ? isActivated.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id", nullable = false)
    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
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
