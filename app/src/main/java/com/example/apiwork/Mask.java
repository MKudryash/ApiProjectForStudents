package com.example.apiwork;

import android.os.Parcel;
import android.os.Parcelable;

public class Mask implements Parcelable /*Parcelable интерфейс -  используется для передачи объектов*/ {
    /*Структура получаемого объекта, должна совпадать с получаемой табличкой из API*/
    /*
    Методы Get реализуются для всех полей для получения конкретного значения из листа
    Методы Set реализуются для всех полей для записи значений в API
     */
    private int ID;
    private int MinCostForAgent;
    private String ProductTypeID;
    private String Title;
    private String ArticleNumber;
    private String Image;

    public Mask(int ID, int minCostForAgent, String productTypeID, String title, String articleNumber,  String image) {
        this.ID = ID;
        MinCostForAgent = minCostForAgent;
        ProductTypeID = productTypeID;
        Title = title;
        ArticleNumber = articleNumber;
        Image = image;
    }

    protected Mask(Parcel in)
        /*Обязательный метод для чтения данных из API (или любой другой БД)*/
    {
        ID = in.readInt();
        MinCostForAgent = in.readInt();
        ProductTypeID = in.readString();
        Title = in.readString();
        ArticleNumber = in.readString();
        Image = in.readString();
    }

    public static final Creator<Mask> CREATOR = new Creator<Mask>() {
        @Override
        public Mask createFromParcel(Parcel in) {
            return new Mask(in);
        }

        @Override
        public Mask[] newArray(int size) {
            return new Mask[size];
        }
    };


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMinCostForAgent(int minCostForAgent) {
        MinCostForAgent = minCostForAgent;
    }

    public void setProductTypeID(String productTypeID) {
        ProductTypeID = productTypeID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setArticleNumber(String articleNumber) {
        ArticleNumber = articleNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    /*Обязательный метод для записи данных в API (или любой другой БД)*/
    {
        parcel.writeInt(ID);
        parcel.writeInt(MinCostForAgent);
        parcel.writeString(ProductTypeID);
        parcel.writeString(Title);
        parcel.writeString(ArticleNumber);
        parcel.writeString(Image);
    }

    public int getMinCostForAgent() {
        return MinCostForAgent;
    }

    public String getProductTypeID() {
        return ProductTypeID;
    }

    public String getTitle() {
        return Title;
    }

    public String getArticleNumber() {
        return ArticleNumber;
    }

    public int getID() {
        return ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
