package io.github.purpleloop.game.genderquest.model.gender;

import java.util.HashMap;
import java.util.Map;

import io.github.purpleloop.game.genderquest.model.Scale;

/**
 * The gender we express through our behavior, style, etc. This is the gender we
 * express in public.
 */
public class GenderExpression {

    /** Expression for each base gender. */
    private Map<BaseGender, Scale> expression;

    /** Constructs a gender expression. */
    public GenderExpression() {
        expression = new HashMap<>();
    }

    /**
     * Set how we express, relatively to a base gender according to a scale
     * value.
     * 
     * @param baseGender base gender
     * @param value scale value
     */
    public void setExpressionForGender(BaseGender baseGender, Scale value) {
        expression.put(baseGender, value);
    }

    /** @return the expression map for each base gender. */
    public Map<BaseGender, Scale> getExpression() {
        return expression;
    }

}
