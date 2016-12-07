package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/7/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ba.boxappandroid.R;
import com.example.ba.boxappandroid.ProductoAdapter;
import com.example.ba.boxappandroid.Producto;
import com.example.ba.boxappandroid.Network;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class listActivity
        extends Activity
{

    ExecutorService executorService = Executors.newFixedThreadPool( 1 );

    Network network = new Network();

    private List<Producto> teams;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.list );
        configureRecyclerView();

        try
        {
            teams = network.getTeams();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        executorService.execute( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    teams = network.getTeams();
                    runOnUiThread( new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            recyclerView.setAdapter( new ProductoAdapter( teams ) );
                        }
                    } );
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        } );


    }

    private void configureRecyclerView()
    {
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
    }


    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings )
        {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}