package neit.em_lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import static java.lang.Boolean.getBoolean;

public class ResultActivity extends AppCompatActivity {

    static ArrayList<Order> CandyOrders = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String inputFName = extras.getString("fNameKey"); // first name
        String inputLName = extras.getString("lNameKey"); // last name
        String inputTypeOfChoc = extras.getString("barsKey"); // type of bar
        int bars = extras.getInt("numOfbarsKey"); // number of bars
        Boolean shipType = getBoolean("shipType"); // true or false
        //String shipTypeChosenText = extras.getString("shipTypeChosenKey"); // ship type text
        //String shipTypeChosenText2 = extras.getString("shipTypeChosenKey2"); // ship type text

        Order purchaseOrder = new Order(inputFName, inputLName, inputTypeOfChoc, bars, shipType);
        CandyOrders.add(purchaseOrder);

        ListView results = (ListView) findViewById(R.id.lstViewOrders);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        for (int counter = 0 ; counter < CandyOrders.size();counter++) {
            adapter.add(CandyOrders.get(counter).firstName + " " +
                            CandyOrders.get(counter).lastName + " " +
                            CandyOrders.get(counter).typeOfChocolate + " " +
                            CandyOrders.get(counter).bars //+ " " +
                    // + " " +
                    //    shipType +  // get true or false from MainActivity
                    //CandyOrders.get(counter).shippingType   // get true or false stored in class
                    //CandyOrders.get(counter).getShippintType() + // get true or false stored in class
                    //shipTypeChosenText // shipping type text
            );  // false  false  false keeps showing...
        }
        results.setAdapter(adapter);
    }

    public void finish() {  /////////////

        Intent i = new Intent();  // create intent
        Integer ResultNum = CandyOrders.size();
        i.putExtra("returnkey",ResultNum);


        setResult(RESULT_OK, i);
        super.finish();

    }

    public void GoBack(View view){  ///////////////
        finish();



    }
}
