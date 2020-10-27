package com.example.project.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listMenu;
    private String menu[] = {"Sevurity", "Cards", "Address", "Invite a friend", "Help", "FAQs", "Sign out"};
    int img[] = {R.drawable.ic_security, R.drawable.ic_card, R.drawable.ic_location, R.drawable.ic_giftcard, R.drawable.ic_help, R.drawable.ic_faq, R.drawable.ic_signout};
    private Context mContext;

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

    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    class CustomAdapter extends ArrayAdapter<String> {
        private Context context;
        private int img[];
        private String menu[];

        private CustomAdapter(Context context, int img[], String menu[]) {
            super(context, R.layout.menu_layout, menu);
            this.context = context;
            this.img = img;
            this.menu = menu;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getActivity().getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.menu_layout, parent, false);
            ImageView imgMenu = row.findViewById(R.id.imgMenu);
            TextView txtMenu = row.findViewById(R.id.txtMenu);
            imgMenu.setImageResource(img[position]);
            txtMenu.setText(menu[position]);

            return row;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listMenu = getView().findViewById(R.id.listMenu);
        CustomAdapter adapter = new CustomAdapter(mContext, img, menu);

        listMenu.setAdapter(adapter);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), SecurityActivity.class);
                    startActivity(intent);
                }
                if(position == 1) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), CardActivity.class);
                    startActivity(intent);
                }
                if(position == 2) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), AddressActivity.class);
                    startActivity(intent);
                }
                if(position == 3) {
                }
                if(position == 4) {
                }
                if(position == 5) {
                }
                if(position == 6) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}