package model;

import javax.persistence.Entity;

@Entity
public class UserDetails {
    private final String phone;
    private final String nickName;
    private final String city;
    private final int birthDay;
    private final int birthMonth;
    private final int birthYear;
    private final String zipCode;
    private final String avatar;

    public static class Builder {
        private String phone = null;
        private String nickName = "0";
        private String city = "0";
        private int birthDay = 1;
        private int birthMonth = 1;
        private int birthYear = 1920;
        private String zipCode = "0";
        private String avatar = "0";

        public Builder() {
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder birthDay(int birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder birthMonth(int birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder birthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserDetails build() {
            return new UserDetails(this);
        }
    }

    private UserDetails(Builder builder) {
        this.phone = builder.phone;
        this.nickName = builder.nickName;
        this.city = builder.city;
        this.birthDay = builder.birthDay;
        this.birthMonth = builder.birthMonth;
        this.birthYear = builder.birthYear;
        this.zipCode = builder.zipCode;
        this.avatar = builder.avatar;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCity() {
        return city;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "phone=" + getPhone() +
                ", nickName=" + getNickName() +
                ", city=" + getCity() +
                ", birthDay=" + getBirthDay() +
                ", birthMonth=" + getBirthMonth() +
                ", birthYear=" + getBirthYear() +
                ", zipCode=" + getZipCode() +
                ", avatar=" + getAvatar() +
                '}';
    }
}
