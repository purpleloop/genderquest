package io.github.purpleloop.game.genderquest.model;

import io.github.purpleloop.game.genderquest.model.gender.Gender;

/** Models a persona. */
public class Persona {

    /** The persona's name. */
    private String name;

    /** The persona's gender. */
    private Gender gender;

    /** Constructor of a persona. */
    public Persona() {
        this.name = "Noname";
        this.gender = new Gender();
    }

    /** @param name the name of the persona */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the name of the persona */
    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
