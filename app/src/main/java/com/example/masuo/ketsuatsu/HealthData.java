package com.example.masuo.ketsuatsu;

/**
 * Created by Masuo on 2016/03/20.
 */
public class HealthData {
    private String recTime; // 記録日時
    private int systolic;   // Systolic blood pressure. 最高血圧。上。
    private int diastolic;  // Diastolic blood pressure. 最低血圧。下。
    private int pulse;      // 脈拍
    private String weight;  // 体重
    private String notes;   // ノート。メモ
    private boolean use;    // データ使用フラグ

    public String getRecTime() { return recTime; }

    public void setRecTime(String recTime) { this.recTime = recTime; }

    public int getSystolic() { return systolic; }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) { this.notes = notes; }

    public boolean isUse() { return use; }

    public void setUse(boolean use) { this.use = use; }
}
