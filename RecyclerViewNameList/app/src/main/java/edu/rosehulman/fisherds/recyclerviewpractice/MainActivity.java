package edu.rosehulman.fisherds.recyclerviewpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerView.setHasFixedSize(true);

    // Next set the adapter that will load data into the recycler view
    final NameAdapter nameAdapter = new NameAdapter(this);
    recyclerView.setAdapter(nameAdapter);
    nameAdapter.addName();
    nameAdapter.addName();
    nameAdapter.addName();


    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        nameAdapter.addName();
      }
    });
  }

}
