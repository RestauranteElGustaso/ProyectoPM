package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    private TextView sub, impuesto, totalP;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");

        sub = (TextView)findViewById(R.id.txtSubtotal);
        impuesto = (TextView)findViewById(R.id.txtIsv);
        totalP = (TextView)findViewById(R.id.txtTotal);

        String subtotal = sub.getText().toString();

        double subValor = Double.parseDouble(subtotal);

        double totalIsv = subValor * 0.15;

        impuesto.setText(String.valueOf(totalIsv));

        double totalValor = subValor + totalIsv;

        totalP.setText(String.valueOf(totalValor));

    }

    public void btnBack (View view){
        Intent i3=new Intent(PaymentActivity.this, OrderActivity.class);
        i3.putExtra("id",id);
        startActivity(i3);
        finish();
    }
}