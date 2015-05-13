package com.example.anderson.myjsonexample;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<Category> all(){
        String url = "http://192.168.7.97/servicedesktest/web/index.php?r=category";
        String formatedUrl = Uri.parse(url).toString();
        List<Category> categories = new ArrayList<>();

        String conteudo = HttpRequest.get(formatedUrl).body();

        try {
            JSONArray myArray = new JSONArray(conteudo);

            for(int i = 0; i < myArray.length(); i++){
                JSONObject object = myArray.getJSONObject(i);
                Category category = new Category();
                category.setId(object.getLong("id"));
                category.setDescription(object.getString("description"));
                categories.add(category);
            }

        }catch (Exception ex){

        }

        return categories;
    }
}
