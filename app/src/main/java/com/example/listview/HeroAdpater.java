package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdpater extends BaseAdapter {
    private final Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public HeroAdpater(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == view) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);

        return itemView;
    }


    private class ViewHolder {
        private TextView txtName, txtDescription;
        private ImageView imgPhoto;

        public ViewHolder(View view) {
            this.txtName = view.findViewById(R.id.txt_name);
            this.txtDescription = view.findViewById(R.id.txt_description);
            this.imgPhoto = view.findViewById(R.id.img_photo);
        }

        public void bind(Hero hero){
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
