package io.github.purpleloop.game.genderquest.model.gender;

/**
 * Gender of a person.
 * 
 * This class is adapted from the "Gender Unicorn" model by Landyn Pan and Ana
 * More at Trans Student Educational Research (TSER).
 * http://www.transstudent.org/
 */
public class Gender {

    /** The gender we feel and define ourselves. */
    private GenderIdentity genderIdentity;

    /** The gender we express through our behavior, style, etc. */
    private GenderExpression genderExpression;

    /** Gender assigned at birth from genitals appearance. */
    private AssignedBirthSex assignedBirthSex;

    /** Who we are sexually attracted to. */
    private SexualAttraction sexualAttraction;

    /** Who we are romantically attracted to. */
    private RomanticAttraction romanticAttraction;

    /** Gender constructor. */
    public Gender() {

        genderIdentity = new GenderIdentity();
        genderExpression = new GenderExpression();
        sexualAttraction = new SexualAttraction();
        romanticAttraction = new RomanticAttraction();
    }

    /** @param genderIdentity The gender we feel and define ourselves */
    public void setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
    }

    /** @return The gender we feel and define ourselves */
    public GenderIdentity getGenderIdentity() {
        return genderIdentity;
    }

    /**
     * @param genderExpression The gender we express through our behavior,
     *            style, etc
     */
    public void setGenderExpression(GenderExpression genderExpression) {
        this.genderExpression = genderExpression;
    }

    /** @return The gender we express through our behavior, style, etc */
    public GenderExpression getGenderExpression() {
        return genderExpression;
    }

    /**
     * @param assignedBirthSex Gender assigned at birth from genitals appearance
     */
    public void setAssignedBirthSex(AssignedBirthSex assignedBirthSex) {
        this.assignedBirthSex = assignedBirthSex;
    }

    /** @return Gender assigned at birth from genitals appearance */
    public AssignedBirthSex getAssignedBirthSex() {
        return assignedBirthSex;
    }

    /** @param sexualAttraction Who we are sexually attracted to */
    public void setSexualAttraction(SexualAttraction sexualAttraction) {
        this.sexualAttraction = sexualAttraction;
    }

    /** @return Who we are sexually attracted to */
    public SexualAttraction getSexualAttraction() {
        return sexualAttraction;
    }

    /** @param romanticAttraction Who we are romantically attracted to */
    public void setRomanticAttraction(RomanticAttraction romanticAttraction) {
        this.romanticAttraction = romanticAttraction;
    }

    /** @return Who we are romantically attracted to */
    public RomanticAttraction getRomanticAttraction() {
        return romanticAttraction;
    }

    @Override
    public String toString() {
        StringBuilder descriptionBuilder = new StringBuilder();        
        descriptionBuilder.append(genderIdentity.toString());
        descriptionBuilder.append(System.lineSeparator());
        descriptionBuilder.append(genderExpression.toString());
        descriptionBuilder.append(System.lineSeparator());
        descriptionBuilder.append("Assigned birth sex : ");
        descriptionBuilder.append(assignedBirthSex.name());
        descriptionBuilder.append(System.lineSeparator());
        descriptionBuilder.append(sexualAttraction.toString());
        descriptionBuilder.append(System.lineSeparator());
        descriptionBuilder.append(romanticAttraction.toString());  
        descriptionBuilder.append(System.lineSeparator());              
        return descriptionBuilder.toString(); 
    }
    
}
