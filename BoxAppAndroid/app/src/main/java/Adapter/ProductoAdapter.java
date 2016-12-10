package Adapter;

/**
 * Created by 2096904 on 12/7/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba.boxappandroid.R;

import java.util.List;

import entidades.Producto;


public class ProductoAdapter
        extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private final List<Producto> producto;
    private Integer n = 1;
    private Context context;

    public ProductoAdapter(List<Producto> producto) {
            this.producto = producto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.product_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Producto p = producto.get(position);
        viewHolder.name.setText(p.getNombre());
        viewHolder.number.setText(n.toString()+".");
        n += 1;
//        viewHolder.shortName.setText(team.getdestino());
    }

    @Override
    public int getItemCount() {
        return producto.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView name;
        TextView number;
//        TextView shortName;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            number = (TextView) view.findViewById(R.id.number);
//            shortName = (TextView) view.findViewById(R.id.shortName);
        }
    }
}