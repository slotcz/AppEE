package cz.o2.vs;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "HistoryEven.findAll", query = "select o from HistoryEven o") })
@Table(name = "\"history_even\"")
public class HistoryEven implements Serializable {
    @Column(name = "DATE_UPDATE")
    private Timestamp dateUpdate;
    @Id
    @Column(nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "STB")
    private Stb imageStb1;
    @ManyToOne
    @JoinColumn(name = "VERSION_FW")
    private RegisterFw registerFw2;

    public HistoryEven() {
    }

    public HistoryEven(Timestamp dateUpdate, int id, Stb imageStb1, RegisterFw registerFw2) {
        this.dateUpdate = dateUpdate;
        this.id = id;
        this.imageStb1 = imageStb1;
        this.registerFw2 = registerFw2;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Stb getImageStb1() {
        return imageStb1;
    }

    public void setImageStb1(Stb imageStb1) {
        this.imageStb1 = imageStb1;
    }

    public RegisterFw getRegisterFw2() {
        return registerFw2;
    }

    public void setRegisterFw2(RegisterFw registerFw2) {
        this.registerFw2 = registerFw2;
    }
}
