package app.itc.org.todo;

import android.os.Build;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.visible;

public class MainActivity extends AppCompatActivity {

    private EditText mItemInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateTextView = (TextView) findViewById(R.id.date_tv);

        mItemInputEditText = (EditText) findViewById(R.id.item_input_et);
        final Button addButton = (Button) findViewById(R.id.add_btn);

        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);

        mItemInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionSet set = new TransitionSet()
                            .addTransition(new Fade())
                            .setInterpolator(new FastOutLinearInInterpolator());

                    TransitionManager.beginDelayedTransition(transitionsContainer, set);
                }

                addButton.setVisibility(View.VISIBLE);
                mItemInputEditText.setVisibility(View.GONE);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionSet set = new TransitionSet()
                            .addTransition(new Fade())
                            .setInterpolator(new FastOutLinearInInterpolator());

                    TransitionManager.beginDelayedTransition(transitionsContainer, set);
                }

                addButton.setVisibility(View.GONE);
                mItemInputEditText.setVisibility(View.VISIBLE);
            }

        });

        SimpleDateFormat dt = new SimpleDateFormat("EEE d MMM yyyy");
        dateTextView.setText(dt.format(new Date()));

    }
}
