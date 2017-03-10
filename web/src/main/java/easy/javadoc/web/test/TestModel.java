package easy.javadoc.web.test;


import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.annotation.TypeDescriptor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@TypeDescriptor(description = "测试类Model")
public class TestModel extends ParentTestModel {
    @FieldDescriptor(descripion = "string1描述")
    private String string1;
    @FieldDescriptor(descripion = "int1描述")
    private Integer int1;
    @FieldDescriptor(descripion = "int2描述")
    private int int2;
    @FieldDescriptor(descripion = "boolean1描述")
    private boolean boolean1;
    @FieldDescriptor(descripion = "boolean2描述")
    private Boolean boolean2;
    @FieldDescriptor(descripion = "date1描述")
    private Date date1;
    @FieldDescriptor(descripion = "float1描述")
    private float float1;
    @FieldDescriptor(descripion = "float2描述")
    private Float float2;
    @FieldDescriptor(descripion = "bigDecimal描述")
    private BigDecimal bigDecimal;
    @FieldDescriptor(descripion = "intArray描述")
    private Integer[] intArray;
    @FieldDescriptor(descripion = "test mdoels")
    private TestModel[] testModels;
    @FieldDescriptor(descripion = "测试枚举")
    private TestEnum testEnum;
    @FieldDescriptor(descripion = "测试枚举")
    private TestEnum[] testEnums;
    @FieldDescriptor(descripion = "测试泛型", defaultValue = "[]", isRequired = true, genericTypes = {String.class})
    private List<String> gStrings;
    @FieldDescriptor(descripion = "泛型测试", defaultValue = "[]", isRequired = true, genericTypes = {String.class, Integer.class})
    private Map<String, Integer> map;
    @FieldDescriptor(descripion = "泛型测试", defaultValue = "[]", isRequired = true, genericTypes = {String.class, TestModel.class})
    private Map<String,TestModel> stringTestModelMap;

    @FieldDescriptor(descripion = "泛型测试", defaultValue = "[]", isRequired = true, genericTypes = {String.class, TestModel[].class})
    private Map<String,TestModel[]> stringTestModelMap2;

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public boolean isBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public Boolean getBoolean2() {
        return boolean2;
    }

    public void setBoolean2(Boolean boolean2) {
        this.boolean2 = boolean2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public Float getFloat2() {
        return float2;
    }

    public void setFloat2(Float float2) {
        this.float2 = float2;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public Integer[] getIntArray() {
        return intArray;
    }

    public void setIntArray(Integer[] intArray) {
        this.intArray = intArray;
    }

    public TestModel[] getTestModels() {
        return testModels;
    }

    public void setTestModels(TestModel[] testModels) {
        this.testModels = testModels;
    }

    public TestEnum getTestEnum() {
        return testEnum;
    }

    public void setTestEnum(TestEnum testEnum) {
        this.testEnum = testEnum;
    }

    public TestEnum[] getTestEnums() {
        return testEnums;
    }

    public void setTestEnums(TestEnum[] testEnums) {
        this.testEnums = testEnums;
    }

    public List<String> getgStrings() {
        return gStrings;
    }

    public void setgStrings(List<String> gStrings) {
        this.gStrings = gStrings;
    }

    public Map<String, TestModel> getStringTestModelMap() {
        return stringTestModelMap;
    }

    public void setStringTestModelMap(Map<String, TestModel> stringTestModelMap) {
        this.stringTestModelMap = stringTestModelMap;
    }
}
