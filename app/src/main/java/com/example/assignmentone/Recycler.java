package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Recycler extends AppCompatActivity {

    private AppDatabase mDB;
    private RecyclerView mRecyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // TODO 1: Initialize
        mDB = AppDatabase.getInstance(getApplicationContext());

        // TODO 2: Initialize Recycler View
        mRecyclerView = findViewById(R.id.recUser);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO 3: Custom Adapter
        userAdapter = new UserAdapter(this);
        mRecyclerView.setAdapter(userAdapter);

        //TODO 5: Call Function
        retrievePersonListFromDatabase();


    }

    public void retrievePersonListFromDatabase(){
        // TODO 4: Call worker thread to get the data and pass to adapter
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                // separate
                final List<User> userList = mDB.userDao().loadAllPerson();

                runOnUiThread(new Runnable() {
                    //Main UI
                    @Override
                    public void run() {
                        userAdapter.setPersonDataInAdapter(userList);
                    }
                });

            }
        });
    }

}