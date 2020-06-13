package com.example.simpleinvent.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleinvent.R;
import com.example.simpleinvent.model.DetailOrderModel;
import com.example.simpleinvent.model.InventModelRv;

import java.util.ArrayList;

public class ItemSearchAdapter extends RecyclerView.Adapter<ItemSearchAdapter.ItemSearchViewHolder> {

    private Context mContext;
    private ArrayList<InventModelRv> itemList;

    public ItemSearchAdapter(Context xFBContext, ArrayList<InventModelRv> itemList) {
        this.mContext=xFBContext;
        this.itemList = itemList;
    }

    @Override
    public ItemSearchAdapter.ItemSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_main_card, parent, false);
        return new ItemSearchAdapter.ItemSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemSearchAdapter.ItemSearchViewHolder holder, int position) {

        holder.txtItemCode.setText(itemList.get(position).getItem_code());
        holder.txtItemName.setText(itemList.get(position).getItem_name());
        holder.txtItemPrice.setText(String.valueOf(itemList.get(position).getItem_price()));
        holder.imgItemView.setImageResource(R.drawable.goods);
    }

    @Override
    public int getItemCount() {
        return (itemList != null) ? itemList.size() : 0;
    }

    public class ItemSearchViewHolder extends RecyclerView.ViewHolder{
        private TextView txtItemCode;
        private TextView txtItemName;
        private TextView txtItemPrice;
        private ImageView imgItemView;

        public ArrayList<DetailOrderModel> detailCart=new ArrayList();
        public ItemSearchViewHolder(View itemView) {
            super(itemView);
            txtItemCode=(TextView) itemView.findViewById(R.id.txtItemCode);
            txtItemName = (TextView) itemView.findViewById(R.id.txtItemName);
            txtItemPrice = (TextView) itemView.findViewById(R.id.txtItemPrice);
            imgItemView=(ImageView) itemView.findViewById(R.id.itemView);

            Button myButton = (Button) itemView.findViewById(R.id.btnAddCart);
            myButton.setOnClickListener(new View.OnClickListener() {



                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent();

                    if (pos != RecyclerView.NO_POSITION) {

                        InventModelRv clickeddataItem = itemList.get(pos);
                        DetailOrderModel setOrder = new DetailOrderModel();

                        setOrder.setItem_code(clickeddataItem.getItem_code());
                        setOrder.setItem_name(clickeddataItem.getItem_name());
                        setOrder.setItem_price(clickeddataItem.getItem_price());
                        setOrder.setItem_qty(clickeddataItem.getItem_qty());
                        //Uploader1 task = new OrderAdapter.Uploader1();
                        //task.execute(new String[] { ServerURL, xCMenu,cPRCMenu,cQTY });
                        detailCart.add(setOrder);
                        detailCart.size();
                    }
                }
            });

        }
    }
}
