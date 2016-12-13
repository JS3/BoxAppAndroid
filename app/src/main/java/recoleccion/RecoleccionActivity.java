package recoleccion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ba.boxappandroid.R;

/**
 * Created by MSTRJL on 12/12/16.
 */

public class RecoleccionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recoleccion_view);

        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        TextView nombreProducto = (TextView) findViewById(R.id.nombreProducto);
        TextView peso = (TextView) findViewById(R.id.peso);
        TextView origen = (TextView) findViewById(R.id.origen);
        TextView destino = (TextView) findViewById(R.id.destino);

        nombreProducto.setText("Torre Oscura I");
        peso.setText("1.5"+"Kg");
        origen.setText("Estados Unidos"+"/"+"New York");
        destino.setText("Colombia"+"/"+"Bogota");
    }
}
