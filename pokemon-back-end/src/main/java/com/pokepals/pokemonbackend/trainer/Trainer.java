package com.pokepals.pokemonbackend.trainer;

import java.util.Objects;

public class Trainer {
    private int id;
    private String name;
    private String emailAddress;
    private String password;
    private String spriteLink;

    public Trainer(int id, String name, String emailAddress, String password, String spriteLink) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.spriteLink = spriteLink;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpriteLink() {
        return spriteLink;
    }

    public void setSpriteLink(String spriteLink) {
        this.spriteLink = spriteLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer trainer = (Trainer) o;
        return id == trainer.id && Objects.equals(name, trainer.name) && Objects.equals(emailAddress, trainer.emailAddress) && Objects.equals(password, trainer.password) && Objects.equals(spriteLink, trainer.spriteLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emailAddress, password, spriteLink);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", spriteLink='" + spriteLink + '\'' +
                '}';
    }
}
