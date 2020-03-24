package com.example.startupfacbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView ;
  adapter adapter ;
    viewmodel viewmodel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        adapter=new adapter();
        viewmodel viewmodel = ViewModelProviders.of(this).get(viewmodel.class);
        viewmodel.getpost();
        viewmodel.mutableLiveData.observe(this,c->adapter.setlist(c));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }
}
