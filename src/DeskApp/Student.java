/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeskApp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author laptop
 */
@Entity
@Table(name = "STUDENT", catalog = "", schema = "SAVIR")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByTagId", query = "SELECT s FROM Student s WHERE s.tagId = :tagId")
    , @NamedQuery(name = "Student.findByIsInside", query = "SELECT s FROM Student s WHERE s.isInside = :isInside")
    , @NamedQuery(name = "Student.findByLateNightPermi", query = "SELECT s FROM Student s WHERE s.lateNightPermi = :lateNightPermi")
    , @NamedQuery(name = "Student.findByRollNo", query = "SELECT s FROM Student s WHERE s.rollNo = :rollNo")})
public class Student implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAG_ID")
    private Integer tagId;
    @Lob
    @Column(name = "NAME")
    private String name;
    @Column(name = "IS_INSIDE")
    private Boolean isInside;
    @Column(name = "LATE_NIGHT_PERMI")
    private Boolean lateNightPermi;
    @Column(name = "ROLL_NO")
    private Long rollNo;

    public Student() {
    }

    public Student(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        Integer oldTagId = this.tagId;
        this.tagId = tagId;
        changeSupport.firePropertyChange("tagId", oldTagId, tagId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Boolean getIsInside() {
        return isInside;
    }

    public void setIsInside(Boolean isInside) {
        Boolean oldIsInside = this.isInside;
        this.isInside = isInside;
        changeSupport.firePropertyChange("isInside", oldIsInside, isInside);
    }

    public Boolean getLateNightPermi() {
        return lateNightPermi;
    }

    public void setLateNightPermi(Boolean lateNightPermi) {
        Boolean oldLateNightPermi = this.lateNightPermi;
        this.lateNightPermi = lateNightPermi;
        changeSupport.firePropertyChange("lateNightPermi", oldLateNightPermi, lateNightPermi);
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        Long oldRollNo = this.rollNo;
        this.rollNo = rollNo;
        changeSupport.firePropertyChange("rollNo", oldRollNo, rollNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagId != null ? tagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.tagId == null && other.tagId != null) || (this.tagId != null && !this.tagId.equals(other.tagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DeskApp.Student[ tagId=" + tagId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
