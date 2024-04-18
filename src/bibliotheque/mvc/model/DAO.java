package bibliotheque.mvc.model;

import bibliotheque.mvcbeta.observer.Subject;

import java.util.List;

public abstract class DAO<T> extends Subject {

    public abstract T add( T elt) ;

    public abstract boolean remove( T elt) ;

    public abstract T update (T elt) ;

    public abstract T read(T rech) ;

    public abstract List<T> getAll() ;

    public List<T> getNotification(){
        return getAll();
    }
}