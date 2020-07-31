package io.github.purpleloop.game.genderquest.gui;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import io.github.purpleloop.game.genderquest.model.Scale;
import io.github.purpleloop.game.genderquest.model.gender.AssignedBirthSex;
import io.github.purpleloop.game.genderquest.model.gender.BaseGender;
import io.github.purpleloop.game.genderquest.model.gender.Gender;
import io.github.purpleloop.game.genderquest.model.gender.GenderExpression;
import io.github.purpleloop.game.genderquest.model.gender.GenderIdentity;
import io.github.purpleloop.game.genderquest.model.gender.RomanticAttraction;
import io.github.purpleloop.game.genderquest.model.gender.SexualAttraction;
import purpleloop.commons.swing.SwingUtils;

/** A panel to edit gender characteristics. */
public class GenderPanel extends JPanel {

    /** Serialization tag. */
    private static final long serialVersionUID = 6104530409077717865L;

    /** Identifies sliders for gender id. */
    private static final String GENDER_ID_SLIDER = "genderIdentitySlider";

    /** Identifies sliders for gender expression. */
    private static final String GENDER_EXP_SLIDER = "genderExpressionSlider";

    /** Identifies radio buttons for birth assignation. */
    private static final String ASSIGNED_BIRTH_RADIO = "assignedBirthRadioButton";

    /** Identifies sliders for sexual attraction. */
    private static final String SEXUAL_ATTRACTION_SLIDER = "sexualAttractionSlider";

    /** Identifies sliders for romantic attraction. */
    private static final String ROMANTIC_ATTRACTION_SLIDER = "romanticAttractionSlider";

    /** Map of created components for update uses. */
    private Map<String, JComponent> components;

    /** Button group for assigned birth sex. */
    private ButtonGroup assignedBirthButtonGroup;

    /** Constructor. */
    public GenderPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        components = new HashMap<>();

        addGenderIdentityPanel();
        add(new JSeparator(SwingConstants.HORIZONTAL));
        addGenderExpressionPanel();
        add(new JSeparator(SwingConstants.HORIZONTAL));
        addAssignedBirthSexPanel();
        add(new JSeparator(SwingConstants.HORIZONTAL));
        addSexualAttractionPanel();
        add(new JSeparator(SwingConstants.HORIZONTAL));
        addRomanticAttractionPanel();
    }

    /** Adds a gender identity fieldSet. */
    private void addGenderIdentityPanel() {

        add(new JLabel("Gender identity"));

        JPanel genderIdentityPanel = new JPanel();
        genderIdentityPanel.setLayout(new GridLayout(0, 2));
        for (BaseGender baseGender : BaseGender.values()) {
            genderIdentityPanel.add(new JLabel(baseGender.getSocialAdult(), SwingConstants.RIGHT));
            JSlider slider = SwingUtils.createSlider(genderIdentityPanel, Scale.N0.ordinal(),
                    Scale.N9.ordinal(), Scale.N0.ordinal(), 1, true);
            components.put(GENDER_ID_SLIDER + baseGender.name(), slider);

        }
        add(genderIdentityPanel);
    }

    /** Adds a gender expression fieldSet. */
    private void addGenderExpressionPanel() {

        add(new JLabel("Gender expression"));

        JPanel genderExpressionPanel = new JPanel();
        genderExpressionPanel.setLayout(new GridLayout(0, 2));
        for (BaseGender baseGender : BaseGender.values()) {
            genderExpressionPanel.add(new JLabel(baseGender.getAdjective(), SwingConstants.RIGHT));
            JSlider slider = SwingUtils.createSlider(genderExpressionPanel, Scale.N0.ordinal(),
                    Scale.N9.ordinal(), Scale.N0.ordinal(), 1, true);
            components.put(GENDER_EXP_SLIDER + baseGender.name(), slider);

        }
        add(genderExpressionPanel);
    }

    /** Adds an assigned birth field. */
    private void addAssignedBirthSexPanel() {

        add(new JLabel("Assigned at birth"));

        JPanel assignedBirthSexPanel = new JPanel();

        assignedBirthButtonGroup = new ButtonGroup();

        for (AssignedBirthSex assignedSex : AssignedBirthSex.values()) {

            JRadioButton assignedBirthRadioButton = SwingUtils.createRadioButton(assignedSex.name(),
                    null, assignedBirthButtonGroup, null, assignedBirthSexPanel, false);

            components.put(ASSIGNED_BIRTH_RADIO + assignedSex.name(), assignedBirthRadioButton);

        }

        add(assignedBirthSexPanel);
    }

    /** Adds a sexual attraction field. */
    private void addSexualAttractionPanel() {

        add(new JLabel("Sexual attraction"));

        JPanel sexualAttractionPanel = new JPanel();
        sexualAttractionPanel.setLayout(new GridLayout(0, 2));
        for (BaseGender baseGender : BaseGender.values()) {
            sexualAttractionPanel
                    .add(new JLabel(baseGender.getSocialAdult(), SwingConstants.RIGHT));
            JSlider slider = SwingUtils.createSlider(sexualAttractionPanel, Scale.N0.ordinal(),
                    Scale.N9.ordinal(), Scale.N0.ordinal(), 1, true);
            components.put(SEXUAL_ATTRACTION_SLIDER + baseGender.name(), slider);

        }
        add(sexualAttractionPanel);
    }

    /** Adds a romantic attraction field. */
    private void addRomanticAttractionPanel() {

        add(new JLabel("Romantic attraction"));

        JPanel romanticAttractionPanel = new JPanel();
        romanticAttractionPanel.setLayout(new GridLayout(0, 2));
        for (BaseGender baseGender : BaseGender.values()) {
            romanticAttractionPanel
                    .add(new JLabel(baseGender.getSocialAdult(), SwingConstants.RIGHT));
            JSlider slider = SwingUtils.createSlider(romanticAttractionPanel, Scale.N0.ordinal(),
                    Scale.N9.ordinal(), Scale.N0.ordinal(), 1, true);
            components.put(ROMANTIC_ATTRACTION_SLIDER + baseGender.name(), slider);

        }
        add(romanticAttractionPanel);

    }

    /**
     * Set the fields values for the given gender.
     * 
     * @param gender Gender to represent
     */
    public void setGender(Gender gender) {

        setGenderIdentity(gender.getGenderIdentity());
        setGenderExpression(gender.getGenderExpression());
        setAssignedBirthSex(gender.getAssignedBirthSex());
        setSexualAttraction(gender.getSexualAttraction());
        setRomanticAttraction(gender.getRomanticAttraction());
    }

    /**
     * Set the fields values for the given gender identity.
     * 
     * @param genderIdentity Gender identity to represent
     */
    private void setGenderIdentity(GenderIdentity genderIdentity) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(GENDER_ID_SLIDER + genderName);
            slider.setValue(genderIdentity.getIdentification().get(baseGender).ordinal());
        }
    }

    /**
     * Set the fields values for the given gender expression.
     * 
     * @param genderExpression Gender expression to represent
     */
    private void setGenderExpression(GenderExpression genderExpression) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(GENDER_EXP_SLIDER + genderName);
            slider.setValue(genderExpression.getExpression().get(baseGender).ordinal());
        }
    }

    /**
     * Set the fields values for the given birth sex assignation.
     * 
     * @param assignedBirthSex Assigned birth sex to represent
     */
    private void setAssignedBirthSex(AssignedBirthSex assignedBirthSex) {

        for (AssignedBirthSex assignedSex : AssignedBirthSex.values()) {
            String sexName = assignedSex.name();
            JRadioButton assignedBirthRadioButton = (JRadioButton) components
                    .get(ASSIGNED_BIRTH_RADIO + sexName);
            assignedBirthRadioButton.setSelected(sexName.equals(assignedBirthSex.name()));
        }
    }

    /**
     * Set the fields values for the given gender expression.
     * 
     * @param sexualAttraction Gender expression to represent
     */
    private void setSexualAttraction(SexualAttraction sexualAttraction) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(SEXUAL_ATTRACTION_SLIDER + genderName);
            slider.setValue(sexualAttraction.getSexualAttraction().get(baseGender).ordinal());
        }
    }

    /**
     * Set the fields values for the given gender expression.
     * 
     * @param romanticAttraction Gender expression to represent
     */
    private void setRomanticAttraction(RomanticAttraction romanticAttraction) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(ROMANTIC_ATTRACTION_SLIDER + genderName);
            slider.setValue(romanticAttraction.getRomanticAttraction().get(baseGender).ordinal());
        }
    }

    /**
     * Updates the given gender according to form values.
     * 
     * @param gender gender to update
     */
    public void update(Gender gender) {
        updateGenderIdentity(gender.getGenderIdentity());
        updateGenderExpression(gender.getGenderExpression());
        updateAssignedBirthSex(gender);
        updateSexualAttraction(gender.getSexualAttraction());
        updateRomanticAttraction(gender.getRomanticAttraction());
    }

    /**
     * Updates the given gender identity according to form values.
     * 
     * @param genderIdentity gender identity to update
     */
    private void updateGenderIdentity(GenderIdentity genderIdentity) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(GENDER_ID_SLIDER + genderName);
            genderIdentity.setIdentificationForGender(baseGender,
                    Scale.values()[slider.getValue()]);
        }
    }

    /**
     * Updates the given gender expression according to form values.
     * 
     * @param genderExpression gender expression to update
     */
    private void updateGenderExpression(GenderExpression genderExpression) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(GENDER_EXP_SLIDER + genderName);
            genderExpression.setExpressionForGender(baseGender, Scale.values()[slider.getValue()]);
        }
    }

    /**
     * Updates the given gender expression according to form values.
     * 
     * @param gender gender to update
     */
    private void updateAssignedBirthSex(Gender gender) {

        for (AssignedBirthSex assignedSex : AssignedBirthSex.values()) {
            String assignedSexName = assignedSex.name();
            JRadioButton assignedBirthRadioButton = (JRadioButton) components
                    .get(ASSIGNED_BIRTH_RADIO + assignedSexName);
            if (assignedBirthRadioButton.isSelected()) {
                gender.setAssignedBirthSex(assignedSex);
            }
        }

    }

    /**
     * Updates the given sexual attraction according to form values.
     * 
     * @param sexualAttraction sexual attraction to update
     */
    private void updateSexualAttraction(SexualAttraction sexualAttraction) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(SEXUAL_ATTRACTION_SLIDER + genderName);
            sexualAttraction.setSexualAttractionForGender(baseGender,
                    Scale.values()[slider.getValue()]);
        }
    }

    /**
     * Updates the given romantic attraction according to form values.
     * 
     * @param romanticAttraction romantic attraction to update
     */
    private void updateRomanticAttraction(RomanticAttraction romanticAttraction) {
        for (BaseGender baseGender : BaseGender.values()) {
            String genderName = baseGender.name();
            JSlider slider = (JSlider) components.get(ROMANTIC_ATTRACTION_SLIDER + genderName);
            romanticAttraction.setRomanticAttractionForGender(baseGender,
                    Scale.values()[slider.getValue()]);
        }
    }

}
