package com.example.correo_is.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.correo_is.Fragments.DetailsFragment;
import com.example.correo_is.R;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO =
            "net.sgoliver.android.fragments.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        DetailsFragment detalle =
                (DetailsFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.detailsFragment);

        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}
