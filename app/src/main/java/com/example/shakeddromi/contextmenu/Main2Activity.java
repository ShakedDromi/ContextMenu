package com.example.shakeddromi.contextmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Shaked Dromi
 * @version alpha
 * @since 16.11.19
 * on this activity the user sees the series.
 * if the user presses long on each item, he can either get the item's index,
 * or the sum of the numbers that appear before the number he chose(including the number he chose)
 */

public class Main2Activity extends AppCompatActivity implements View.OnCreateContextMenuListener,AdapterView.OnItemLongClickListener {

    double[] d=new double[20];
    String[] y=new String[20];
    double m,n;
    boolean b;
    ListView lv;
    TextView tv1;
    String st="";
    int index;

    /**
     * d- double array for the series of numbers
     * y- string array for the series numbers string
     * m- the first number of the series
     * n- the difference or multiplier
     * index- the index of the list view's choice
     * lv- the java object of ListView
     * tv- the java object of TextView
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        lv=(ListView) findViewById(R.id.lv);
        tv1=(TextView) findViewById(R.id.tv1);


        Intent gi=getIntent();
        n=gi.getDoubleExtra("hukiut",-2000000000);
        m=gi.getDoubleExtra("first",-2000000000);
        b=gi.getBooleanExtra("sug",false);

        d[0]=m;
        if (!b) {
            for (int i=1;i<=19;i++){
                d[i]=d[i-1]+n;
            }
        }
        else{
            for (int i=1;i<=19;i++){
                d[i]=d[i-1]*n;
            }}

        for(int i=0;i<=19;i++) {
            y[i]=""+d[i];
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,y);
        lv.setAdapter(adp);
        lv.setOnCreateContextMenuListener(this);
        lv.setOnItemLongClickListener(this);
    }

    /**
     * this method creates the context menu
     */

    @Override
    public void onCreateContextMenu (ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Options");
        menu.add("item index");
        menu.add("sum");

    }

    /**
     * this method starts when the user clicks on one option.
     * if the user clicks on the first option, in the text view there will be the item's index.
     * if the user clicks on the second option, in the text view there will be the sum
     * of the numbers below the chosen number(including the chosen number).
     * @param item - the selected item
     */

    @Override
    public boolean onContextItemSelected(MenuItem item){
        String oper=item.getTitle().toString();
        if (oper.equals("item index")) {
            tv1.setText("index: "+(index+1));
        }
        if (oper.equals("sum")) {
            double sum=0;
            for(int i=0;i<=index;i++) {
                sum+=d[i];
            }
            tv1.setText("sum= "+sum);
        }
        return super.onContextItemSelected(item);
    }

    /**
     * this method takes the user to the first activity.
     */

    public void bk(View view) {
        finish();
    }

    /**
     * this method takes the user to the credits activity.
     */

    public void credis(View view) {
        Intent si=new Intent(this,credits.class);
        startActivity(si);
    }

    /**
     * this method gets the item's index from the series.
     * @param position
     */

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        index=position;
        return false;
    }
}