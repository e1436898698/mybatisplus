package com.liianjun.demo.test.doman;


import lombok.Data;

import java.util.List;
@Data
public class TestA {

    private List<Titles> title;
    private List<com.liianjun.demo.test.doman.data> data;

    private List<Integer> warningIndex;
}
