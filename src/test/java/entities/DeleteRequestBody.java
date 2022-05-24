package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteRequestBody {
    @JsonProperty
    private String id;

    public DeleteRequestBody(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeleteRequestBody that = (DeleteRequestBody) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void setId(String id) {
        this.id = id;
    }
}
