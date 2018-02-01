package com.example.aniket.todo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NotesAdd extends AppCompatActivity {

    private Toolbar mToolbar;

    TextInputEditText mTitle;

    TextInputEditText mDesc;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_add);

        mToolbar=findViewById(R.id.nav_action);

        setSupportActionBar(mToolbar);

        mTitle=findViewById(R.id.txt_title);

        mDesc=findViewById(R.id.txt_desc);

        submit=findViewById(R.id.submit);

        final AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();



        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Notes nd=new Notes(mTitle.getText().toString(),mDesc.getText().toString());
                        db.notesDAO().insertAll(nd);
                        startActivity(new Intent(NotesAdd.this,MainActivity.class));

                    }
                }
        );


    }
}
