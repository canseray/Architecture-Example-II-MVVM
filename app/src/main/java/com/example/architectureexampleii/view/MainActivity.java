package com.example.architectureexampleii.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.architectureexampleii.R;
import com.example.architectureexampleii.adapter.CategoriesAdapter;
import com.example.architectureexampleii.viewmodel.CategoriesViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CategoriesViewModel categoriesViewModel;
    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);

        categoriesViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<CategoriesViewModel>>() {
            @Override
            public void onChanged(ArrayList<CategoriesViewModel> categoriesViewModels) {

                categoriesAdapter = new CategoriesAdapter(MainActivity.this, categoriesViewModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(categoriesAdapter);
            }
        });
    }
}
