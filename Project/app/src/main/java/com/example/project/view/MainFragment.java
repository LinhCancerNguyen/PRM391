package com.example.project.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.project.R;
import com.example.project.data.db.AccountDAO;
import com.example.project.data.db.DBConnection;
import com.example.project.data.db.PetDAO;
import com.example.project.data.db.ProductDAO;
import com.example.project.data.model.Account;
import com.example.project.data.model.Pet;
import com.example.project.data.model.Product;
import com.example.project.view.adapter.ProductRecyclerViewAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Toolbar toolbar;
    private ViewFlipper imgSlide;
    private Context mContext;

    private RecyclerView recyclerViewProduct;
    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    private List<Product> products;
    private DBConnection db;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = getView().findViewById(R.id.toolBar);
        imgSlide = getView().findViewById(R.id.imgSlide);
        recyclerViewProduct = getView().findViewById(R.id.recyclerViewProduct);

        db = Room.databaseBuilder(mContext, DBConnection.class, "database.db")
                .allowMainThreadQueries()
                .build();
        ProductDAO productDAO = db.getProductDAO();
        products = productDAO.all();


        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        int img[]= {R.drawable.banner_1, R.drawable.banner_2};
        for(int i: img) {
            slide(i);
        }

        productRecyclerViewAdapter = new ProductRecyclerViewAdapter(mContext, products);
        recyclerViewProduct.setHasFixedSize(true);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewProduct.setAdapter(productRecyclerViewAdapter);
        productRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void slide(int img) {
        ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundResource(img);
        imgSlide.addView(imageView);
        imgSlide.setFlipInterval(3000);
        imgSlide.setAutoStart(true);
        imgSlide.setInAnimation(mContext, android.R.anim.slide_in_left);
        imgSlide.setOutAnimation(mContext, android.R.anim.slide_out_right);
    }

}