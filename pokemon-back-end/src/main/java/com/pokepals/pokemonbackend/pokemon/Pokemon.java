package com.pokepals.pokemonbackend.pokemon;

import java.util.Objects;

public class Pokemon {
    private Integer id;
    private Integer trainer_id ;
    private String name;
    private String pokeapi_id;
    private String sprite_link;
    private Integer hp;
    private Integer level;

    public Pokemon(Integer id, Integer trainer_id, String name, String pokeapi_id, String sprite_link, Integer hp, Integer level) {
        this.id = id;
        this.trainer_id = trainer_id;
        this.name = name;
        this.pokeapi_id = pokeapi_id;
        this.sprite_link = sprite_link;
        this.hp = hp;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public String getName() {
        return name;
    }

    public String getPokeapi_id() {
        return pokeapi_id;
    }

    public String getSprite_link() {
        return sprite_link;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPokeapi_id(String pokeapi_id) {
        this.pokeapi_id = pokeapi_id;
    }

    public void setSprite_link(String sprite_link) {
        this.sprite_link = sprite_link;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(trainer_id, pokemon.trainer_id) && Objects.equals(name, pokemon.name) && Objects.equals(pokeapi_id, pokemon.pokeapi_id) && Objects.equals(sprite_link, pokemon.sprite_link) && Objects.equals(hp, pokemon.hp) && Objects.equals(level, pokemon.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainer_id, name, pokeapi_id, sprite_link, hp, level);
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", trainer_id=" + trainer_id +
                ", name='" + name + '\'' +
                ", pokeapi_id='" + pokeapi_id + '\'' +
                ", sprite_link='" + sprite_link + '\'' +
                ", hp=" + hp +
                ", level=" + level +
                '}';
    }
}
