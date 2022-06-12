package cz.czechitas.ukol7;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;

public class PreferenceBean implements ObservableBean  {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);
    private String prezdivka;
    private Barva oblibenaBarva;


    public Barva getOblibenaBarva() {
        return oblibenaBarva;
    }

    public void setOblibenaBarva(Barva oblibenaBarva) {
        Barva staraBarva = this.oblibenaBarva;
        this.oblibenaBarva = oblibenaBarva;
        pcs.firePropertyChange("oblibenaBarva", staraBarva, oblibenaBarva);

    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        String staraPrezdivka = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("Prezdivka", staraPrezdivka, prezdivka);


    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
enum Barva{
    Red("Červená"),
    Blue("Modrá"),
    Green("Zelená"),
    Yellow("Žlutá"),
    Pink("Růžová");

    private final String text;

    Barva(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}