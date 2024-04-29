package com.fly.mybatis.model;

/**
 * @author fly
 * @create 2024-04-29-14:11
 **/
public class FyUser {
    Long id;
    String email;

    public Long getId() {return id;}

    public FyUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {return email;}

    public FyUser setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FyUser fyUser = (FyUser) o;

        if (id != null ? !id.equals(fyUser.id) : fyUser.id != null) return false;
        return email != null ? email.equals(fyUser.email) : fyUser.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FyUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
