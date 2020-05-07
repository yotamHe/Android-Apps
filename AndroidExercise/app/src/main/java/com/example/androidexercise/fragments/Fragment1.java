package com.example.androidexercise.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.androidexercise.R;
import com.example.androidexercise.activities.MainActivity;
import com.example.androidexercise.classes.OnSwipeTouchListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View view =  inflater.inflate(R.layout.fragment_1, container, false);

        //Button 1
        final Animation shakeAnim = AnimationUtils.loadAnimation(getContext() ,R.anim.shake);
        Button button1 = (Button) view.findViewById(R.id.button1Frag1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(shakeAnim);
            }
        });

        //Button 2

        final Animation rotateAnim = AnimationUtils.loadAnimation(getContext(),R.anim.rotate);

        Button button2 = (Button) view.findViewById(R.id.button2Frag1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(rotateAnim);
            }
        });


        //Button 3

        final Animation flipAnim = AnimationUtils.loadAnimation(getContext(),R.anim.flip3d);

        Button button3 = (Button) view.findViewById(R.id.button3Frag1);

        //Short click
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadFragment2();
            }
        });

    //long click
        button3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.startAnimation(flipAnim);
                return true;
            }
        });



        //Touchlistener

        view.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            public void onSwipeRight() {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadFragment2();
            }
        });
        return view;
    }
}
