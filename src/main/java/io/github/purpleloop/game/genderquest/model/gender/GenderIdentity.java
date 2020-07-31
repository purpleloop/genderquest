package io.github.purpleloop.game.genderquest.model.gender;

import java.util.HashMap;
import java.util.Map;

import io.github.purpleloop.game.genderquest.model.Scale;

/**
 * The gender we feel and define ourselves.
 * 
 * This is the sense of feel or being of each given base gender.
 */
public class GenderIdentity {

    /** Identification for each basic gender. */
    private Map<BaseGender, Scale> identification;

    /** Creates a gender identity. */
    public GenderIdentity() {
        identification = new HashMap<>();
    }

    /**
     * Set how we identify to a base gender, according to a scale value.
     * 
     * @param baseGender base gender
     * @param value scale value
     */
    public void setIdentificationForGender(BaseGender baseGender, Scale value) {
        identification.put(baseGender, value);
    }

    /** @return the identification map for each base gender. */
    public Map<BaseGender, Scale> getIdentification() {
        return identification;
    }
    
    @Override
    public String toString() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("Gender identity : ");
        for (BaseGender baseGender : BaseGender.values()) {
            descriptionBuilder.append(baseGender.getSocialAdult());
            descriptionBuilder.append("(");
            descriptionBuilder.append(identification.get(baseGender).ordinal());
            descriptionBuilder.append(") ");
        }
                
        return descriptionBuilder.toString(); 
    }

}
