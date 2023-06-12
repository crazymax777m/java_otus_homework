import java.util.Objects;

public class Client {
    private String name;
    private Integer age;

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(age, other.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
