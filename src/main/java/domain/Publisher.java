package domain;

public class Publisher {

    private Long id;
    private String namePublisher;
    private String address;
    private String site;

    public Publisher() {
    }

    public Publisher(String namePublisher, String address, String site) {
        this.namePublisher = namePublisher;
        this.address = address;
        this.site = site;
    }

    public Publisher(Long id, String namePublisher, String address, String site) {
        this.id = id;
        this.namePublisher = namePublisher;
        this.address = address;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Publisher {Id = " + id + ", NamePublisher = " + namePublisher
                + ", Address = " + address + ", Site = " + site + "}";
    }
}