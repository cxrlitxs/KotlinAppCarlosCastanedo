package castanedo.carlos.kotlinappcarloscastanedo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia a la vista
        val bodyLayout = findViewById<FrameLayout>(R.id.bodyLayout)

        // Cambia el color de fondo
        frameLayoutSetBackgroudColor(bodyLayout, Color.rgb(169 ,251,230)) // Puedes cambiar el color aquí

    }

    private fun frameLayoutSetBackgroudColor(frameLayout: FrameLayout, color: Int) {
        frameLayout.setBackgroundColor(color)
    }
}