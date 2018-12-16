package hr.ferit.tumiljanovic.orwima_lv3;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BasicViewPagerAdapter extends FragmentStatePagerAdapter {

    private int size = 4;

    private InputFragment inputFragment;
    private MessageFragment messageFragment;
    private ChangeableFragment changeableFragmentImage;
    private ChangeableFragment changeableFragmentText;

    public BasicViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (inputFragment == null) {
                    inputFragment = InputFragment.newInstance();
                }
                return inputFragment;
            case 1:
                if (messageFragment == null) {
                    messageFragment = MessageFragment.newInstance();
                }
                return messageFragment;
            case 2:
                if (changeableFragmentText == null) {
                    changeableFragmentText = ChangeableFragment.newInstance("puzzle");
                }
                return changeableFragmentText;
            case 3:
                if (changeableFragmentImage == null) {
                    changeableFragmentImage = ChangeableFragment.newInstance("image");
                }
                return changeableFragmentImage;

            default:
                return InputFragment.newInstance();

        }
    }

    @Override
    public int getCount() {
        return size;
    }

    public MessageFragment getMessageFragment() {
        return messageFragment;
    }

}
