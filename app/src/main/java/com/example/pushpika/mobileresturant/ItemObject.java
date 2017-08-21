package com.example.pushpika.mobileresturant;


public class ItemObject {
    private int id;
    private String name;
    private String category;
    private float price;
    private int quantity;
    private boolean isOrdered;
    private int thumbnail;

    private int [] imageList = { R.drawable.no_image_available,
            R.drawable.breakfast_rice, R.drawable.breakfast_string_hoppers, R.drawable.breakfast_milk_rice, R.drawable.breakfast_rotti,
            R.drawable.lunch_vegitable_rice, R.drawable.lunch_chicken_rice, R.drawable.lunch_fish_rice, R.drawable.lunch_egg_rice, R.drawable.lunch_fried_rice,
            R.drawable.shorteats_fish_bun, R.drawable.shorteats_seenisambol, R.drawable.shorteats_egg_bun, R.drawable.shorteats_fish_rolls, R.drawable.shorteats_pasties, R.drawable.shorteats_pastry, R.drawable.shorteats_cupcakes,
            R.drawable.drinks_vanilla, R.drawable.drinks_chocolate, R.drawable.drinks_ice_coffee, R.drawable.drinks_falooda,
            R.drawable.desert_vanila, R.drawable.desert_chcolate, R.drawable.desert_strawberry, R.drawable.desert_yogurt, R.drawable.desert_biscuit_pudding, R.drawable.desert_caramel_pudding, R.drawable.desert_watalappan,
            R.drawable.fruits_apple, R.drawable.fruits_orange, R.drawable.fruits_papaya, R.drawable.fruits_mango, R.drawable.fruits_grapes, R.drawable.fruits_pears, R.drawable.fruits_water_melon, R.drawable.fruits_mixed_fruits,
            R.drawable.fruit_juice_apple_juice, R.drawable.fruit_juice_orange_juice, R.drawable.fruit_juice_papaya_juice, R.drawable.fruit_juice_papaya_juice, R.drawable.fruit_juice_watermelon, R.drawable.fruit_juice_mixed_fruit_juice, R.drawable.fruit_juice_mixed_fruit_juice
    };

    public ItemObject() {
    }

    public ItemObject(int id, String name, String category,float price, int quantity, boolean isOrdered, int thumbnail) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.isOrdered =isOrdered;
        this.thumbnail = thumbnail;
    }

    public ItemObject(ItemObject itemObject) {
        this.id = itemObject.id;
        this.name = itemObject.name;
        this.category = itemObject.category;
        this.price = itemObject.price;
        this.quantity = itemObject.quantity;
        this.isOrdered =itemObject.isOrdered;
        this.thumbnail = itemObject.thumbnail;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsOrdered() {
        return isOrdered;
    }
    public void setIsOrdered(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public int getThumbnail() {
        if (thumbnail < imageList.length){
            return imageList[thumbnail];
        }
        return imageList[0];
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
