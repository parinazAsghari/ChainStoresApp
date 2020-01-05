package com.example.parinaz.chainstoresapp.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parinaz.chainstoresapp.MutableLiveData;
import com.example.parinaz.chainstoresapp.R;


public class SumFragment extends Fragment {
    EditText firstNumber;
    EditText secondNumber;
    Button Add;
    TextView sum;
    private MutableLiveData<String> mutableLiveData;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_number, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstNumber=view.findViewById(R.id.editText_first_no);
        secondNumber=view.findViewById(R.id.editText_second_no);
        Add=view.findViewById(R.id.add_button);
        sum=view.findViewById(R.id.textView_answer);
        mutableLiveData=new MutableLiveData<>();

    mutableLiveData.observe((LifecycleOwner) getContext(), new Observer<String>() {
        @Override
        public void onChanged(@Nullable String string) {
            sum.setText(string);
        }
    });




        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(firstNumber.getText().toString());
                int num2 = Integer.parseInt(secondNumber.getText().toString());
                int finalresult = num1+num2;

                mutableLiveData.postValue("final result:"+finalresult);
            }
        });

    }


}
