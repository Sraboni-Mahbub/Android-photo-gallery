package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.annotation.SuppressLint;
import android.os.AsyncTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    customImageAdapter customImageAdapter;
    ArrayList<imagesArrayList> arrayList;

    private String URL = "https://muthosoft.com/univ/photos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        arrayList = new ArrayList<>();

        httpRequest();
    }

    @SuppressLint("StaticFieldLeak")
    private void httpRequest(){
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... param){
                try{
                    String data = JSONParser.getInstance().makeHttpRequest(URL, "POST");
                    return data;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);

                String[] splitByComma = data.split(",");
                ArrayList<imagesArrayList> arrayList = new ArrayList<>();
                for (String a : splitByComma){
                    String[] splitByColon = a.split(":");

                    imagesArrayList imagesArrayList = new imagesArrayList(splitByColon[0], splitByColon[1]);
                    arrayList.add(imagesArrayList);
                }

                loadData(arrayList);
            }
        }.execute();
    }
    void loadData(ArrayList arrayList){
        customImageAdapter = new customImageAdapter(this,arrayList);
        gridView.setAdapter(customImageAdapter);
        customImageAdapter.notifyDataSetChanged();

    }
}