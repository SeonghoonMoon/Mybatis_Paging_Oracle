package com.hanatour.account.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Component
public class Criteria {
    private int pageNum;
    private int amount;
    private String type;
    private String keyword;

    public Criteria(){
        this.pageNum = 1;
        this.amount = 10;
    }

    public String getListLink() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum",pageNum)
                .queryParam("amount",amount);
        return builder.toUriString();
    }

    public String[] getTypeArr(){
        return type == null ? new String[]{} : type.split("");
    }
}
