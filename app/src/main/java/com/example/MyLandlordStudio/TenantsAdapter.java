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

public class TenantsAdapter extends RecyclerView.Adapter<TenantsAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Tenant> tenantList;

    public TenantsAdapter(Context mCtx, List<Tenant> tenantList) {
        this.mCtx = mCtx;
        this.tenantList = tenantList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.tenantview, parent, false)
        );
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Tenant tenant = tenantList.get(position);
        holder.Firstname.setText(tenant.getFirst_name());
        holder.SecondName.setText(tenant.getSecond_name());
        holder.PhoneNumber.setText(tenant.getPhone_number());
        holder.Email.setText(tenant.getEmail());
        holder.Amount.setText("Ksh "+tenant.getAmount_paid());
        holder.HouseNumber.setText("House Number: " + tenant.getHouse_number());
    }

    @Override
    public int getItemCount() {
        return tenantList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView Firstname,SecondName, PhoneNumber, Email, Amount, HouseNumber;

        public ProductViewHolder(View itemView) {
            super(itemView);
            Firstname=itemView.findViewById(R.id.textView_FirstName);
            SecondName = itemView.findViewById(R.id.textView_SecondName);
            PhoneNumber = itemView.findViewById(R.id.textView_phoneNumber);
            Email = itemView.findViewById(R.id.textView_email);
            Amount = itemView.findViewById(R.id.textView_Monthly_rent);
            HouseNumber = itemView.findViewById(R.id.textView_houseNumber);

        }
    }
}
