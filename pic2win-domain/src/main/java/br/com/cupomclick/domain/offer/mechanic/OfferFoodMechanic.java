package br.com.cupomclick.domain.offer.mechanic;

/**
 * Created by georgegodas on 02/10/16.
 */
public class OfferFoodMechanic extends OfferMechanic {
    private double amountMinToParticipate;
    private double maxDaysForParticipationExpiration;
    private int participationsNeededToWin;

    public double getAmountMinToParticipate() {
        return amountMinToParticipate;
    }

    public void setAmountMinToParticipate(double amountMinToParticipate) {
        this.amountMinToParticipate = amountMinToParticipate;
    }

    public double getMaxDaysForParticipationExpiration() {
        return maxDaysForParticipationExpiration;
    }

    public void setMaxDaysForParticipationExpiration(double maxDaysForParticipationExpiration) {
        this.maxDaysForParticipationExpiration = maxDaysForParticipationExpiration;
    }

    public int getParticipationsNeededToWin() {
        return participationsNeededToWin;
    }

    public void setParticipationsNeededToWin(int participationsNeededToWin) {
        this.participationsNeededToWin = participationsNeededToWin;
    }
}
