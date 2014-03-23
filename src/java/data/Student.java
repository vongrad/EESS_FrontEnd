package data;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("name")
    private final String firstName;
    @SerializedName("primary")
    private String primary;
    @SerializedName("secondary")
    private String secondary;

    public Student(String firstName) {
        this.firstName = firstName;
        this.primary = "";
        this.secondary = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }
}
