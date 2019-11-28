package com.example.architectureexampleii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architectureexampleii.R;
import com.example.architectureexampleii.databinding.CategoriesBinding;
import com.example.architectureexampleii.viewmodel.CategoriesViewModel;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private ArrayList<CategoriesViewModel> viewModelArrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CategoriesAdapter(Context context, ArrayList<CategoriesViewModel> viewModelArrayList){
        this.context = context;
        this.viewModelArrayList = viewModelArrayList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        CategoriesBinding categoriesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_category,parent,false);

        return new CategoriesViewHolder(categoriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesViewModel categoriesViewModel = viewModelArrayList.get(position);
        holder.bind(categoriesViewModel);
    }

    @Override
    public int getItemCount() {
        return viewModelArrayList.size();
    }


    class CategoriesViewHolder extends RecyclerView.ViewHolder{
        private CategoriesBinding categoriesBinding;

        public CategoriesViewHolder(@NonNull CategoriesBinding categoriesBinding) {
            super(categoriesBinding.getRoot());
            this.categoriesBinding = categoriesBinding;
        }

        public void bind(CategoriesViewModel categoriesViewModel) {
            this.categoriesBinding.setCategorymodel(categoriesViewModel);
            categoriesBinding.executePendingBindings();
        }

        public CategoriesBinding getCategoriesBinding(){
            return categoriesBinding;
        }
    }

}
