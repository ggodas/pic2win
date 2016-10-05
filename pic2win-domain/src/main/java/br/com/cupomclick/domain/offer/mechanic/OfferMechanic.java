package br.com.cupomclick.domain.offer.mechanic;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by georgegodas on 02/10/16.
 */
public abstract class OfferMechanic {
    protected List<DayOfWeek> daysOfWeekAllowed;
    private String blabla;

    public List<DayOfWeek> getDaysOfWeekAllowed() {
        return daysOfWeekAllowed;
    }

    public void addDaysOfWeekAllowed(DayOfWeek dayOfWeek) {
        this.daysOfWeekAllowed.add(dayOfWeek);
    }

    public String getBlabla() {
        return blabla;
    }

    public void setBlabla(String blabla) {
        this.blabla = blabla;
    }
}
