package com.example.dell.proy_turismo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class ListarUnCircuito extends ActionBarActivity {

    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido;
    String[] titulo;
    String[] contenido;
    public Button button;

    private int[] imagenRestaurantes = {
            R.drawable.restaurante_alexander,
            R.drawable.restaurante_angelo,
            R.drawable.restaurante_joe,
            R.drawable.restaurante_arriero
    };

    private int[] imagenHoteles = {
            R.drawable.hotel_presidente,
            R.drawable.hotel_ritz,
            R.drawable.hotel_x,
            R.drawable.hotel_y,
            R.drawable.hotel_z
    };

    private int[] imagenRutaDelVino = {
            R.drawable.rutadelvino_champaneramiguelmas,
            R.drawable.rutadelvino_champaneramiguelmas,
            R.drawable.rutadelvino_champaneramiguelmas,
            R.drawable.rutadelvino_lasmarianasbodegafamliar,
            R.drawable.rutadelvino_vinassegisa
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_un_circuito);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent1 = new Intent(ListarUnCircuito.this, PathGoogleMapActivity.class);
                startActivity(intent1);


            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        int idcircuito = extras.getInt("idcircuito");
        final int position = extras.getInt("position");
        String nombreCircuito = extras.getString("nombreCircuito");
        String nombreSubCircuito = extras.getString("nombreSubCircuito");

        //Log.i("ramiro", "listar un circuito idcircuito" + idcircuito);
        //Log.i("ramiro", "listar un circuito position " + position);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle(nombreCircuito);
        actionBar.setSubtitle(nombreSubCircuito);

        txtTitulo = (TextView) findViewById(R.id.tv_titulo_listaruncircuito);
        txtContenido = (TextView) findViewById(R.id.tv_contenido_listaruncircuito);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen_listaruncircuito);

        switch (idcircuito){
            case 0: //restaurantes
                titulo = getResources().getStringArray(R.array.restaurantes_titulo);
                contenido = getResources().getStringArray(R.array.restaurantes_contenido_completo);
                imgImagen.setImageResource(imagenRestaurantes[position]);
                break;
            case 1: //hoteles
                titulo = getResources().getStringArray(R.array.hoteles_titulo);
                contenido = getResources().getStringArray(R.array.hoteles_contenido_completo);
                imgImagen.setImageResource(imagenHoteles[position]);
                break;

            case 2: //miradores
                titulo = getResources().getStringArray(R.array.miradores_titulo);
                contenido = getResources().getStringArray(R.array.miradores_contenido_completo);
                imgImagen.setImageResource(imagenRutaDelVino[position]);
                break;



            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);
    }
}
