package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.LinkedList;

public class Menu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Menu;
    private ArrayList<String> Price;
    private ArrayList<Integer> Gambar;

    //Daftar Menu
    private String[] menu = {"Lasagna", "Ramen", "Massaman Curry", "Dim Sum", "Rendang", "Tom Yum Goong"};
    //Daftar Harga
    private String[] price = {"80.000", "50.000", "40.000", "35.000", "90.000", "70.000"};
    //Daftar Gambar
    private int[] image = {R.drawable.lasagna, R.drawable.ramen, R.drawable.curry, R.drawable.dimsum, R.drawable.rendang,
            R.drawable.goong};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Menu = new ArrayList<>();
        Price = new ArrayList<>();
        Gambar = new ArrayList<>();

        recyclerView= findViewById(R.id.recycler_view);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAdapter(Menu, Price, Gambar);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }
    private void DaftarItem() {
        for (int w=0; w<menu.length; w++){
            Gambar.add(image[w]);
            Menu.add(menu[w]);
            Price.add(price[w]);
        }
    }
}
