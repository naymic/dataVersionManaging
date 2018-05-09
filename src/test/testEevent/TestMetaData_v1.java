package test.testEevent;

import com.company.BaseMetaData;

public class TestMetaData_v1 extends BaseMetaData {

    private String name;
    private Integer count;
    private Double price;
    private String type;


    @Override
    public void upgrade(BaseMetaData baseMetaData) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
