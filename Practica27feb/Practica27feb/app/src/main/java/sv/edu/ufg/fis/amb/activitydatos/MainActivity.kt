package sv.edu.ufg.fis.amb.activitydatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombres: EditText
    private lateinit var txtApellidos: EditText
    private lateinit var txtEmail: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres = findViewById(R.id.txtnombres)
        txtApellidos = findViewById(R.id.txtapellidos)
        txtEmail = findViewById(R.id.txtemail)
        btnGuardar = findViewById(R.id.btnguardar)

        btnGuardar.setOnClickListener(){

            if (txtNombres.getText().toString().isNullOrEmpty() || txtApellidos.getText().toString().isNullOrEmpty() || txtEmail.getText().toString().isNullOrEmpty() ){
                mensaje("Campos vacios","Se ha detectado que uno de los campos esta vacio")
            }else{
                val intent = Intent(this,ActivityRecepcionDatos::class.java)
                intent.putExtra("nombres",txtNombres.getText().toString())
                intent.putExtra("apellidos",txtApellidos.getText().toString())
                intent.putExtra("email",txtEmail.getText().toString())
                startActivity(intent)
            }

        }
    }

    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}