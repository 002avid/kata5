package es.ulpgc.is2.control.pojo;


public class RandomUser {
    private String gender;
    private String email;
    private Name name;
    private Picture picture;

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Picture getPicture() {
        return picture;
    }

    public record Name(String title, String first, String last){}
    public record Picture(String large, String medium, String thumbnail){}

}
