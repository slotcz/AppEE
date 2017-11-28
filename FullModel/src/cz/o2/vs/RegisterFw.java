package cz.o2.vs;

import java.io.Serializable;

import java.sql.Timestamp;

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
@NamedQueries({ @NamedQuery(name = "RegisterFw.findAll", query = "select o from RegisterFw o") })
@Table(name = "\"register_fw\"")
public class RegisterFw implements Serializable {
    @Column(name = "CODE_PATCH")
    private String codePatch;
    @Column(name = "DATE_FW")
    private Timestamp dateFw;
    @Id
    @Column(nullable = false)
    private int id;
    @Column(name = "MANUAL_PATH")
    private String manualPath;
    private String version;
    @OneToMany(mappedBy = "registerFw", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Stb> imageStbList;
    @OneToMany(mappedBy = "registerFw1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistoryOdd> historyOddList;
    @ManyToOne
    @JoinColumn(name = "IMG_TYPE")
    private ImageStb imageStb;
    @OneToMany(mappedBy = "registerFw2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistoryEven> historyEvenList1;

    public RegisterFw() {
    }

    public RegisterFw(Category category, String codePatch, Timestamp dateFw, int id, ImageStb imageStb, String manualPath, Model model, String version) {
       // this.category = category;
        this.codePatch = codePatch;
        this.dateFw = dateFw;
        this.id = id;
        this.imageStb = imageStb;
        this.manualPath = manualPath;
     //   this.model = model;
        this.version = version;
    }


    public String getCodePatch() {
        return codePatch;
    }

    public void setCodePatch(String codePatch) {
        this.codePatch = codePatch;
    }

    public Timestamp getDateFw() {
        return dateFw;
    }

    public void setDateFw(Timestamp dateFw) {
        this.dateFw = dateFw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getManualPath() {
        return manualPath;
    }

    public void setManualPath(String manualPath) {
        this.manualPath = manualPath;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Stb> getImageStbList() {
        return imageStbList;
    }

    public void setImageStbList(List<Stb> imageStbList) {
        this.imageStbList = imageStbList;
    }

    public Stb addStb(Stb stb) {
        getImageStbList().add(stb);
        stb.setRegisterFw(this);
        return stb;
    }

    public Stb removeStb(Stb stb) {
        getImageStbList().remove(stb);
        stb.setRegisterFw(null);
        return stb;
    }

    public List<HistoryOdd> getHistoryOddList() {
        return historyOddList;
    }

    public void setHistoryOddList(List<HistoryOdd> historyOddList) {
        this.historyOddList = historyOddList;
    }

    public HistoryOdd addHistoryOdd(HistoryOdd historyOdd) {
        getHistoryOddList().add(historyOdd);
        historyOdd.setRegisterFw1(this);
        return historyOdd;
    }

    public HistoryOdd removeHistoryOdd(HistoryOdd historyOdd) {
        getHistoryOddList().remove(historyOdd);
        historyOdd.setRegisterFw1(null);
        return historyOdd;
    }

    public ImageStb getImageStb() {
        return imageStb;
    }

    public void setImageStb(ImageStb imageStb) {
        this.imageStb = imageStb;
    }
/*
    public void setModel(Model model) {
        this.model = model;
    }
*/
    public List<HistoryEven> getHistoryEvenList1() {
        return historyEvenList1;
    }

    public void setHistoryEvenList1(List<HistoryEven> historyEvenList1) {
        this.historyEvenList1 = historyEvenList1;
    }

    public HistoryEven addHistoryEven(HistoryEven historyEven) {
        getHistoryEvenList1().add(historyEven);
        historyEven.setRegisterFw2(this);
        return historyEven;
    }

    public HistoryEven removeHistoryEven(HistoryEven historyEven) {
        getHistoryEvenList1().remove(historyEven);
        historyEven.setRegisterFw2(null);
        return historyEven;
    }
/*
    public void setCategory(Category category) {
        this.category = category;
    }
*/
}
