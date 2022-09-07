package academy.prog.models.DTO;

import academy.prog.models.DTO.UrlResultDTO;

import java.util.Date;

public class UrlStatDTO extends UrlResultDTO {
    private long redirects;
    private String lastAccessTime; // TODO: set normal format

    public long getRedirects() {
        return redirects;
    }

    public void setRedirects(long redirects) {
        this.redirects = redirects;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}
