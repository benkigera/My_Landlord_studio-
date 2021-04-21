package com.example.MyLandlordStudio;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class currentFragment extends Fragment {

    private RecyclerView recyclerView;
    private List tenantList;
    private TenantsAdapter adapter;





    private FirebaseFirestore db;

    private FloatingActionButton fab_main, fab1_mail, fab2_share;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    TextView textview_mail, textview_share;
    View mShadowView;

    Boolean isOpen = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.current_tenants, container, false);

       mShadowView = view.findViewById(R.id.shadowView);


        //  final FloatingActionButton floating_add_tenant_button = view.findViewById(R.id.floating_add_tenant_button);

        recyclerView = view.findViewById(R.id.recyclerview_tenants);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        db = FirebaseFirestore.getInstance();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();


        fab_main = view.findViewById(R.id.fab);
        fab1_mail = view.findViewById(R.id.fab1);
        fab2_share = view.findViewById(R.id.fab2);
        fab_close = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_rotate_anticlock);


        textview_mail = view.findViewById(R.id.textview_mail);
        textview_share = (TextView) view.findViewById(R.id.textview_share);


        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {
                    mShadowView.setVisibility(View.GONE);
                    textview_mail.setVisibility(View.INVISIBLE);
                    textview_share.setVisibility(View.INVISIBLE);
                    fab2_share.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab2_share.setClickable(false);
                    fab1_mail.setClickable(false);
                    isOpen = false;


                } else {
                    textview_mail.setVisibility(View.VISIBLE);
                    textview_share.setVisibility(View.VISIBLE);
                    fab2_share.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab2_share.setClickable(true);
                    fab1_mail.setClickable(true);
                    isOpen = true;
                    mShadowView.setVisibility(View.VISIBLE);

                }

            }
        });



        fab2_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();



            }
        });

        fab1_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tenant_detail=new Intent(getActivity(),Tenant_details_activity.class);
                startActivity(tenant_detail);

            }
        });


        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.animation_leave);
        recyclerView.setLayoutAnimation(animationController);


        tenantList = new ArrayList<>();
        adapter = new TenantsAdapter(getActivity(), tenantList);


        recyclerView.setAdapter(adapter);
        CollectionReference documentReference = db.collection("Users").document(uid).collection("tenants");


        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {


                                Tenant tenant = d.toObject(Tenant.class);
                                tenantList.add(tenant);
                            }

                            adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getActivity(), "You don't have tenants", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });


//        floating_add_tenant_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                //intent from fragment to activity

               // floating_add_tenant_button.setImageResource(R.drawable.ic_clear_white_24dp);
//
//            }
//        });


        return view;


    }
    }




