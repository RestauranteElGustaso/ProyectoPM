package com.example.entregadecomida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.entregadecomida.Adapters.MainAdapter;
import com.example.entregadecomida.Models.MainModel;
import com.example.entregadecomida.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.carnes, "Carne Asada","150","Debes probar nuestra deliciosa carne", "1"));
        list.add(new MainModel(R.drawable.combo1, "Hamburguesa","120","Te incluye las papas", "1"));
        list.add(new MainModel(R.drawable.desayuno1, "Desayuno","60","Frijoles, Pan integral, Huevo y queso", "1"));
        list.add(new MainModel(R.drawable.desayuno2, "Desayuno","50","Pan integral con huevo", "1"));
        list.add(new MainModel(R.drawable.desayuno3, "Desayuno","85","Pan integral con salsa, incluye frutas","1"));
        list.add(new MainModel(R.drawable.desayuno4, "Café","20","Café negro","1"));
        list.add(new MainModel(R.drawable.desayuno5, "Panqueque","50","Panqueque con miel","1"));
        list.add(new MainModel(R.drawable.desayuno6, "Frutas","100","Uvas, Kiwi, Fresa, Sandia","1"));
        list.add(new MainModel(R.drawable.ensalado2, "Ensalada","100","Incluye frutas y vegetales","1"));
        list.add(new MainModel(R.drawable.hamburguesa1, "Hamburguesa","85","No incluye papas","1"));
        list.add(new MainModel(R.drawable.papasfritas, "Papas Fritas","65","Ketchup","1"));
        list.add(new MainModel(R.drawable.papas2, "Papas asadas","110","Incluye vegetales y salsa especial","1"));
        list.add(new MainModel(R.drawable.postre1, "Postre","115","Pastel de vainilla","1"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.orders:
               startActivity(new Intent(MainActivity.this,OrderActivity.class));
               break;
       }

        return super.onOptionsItemSelected(item);
    }
}