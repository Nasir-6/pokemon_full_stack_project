package com.pokepals.pokemonbackend.trainer;

import java.util.Objects;

public class Trainer {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String sprite_link;

    public Trainer(Integer id, String name, String email, String password, String sprite_link) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.sprite_link = sprite_link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSprite_link() {
        return sprite_link;
    }

    public void setSprite_link(String sprite_link) {
        this.sprite_link = sprite_link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer trainer = (Trainer) o;
        return id == trainer.id && Objects.equals(name, trainer.name) && Objects.equals(email, trainer.email) && Objects.equals(password, trainer.password) && Objects.equals(sprite_link, trainer.sprite_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, sprite_link);
    }


    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sprite_link='" + sprite_link + '\'' +
                '}';
    }
}
