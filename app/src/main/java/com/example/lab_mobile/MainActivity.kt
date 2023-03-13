package com.example.lab_mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_mobile.ui.theme.LabMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabMobileTheme {
                val configuration = LocalConfiguration.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //OrientationChange(configuration = configuration)
                    //VerticalLayout(configuration = configuration)
                    //HorizontalLayout(configuration = configuration)
                    //BoxConstraintsLayout()
                    //ListNames()
                    //ScrollableList()
                    //ScaffoldFunction()
                    GoToSettings()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LabMobileTheme {
        Greeting("Android")
    }
}

@Composable
fun GoToSettings() {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, SettingsActivity::class.java)
            context.startActivity(intent)

            /*
            val geoLocation = Uri.parse("geo:44.1391, 12.24315")

            val intent = Intent(Intent.ACTION_VIEW).apply {
                data =  geoLocation
            }

            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
            */
        },
        modifier = Modifier.requiredSize(150.dp, 50.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimaryContainer)
    ) {
        Text(text = "Go to settings")
    }
}