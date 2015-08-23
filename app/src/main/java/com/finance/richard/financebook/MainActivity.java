package com.finance.richard.financebook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText item, price;
    TextView showPurchase;
    Button enter;
    StudentDatabaseHelper writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setGlobalVariables();

    }

    private void setGlobalVariables(){
        item = (EditText) findViewById(R.id.Name);
        price = (EditText) findViewById(R.id.Price);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
        showPurchase = (TextView) findViewById(R.id.output);
        writer = new StudentDatabaseHelper(getApplicationContext());
    }


    @Override
    public void onClick(View v) {
        //when
        if(v.getId() == R.id.enter){
            writer.insert(makePurchaseItemFromCurrentData());
        }
    }

    private Purchase makePurchaseItemFromCurrentData() {

        // setting variables
        String name;
        float price;
        Purchase purchase;

        // get value from the input textboxes
        name = getNewItemName();
        price = getNewItemValue();

        // make purchase based on the input values
        purchase = new Purchase();
        purchase.setName(name).setPrice(price);

        // return the purchase
        return purchase;
    }

    private String getNewItemName(){
        String name = item.getText().toString();
        return name;
    }

    private float getNewItemValue(){
        String price = this.price.getText().toString();
        return Float.valueOf(price);
    }
}