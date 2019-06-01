package com.example.gagsddvdstoretworecview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView expanderRecyclerView; // объявляем рецик.вью

    public ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expanderRecyclerView = findViewById(R.id.recyclerView); //инициализиация рецик.вью (мэйн активити)

        initiateExpander(); //вызывов initiateExpander
    }

    private void initiateExpander() {

        ArrayList<Items> parentList = new ArrayList<>();         //лист родительских элементов
//        ArrayList<ArrayList> childListHolder = new ArrayList<>(); //лист листов Item'ов дочерних элементов



        ArrayList<Item> bookList = new ArrayList<>(); // лист Item'ов #1 (книг)
        bookList.add(new Item("Полёт ворона", 70, "Bark_7", 110, "Эзотерика", 42));
        bookList.add(new Item("Космос и ты", 80, "Bark_8", 120, "Эзотерика", 50));
        bookList.add(new Item("Руководство по Java", 90, "Bark_9", 130, "Програмирование", "Java"));
        bookList.add(new Item("Effective C++", 100, "Bark_10", 140, "Програмирование", "С++"));
        bookList.add(new Item("Едим дома", 110, "Bark_11", 150, "Кулинария", "Баклажаны"));
//        childListHolder.add(bookList);

        ArrayList<Item> diskList = new ArrayList<>(); //лист Item'ов #2 (дисков)
        diskList.add(new Item("Disko 70", 10, "Barc_1", "CD", "Music"));
        diskList.add(new Item("Disko 80", 20, "Barc_2", "DVD", "Music"));
        diskList.add(new Item("Pulp Fiction", 30, "Barc_3", "CD", "Movie"));
        diskList.add(new Item("Forrest Gump", 40, "Barc_4", "DVD", "Movie"));
        diskList.add(new Item("Windows 7", 50, "Barc_5", "CD", "Soft"));
        diskList.add(new Item("MathCad 15", 60, "Barc_6", "DVD", "Soft"));
//        childListHolder.add(diskList);


        parentList.add(new Items("Книги", bookList) );  //заполнение листа родительских элементов
        parentList.add(new Items("Диски", diskList) );  //заполнение листа родительских элементов


        expandableCategoryRecyclerViewAdapter = //инициализация адаптера типа ExpandableRecyclerViewAdapter
                new ExpandableRecyclerViewAdapter(getApplicationContext(), //с передачей в параметре листов род. эл.
                         parentList); //и листа листов доч. эл.

        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //присвоение рец.вью лайоутМэнеджера

        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter); //присвоение рец.вью адаптера
    }
}
