package hr.ferit.tumiljanovic.orwima_lv3;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ButtonClickListener{

    @BindView(R.id.tableLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private BasicViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpPager();
    }

    private void setUpPager() {
        pagerAdapter = new BasicViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setUpTab();
    }

    private void setUpTab() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(
                    String.format(Locale.getDefault(), "#%d", i + 1));
        }
    }

    @Override
    public void onButtonClicked(String message) {
        pagerAdapter.getMessageFragment().displayMessage(message);
        viewPager.setCurrentItem(1);
    }

}
