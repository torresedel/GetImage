package com.example.admin.firebasestorage;

/**
 * Created by Admin on 10/19/2017.
 */

public class PtoInfoClass {
    private float totalPto;
    private float usedPto;
    private float remainingPto;

    public PtoInfoClass(float totalPto, float usedPto, float remainingPto) {
        this.totalPto = totalPto;
        this.usedPto = usedPto;
        this.remainingPto = remainingPto;
    }

    public float getTotalPto() {
        return totalPto;
    }

    public void setTotalPto(float totalPto) {
        this.totalPto = totalPto;
    }

    public float getUsedPto() {
        return usedPto;
    }

    public void setUsedPto(float usedPto) {
        this.usedPto = usedPto;
    }

    public float getRemainingPto() {
        return remainingPto;
    }

    public void setRemainingPto(float remainingPto) {
        this.remainingPto = remainingPto;
    }
}
