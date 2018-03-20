package com.example.aniket.todo;

import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivtiy";

    private DrawerLayout mDrawer;

   private ActionBarDrawerToggle mToggle;

   private Toolbar mToolbar;

   private LinearLayout myLayout;

   private FloatingActionButton fbutton;

   RecyclerView recyclerView;

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

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();

        List<Notes> notes=db.notesDAO().getAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new NotesAdapter(this,notes);

        recyclerView.setHasFixedSize(true);


        recyclerView.setAdapter(adapter);


       fbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,NotesAdd.class));

                    }
                }
        );

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int item_id=item.getItemId();
        switch (item_id)
        {
            case R.id.my_notes: Toast.makeText(MainActivity.this,"Clicked Settings",Toast.LENGTH_LONG).show(); break;
            case R.id.archive: Toast.makeText(MainActivity.this,"Clicked Settings",Toast.LENGTH_LONG).show(); break;
            case R.id.delete: Toast.makeText(MainActivity.this,"Clicked Settings",Toast.LENGTH_LONG).show(); break;
            case R.id.settings: //Toast.makeText(MainActivity.this,"Clicked Settings",Toast.LENGTH_LONG).show(); break;
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            case R.id.share: Toast.makeText(MainActivity.this,"Clicked Settings",Toast.LENGTH_LONG).show(); break;
        }
        return true;
    }

    /* @Override
        public boolean onCreateOptionsMenu(Menu menu) {
             getMenuInflater().inflate(R.menu.nav_menu,menu);
             return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            Log.d(TAG,"Clicked");
            switch (item.getItemId())
            {
                case R.id.settings: Log.d(TAG,"Clicked Settings");
                    new Intent(MainActivity.this,SettingsActivity.class); break;
            }
            return true;
        }
    */
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       if(mToggle.onOptionsItemSelected(item)) {
           return true;
       }

       return super.onOptionsItemSelected(item);
   }

}
