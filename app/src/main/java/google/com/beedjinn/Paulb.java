package google.com.beedjinn;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Paulb extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paulb);

        Button toMenu = (Button) findViewById(R.id.toMenu);
        toMenu.setOnClickListener(this);

        ImageButton toBel = (ImageButton) findViewById(R.id.toBel);
        toBel.setOnClickListener(this);

        ImageButton toLara = (ImageButton) findViewById(R.id.toLara);
        toLara.setOnClickListener(this);

        TextView myTextView = (TextView) findViewById(R.id.titre);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/Amarillo.ttf");
        myTextView.setTypeface(typeface);

        TextView myTextView2 = (TextView) findViewById(R.id.texte);
        Typeface typeface2=Typeface.createFromAsset(getAssets(), "fonts/Cicle Fina.ttf");
        myTextView2.setTypeface(typeface2);

        TextView myTextView3 = (TextView) findViewById(R.id.stitre);
        Typeface typeface3=Typeface.createFromAsset(getAssets(), "fonts/Amarillo.ttf");
        myTextView3.setTypeface(typeface3);

        final RelativeLayout layout=(RelativeLayout) findViewById(R.id.paulb);
        layout.setOnTouchListener(new OnSwipeTouchListener(layout.getContext()){
            public void onSwipeRight (){
                finish();
                Intent toBel = new Intent(layout.getContext(),Bel.class);
                startActivity(toBel);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
            public void onSwipeLeft(){
                finish();
                Intent toLara = new Intent(layout.getContext(),Lara.class);
                startActivity(toLara);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.toMenu:
                finish();
                Intent toMenu = new Intent(this,Presentation.class);
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                break;

            case R.id.toBel:
                finish();
                Intent toBel = new Intent(this,Bel.class);
                startActivity(toBel);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;

            case R.id.toLara:
                finish();
                Intent toLara = new Intent(this,Lara.class);
                startActivity(toLara);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;


        }
    }


}