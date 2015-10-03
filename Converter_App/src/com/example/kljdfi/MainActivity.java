package com.example.kljdfi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	Spinner spinnersel;
	TextView textshow,textt,textinv;
	static EditText edittextone,edittexttwo;
	static Button buttonc,buttonr;

	double res=0;
	static String enterstring1=null;
	static String enterstring2=null;
	static double enteredvl=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final String[] spin = {"Temprature Converter","Meter Converter","Currency Converter"};

		spinnersel = (Spinner) findViewById(R.id.spinnerselect);
		textshow = (TextView) findViewById(R.id.textViewshow);
		textt = (TextView) findViewById(R.id.textViewto);
		edittextone = (EditText) findViewById(R.id.editTextone);
		edittexttwo = (EditText) findViewById(R.id.editTexttwo);
		buttonc = (Button) findViewById(R.id.buttonconv);
		buttonr = (Button) findViewById(R.id.buttonres);
		textinv = (TextView) findViewById(R.id.textViewinv);
		
		textinv.setText("");
		ArrayAdapter<String> adap = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, spin);
		spinnersel.setAdapter(adap);

		buttonr.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				textinv.setText("");
				edittextone.setText("");
				edittexttwo.setText("");
			}
		});

		spinnersel.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				textshow.setText("You Have Selected "+spin[arg2]);

				switch (arg2) {
				case 0: fortemp();

				break;

				case 1 : formeter();

				break;

				case 2: forcurr();

				break; 

				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	void fortemp()
	{
		edittextone.setHint("Celcius");
		edittexttwo.setHint("Farenheit");

		edittextone.setText("");
		edittexttwo.setText("");

		buttonc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {


				enterstring1=edittextone.getText().toString();
				enterstring2=edittexttwo.getText().toString();


				if(enterstring1.length()> 0 && enterstring1 != null)
				{

					enteredvl = Double.parseDouble(enterstring1);
					res=tempCon1(enteredvl);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittexttwo.setText(rest);

				}
				else if(enterstring2.length()>0 && enterstring2 != null)
				{

					enteredvl = Double.parseDouble(enterstring2);
					res=((enteredvl-32)*0.55555);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittextone.setText(rest);

				}
				else
				{
					edittextone.setText("");
					edittexttwo.setText("");
					textinv.setText("Invalid Entry!");
				}

			}
		});
	}

	void formeter()
	{
		edittextone.setHint("Meter");
		edittexttwo.setHint("Millimeter");

		edittextone.setText("");
		edittexttwo.setText("");

		buttonc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {


				enterstring1=edittextone.getText().toString();
				enterstring2=edittexttwo.getText().toString();


				if(enterstring1.length()>0)
				{

					enteredvl = Double.parseDouble(enterstring1);
					res=metercon(enteredvl);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittexttwo.setText(rest);



				}
				else if(enterstring2.length()>0)
				{
					enteredvl = Double.parseDouble(enterstring2);
					res=metercon1(enteredvl);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittextone.setText(rest);

				}
				else
				{
					edittexttwo.setText("");
					textinv.setText("Invalid Entry!");
				}


			}
		});
	}

	void forcurr(){
		edittextone.setHint("Dollar");
		edittexttwo.setHint("Rupee");

		edittextone.setText("");
		edittexttwo.setText("");

		buttonc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {


				enterstring1=edittextone.getText().toString();
				enterstring2=edittexttwo.getText().toString();



				if(enterstring1.length()>0)
				{
					enteredvl = Double.parseDouble(enterstring1);
					res=currcon(enteredvl);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittexttwo.setText(rest);


				}
				else if(enterstring2.length()>0)
				{
					enteredvl = Double.parseDouble(enterstring2);
					res=currcon1(enteredvl);
					textinv.setText("");
					String rest = String.valueOf(res);
					edittextone.setText(rest);
				}
				else
				{
					edittexttwo.setText("");
					textinv.setText("Invalid Entry!");
				}


			}
		});
	}

	public double tempCon1(double arg1){
		double a=32;
		double b=9/5;
		double f;
		f=arg1*b+a;

		return f;
	}

	public double metercon(double arg1){
		double a=0.0010000;
		double f;
		f=arg1/a;

		return f;
	}

	public double metercon1(double arg1){


		return arg1/1000.0;
	}

	public double currcon(double arg1){
		double a=66.37;
		double f;
		f=arg1*a;

		return f;
	}

	public double currcon1(double arg1){
		double a=66.37;
		double f;
		f=arg1/a;

		return f;
	}

}
