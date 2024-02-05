package castanedo.carlos.kotlinappcarloscastanedo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val receivedMessage = intent.getStringExtra("MESSAGE")
        val textView = findViewById<TextView>(R.id.txtReceivedMessageFromUser)
        textView.text = receivedMessage

    }
}