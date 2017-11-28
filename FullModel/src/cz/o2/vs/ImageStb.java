package cz.o2.vs;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ImageStb.findAll", query = "select o from ImageStb o") })
@Table(name = "\"image_stb\"")
public class ImageStb implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;
    private String name;
    @OneToMany(mappedBy = "imageStb", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RegisterFw> registerFwList;

    public ImageStb() {
    }

    public ImageStb(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<RegisterFw> getRegisterFwList() {
        return registerFwList;
    }

    public void setRegisterFwList(List<RegisterFw> registerFwList) {
        this.registerFwList = registerFwList;
    }

    public RegisterFw addRegisterFw(RegisterFw registerFw) {
        getRegisterFwList().add(registerFw);
        registerFw.setImageStb(this);
        return registerFw;
    }

    public RegisterFw removeRegisterFw(RegisterFw registerFw) {
        getRegisterFwList().remove(registerFw);
        registerFw.setImageStb(null);
        return registerFw;
    }
}
