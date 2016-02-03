package tyfrontier.cleanarchitecturesample.data.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDto {

    @SerializedName("id")
    @Expose
    public String id;
}
