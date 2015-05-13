package com.example.anderson.myjsonexample;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListCategoryTask extends AsyncTask<String, Void, List<Category>>{

    private ListView categoriesListView;
    private Context context;

    public ListCategoryTask(ListView categoriesListView, Context context) {
        this.categoriesListView = categoriesListView;
        this.context = context;
    }

    @Override
    protected void onPostExecute(List<Category> categories) {
        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, categories);
        categoriesListView.setAdapter(adapter);
    }

    @Override
    protected List<Category> doInBackground(String... params) {
        return new CategoryDAO().all();
    }

}
