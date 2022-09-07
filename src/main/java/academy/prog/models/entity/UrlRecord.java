package academy.prog.models.entity;

import academy.prog.models.DTO.UrlDTO;
import academy.prog.models.DTO.UrlStatDTO;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class UrlRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String url; // long URL

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private String lastAccessTime;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public UrlRecord() {
        count = 0L;
        lastAccessTime = LocalDateTime.now().format(formatter);
    }

    public UrlRecord(String url) {
        this();
        this.url = url;
    }

    public static UrlRecord of(UrlDTO urlDTO) {
        return new UrlRecord(urlDTO.getUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public UrlStatDTO toStatDTO() {
        var result = new UrlStatDTO();

        result.setUrl(url);
        result.setShortUrl(Long.toString(id));
        result.setRedirects(count);
        result.setLastAccessTime(lastAccessTime);

        return result;
    }
}
