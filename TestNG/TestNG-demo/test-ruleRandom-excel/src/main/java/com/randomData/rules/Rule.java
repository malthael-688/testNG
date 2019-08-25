package com.randomData.rules;

import java.util.List;

/**
 * @author Malthael
 * @date 2019/8/21
 * 规则
 */
public class Rule {
    //规则名称
    private String ruleName;
    //属性名称
    private String typeName;
    //属性类型
    private String type;
    //长度
    private int length;
    //是否有特殊字符
    private boolean hasSpecial;
    //是否可以长度越界
    private boolean hasCross;
    //是否有数字
    private boolean hasNumber;
    //是否有字母
    private boolean hasChar;
    //是否可以重复
    private boolean hasSame;
    //是否可以为空
    private boolean hasEmpty;

    public Rule(String ruleName, String typeName, String type, int length, boolean hasSpecial, boolean hasCross, boolean hasNumber, boolean hasChar, boolean hasSame, boolean hasEmpty) {
        this.ruleName = ruleName;
        this.typeName = typeName;
        this.type = type;
        this.length = length;
        this.hasSpecial = hasSpecial;
        this.hasCross = hasCross;
        this.hasNumber = hasNumber;
        this.hasChar = hasChar;
        this.hasSame = hasSame;
        this.hasEmpty = hasEmpty;
    }
    public Rule()
    {

    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleName='" + ruleName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", hasSpecial=" + hasSpecial +
                ", hasCross=" + hasCross +
                ", hasNumber=" + hasNumber +
                ", hasChar=" + hasChar +
                ", hasSame=" + hasSame +
                ", hasEmpty=" + hasEmpty +
                '}';
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHasSpecial() {
        return hasSpecial;
    }

    public void setHasSpecial(boolean hasSpecial) {
        this.hasSpecial = hasSpecial;
    }

    public boolean isHasCross() {
        return hasCross;
    }

    public void setHasCross(boolean hasCross) {
        this.hasCross = hasCross;
    }

    public boolean isHasNumber() {
        return hasNumber;
    }

    public void setHasNumber(boolean hasNumber) {
        this.hasNumber = hasNumber;
    }

    public boolean isHasChar() {
        return hasChar;
    }

    public void setHasChar(boolean hasChar) {
        this.hasChar = hasChar;
    }

    public boolean isHasSame() {
        return hasSame;
    }

    public void setHasSame(boolean hasSame) {
        this.hasSame = hasSame;
    }

    public boolean isHasEmpty() {
        return hasEmpty;
    }

    public void setHasEmpty(boolean hasEmpty) {
        this.hasEmpty = hasEmpty;
    }
}
