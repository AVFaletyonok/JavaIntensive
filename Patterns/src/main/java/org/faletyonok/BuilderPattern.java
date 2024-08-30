package org.faletyonok;

/**
 * @author Alexander Victorovich Faletyonok
 * <p>
 *     About singleton pattern: - antipattern
 *     - software pattern that restricts the instantiation
 *     of a class to a singular instance.
 *     The pattern is useful when exactly one object
 *     is needed to coordinate actions across a system.
 *     - reduces memory consumption;
 *     - the same internal state from anywhere.
 * </p>
 * https://github.com/AVFaletyonok/JavaIntensive
 */
public class BuilderPattern {
    public static void main(String[] args) {
        MyClass myClass = new MyClass.Builder()
                .someField("someValue")
                .anotherField(10)
                .build();

        System.out.println(myClass.getSomeField() + " " +
                            myClass.getAnotherField());
    }
}

class MyClass {
    public MyClass() {}

    private MyClass(Builder builder) {
        this.someField = builder.someField;
        this.anotherField = builder.anotherField;
    }

    private String someField;

    private int anotherField;

    public String getSomeField() {
        return someField;
    }

    public int getAnotherField() {
        return anotherField;
    }

    public static class Builder {

        private String someField;

        private int anotherField;

        public MyClass build() {
            return new MyClass(this);
        }

        public Builder someField(String someField) {
            this.someField = someField;
            return this;
        }

        public Builder anotherField(int anotherField) {
            this.anotherField = anotherField;
            return this;
        }
    }
}
