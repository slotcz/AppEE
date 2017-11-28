package cz.o2.vs.dbm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Model")
@NamedQueries({ @NamedQuery(name = "Model.findAll", query = "select o from Model o") })
@Table(name = "\"model\"")
public class ModelSTB implements Serializable {
    private static final long serialVersionUID = 1528211588229420316L;
    private String fabricate;
    @Id
    @Column(nullable = false)
    private int id;
    private String name;

    public ModelSTB() {
    }

    public ModelSTB(String fabricate, int id, String name) {
        this.fabricate = fabricate;
        this.id = id;
        this.name = name;
    }

    public String getFabricate() {
        return fabricate;
    }

    public void setFabricate(String fabricate) {
        this.fabricate = fabricate;
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
}
