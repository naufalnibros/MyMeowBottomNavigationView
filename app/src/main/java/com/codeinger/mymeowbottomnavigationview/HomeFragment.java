package com.codeinger.mymeowbottomnavigationview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.codeinger.mymeowbottomnavigationview.api.ApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ListView listView;
    private String JSON_STRING;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        final View view =  inflater.inflate(R.layout.fragment_home, container, false);
        TextView text = view.findViewById(R.id.tvNamaHome);
        SessionManager sessionManager = new SessionManager(getActivity());
        String loginName = sessionManager.getUserDetail().get(SessionManager.NAME);
        text.setText(loginName);

        // select

        listView = view.findViewById(R.id.lvTugasHome);

        JSONObject jsonObject;
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(ApiClient.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length();i++){

                JSONObject object = result.getJSONObject(i);
                String judul = object.getString(ApiClient.JUDUL_TUGAS);
                String pengajar = object.getString(ApiClient.PENGAJAR_TUGAS);

                HashMap<String,String> tugas = new HashMap<>();
                tugas.put(ApiClient.JUDUL_TUGAS,judul);
                tugas.put(ApiClient.PENGAJAR_TUGAS,pengajar);
                list.add(tugas);
            }
        } catch (JSONException e) {
            new AlertDialog.Builder(view.getContext())
                    .setMessage(e.getMessage())
                    .show();
        }catch (NullPointerException e){
            new AlertDialog.Builder(view.getContext())
                    .setMessage(e.getMessage())
                    .show();
        }
        ListAdapter adapter = new SimpleAdapter(
                view.getContext(), list,R.layout.uicrudtugashome,
                new String[] {ApiClient.JUDUL_TUGAS,ApiClient.PENGAJAR_TUGAS},
                new int[] {R.id.tvJudulCrudTugasHome,R.id.tvPengajarCrudTugasHome});
        listView.setAdapter(adapter);
        return view;

    }

}