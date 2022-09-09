package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wyniki", schema = "dbo", catalog = "projektHi")
@NamedQueries({
        @NamedQuery(name = "wyniki.findAll", query = "select e from WynikiEntity e"),
        @NamedQuery(name = "wyniki.findByNameAndSurname", query = "select e from WynikiEntity e where e.name=:name and e.surname=:surname"),
        @NamedQuery(name = "wyniki.findMore", query = "select e from WynikiEntity e where e.pkt>=:pkt")
        //@NamedQuery(name = "wyniki.najwiecejZgry", query = "select e from WynikiEntity e where ")
})
public class WynikiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "surname", nullable = true, length = 50)
    private String surname;

    @Basic
    @Column(name = "pkt", nullable = true)
    private Integer pkt;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idgry", referencedColumnName = "id")
    private GraEntity graEntity;

    public WynikiEntity(String name, String surname, Integer pkt, GraEntity graEntity) {
        this.name = name;
        this.surname = surname;
        this.pkt = pkt;
        this.graEntity = graEntity;
    }

    public WynikiEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getPkt() {
        return pkt;
    }

    public void setPkt(Integer pkt) {
        this.pkt = pkt;
    }

    public GraEntity getGraEntity() {
        return graEntity;
    }

    public void setGraEntity(GraEntity graEntity) {
        this.graEntity = graEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WynikiEntity that = (WynikiEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(pkt, that.pkt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, pkt);
    }

    @Override
    public String toString() {
        return "idgracza = " + id +
                ", imie = " + name +
                ", nazwisko = " + surname +
                ", pkt = " + pkt + "," +
                graEntity + "\n";
    }

}
