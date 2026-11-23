package interfaces;

import java.util.Iterator;

public interface ITreeIterator<T> {

    public Iterator<T> getInorderIterator();

   public Iterator<T> getPreorderIterator();

    public Iterator<T> getPostorderIterator();
}
