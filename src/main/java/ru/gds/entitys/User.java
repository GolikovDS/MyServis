package ru.gds.entitys;



public class User {
    private int id;
    private String name;
    private String password;
    private String jsessionid;

    public User() {
    }

    public User(int id, String name, String password, String jsessionid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.jsessionid = jsessionid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", jsessionid='" + jsessionid + '\'' +
                '}';
    }
}
