package com.example.apiwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMask  extends BaseAdapter {
    private Context mContext;// объект, для домтупа к базовым функциям страницы
    List<Mask> maskList; //Лист с получаемыми объектами из API

    public AdapterMask(Context mContext, List<Mask> listProduct) {
        this.mContext = mContext;
        this.maskList = listProduct;
    }

    @Override
    public int getCount() {
        return maskList.size();
    } //Метод отвечающий за количество объектов в Листе

    @Override
    public Object getItem(int i) {
        return maskList.get(i);
    }
    //Получение конкретного объекта

    @Override
    public long getItemId(int i)
    {
        return maskList.get(i).getID();
    }
    //Получение ID конкретного объекта

    private Bitmap getUserImage(String encodedImg) //Метод отвечающий за декдирование изображения
    {
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {
            return null;
        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = View.inflate(mContext,R.layout.item_layuot,null);
        /*Отвечает за создание элементов на странице
        mContext - на какой активности создается
        R.layout.item_layuot - на основе чего отображается объект
        (создается самостоятельно, разрабатывается макет отображения одного объекта в листе)
        null - 3 параметр отвечает за родительский объект, которого здесь нет
        */
        /*Дальше находятся объекты макета в соотвестивии с тем, что хотите вывести*/
        TextView Title = v.findViewById(R.id.txtTitle); //нахождение textView куда будет положено название

        TextView Count = v.findViewById(R.id.articleNumber); //нахождение textView куда будет положено количесво
        ImageView imageView = v.findViewById(R.id.imageView); //нахождение imageView куда будет положено изображение
        Mask mask = maskList.get(i); //получаем объект из листа
        Title.setText(mask.getTitle());//присваиваем textView наименование текущего объекта
        Count.setText(Integer.toString(mask.getMinCostForAgent()));//присваиваем textView количество текущего объекта

        //imageView.setImageBitmap(getUserImage(mask.getImage())); ////присваиваем imageView изображения текущего объекта
        /*Текущий метод не подходит под данные к подключаемой API, но опдходит для экзамена*/
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Открываем окно редактирование выбранного объекта с помощью клика по этому объекту
            }
        });


        return v; //возвращаем измененную страницу
    }
}

