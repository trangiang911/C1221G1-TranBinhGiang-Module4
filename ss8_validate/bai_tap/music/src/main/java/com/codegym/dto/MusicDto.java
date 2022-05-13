package com.codegym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class MusicDto {
    private Integer id;
    @NotBlank(message = "ko đc để trống")
    private String link;
    @NotBlank(message = "ko đc để trống")
    @Pattern(regexp = "^[[a-zA-z][0-9] ]+$")
    private String name;
    @NotBlank(message = "ko đc để trống")
    @Pattern(regexp = "^[[a-zA-z][0-9] ]+$")
    private String singer;
    @NotBlank(message = "ko đc để trống")
    @Pattern(regexp = "^[[a-zA-Z][0-9]\\,]+$")
    private String type;

    public MusicDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
