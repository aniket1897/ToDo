package com.example.aniket.todo;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private DrawerLayout mDrawer;
   private ActionBarDrawerToggle mToggle;
   private Toolbar mToolbar;


   private LinearLayout myLayout;

   private FloatingActionButton fbutton;

  // private String title,desc;

   RecyclerView recyclerView;

   List<Notes> notes;

   NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.nav_action);

        setSupportActionBar(mToolbar);

        fbutton=findViewById(R.id.fbutton);

        recyclerView=findViewById(R.id.recycler_view);

        myLayout=findViewById(R.id.myLayout);

        mDrawer=findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notes=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);


        notes.add(
          new Notes("My first post","I like reading!!")
        );

        notes.add(
                new Notes("My first post","I like reading!!")
        );

        notes.add(
                new Notes("My first post","I like reading!!")
        );


        adapter=new NotesAdapter(this,notes);

        recyclerView.setAdapter(adapter);


       fbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Log.d("MainActivity.this","Here!!!");
                        startActivity(new Intent(MainActivity.this,NotesAdd.class));

                    }
                }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
