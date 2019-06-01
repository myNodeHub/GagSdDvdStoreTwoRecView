package com.example.gagsddvdstoretworecview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aroliant on 1/3/2018.
 */
//  RecyclerView с параметром ViewHolder
public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    ArrayList<Integer> counter = new ArrayList<>();
    ArrayList<Items> itemsList = new ArrayList<Items>();
    Context context;

    public ExpandableRecyclerViewAdapter(Context context, //конструктор, принимающий контекст,
//                                         ArrayList<Item> itemList, //лист род. эл.
                                         ArrayList<Items> itemsList) { // лист листов д.эл.
//        this.itemList = itemList;
        this.itemsList = itemsList;
        this.context = context;

        Log.d("namelist", itemsList.toString());

        for (int i = 0; i < itemsList.size(); i++) { //создаёт лист нолей размером с кол-во род. эл.
            counter.add(0); //{0,0,0}
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder { //принимает Вью(layout) на вход и инициализирует все его компоненты
        TextView name;
        RecyclerView cardRecyclerView; //( у каждого холдера есть свой рец.Вью)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.categoryTitle);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //создает объект ViewHolder передавая ему Вью(layout)
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_collapseview, parent, false);

        ExpandableRecyclerViewAdapter.ViewHolder vh = new ExpandableRecyclerViewAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(itemsList.get(position).getName());

        //инициализация адаптера типа InnerRecyclerViewAdapter
        InnerRecyclerViewAdapter itemInnerRecyclerView = new InnerRecyclerViewAdapter(itemsList.get(position).getItem(), context);

        //устанавливает рец.вьюхе innerRecyclerView табличный лэйаут
        holder.cardRecyclerView.setLayoutManager(new LinearLayoutManager(context));
//        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // обработчик.
                //чётный клик по род. элементу - показать рец.Вью этого элемента
                //не чётный клик по род. элементу - скрыть рец.Вью этого элемента
//                if (counter.get(position) % 2 == 0) { //узнаем чётность клика по конкретному элементу (сначала 0)
//                    Log.d("wwwppp111", counter.get(position).toString());
                if(itemsList.get(position).isExpanded()==false){
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                    itemsList.get(position).setExpanded(true);
                }else{
                    holder.cardRecyclerView.setVisibility(View.GONE);
                    itemsList.get(position).setExpanded(false);
                }

//                } else {
//                    holder.cardRecyclerView.setVisibility(View.GONE);
//                    Log.d("wwwppp222", counter.get(position).toString());
//                }

                counter.set(position, counter.get(position) + 1); //прибавляем 1 в элемент массива под номером кликнутой позиции


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView); //устанавливает рец.вьюхе innerRecyclerView адаптер itemInnerRecyclerView

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


}
