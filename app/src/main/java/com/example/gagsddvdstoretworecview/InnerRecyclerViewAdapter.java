package com.example.gagsddvdstoretworecview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aroliant on 1/3/2018.
 */
//  RecyclerView с параметром ViewHolder
public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder> {
    public ArrayList<Item> itemList = new ArrayList<Item>();
    Context context;

    public InnerRecyclerViewAdapter(ArrayList<Item> itemList, Context context) { //в конструкторе только лист листов дочерних элементов
        this.context = context;
        this.itemList = itemList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //Предоставляет прямую ссылку на каждый View-компонент
        TextView itemName;
        TextView itemCost;
        TextView itemBarcode;
        TextView numPage;
        TextView progrLangOrIngredient;
        TextView minAge;
        TextView genre;
        TextView diskType;
        TextView diskSoft;
        CardView cardViewLast;

        public ViewHolder(View itemView) { //конструктор принимает на вход View-компонент, ищет все дочерние компоненты, и возвращает их холдеру
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemCost = itemView.findViewById(R.id.itemCost);
            itemBarcode = itemView.findViewById(R.id.itemBarcode);
            numPage = itemView.findViewById(R.id.numPage);
            progrLangOrIngredient = itemView.findViewById(R.id.progrLangOrIngredient);
            minAge = itemView.findViewById(R.id.minAge);
            genre = itemView.findViewById(R.id.genre);
            diskType = itemView.findViewById(R.id.diskType);
            diskSoft = itemView.findViewById(R.id.diskSoft);
//            cardViewLast = itemView.findViewById(R.id.cardViewLast);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //создаёт объект ViewHolder, которому передаем на вход View-компонент
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_expand_item_view, parent, false);


        InnerRecyclerViewAdapter.ViewHolder vh = new InnerRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemName.setText(itemList.get(position).getItemName()); // связывает холдер с элементом листа листов д.э.
        holder.itemCost.setText(String.valueOf(itemList.get(position).getItemCost()));
        holder.itemBarcode.setText(itemList.get(position).getItemBarcode());
        holder.numPage.setText(String.valueOf(itemList.get(position).getItemPage()));

        holder.progrLangOrIngredient.setText(itemList.get(position).getProgrLangOrIngredient());
        holder.minAge.setText(String.valueOf(itemList.get(position).getMinAge()));

        holder.genre.setText(itemList.get(position).getGenre());
        holder.diskType.setText(itemList.get(position).getDiskType());
        holder.diskSoft.setText(itemList.get(position).getDiskSoft());

        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("item", itemList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
