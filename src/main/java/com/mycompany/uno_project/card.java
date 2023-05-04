/**
 * The "card" class defines a card object with a color and value attribute.
 */
package com.mycompany.uno_project;


public class card {
    private String color;
    private String value;

   // This is a constructor method for the `card` class that takes in two parameters, `color` and
   // `value`, and assigns them to the corresponding instance variables `this.color` and `this.value`.
   // This allows for the creation of a new `card` object with specific color and value attributes.
    public card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    
    //copy constructor
    public card(card car){
        this.color = car.color;
        this.value = car.value;
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


