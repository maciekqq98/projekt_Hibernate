package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gra", schema = "dbo", catalog = "projektHi")
@NamedQueries({
        @NamedQuery(name = "wyniki.game", query = "select e from GraEntity e where e.id=:idgry")
})
public class GraEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;

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

    public GraEntity() {
    }

    public GraEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraEntity graEntity = (GraEntity) o;
        return id == graEntity.id &&
                Objects.equals(name, graEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return " idgry = " + id +
                ", nazwa gry = " + name;
    }
}
