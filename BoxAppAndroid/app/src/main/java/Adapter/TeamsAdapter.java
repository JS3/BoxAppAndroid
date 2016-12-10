package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba.boxappandroid.Producto;
import com.example.ba.boxappandroid.R;

import java.util.List;

/**
 * Created by jose on 16/11/16.
 *
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    //This list stores the teams.
    private final List<Producto> teams;
    private Context context;

    public TeamsAdapter(List<Producto> teams) {
        this.teams = teams;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.product_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Producto team = teams.get(position);
        viewHolder.name.setText((team.getName()));
    }

    @Override
    public int getItemCount() {return teams.size();}

    /**
     * The class is created inside to hold eference to UI elements that represent a Team in
     * the model.
     */
    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
//        TextView shortName;
//        ImageView logo;

        ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
//            shortName = (TextView) view.findViewById(R.id.shortName);
//            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }
}