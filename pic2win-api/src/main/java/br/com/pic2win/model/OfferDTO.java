package br.com.pic2win.model;

import java.util.Date;

/**
 * Created by georgegodas on 24/08/16.
 */
public class OfferDTO {
    private String id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int sortPriority;

    public OfferDTO() {
    }

    public OfferDTO(String id, String title, String description, Date startDate, Date endDate, int sortPriority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sortPriority = sortPriority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSortPriority() {
        return sortPriority;
    }

    public void setSortPriority(int sortPriority) {
        this.sortPriority = sortPriority;
    }
}
