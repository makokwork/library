package domain;

public class Book {

    private Long id;
    private Long authorId;
    private Long publishId;
    private String title;
    private String code;
    private Integer yearPublish;
    private Integer countPage;
    private Boolean hardcover;
    private String abstractText;
    private Boolean status;

    private Author author;
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, String code, Integer yearPublish, Integer countPage,
                Boolean hardcover, String abstractText, Boolean status,
                Long authorId, Long publishId) {
        this.title = title;
        this.code = code;
        this.yearPublish = yearPublish;
        this.countPage = countPage;
        this.hardcover = hardcover;
        this.abstractText = abstractText;
        this.status = status;
        this.authorId = authorId;
        this.publishId = publishId;
    }

    public Book(Long id, String title, String code, Integer yearPublish, Integer countPage,
                Boolean hardcover, String abstractText, Boolean status,
                Long authorId, Long publishId) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.yearPublish = yearPublish;
        this.countPage = countPage;
        this.hardcover = hardcover;
        this.abstractText = abstractText;
        this.status = status;
        this.authorId = authorId;
        this.publishId = publishId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(Integer yearPublish) {
        this.yearPublish = yearPublish;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Boolean getHardcover() {
        return hardcover;
    }

    public void setHardcover(Boolean hardcover) {
        this.hardcover = hardcover;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Author getAuthorObject() {
        return author;
    }

    public void setAuthorObject(Author author) {
        this.author = author;
    }

    public Publisher getPublisherObject() {
        return publisher;
    }

    public void setPublisherObject(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getAuthorName() {
        if (author == null) {
            return "";
        }
        return author.getLastName() + " " + author.getFirstName();
    }

    public String getPublisherName() {
        if (publisher == null) {
            return "";
        }
        return publisher.getNamePublisher();
    }

    @Override
    public String toString() {
        return "Book {Id = " + id
                + ", Title = " + title
                + ", Code = " + code
                + ", YearPublish = " + yearPublish
                + ", CountPage = " + countPage
                + ", Hardcover = " + hardcover
                + ", Abstract = " + abstractText
                + ", Status = " + status
                + ", AuthorId = " + authorId
                + ", PublishId = " + publishId
                + "}";
    }
}