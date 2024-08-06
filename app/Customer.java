import java.time.LocalDate;

public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" :");
        builder.append("\"" + id + "\"");
        builder.append(", \"firstName\" :");
        builder.append("\"" + firstName + "\"");
        builder.append(", \"lastName\" :");
        builder.append("\"" + lastName + "\"");
        builder.append(", \"phone\" :");
        builder.append("\"" + phone + "\"");
        builder.append(", \"birthDate\" :");
        builder.append("\"" + birthDate + "\"");
        builder.append("}");
        return builder.toString();
    }

}
