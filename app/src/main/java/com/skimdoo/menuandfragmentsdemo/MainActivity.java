package com.skimdoo.menuandfragmentsdemo;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private Button btn_add;
    private Button btn_remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        btn_add = (Button) findViewById(R.id.btn_add_fragment);
        btn_remove = (Button) findViewById(R.id.btn_remove_fragment);

        btn_add.setOnClickListener(v -> addFragment());
        btn_remove.setOnClickListener(v -> removeFragment());
    }

    private void removeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        }
    }

    private void addFragment() {
        Toast.makeText(this, "Añadiendo contenido", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, BlankFragment.newInstance(null, null))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_profile:
                Toast.makeText(this, "Tu perfil es: mjl1010", Toast.LENGTH_SHORT).show();
                // indica que hem consumit l'event.
                return true;
            case R.id.item_config:
                Toast.makeText(this, "Gracias por configurar", Toast.LENGTH_SHORT).show();
                // indica que hem consumit l'event.
                return true;
            case R.id.item_about:
                Toast.makeText(this, "Sobre nosotros, un producto de EA Sports", Toast.LENGTH_SHORT).show();
                // indica que hem consumit l'event.
                return true;
        }
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
