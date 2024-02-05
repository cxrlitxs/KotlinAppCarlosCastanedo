package castanedo.carlos.kotlinappcarloscastanedo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var bodyLayout:FrameLayout
    lateinit var buttonChangeColor:Button
    lateinit var buttonChangeActivity:Button
    lateinit var edTextWriteSomething:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia a la vista
        bodyLayout = findViewById<FrameLayout>(R.id.bodyLayout)
        // Cambia el color de fondo
        frameLayoutSetBackgroudColor(bodyLayout, Color.rgb(169 ,251,230)) // Puedes cambiar el color aquí


        buttonChangeColor=findViewById(R.id.buttonChangeColor)
        buttonChangeActivity=findViewById(R.id.buttonChangeActivity)
        edTextWriteSomething=findViewById(R.id.edTextWriteSomething)

        buttonChangeColor.setOnClickListener(this)
        buttonChangeActivity.setOnClickListener(this)

    }

    private fun frameLayoutSetBackgroudColor(frameLayout: FrameLayout, color: Int) {
        frameLayout.setBackgroundColor(color)
    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.buttonChangeColor){
            val randomColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            bodyLayout.setBackgroundColor(randomColor)
        }
        else if(v!!.id==R.id.buttonChangeActivity){
            var message = edTextWriteSomething.text.toString()
            var activity2: Intent = Intent(this,Activity2::class.java)
            activity2.putExtra("MESSAGE", message)
            startActivity(activity2)
        }
    }

}