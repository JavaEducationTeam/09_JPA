package hu.javagladiators.example.sport.viewmodel.system;

import hu.javagladiators.example.sport.viewmodel.IdNamePOJO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public class PickListPOJO {
    String title;
    List<IdNamePOJO> selected = new ArrayList<>();
    List<IdNamePOJO> unselected = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IdNamePOJO> getSelected() {
        return selected;
    }

    public void setSelected(List<IdNamePOJO> selected) {
        this.selected = selected;
    }

    public void addSelected(IdNamePOJO selected) {
        this.selected.add(selected);
    }

    public List<IdNamePOJO> getUnselected() {
        return unselected;
    }

    public void setUnselected(List<IdNamePOJO> unselected) {
        this.unselected = unselected;
    }
    
    public void addUnselected(IdNamePOJO unselected) {
        this.unselected.add(unselected);
    }
}
