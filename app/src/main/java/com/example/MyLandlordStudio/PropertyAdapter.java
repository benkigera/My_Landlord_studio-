package com.example.MyLandlordStudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private Context mCtx;
    private List<Property> propertyList;

    public PropertyAdapter(Context mCtx, List<Property> propertyList) {
        this.mCtx = mCtx;
        this.propertyList =propertyList ;
    }

    @NonNull
    @Override
    public PropertyAdapter.PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PropertyAdapter.PropertyViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.property_single_view, parent, false)
        );
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PropertyAdapter.PropertyViewHolder holder, int position) {
        Property property = propertyList.get(position);
        holder.PropertyName.setText(property.getName());
        holder.propertyLocation.setText(property.getCity());

    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    class PropertyViewHolder extends RecyclerView.ViewHolder {

        TextView PropertyName,propertyLocation;

        public PropertyViewHolder(View itemView) {
            super(itemView);
            PropertyName =itemView.findViewById(R.id.textView_propertyName);
            propertyLocation = itemView.findViewById(R.id.textView_Location);


        }
    }
}



