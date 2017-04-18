package hu.javagladiators.example.sport.viewmodel.system;

/**
 *
 * @author krisztian
 */
public class FilterPOJO {
protected String type,sort,direction;
protected long per_page,page;

    public FilterPOJO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public long getPer_page() {
        return per_page;
    }

    public void setPer_page(long per_page) {
        this.per_page = per_page;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }
   
}
