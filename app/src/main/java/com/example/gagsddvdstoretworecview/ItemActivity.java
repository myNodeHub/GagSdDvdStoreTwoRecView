package com.example.gagsddvdstoretworecview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    TextView textView1It;
    TextView textView2It;
    TextView textView3It;
    TextView textView4It;
    TextView textView5It;
    TextView textView6It;
    TextView textView7It;
    TextView textView8It;
    TextView textView9It;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Информация о товаре");

        textView1It = findViewById(R.id.textView1It);
        textView2It = findViewById(R.id.textView2It);
        textView3It = findViewById(R.id.textView3It);
        textView4It = findViewById(R.id.textView4It);
        textView5It = findViewById(R.id.textView5It);
        textView6It = findViewById(R.id.textView6It);
        textView7It = findViewById(R.id.textView7It);
        textView8It = findViewById(R.id.textView8It);
        textView9It = findViewById(R.id.textView9It);


        Bundle arguments = getIntent().getExtras();
        final Item item;
        if (arguments != null) {
            item = arguments.getParcelable("item");

            textView1It.setText("Название: " + item.getItemName());
            textView2It.setText("Цена: " + item.getItemCost());
            textView3It.setText("Штрихкод: " + item.getItemBarcode());
            if (item.getGenre() == null) textView4It.setVisibility(View.GONE);
            textView4It.setText("Жанр: " + item.getGenre());
            if (item.getProgrLangOrIngredient() == null) textView5It.setVisibility(View.GONE);
            textView5It.setText("Язык или ингридиент: " + item.getProgrLangOrIngredient());
            if (item.getMinAge() == 0) textView6It.setVisibility(View.GONE);
            textView6It.setText("Минимальный возраст: " + item.getMinAge());
            if (item.getItemPage() == 0) textView7It.setVisibility(View.GONE);
            textView7It.setText("Кол-во стрниц: " + item.getItemPage());
            if (item.getDiskType() == null) textView8It.setVisibility(View.GONE);
            textView8It.setText("Носитель: " + item.getDiskType());
            if (item.getDiskSoft() == null) textView9It.setVisibility(View.GONE);
            textView9It.setText("Тип данных: " + item.getDiskSoft());
        }

    }

}
