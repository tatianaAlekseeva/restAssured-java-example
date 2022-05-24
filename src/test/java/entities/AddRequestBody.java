package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRequestBody {
    @JsonProperty
    private String id;
    @JsonProperty
    private String cookie;
    @JsonProperty("prod_id")
    private String prodId;
    @JsonProperty
    private Boolean flag;

    public AddRequestBody(String id, String cookie, String prodId, Boolean flag) {
        this.id = id;
        this.cookie = cookie;
        this.prodId = prodId;
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddRequestBody that = (AddRequestBody) o;

        if (!id.equals(that.id)) return false;
        if (!cookie.equals(that.cookie)) return false;
        if (!prodId.equals(that.prodId)) return false;
        return flag.equals(that.flag);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cookie.hashCode();
        result = 31 * result + prodId.hashCode();
        result = 31 * result + flag.hashCode();
        return result;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
