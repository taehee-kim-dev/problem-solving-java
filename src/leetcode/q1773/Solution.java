package leetcode.q1773;

import java.util.ArrayList;
import java.util.List;

enum RuleKey {
    TYPE, COLOR, NAME
}

class Item {

    private final String type;
    private final String color;
    private final String name;

    public Item(String type, String color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

    public boolean isMatchedByRule(Rule rule) {
        String ruleValue = rule.getRuleValue();
        if (rule.getRuleKey() == RuleKey.TYPE) {
            return type.equals(ruleValue);
        }
        if (rule.getRuleKey() == RuleKey.COLOR) {
            return color.equals(ruleValue);
        }
        if (rule.getRuleKey() == RuleKey.NAME) {
            return name.equals(ruleValue);
        }
        throw new IllegalArgumentException("유효하지 않은 RuleKey입니다.");
    }
}

class Rule {

    private final RuleKey ruleKey;
    private final String ruleValue;

    public Rule(RuleKey ruleKey, String ruleValue) {
        this.ruleKey = ruleKey;
        this.ruleValue = ruleValue;
    }

    public RuleKey getRuleKey() {
        return ruleKey;
    }

    public String getRuleValue() {
        return ruleValue;
    }
}

class Solution {

    public int countMatches(List<List<String>> inputItems, String ruleKey, String ruleValue) {
        List<Item> items = getConvertedItems(inputItems);
        Rule rule = new Rule(RuleKey.valueOf(ruleKey.toUpperCase()), ruleValue);
        return getNumberOfMatchedItems(items, rule);
    }

    private int getNumberOfMatchedItems(List<Item> items, Rule rule) {
        int numberOfMatchedItems = 0;
        for (Item item : items) {
            if (item.isMatchedByRule(rule)) {
                numberOfMatchedItems += 1;
            }
        }
        return numberOfMatchedItems;
    }

    private List<Item> getConvertedItems(List<List<String>> inputItems) {
        List<Item> convertedItems = new ArrayList<>();
        for (List<String> inputItem : inputItems) {
            Item item = new Item(inputItem.get(0), inputItem.get(1), inputItem.get(2));
            convertedItems.add(item);
        }
        return convertedItems;
    }
}
