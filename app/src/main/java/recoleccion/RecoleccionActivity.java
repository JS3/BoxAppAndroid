package recoleccion;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ba.boxappandroid.Pedido;
import com.example.ba.boxappandroid.R;

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

    List<Pedido> lista = new ArrayList<>();

    Button button;
    RadioButton radioButton;

    TextView nombreProducto;
    TextView peso;
    TextView origen;
    TextView destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recoleccion_view);

        button = (Button) findViewById(R.id.button);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        nombreProducto = (TextView) findViewById(R.id.nombreProducto);
        peso = (TextView) findViewById(R.id.peso);
        origen = (TextView) findViewById(R.id.origen);
        destino = (TextView) findViewById(R.id.destino);

        listaPedidos.add(new Pedido(
                new Solicitante(3048, "José"),
                new Producto("ORIGEN", "La Torre Oscura I", "Un libro escrito por Stephen King.",
                        "Estados Unidos", "New York", "Colombia", "Bogota", 1.5, false, false))
        );

        configurarlistaProductosEspera();
        lista = listaPedidosEspera;
        configurarInformacion();

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton.isChecked()) {
                    listaPedidos.get(0).setEstado("Enviando");
                    configurarlistaProductosEspera();
                    configurarlistaProductosEnviando();
                    lista = listaPedidosEnviando;
                    configurarInformacion();
                    button.setVisibility(v.VISIBLE);
                    radioButton.setEnabled(false);
//                System.out.println(button.getVisibility());
//                ViewGroup layout = (ViewGroup) findViewById(R.id.LinearLayout1);
//                Button button = new Button();
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(Color.parseColor("#00FF00"));
                button.setText("Entregado");
            }
        });


        //Agregar boton de entregar.
    }

    public void configurarlistaProductosEspera(){
        listaPedidosEspera = new ArrayList<>();

        for(Pedido p:listaPedidos){
            if(p.getEstado() == "Espera")
                listaPedidosEspera.add(p);
        }
    }

    public void configurarlistaProductosEnviando(){
        listaPedidosEnviando = new ArrayList<>();

        for(Pedido p:listaPedidos){
            if(p.getEstado() == "Enviando")
                listaPedidosEnviando.add(p);
        }
    }

    public void configurarInformacion(){
        nombreProducto.setText(lista.get(0).getProducto().getNombre());
        peso.setText(lista.get(0).getProducto().getPeso().toString()+"Kg");
        origen.setText(lista.get(0).getProducto().getPaisOrigen()+"/"+lista.get(0).getProducto().getCiudadOrigen());
        destino.setText(lista.get(0).getProducto().getPaisDestino()+"/"+lista.get(0).getProducto().getCiudadDestino());
    }
}
