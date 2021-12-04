package com.example.entregadecomida;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilUsuario extends AppCompatActivity implements View.OnClickListener {
Button btnEditar, btnEliminar, btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        nombre=(TextView)findViewById(R.id.txtNombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditarPerf);
        btnEliminar=(Button)findViewById(R.id.btnEliminarPerf);
        btnSalir=(Button)findViewById(R.id.btnSalirPerf);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuariobyID(id);
        nombre.setText(u.getNombres()+" "+u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditarPerf:
                Intent a=new Intent(PerfilUsuario.this, actualizarUsuario.class);
                a.putExtra("id", id);
                startActivity(a);
                break;
            case R.id.btnEliminarPerf:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setMessage("¿Está seguro(a) que desea eliminar la cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.deleteUsuario(id)){

                            Toast.makeText(PerfilUsuario.this, "Se eliminó Correctamente", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(PerfilUsuario.this, login.class);
                            startActivity(a);
                            finish();
                        }
                        else {
                            Toast.makeText(PerfilUsuario.this, "ERROR: No fue posible eliminar su cuenta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnSalirPerf:
                Intent c=new Intent(PerfilUsuario.this, login.class);
                startActivity(c);
                break;
        }
    }

    public void btnPedidos (View view){
        Intent i3=new Intent(PerfilUsuario.this, OrderActivity.class);
        i3.putExtra("id",id);
        startActivity(i3);
        finish();
    }

    public void btnCasa (View view){
        Intent i2=new Intent(PerfilUsuario.this, MainActivity.class);
        i2.putExtra("id",id);
        startActivity(i2);
        finish();
    }
}