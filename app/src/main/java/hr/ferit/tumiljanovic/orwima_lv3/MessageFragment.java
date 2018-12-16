package hr.ferit.tumiljanovic.orwima_lv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageFragment extends Fragment  {

    @BindView(R.id.tvMessage)
    TextView mMessageTextView;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_message, container, false);
        ButterKnife.bind(this, rootView);


        return rootView;
    }

    public void displayMessage(String message) {
        mMessageTextView.setText(message);
    }

}

