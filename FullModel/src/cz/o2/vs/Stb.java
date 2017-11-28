package cz.o2.vs;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Stb.findAll", query = "select o from Stb o") })
@Table(name = "\"stb\"")
public class Stb implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;
    private int image;
    private String mac;
    @ManyToOne
    @JoinColumn(name = "VERSION_FW")
    private RegisterFw registerFw;
    @OneToMany(mappedBy = "imageStb", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistoryOdd> historyOddList1;
    @OneToMany(mappedBy = "imageStb1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistoryEven> historyEvenList;
    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private Category category1;

    public Stb() {
    }

    public Stb(Category category1, int id, int image, String mac, RegisterFw registerFw) {
        this.category1 = category1;
        this.id = id;
        this.image = image;
        this.mac = mac;
        this.registerFw = registerFw;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }


    public RegisterFw getRegisterFw() {
        return registerFw;
    }

    public void setRegisterFw(RegisterFw registerFw) {
        this.registerFw = registerFw;
    }

    public List<HistoryOdd> getHistoryOddList1() {
        return historyOddList1;
    }

    public void setHistoryOddList1(List<HistoryOdd> historyOddList1) {
        this.historyOddList1 = historyOddList1;
    }

    public HistoryOdd addHistoryOdd(HistoryOdd historyOdd) {
        getHistoryOddList1().add(historyOdd);
        historyOdd.setImageStb(this);
        return historyOdd;
    }

    public HistoryOdd removeHistoryOdd(HistoryOdd historyOdd) {
        getHistoryOddList1().remove(historyOdd);
        historyOdd.setImageStb(null);
        return historyOdd;
    }

    public List<HistoryEven> getHistoryEvenList() {
        return historyEvenList;
    }

    public void setHistoryEvenList(List<HistoryEven> historyEvenList) {
        this.historyEvenList = historyEvenList;
    }

    public HistoryEven addHistoryEven(HistoryEven historyEven) {
        getHistoryEvenList().add(historyEven);
        historyEven.setImageStb1(this);
        return historyEven;
    }

    public HistoryEven removeHistoryEven(HistoryEven historyEven) {
        getHistoryEvenList().remove(historyEven);
        historyEven.setImageStb1(null);
        return historyEven;
    }

    public Category getCategory1() {
        return category1;
    }

    public void setCategory1(Category category1) {
        this.category1 = category1;
    }
}
