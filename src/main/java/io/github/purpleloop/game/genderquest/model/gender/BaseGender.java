package io.github.purpleloop.game.genderquest.model.gender;

/** Base genders, used to build gender characteristics. */
public enum BaseGender {

    /** Male / masculine / man / boy gender. */
    MALE("Male", "Masculine", "Man", "Boy"),

    /** Female / feminine / woman / girl gender. */
    FEMALE("Female", "Feminine", "Woman", "Girl"),

    /** Other genders. */
    OTHER("Other", "Other", "Other", "Other");

    /** Name to use to design typical sexual characteristics. */
    private String sexualName;

    /** Name to use as an adjective to represent the identity and appearance. */
    private String adjective;

    /** Name use to represent a person as a social adult. */
    private String socialAdult;

    /** Name use to represent a person as a social child. */
    private String socialChild;

    /**
     * @param sexualName Name to use to design typical sexual characteristics.
     * @param adjective Name to use as an adjective to represent the identity
     *            and appearance.
     * @param socialAdult Name use to represent a person as a social adult.
     * @param socialChild Name use to represent a person as a social child.
     */
    BaseGender(String sexualName, String adjective, String socialAdult, String socialChild) {
        this.sexualName = sexualName;
        this.adjective = adjective;
        this.socialAdult = socialAdult;
        this.socialChild = socialChild;
    }

    /** @return Name to use to design typical sexual characteristics. */
    public String getSexualName() {
        return sexualName;
    }

    /**
     * @return Name to use as an adjective to represent the identity and
     *         appearance.
     */

    public String getAdjective() {
        return adjective;
    }

    /** @return Name use to represent a person as a social adult. */
    public String getSocialAdult() {
        return socialAdult;
    }

    /** @return Name use to represent a person as a social child. */
    public String getSocialChild() {
        return socialChild;
    }

}
