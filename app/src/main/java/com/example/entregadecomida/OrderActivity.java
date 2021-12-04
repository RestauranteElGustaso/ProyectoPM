package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.entregadecomida.Adapters.OrdersAdapter;
import com.example.entregadecomida.Models.OrdersModel;
import com.example.entregadecomida.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
    }

    public void btnCasa (View view){
        Intent i2=new Intent(OrderActivity.this, MainActivity.class);
        i2.putExtra("id",id);
        startActivity(i2);
        finish();
    }

    public void btnPerfil (View view){
        Intent i3=new Intent(OrderActivity.this, PerfilUsuario.class);
        i3.putExtra("id",id);
        startActivity(i3);
        finish();
    }

    public void btnPago (View view){
        Intent i3=new Intent(OrderActivity.this, PaymentActivity.class);
        i3.putExtra("id",id);
        startActivity(i3);
        finish();
    }
}