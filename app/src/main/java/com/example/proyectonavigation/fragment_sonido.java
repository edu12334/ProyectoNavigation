package com.example.proyectonavigation;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.media.MediaPlayer.*;
import static com.example.proyectonavigation.R.raw.chata;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_sonido#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_sonido extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_sonido() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_sonido.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_sonido newInstance(String param1, String param2) {
        fragment_sonido fragment = new fragment_sonido();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private View view;
    private Button btnanterior, btnparar, btnsiguiente, btnnorepetir, btnplay_pause;
    private ImageView iv;
    private MediaPlayer mp;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp[] = new MediaPlayer[1];

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
        View view1 = inflater.inflate(R.layout.fragment_sonido, container, false);

        btnplay_pause = view1.findViewById(R.id.btnplay);
        btnparar = view1.findViewById(R.id.btnparar);
        btnanterior = view1.findViewById(R.id.btnanterior);
        btnsiguiente = view1.findViewById(R.id.btnsiguiente);
        btnnorepetir = view1.findViewById(R.id.btnnorepetir);
        iv = view1.findViewById(R.id.iv);

        return view1;

    }


    public void PlayPause(View view)
    {
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            btnplay_pause.setBackgroundResource(R.drawable.reproducir);

        } else {
            vectormp[posicion].start();
            btnplay_pause.setBackgroundResource(R.drawable.pausa);
        }
    }

    public void stop(View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();


        }
    }

}