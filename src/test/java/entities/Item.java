package entities;

public class Item {
    private String cookie;

    private String id;

    private String prod_id;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!cookie.equals(item.cookie)) return false;
        if (!id.equals(item.id)) return false;
        return prod_id.equals(item.prod_id);
    }

    @Override
    public int hashCode() {
        int result = cookie.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + prod_id.hashCode();
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }
}
