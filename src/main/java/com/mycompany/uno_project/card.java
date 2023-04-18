/**
 * The "card" class defines a card object with a color and value attribute.
 */
package com.mycompany.uno_project;


public class card {
    private String color;
    private String value;

    public card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    }


