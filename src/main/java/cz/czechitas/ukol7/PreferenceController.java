package cz.czechitas.ukol7;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class PreferenceController {
    public enum Barva{
        RED,
        BLUE,
        GREEN,
        YELLOW,
        PINK}
    private final PresentationModel<PreferenceBean> model;
    private final Action ulozitAction;

    public PreferenceController() {
        model = new PresentationModel<>(new PreferenceBean());
        ulozitAction = ActionBuilder.create("&Ulozit", this::handleUlozit);
        model.addBeanPropertyChangeListener(this::handlePropertyChange);
        vypoctiStavAkci();
    }

    private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
        vypoctiStavAkci();
    }

    public PresentationModel<PreferenceBean> getModel() {
        return model;
    }


    public Action getUlozitAction() {
        return ulozitAction;
    }

    private void vypoctiStavAkci() {

        if (model.getBean().getOblibenaBarva() == null){
            ulozitAction.setEnabled(false);
            return;
        }

        if (model.getBean().getPrezdivka() == null) {
            ulozitAction.setEnabled(false);
            return;
        }
        ulozitAction.setEnabled(true);
    }

    public void handleUlozit() {
        PreferenceBean bean = this.model.getBean();
        System.out.println("Přezdívka uživatele je:");
        System.out.printf("Přezdívka uživatele je: %s", bean.getPrezdivka()).println();
        System.out.printf("Oblíbená barva je: %s", bean.getOblibenaBarva().getText()).println();
    }
}



