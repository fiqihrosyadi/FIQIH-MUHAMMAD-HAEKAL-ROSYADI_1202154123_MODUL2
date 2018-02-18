package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> arrayListMenu; //untuk menampung Judul
    private ArrayList<String> arrayListsPrice; //untuk menampung Menu
    private ArrayList<Integer> gambar; //Digunakan untuk menampung Gambar

    //Membuat Konstruktor pada Class RecyclerViewAdapter
    MyAdapter(ArrayList<String> arrayListMenu, ArrayList<String> arrayListsPrice, ArrayList<Integer> Gambar){
        this.arrayListMenu = arrayListMenu;
        this.arrayListsPrice = arrayListsPrice;
        this.gambar = Gambar;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView menu, price;
        private ImageView gambar;
        private LinearLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi untuk RecyclerView
            menu = itemView.findViewById(R.id.txtMenu);
            price = itemView.findViewById(R.id.txtPrice);
            gambar = itemView.findViewById(R.id.image);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }


    public void onBindViewHolder(final MyAdapter.ViewHolder holder, final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat
        final String menu = arrayListMenu.get(position);//Mengambil data sesuai dengan posisi
        final String price = arrayListsPrice.get(position);//Mengambil data sesuai dengan posisi
        final Integer image = gambar.get(position);//Mengambil data sesuai dengan posisi
        holder.menu.setText(menu);
        holder.price.setText("Price Rp. "+price);
        holder.gambar.setImageResource(image); // Mengambil gambar sesuai posisi
        //Membuat Aksi Saat Judul Pada List ditekan
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Membuat Aksi Saat List Ditekan
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                String komposisi;
                switch (position){
                    case 0:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Meat, Lasagna";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Meatballs, Fishballs, Shrimp";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "meat, potatoes";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Chicken, Sauce, Shrimp, Mushrooms and vegetables";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Beef, seasoning";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Shrimp, mushrooms, vegetables";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }


    public int getItemCount() {
        return arrayListMenu.size();
    }
}
