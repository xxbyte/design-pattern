package com.xiaokey.design.pattern.builder.v2;

/**
 * @author chenhao
 * @net xiaokey.com
 * @模式： 建造者模式与不可变对象配合使用
 * @应用场景： 1.需要生成的对象具有复杂的内部结构 2.需要生成的对象内部属性本身相互依赖 3.与不可变对象配合使用
 * @优点： 1、建造者独立，易扩展。 2、便于控制细节风险。
 */
public class BuilderTest2 {
    public static void main(String[] args) {

        Product.Builder builder = new Product.Builder().builderPart1("part1").builderPart2("part2");

        if (false) {
            builder.builderPart3("part3");
        }

        Product.Builder part4 = builder.builderPart4("part4");
        Product product = part4.build();
        System.out.println(product);
    }
}

class Product {


    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;
    //  .....


    public Product(String part1, String part2, String part3, String part4) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getPart1() {
        return part1;
    }

    public String getPart2() {
        return part2;
    }

    public String getPart3() {
        return part3;
    }

    public String getPart4() {
        return part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }


    static class Builder {
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder builderPart1(String part1) {
            this.part1 = part1;
            return this;
        }

        public Builder builderPart2(String part2) {
            this.part2 = part2;
            return this;
        }

        public Builder builderPart3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Builder builderPart4(String part4) {
            this.part4 = part4;
            return this;
        }

        Product build() {
            return new Product(part1, part2, part3, part4);
        }

    }


}

