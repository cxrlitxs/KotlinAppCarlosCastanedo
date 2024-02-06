package castanedo.carlos.kotlinappcarloscastanedo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnBoarding : AppCompatActivity(), OnClickListener{

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        navController = findNavController(R.id.nav_host_fragment_content_main)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}