package io.github.purpleloop.game.genderquest.model.gender;

import java.util.HashMap;
import java.util.Map;

import io.github.purpleloop.game.genderquest.model.Scale;

/** Who we are romantically or emotionally attracted to. */
public class RomanticAttraction {

    /** Romantic attraction for each base gender. */
    private Map<BaseGender, Scale> romanticAttraction;

    /** Constructs a romantic attraction. */
    public RomanticAttraction() {
        romanticAttraction = new HashMap<>();
    }

    /**
     * Set how we are romantically attracted to a base gender, according to a
     * scale value.
     * 
     * @param baseGender base gender
     * @param value scale value
     */
    public void setRomanticAttractionForGender(BaseGender baseGender, Scale value) {
        romanticAttraction.put(baseGender, value);
    }

    /** @return the romantic attraction map for each base gender. */
    public Map<BaseGender, Scale> getRomanticAttraction() {
        return romanticAttraction;
    }

    @Override
    public String toString() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("Romantic attraction : ");
        for (BaseGender baseGender : BaseGender.values()) {
            descriptionBuilder.append(baseGender.getSocialAdult());
            descriptionBuilder.append("(");
            descriptionBuilder.append(romanticAttraction.get(baseGender).ordinal());
            descriptionBuilder.append(") ");
        }
                
        return descriptionBuilder.toString(); 
    }
    
}
