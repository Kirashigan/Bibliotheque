package bibliotheque.mvc.view;

import bibliotheque.mvcbeta.observer.Observer;
import bibliotheque.mvc.controller.Controller;

import java.util.List;


public abstract  class AbstractView<T> implements Observer {

    protected Controller<T> controller;
    protected List<T> la;

    public void setController(Controller<T> controller) {
        this.controller = controller;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<T> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
