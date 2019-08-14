package com.dwarsh.mashapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dwars on 01-05-2019.
 */

public class GAdapter extends RecyclerView.Adapter<GAdapter.MyViewHolder> {
    int pos;
    private List<Games> itemList;
    private Context context;
    public GAdapter()
    {}
    public GAdapter(Context context, List<Games> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        pos = position;
        holder.bindViewHolder(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemimage;
        TextView textViewname,textViewdesc,textViewpoint;
        public MyViewHolder(final View itemView) {
            super(itemView);
            textViewname = (TextView)itemView.findViewById(R.id.title);
            textViewdesc = (TextView)itemView.findViewById(R.id.desc);
            textViewpoint = (TextView)itemView.findViewById(R.id.points);
            itemimage = (ImageView)itemView.findViewById(R.id.itemimage);
        }

        public void bindViewHolder(final Games item) {
            textViewname.setText(item.getName());
            textViewdesc.setText(item.getDesc());
            textViewpoint.setText("0/"+item.getPoints());
            itemimage.setBackgroundResource(item.getImg());
        }
    }
}
