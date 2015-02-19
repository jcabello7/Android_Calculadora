package com.example.calculadora;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener  {
	
	//Crea les variables i estableix valors
	TextView tVPantalla, tVResultat;
	float num;
	char opAnt;
	float resultat = 0;
	CharSequence prova;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Associa les pantalles de la interfície amb les variables de Java
		tVPantalla = (TextView) findViewById (R.id.tVPantalla);
		tVResultat = (TextView) findViewById (R.id.tVResultat);
		
		//Està atent a si es fa clic a algun botó de la interfície
		findViewById(R.id.boto0).setOnClickListener(this);
		findViewById(R.id.boto1).setOnClickListener(this);
		findViewById(R.id.boto2).setOnClickListener(this);
		findViewById(R.id.boto3).setOnClickListener(this);
		findViewById(R.id.boto4).setOnClickListener(this);
		findViewById(R.id.boto5).setOnClickListener(this);
		findViewById(R.id.boto6).setOnClickListener(this);
		findViewById(R.id.boto7).setOnClickListener(this);
		findViewById(R.id.boto8).setOnClickListener(this);
		findViewById(R.id.boto9).setOnClickListener(this);
		findViewById(R.id.botoSuma).setOnClickListener(this);
		findViewById(R.id.botoResta).setOnClickListener(this);
		findViewById(R.id.botoMultiplica).setOnClickListener(this);
		findViewById(R.id.botoDividir).setOnClickListener(this);
		findViewById(R.id.botoIgual).setOnClickListener(this);
		findViewById(R.id.botoPunt).setOnClickListener(this);
		findViewById(R.id.botoBorra).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Quan es fa clic a un botó de la interfície, crida a aquesta funció
	@Override
	public void onClick(View v) {
		// Si es fa clic a un número, l'afageix a la pantalla
		if (((v.getId()==R.id.boto0)||(v.getId()==R.id.boto1)||(v.getId()==R.id.boto2)||(v.getId()==R.id.boto3)||(v.getId()==R.id.boto4)||(v.getId()==R.id.boto5)||(v.getId()==R.id.boto6)||(v.getId()==R.id.boto7)||(v.getId()==R.id.boto8)||(v.getId()==R.id.boto9)))
			tVPantalla.append(((TextView) v).getText().toString());
		
		// Si es fa clic a borrar, borra les pantalles i inicialitza les variables.
		if (v.getId()==R.id.botoBorra) { 
			tVPantalla.setText("");
			tVResultat.setText("");
			resultat=0;
			num=0;
			opAnt=0;
		}
	
		// Si es fa clic al punt, i no n'hi ha cap, afegeix el punt.
		if (v.getId()==R.id.botoPunt)
			if (tVPantalla.getText().toString().contains("."))
				;
			else
				tVPantalla.append(((TextView) v).getText().toString());
		
		// Si es fa clic a algun operador...
		if ((v.getId()==R.id.botoSuma)||(v.getId()==R.id.botoResta)||(v.getId()==R.id.botoMultiplica)||(v.getId()==R.id.botoDividir)||(v.getId()==R.id.botoIgual)) {
			
			// Si hi ha algun número a la pantalla, calcula el resultat
			if ((tVPantalla.getText().length()!=0) && (!(tVPantalla.getText().toString().contentEquals(".")))) {
				num = Float.valueOf(tVPantalla.getText().toString());
				switch (opAnt) {
					case 's': resultat = resultat + num;
					break;
					
					case 'r': resultat = resultat - num;
					break;
					
					case 'm': resultat = resultat * num;
					break;
					
					case 'd': resultat = resultat / num;
					break;
					
					default: resultat = num;
					break;
				}
			}
			
			// Escriu el resultat, borra la pantalla, i afegeix l'operador darrera del resultat
			tVResultat.setText(Float.toString(resultat));
			tVPantalla.setText("");	
			tVResultat.append(((TextView) v).getText().toString());
			
			// Guarda l'operador pulsat, per fer la següent operació
			switch (v.getId()) {
				
				case R.id.botoSuma:
					opAnt = 's';
					break;
					
				case R.id.botoResta:
					opAnt = 'r';
					break;
					
				case R.id.botoMultiplica:
					opAnt = 'm';
					break;
					
				case R.id.botoDividir:
					opAnt = 'd';
					break;
					
				default: opAnt=0;
					break;
					
			}		
		}
	}
}

	