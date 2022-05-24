package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewRequestBody {
    @JsonProperty
    private String cookie;
    @JsonProperty
    private Boolean flag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewRequestBody that = (ViewRequestBody) o;

        if (!cookie.equals(that.cookie)) return false;
        return flag.equals(that.flag);
    }

    @Override
    public int hashCode() {
        int result = cookie.hashCode();
        result = 31 * result + flag.hashCode();
        return result;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public ViewRequestBody(String cookie, Boolean flag) {
        this.cookie = cookie;
        this.flag = flag;
    }
}
