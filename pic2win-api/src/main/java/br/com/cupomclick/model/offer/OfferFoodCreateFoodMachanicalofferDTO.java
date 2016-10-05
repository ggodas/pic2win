package br.com.cupomclick.model.offer;

/**
 * Created by georgegodas on 03/10/16.
 */
public class OfferFoodCreateFoodMachanicalofferDTO {
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
