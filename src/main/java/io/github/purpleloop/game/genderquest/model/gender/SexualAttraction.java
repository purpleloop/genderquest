package io.github.purpleloop.game.genderquest.model.gender;

import java.util.HashMap;
import java.util.Map;

import io.github.purpleloop.game.genderquest.model.Scale;

/** This class represents who we are sexually attracted to. */
public class SexualAttraction {

    /** Sexual attraction towards each other base gender. */
    private Map<BaseGender, Scale> sexualAttraction;

    /** Constructor for sexual attraction. */
    public SexualAttraction() {
        sexualAttraction = new HashMap<>();
        for (BaseGender baseGender : BaseGender.values()) {
            setSexualAttractionForGender(baseGender, Scale.N0);
        }
    }

    /**
     * Set how we are sexually attracted to a base gender according to a scale
     * value.
     * 
     * @param baseGender base gender
     * @param value scale value
     */
    public void setSexualAttractionForGender(BaseGender baseGender, Scale value) {
        sexualAttraction.put(baseGender, value);
    }

    /** @return the sexual attraction map for each base gender. */
    public Map<BaseGender, Scale> getSexualAttraction() {
        return sexualAttraction;
    }

    @Override
    public String toString() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("Sexual attraction : ");
        for (BaseGender baseGender : BaseGender.values()) {
            descriptionBuilder.append(baseGender.getSocialAdult());
            descriptionBuilder.append("(");
            descriptionBuilder.append(sexualAttraction.get(baseGender).ordinal());
            descriptionBuilder.append(") ");
        }

        return descriptionBuilder.toString();
    }

}
