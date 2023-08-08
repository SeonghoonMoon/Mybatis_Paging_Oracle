package com.hanatour.account.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private Criteria criteria;

    public PageDTO(){};

    public PageDTO(int total, int pageCount, Criteria criteria) {
        this.total = total;
        this.criteria = criteria;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage - 9;
        realEnd = (int)(Math.ceil(total*1.0 / criteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd ==0 ? 1 : realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }

}
