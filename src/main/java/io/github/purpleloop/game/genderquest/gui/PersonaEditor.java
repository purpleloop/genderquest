package io.github.purpleloop.game.genderquest.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.github.purpleloop.game.genderquest.model.Persona;

/** Graphic user interface for the persona editor. */
public class PersonaEditor extends JFrame {

    /** Serialization tag. */
    private static final long serialVersionUID = -8896233199139665019L;

    /** Class logger. */
    public static final Log LOG = LogFactory.getLog(PersonaEditor.class);

    /** The current persona. */
    protected Persona persona;

    /** Persona panel. */
    private PersonaPanel personaPanel;

    /** Creates an new persona. */
    private Action newPersonaAction = new AbstractAction() {

        /** Serialization tag. */
        private static final long serialVersionUID = 5436485080962804246L;

        @Override
        public void actionPerformed(ActionEvent e) {
            newPersona();
        }

    };

    public PersonaEditor() {
        super("Persona Editor");

        JMenuBar menuBar = new JMenuBar();

        JMenu personaMenu = new JMenu("Persona");
        menuBar.add(personaMenu);

        JMenuItem newPrsonaMenuItem = new JMenuItem(newPersonaAction);
        personaMenu.add(newPrsonaMenuItem);

        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();

        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        personaPanel = new PersonaPanel();
        mainPanel.add(personaPanel, BorderLayout.CENTER);

        newPersona();

        pack();
    }

    /** Creates a new persona. */
    private void newPersona() {
        persona = new Persona();
        personaPanel.setPersona(persona);
    }

    /**
     * Entry point for the editor.
     * 
     * @param args command-line arguments
     */
    public static void main(String... args) {
        PersonaEditor personaEditor = new PersonaEditor();
        personaEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        personaEditor.setVisible(true);
    }

}
