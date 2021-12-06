package com.example.entregadecomida;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entregadecomida.Models.OrdersModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {

    private TextView sub, impuesto, totalP;
    int id;
    Button btnConfirmar;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");

        sub = (TextView)findViewById(R.id.txtSubtotal);
        impuesto = (TextView)findViewById(R.id.txtIsv);
        totalP = (TextView)findViewById(R.id.txtTotal);
        btnConfirmar =(Button) findViewById(R.id.btnConfirmar);


        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();
        //  String subtotal = sub.getText().toString();

        double subtotals=0;
        for (int i=0; i<list.size(); i++){
            subtotals= subtotals + (Double.parseDouble(list.get(i).getPrice()))*(Double.parseDouble(list.get(i).getQuantity()));
        }



        sub.setText(String.valueOf(subtotals));



        double totalIsv = subtotals * 0.15;

        double costoEnvio = 30;

        impuesto.setText(String.valueOf(totalIsv));

        double totalValor = subtotals + totalIsv + costoEnvio;

        totalP.setText(String.valueOf(totalValor));


        if (ActivityCompat.checkSelfPermission(PaymentActivity.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(PaymentActivity.this,Manifest
        .permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){ActivityCompat.requestPermissions(PaymentActivity.this, new String[]
                {Manifest.permission.SEND_SMS,
                },      1000);
                }else{
    };

       btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje= " Pedido: \n";
                for (int a = 0; a < list.size(); a++) {
                    enviarPedido("95804586", mensaje+ list.get(a).getQuantity()+ " " + list.get(a).getSoldItemName() + " " + list.get(a).getPrice() + " \n")
                    ;
                }
                }
        });

    }

    private void enviarPedido(String numero, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero, null, mensaje,null,null);
            Toast.makeText(getApplicationContext(),"Mensaje Enviado", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Mensaje no enviado, datos incorrectos", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    public void btnBack (View view){
        Intent i3=new Intent(PaymentActivity.this, OrderActivity.class);
        i3.putExtra("id",id);
        startActivity(i3);
        finish();
    }




}