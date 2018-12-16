package hr.ferit.tumiljanovic.orwima_lv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeableFragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "message";

    @BindView(R.id.tvRandomMessage)
    TextView mMessageTextView;

    @BindView(R.id.ivImage)
    ImageView imageView;

    @BindView(R.id.btnSolution)
    Button mSolutionBtn;

    @BindView(R.id.tvSolution)
    TextView mPuzzleSolution;

    public static ChangeableFragment newInstance(String message) {
        ChangeableFragment fragment = new ChangeableFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_changeable, container, false);
        ButterKnife.bind(this, rootView);
        
        setUpView();

        return rootView;
        
    }

    private void setUpView() {

        if (getArguments() != null) {
            String argMessage = getArguments().getString(BUNDLE_MESSAGE);
            if (argMessage != null && !argMessage.isEmpty()) {
                if(argMessage.equals("puzzle")){
                    mMessageTextView.setVisibility(View.VISIBLE);
                    mSolutionBtn.setVisibility(View.VISIBLE);

                }
                else if(argMessage.equals("image")){
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @OnClick(R.id.btnSolution)
    public void onSolutionBtnClick(){
        mPuzzleSolution.setVisibility(View.VISIBLE);
    }

}
