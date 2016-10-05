package br.com.cupomclick.domain.offer;

import br.com.cupomclick.domain.offer.mechanic.OfferMechanic;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by georgegodas on 24/08/16.
 */
@EntityScan
public class Offer {
    @Id
    private String id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int sortPriority;
    private OfferMechanic offerMechanic;

    public Offer() {
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

    public OfferMechanic getOfferMechanic() {
        return offerMechanic;
    }

    public void setOfferMechanic(OfferMechanic offerMechanic) {
        this.offerMechanic = offerMechanic;
    }

}
