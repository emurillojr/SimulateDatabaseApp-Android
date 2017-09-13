package neit.em_lab1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;
//import static neit.em_lab1.R.id.radioShipmentType;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10; ///////

    private EditText txtFirstName; // first name
    private EditText txtLastName; // last name
    private Spinner ddTypeOfChoc; // dropdown type of chocolate
    private EditText txtNumberOfBars; // number of bars
    private RadioButton rbNormalShipment; // normal shipment
    private RadioButton rbExpited; // expidited shipment
    private Boolean shipment = true; // true or false for radio button
    private TextView txtResults; // text results
    //private Button btnSave; // save button
    public Button btnGetResults; // get results button
    ArrayList<Order> purchases = new ArrayList<Order>();



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data.hasExtra("returnkey")) {
            Integer result = data.getExtras().getInt("returnkey");
            txtResults.setText("Orders " + result.toString());
            txtFirstName.setText("");
            txtLastName.setText("");
            rbNormalShipment.setChecked(true);
            txtNumberOfBars.setText("");
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtFirstName = (EditText)findViewById(R.id.txtFirstName); // first name
        txtLastName = (EditText)findViewById(R.id.txtLastName); // last name
        ddTypeOfChoc = (Spinner)findViewById(R.id.ddTypeOfChoc); // dropdown
        rbNormalShipment = (RadioButton)findViewById(R.id.rbNormalShipment); // normal shipment
        rbExpited = (RadioButton)findViewById(R.id.rbExpited); // expidited
        txtNumberOfBars = (EditText)findViewById(R.id.txtNumberOfBars); // number of bars
        txtResults = (TextView)findViewById(R.id.txtResults);// results
        //btnSave = (Button)findViewById(R.id.btnSave); // save button
        btnGetResults = (Button)findViewById(R.id.btnGetResults); // save button


        btnGetResults.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                String firstName = txtFirstName.getText().toString();
                String lastName = txtLastName.getText().toString();
                String TypeOfChoc = ddTypeOfChoc.getSelectedItem().toString(); // dropdown
                String bars = txtNumberOfBars.getText().toString();
                int NumberOfBars = parseInt(bars);
                Order purchaseOrder = new Order(firstName, lastName, TypeOfChoc, NumberOfBars,shipment);
                purchases.add(purchaseOrder);
                Intent i = new Intent(getApplicationContext(), neit.em_lab1.ResultActivity.class);
                i.putExtra("fNameKey", firstName);
                i.putExtra("lNameKey", lastName);
                i.putExtra("barsKey", TypeOfChoc);
                i.putExtra("numOfbarsKey", NumberOfBars);

                if (rbNormalShipment.isChecked()) {
                    //rbNormalShipment.setChecked(true);
                    //rbExpited.setChecked(false);
                    shipment = true;
                    String rbNS = rbNormalShipment.getText().toString();
                    //i.putExtra("shipTypeKey", shipment);  // sending true
                    i.putExtra("shipTypeChosenKey", rbNS); // sending text of radiobutton
                } else {
                    //rbExpited.setChecked(true);
                    //rbNormalShipment.setChecked(false);
                    shipment = false;
                    String rbNS = rbExpited.getText().toString();
                    //i.putExtra("shipTypeKey", shipment);  // sending true
                    i.putExtra("shipTypeChosenKey", rbNS); // sending text of radiobutton
                    //
                }
                i.putExtra("shipTypeKey", shipment);  // sending true

                startActivityForResult(i, REQUEST_CODE);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
