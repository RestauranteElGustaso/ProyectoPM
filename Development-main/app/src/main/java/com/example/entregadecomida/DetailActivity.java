package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.entregadecomida.databinding.ActivityDetailBinding;
import com.example.entregadecomida.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private EditText nombreC, phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1){



       final int image = getIntent().getIntExtra("image",0);
       final int price = Integer.parseInt(getIntent().getStringExtra("price"));
       final String name = getIntent().getStringExtra("name");
       final String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.textView.setText(name);
        binding.detailDescription.setText(description);


        binding.insertBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nombreC = (EditText) findViewById(R.id.nameBox);
                phones = (EditText) findViewById(R.id.phoneBox);


                String nombre = nombreC.getText().toString();
                String phone = phones.getText().toString();

                boolean isInserted =  helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );

              if (isInserted = !nombre.isEmpty() && !phone.isEmpty() && phone.length() == 8){

                  Toast.makeText(DetailActivity.this,"Datos guardados con exito", Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(DetailActivity.this, "Verifique los datos ingresados", Toast.LENGTH_SHORT).show();
              }
            }
        });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.textView.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));


            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Actualizar");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
               boolean isUpdated =  helper.updateOrder(binding.nameBox.getText().toString(),
                       binding.phoneBox.getText().toString(),
                        Integer.parseInt(binding.priceLbl.getText().toString()),
                         image,
                         binding.detailDescription.getText().toString(),
                         binding.textView.getText().toString(),
                         1,
                         id
                         );

                    nombreC = (EditText) findViewById(R.id.nameBox);
                    phones = (EditText) findViewById(R.id.phoneBox);


                    String nombre = nombreC.getText().toString();
                    String phone = phones.getText().toString();

               if (isUpdated == !nombre.isEmpty() && !phone.isEmpty() && phone.length() == 8)
                   Toast.makeText(DetailActivity.this,"Datos acualizados correctamente", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(DetailActivity.this,"Ocurrio un fallo en su solicitud, verifique los datos", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}