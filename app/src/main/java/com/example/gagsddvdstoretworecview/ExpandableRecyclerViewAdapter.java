package com.example.gagsddvdstoretworecview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
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

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    ArrayList<Items> itemsList = new ArrayList<Items>();
    Context context;

    public ExpandableRecyclerViewAdapter(Context context, //конструктор, принимающий контекст,

                                         ArrayList<Items> itemsList) { // лист листов д.эл.
        this.itemsList = itemsList;
        this.context = context;

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

        //устанавливает рец.вью innerRecyclerView табличный лэйаут
        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // обработчик.
                if (itemsList.get(position).isExpanded() == false) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                    itemsList.get(position).setExpanded(true);
                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                    itemsList.get(position).setExpanded(false);
                }
            }
        });

        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView); //устанавливает рец.вьюхе innerRecyclerView адаптер itemInnerRecyclerView

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
