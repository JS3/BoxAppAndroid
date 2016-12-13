package recoleccion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        TextView nombreProducto = (TextView) findViewById(R.id.nombreProducto);
        nombreProducto.setText("Torre Oscura I");
    }
}
