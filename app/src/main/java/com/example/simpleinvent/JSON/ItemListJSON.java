package com.example.simpleinvent.JSON;

import android.content.Context;

import com.example.simpleinvent.model.InventModelRv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ItemListJSON {

    public static ArrayList<InventModelRv> GetItemList(Context context, String itemListJSON)
            throws JSONException {

        final String mItemCode="KD_BRG";

        final String mItemName="NM_BRG";
        final String mItemPrice="HRG_JUALB";




        JSONArray ItemListJSONArray = new JSONArray(itemListJSON);
        JSONObject myJSONObject;



        ArrayList<InventModelRv> dataItemList=new ArrayList();



        for (int i = 0; i < ItemListJSONArray.length(); i++){

            InventModelRv mdataItemList=new InventModelRv();
            ;

            myJSONObject = ItemListJSONArray.getJSONObject(i);
            mdataItemList.setItem_code(myJSONObject.getString(mItemCode));
            mdataItemList.setItem_name((myJSONObject.getString(mItemName)));
            mdataItemList.setItem_price(myJSONObject.getString(mItemPrice));


            dataItemList.add(mdataItemList);
        }

        return dataItemList;

    }
}
