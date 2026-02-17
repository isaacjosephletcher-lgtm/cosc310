import chapter8.Person;

public class BannerAdmin extends Person {
    
    public BannerAdmin(String name, String id, String addr, String email) {
        super(name, id, addr, email);
    }
    @Override
    public String getType() {
        return "BannerAdmin" + name;
    }
}
