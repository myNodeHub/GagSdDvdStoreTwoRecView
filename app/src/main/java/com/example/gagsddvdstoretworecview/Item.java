package com.example.gagsddvdstoretworecview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Item implements Parcelable {

    private String itemName;
    private int itemCost;
    private String itemBarcode;

    private int numPage;
    private String progrLangOrIngredient;
    private int minAge;
    private String genre;

    private String diskType;
    private String diskSoft;

    public Item(String itemName, int itemCost, String itemBarcode, int numPage, String progrLangOrIngredient, int minAge, String genre, String diskType, String diskSoft) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemBarcode = itemBarcode;
        this.numPage = numPage;
        this.progrLangOrIngredient = progrLangOrIngredient;
        this.minAge = minAge;
        this.genre = genre;
        this.diskType = diskType;
        this.diskSoft = diskSoft;
    }

    //программирование и кулинария
    public Item(String itemName, int itemCost, String itemBarcode, int numPage, String genre, String progrLangOrIngredient) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemBarcode = itemBarcode;
        this.numPage = numPage;
        this.genre = genre;
        this.progrLangOrIngredient = progrLangOrIngredient;
    }

    //изотерика
    public Item(String itemName, int itemCost, String itemBarcode, int numPage, String genre, int minAge) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemBarcode = itemBarcode;
        this.numPage = numPage;
        this.genre = genre;
        this.minAge = minAge;
    }

    //диски
    public Item(String itemName, int itemCost, String itemBarcode, String diskType, String diskSoft) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemBarcode = itemBarcode;
        this.diskType = diskType;
        this.diskSoft = diskSoft;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCost() {
        return itemCost;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public int getItemPage() {
        return numPage;
    }

    public String getProgrLangOrIngredient() {
        return progrLangOrIngredient;
    }

    public int getMinAge() {
        return minAge;
    }

    public String getGenre() {
        return genre;
    }

    public String getDiskType() {
        return diskType;
    }

    public String getDiskSoft() {
        return diskSoft;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemCost=" + itemCost +
                ", itemBarcode='" + itemBarcode + '\'' +
                ", numPage=" + numPage +
                ", progrLangOrIngredient='" + progrLangOrIngredient + '\'' +
                ", minAge=" + minAge +
                ", genre='" + genre + '\'' +
                ", diskType='" + diskType + '\'' +
                ", diskSoft='" + diskSoft + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeInt(itemCost);
        dest.writeString(itemBarcode);

        dest.writeInt(numPage);
        dest.writeString(progrLangOrIngredient);
        dest.writeInt(minAge);

        dest.writeString(genre);
        dest.writeString(diskType);
        dest.writeString(diskSoft);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return  new Item(source.readString(), source.readInt(),source.readString(),
                    source.readInt(),source.readString(),source.readInt(),
                    source.readString(), source.readString(),source.readString());
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

}
