package com.example.correo_is.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.correo_is.Fragments.DataFragment;
import com.example.correo_is.Fragments.DetailsFragment;
import com.example.correo_is.R;
import com.example.correo_is.correo;

public class MainActivity extends AppCompatActivity implements DataFragment.CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataFragment frgListado
                =(DataFragment) getSupportFragmentManager()
                .findFragmentById(R.id.dataFragment);

        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);

        if(hayDetalle) {
            ((DetailsFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.detailsFragment)).mostrarDetalle(c.getTexto());
        }
        else {
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra(DetailsActivity.EXTRA_TEXTO, c.getTexto());
            startActivity(i);
        }
    }
}
