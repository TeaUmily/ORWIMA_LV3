package hr.ferit.tumiljanovic.orwima_lv3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputFragment extends Fragment implements TextWatcher {

    @BindView(R.id.edMessage)
    EditText mEditText;

    @BindView(R.id.btSubmit)
    Button mSubmitButton;

    private static String mMessageString = "...";

    private ButtonClickListener buttonClickListener;

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_input, container, false);

        ButterKnife.bind(this, rootView);
        setUpListeners();
        return rootView;
    }

    private void setUpListeners() {
        mEditText.addTextChangedListener(this);
    }

    @OnClick(R.id.btSubmit)
    void onBtnSubmitClick(){
        buttonClickListener.onButtonClicked(mMessageString);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener) {
            this.buttonClickListener = (ButtonClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.buttonClickListener = null;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        mMessageString = s.toString();

    }

}