package br.com.cupomclick.model.offer;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by georgegodas on 02/10/16.
 */
public class OfferFoodCreateDTO {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int sortPriority;
    protected List<DayOfWeek> daysOfWeekAllowed;
    private OfferFoodCreateFoodMachanicalofferDTO offerMechanic;

    public OfferFoodCreateDTO() {
        this.daysOfWeekAllowed = new ArrayList<>();
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

    public OfferFoodCreateFoodMachanicalofferDTO getOfferMechanic() {
        return offerMechanic;
    }

    public void setOfferMechanic(OfferFoodCreateFoodMachanicalofferDTO offerMechanic) {
        this.offerMechanic = offerMechanic;
    }

    public List<DayOfWeek> getDaysOfWeekAllowed() {
        return daysOfWeekAllowed;
    }

    public void setDaysOfWeekAllowed(List<DayOfWeek> daysOfWeekAllowed) {
        this.daysOfWeekAllowed = daysOfWeekAllowed;
    }
}
