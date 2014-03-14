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
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(Elective primary) {
        this.primary = primary.getSubject();
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(Elective secondary) {
        this.secondary = secondary.getSubject();
    }
}
