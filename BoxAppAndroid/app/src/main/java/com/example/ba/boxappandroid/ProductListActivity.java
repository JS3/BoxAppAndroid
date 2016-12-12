package com.example.ba.boxappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Adapter.ProductoAdapter;
import entidades.Producto;

/**
 * Created by MSTRJL on 9/12/16.
 */

public class ProductListActivity extends AppCompatActivity {

    List<Producto> listaProductos = new ArrayList<>();
    List<Producto> listaProductosPendientes = new ArrayList<>();
    List<Producto> listaProductosEntregados = new ArrayList<>();
    List<Producto> lista = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Network network = new Network();
    RecyclerView recyclerView;
    Boolean ordPendiente;
    Boolean ordEntregado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        Intent intent = getIntent();

        ordPendiente = (Boolean) intent.getSerializableExtra("ORDENA_POR_PENDIENTES");
        if(ordPendiente == null)
            ordPendiente = false;

        ordEntregado = (Boolean) intent.getSerializableExtra("ORDENA_POR_ENTREGADOS");
        if(ordEntregado == null)
            ordEntregado = false;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                    lista = network.getTeams();
                lista = Listas.getListas().getProductos();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listaProductos = lista;
                            configurarlistaProductosPendientes();
                            configurarlistaProductosEntregados();

                            if(ordPendiente)
                                lista = listaProductosPendientes;

                            if(ordEntregado)
                                lista = listaProductosEntregados;
                            recyclerView.setAdapter(new ProductoAdapter(lista));
                        }
                    });
            }
        });

        configureRecyclerView();
    }

    private void configurarlistaProductosPendientes(){

        for(Producto p:listaProductos){
            if(!p.getEntregado())
                listaProductosPendientes.add(p);
        }
    }

    private void configurarlistaProductosEntregados(){

        for(Producto p:listaProductos){
            if(p.getEntregado())
                listaProductosEntregados.add(p);
        }
    }

    private void configureRecyclerView(){

        recyclerView = (RecyclerView) findViewById((R.id.recyclerView));
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void myClickHandler(View v){

        LinearLayout vwParentRow1 = (LinearLayout)v.getParent().getParent();
        TextView textView = (TextView) vwParentRow1.getChildAt(0);
//        System.out.println("||||||"+textView.getText().toString());

        Producto p = lista.get(Integer.parseInt(textView.getText().toString().charAt(0) + "") - 1);
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        Button detalles = (Button) vwParentRow.getChildAt(1);
        Intent i = new Intent(getApplicationContext(), Detalles.class);
        i.putExtra("PRODUCTO", p);
        startActivity(i);
    }
}