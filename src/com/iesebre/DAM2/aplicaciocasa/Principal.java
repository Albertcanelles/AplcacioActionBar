package com.iesebre.DAM2.aplicaciocasa;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends Activity {
	public final static String identificadorIntent = "numero";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		final Button btn_insertar = (Button)findViewById(R.id.btn_insertar);
		final Button btn_actualitzar = (Button)findViewById(R.id.btn_actualitzar);
		final Button btn_eliminar = (Button)findViewById(R.id.btn_eliminar);
		OnTouchListener Insertar = new OnTouchListener() {
	         
			public boolean onTouch(View v, MotionEvent event) {
	             switch (event.getAction()) {	            
	             case MotionEvent.ACTION_UP:
	            	 Intent in = new Intent(Principal.this, MainActivity.class );
	            	 in.putExtra(identificadorIntent,1);
	            	 startActivity(in);
		             Toast.makeText(Principal.this, "Insertar" ,Toast.LENGTH_LONG).show();
	               // nothing to do
	               break;
	             default:
	               return false;
	             }
	                return false;
	        }
	     };
	     OnTouchListener Eliminar = new OnTouchListener() {
	         
				public boolean onTouch(View v, MotionEvent event) {
		             switch (event.getAction()) {	            
		             case MotionEvent.ACTION_UP:
		            	 Intent in= new Intent(Principal.this, MainActivity.class );			           
		            	 in.putExtra(identificadorIntent,2);
		            	 startActivity(in);
			             Toast.makeText(Principal.this, "Eliminar" ,Toast.LENGTH_LONG).show();
		               // nothing to do
		               break;
		             default:
		               return false;
		             }
		                return false;
		        }
		     };
	     
	     OnTouchListener Actualitzar = new OnTouchListener() {
	         
				public boolean onTouch(View v, MotionEvent event) {
		             switch (event.getAction()) {	            
		             case MotionEvent.ACTION_UP:
		            	 Intent in = new Intent(Principal.this, MainActivity.class );  
		            	 in.putExtra(identificadorIntent,3);
		            	 startActivity(in);
			             Toast.makeText(Principal.this, "Actualitzar" ,Toast.LENGTH_LONG).show();
		               // nothing to do
		               break;
		             default:
		               return false;
		             }
		                return false;
		        }
		     };
		     
		     
	     
	     btn_insertar.setOnTouchListener(Insertar);
	     btn_actualitzar.setOnTouchListener(Actualitzar);
	     btn_eliminar.setOnTouchListener(Eliminar);
		
	}
}
