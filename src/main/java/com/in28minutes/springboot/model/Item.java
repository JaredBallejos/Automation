package com.in28minutes.springboot.model;

public class Item {
    private String item1;
    private String item2;
    private String item3;

    public Item(String item1, String item2, String item3) {
        super();
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public String getitem1() {
        return item1;
    }
    public void setitem1(String item1) {
        this.item1 = item1;
    }
    public String getitem2() {
        return item2;
    }
    public void setitem2(String item2) {
        this.item2 = item2;
    }
    public String getitem3() {
        return item3;
    }
    public void setEmail(String item3) {
        this.item3 = item3;
    }
}
