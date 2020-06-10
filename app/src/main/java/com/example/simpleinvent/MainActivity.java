package com.example.simpleinvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.simpleinvent.JSON.ItemListJSON;
import com.example.simpleinvent.adapters.ItemSearchAdapter;
import com.example.simpleinvent.model.InventModelRv;
import com.example.simpleinvent.network.ConnectParseURI;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItemList;
    private ItemSearchAdapter adapterItemList;
    private ArrayList<InventModelRv> dataItemList;
    private AppCompatActivity activity=MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataItemList= new ArrayList<InventModelRv>();

        rvItemList = (RecyclerView) findViewById(R.id.rvSearchItems);

        adapterItemList = new ItemSearchAdapter(this.getApplicationContext(),dataItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(MasterMenu.this,2);
        rvItemList.setLayoutManager(layoutManager);
        rvItemList.setAdapter(adapterItemList);

        adapterItemList.notifyDataSetChanged();
        if (savedInstanceState == null) {
            new FetchItemList().execute();
        } else {
            //ArrayList parcelRecipe = savedInstanceState.getParcelableArrayList(MY_KEY);
            rvItemList.setAdapter(new ItemSearchAdapter(getApplicationContext(), dataItemList));

        }
    }//end of onCreate

    public class FetchItemList extends AsyncTask<String,Void,ArrayList<InventModelRv>> {

        @Override
        protected ArrayList<InventModelRv> doInBackground(String... params) {

            URL ItemDataUrl = ConnectParseURI.buildURL();

            try {
                String ItemListResponse = ConnectParseURI.getResponseFromHttpUrl(ItemDataUrl);

                ArrayList<InventModelRv> JSONItemData = ItemListJSON.GetItemList(MainActivity.this, ItemListResponse);

                return JSONItemData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(ArrayList<InventModelRv> strings) {
            if (strings != null) {
                adapterItemList = new ItemSearchAdapter(getApplicationContext(),strings);
                rvItemList.setAdapter(adapterItemList);
                dataItemList=strings;

            }
        }
    } // end Class:FetchItemList

}