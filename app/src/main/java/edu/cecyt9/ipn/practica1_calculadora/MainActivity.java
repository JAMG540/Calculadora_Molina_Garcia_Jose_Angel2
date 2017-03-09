package edu.cecyt9.ipn.practica1_calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.math.*;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Double numero1=0.0;
    Double numero2=0.0;
    Double resultado=0.0;
    String operador;

    public void onClickButtonUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickButtonDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickButtonTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickButtonCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickButtonCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickButtonSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickButtonSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickButtonOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickButtonNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickButtonCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "0");
    }

    public void onClickButtonPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        if(tv.equals(".")){
            android.widget.Toast.makeText(this,"Ya se incertó un punto anteriormente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            tv.setText(tv.getText() + ".");
        }

    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        try {
            TextView tv = (TextView) findViewById(R.id.textViewNumero);
            numero1 = Double.parseDouble(tv.getText().toString());
            tv.setText("");
        }catch (Exception e){

            android.widget.Toast.makeText(this,"Introduce un número", Toast.LENGTH_SHORT).show();

        }


    }

    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickRaiz(View miView)
    {
        operador = "Raiz";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickPotencia(View miView){
        operador = "Potencia";
        onClickOperacionCapturaNumero1(miView);

    }
    public void onClickSeno(View miView)
    {
        operador = "Sen";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickCoseno(View miView)
    {
        operador = "Cos";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickTangente(View miView)
    {
        operador = "Tan";
        onClickOperacionCapturaNumero1(miView);
    }




    public void onClickIgual(View miView)
    {
        TextView tv;
        String mensaje="";
        try {

            tv = (TextView) findViewById(R.id.textViewNumero);

            if(!operador.equals("Sen") & !operador.equals("Cos") & !operador.equals("Tan") & !operador.equals("Raiz") ) {


             try {
                 numero2 = Double.parseDouble(tv.getText().toString());

                  if (operador.equals("+")) {
                      resultado = numero1 + numero2;
                  } else if (operador.equals("-")) {
                      resultado = numero1 - numero2;
                  } else if (operador.equals("*")) {
                      resultado = numero1 * numero2;
                  } else if (operador.equals("/")) {
                      resultado = numero1 / numero2;
                  } else if (operador.equals("Potencia")) {
                      resultado = Math.pow(numero1, numero2);
                  }
              }catch (Exception e)
              {
                  mensaje="Asegúrate de introducir correctamente el operador y los números";
              }
            }
         else {
                try {

                    if (operador.equals("Raiz")) {
                        resultado = Math.sqrt(numero1);
                    } else if (operador.equals("Sen")) {
                        resultado = Math.sin(numero1);
                    } else if (operador.equals("Cos")) {
                        resultado = Math.cos(numero1);
                    } else if (operador.equals("Tan")) {
                        resultado = Math.tan(numero1);
                    }
                }catch (Exception e){
                    mensaje="Presiona un número primero.";
                }
            }


            tv.setText(resultado.toString());
        }catch(NumberFormatException nfe){

            Toast.makeText(this,mensaje, LENGTH_SHORT).show();
        }
    }

    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText("");
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
