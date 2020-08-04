package io.github.purpleloop.game.genderquest.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.github.purpleloop.commons.swing.SwingUtils;
import io.github.purpleloop.game.genderquest.model.Persona;

/** The panel for a editing a persona. */
public class PersonaPanel extends JPanel {

    /** Class logger. */
    public static final Log LOG = LogFactory.getLog(PersonaPanel.class);

    /** Serialization tag. */
    private static final long serialVersionUID = 6076337487275275152L;

    /** The current persona. */
    private Persona persona;

    /** The gender panel. */
    private GenderPanel genderPanel;

    /** Textfield for the persona's name. */
    private JTextField nameTextField;

    /** Reset listener. */
    private Action resetAction = new AbstractAction("Reset") {
    
        /** Serial tag. */
        private static final long serialVersionUID = -5839058319026718576L;
    
        @Override
        public void actionPerformed(ActionEvent e) {
            resetPersonaForm();
        }
    };

    /** Update listener. */
    private Action updateAction = new AbstractAction("Update") {

        /** Serial tag. */
        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {       
          updatePersona();
        }

    };

    /** Panel constructor. */
    public PersonaPanel() {

        setPreferredSize(new Dimension(800, 600));

        setLayout(new BorderLayout());

        JPanel idPanel = new JPanel();

        idPanel.setLayout(new GridLayout(0, 2));

        SwingUtils.addLabel("Name", idPanel);
        nameTextField = SwingUtils.addTextField(40, "", idPanel, null);

        add(idPanel, BorderLayout.NORTH);

        genderPanel = new GenderPanel();

        add(genderPanel, BorderLayout.CENTER);

        JPanel commandPanel = new JPanel();
        add(commandPanel, BorderLayout.SOUTH);

        SwingUtils.createButton(resetAction, commandPanel);
        SwingUtils.createButton(updateAction, commandPanel);
    }

    /**
     * Set the persona to edit.
     * 
     * @param persona persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
        nameTextField.setText(persona.getName());
        genderPanel.setGender(persona.getGender());
    }

    protected void resetPersonaForm() {
        nameTextField.setText(persona.getName());
        genderPanel.setGender(persona.getGender());        
    }

    /** Updates the persona from the form fields. */
    private void updatePersona() {
        persona.setName(nameTextField.getText());
        genderPanel.update(this.persona.getGender());
        LOG.info(this.persona.getGender().toString());
    }

}
