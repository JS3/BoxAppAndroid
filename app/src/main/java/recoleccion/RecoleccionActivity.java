package recoleccion;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ba.boxappandroid.Mensajero;
import com.example.ba.boxappandroid.Pedido;
import com.example.ba.boxappandroid.R;
import com.example.ba.boxappandroid.Viaje;

import java.util.ArrayList;
import java.util.List;

import entidades.Producto;
import entidades.Solicitante;

/**
 * Created by MSTRJL on 12/12/16.
 */

public class RecoleccionActivity extends AppCompatActivity {

    List<Pedido> listaPedidos = new ArrayList<>();
    List<Pedido> listaPedidosEspera;
    List<Pedido> listaPedidosEnviando;
    List<Pedido> listaPedidosEntregado;

    List<Pedido> lista = new ArrayList<>();

    Button button;
    Button peticion;
    RadioButton radioButton;

    TextView nombreProducto;
    TextView peso;
    TextView origen;
    TextView destino;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recoleccion_view);

        button = (Button) findViewById(R.id.button);
        peticion = (Button) findViewById(R.id.peticion);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        nombreProducto = (TextView) findViewById(R.id.nombreProducto);
        peso = (TextView) findViewById(R.id.peso);
        origen = (TextView) findViewById(R.id.origen);
        destino = (TextView) findViewById(R.id.destino);

        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout1);

        peticion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPedidos.add(
                        new Pedido(
                            new Solicitante(3048, "José"),
                            new Producto("ORIGEN", "La Torre Oscura I", "Un libro escrito por Stephen King.",
                                    "Estados Unidos", "New York", "Colombia", "Bogota", 1.5, false, false))
                );
                configurarlistaPedidosEspera();
                lista = listaPedidosEspera;
                configurarInformacion();

                peticion.setVisibility(v.INVISIBLE);
                linearLayout.setVisibility(v.VISIBLE);
                button.setVisibility(v.INVISIBLE);
                radioButton.setEnabled(true);
                button.setEnabled(true);

                button.setText("Entregar");
                button.setBackgroundColor(Color.parseColor("#D3D3D3"));
            }
        });

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton.isChecked()) {
                    listaPedidos.get(0).setEstado("Enviando");
                    configurarlistaPedidosEspera();
                    configurarlistaPedidosEnviando();
                    lista = listaPedidosEnviando;
                    configurarInformacion();

                    button.setVisibility(v.VISIBLE);
                    radioButton.setEnabled(false);

                    listaPedidos.get(0).setMensajero(new Mensajero()); //Se agrega el mensajero
                    listaPedidos.get(0).setViaje(new Viaje()); //Se agrega el viaje
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(Color.parseColor("#00FF00"));
                button.setText("Entregado");
                configurarlistaPedidosEnviando();
                configurarlistaPedidosEntregado();
                lista = listaPedidosEntregado;
                listaPedidos.remove(0);
                button.setEnabled(false);

                peticion.setVisibility(v.VISIBLE);
                linearLayout.setVisibility(v.INVISIBLE);
            }
        });


        //Agregar boton de entregar.
    }

    public void configurarlistaPedidosEspera(){
        listaPedidosEspera = new ArrayList<>();

        for(Pedido p:listaPedidos){
            if(p.getEstado() == "Espera")
                listaPedidosEspera.add(p);
        }
    }

    public void configurarlistaPedidosEnviando(){
        listaPedidosEnviando = new ArrayList<>();

        for(Pedido p:listaPedidos){
            if(p.getEstado() == "Enviando")
                listaPedidosEnviando.add(p);
        }
    }

    public void configurarlistaPedidosEntregado(){
        listaPedidosEntregado = new ArrayList<>();

        for(Pedido p:listaPedidos){
            if(p.getEstado() == "Entregando")
                listaPedidosEntregado.add(p);
        }
    }

    public void configurarInformacion(){
        nombreProducto.setText(lista.get(0).getProducto().getNombre());
        peso.setText(lista.get(0).getProducto().getPeso().toString()+"Kg");
        origen.setText(lista.get(0).getProducto().getPaisOrigen()+"/"+lista.get(0).getProducto().getCiudadOrigen());
        destino.setText(lista.get(0).getProducto().getPaisDestino()+"/"+lista.get(0).getProducto().getCiudadDestino());
    }
}
