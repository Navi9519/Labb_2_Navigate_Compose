package com.navi9519.labb_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_2.ui.models.User
import com.navi9519.labb_2.ui.screens.NavGraphs
import com.navi9519.labb_2.ui.theme.Labb_2Theme
import com.ramcosta.composedestinations.DestinationsNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labb_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root
                    )

                }
            }
        }
    }
}

// List of users added when signing/Logging in to a MutableList
val users = mutableStateListOf<User>()


//// Reusable composables over all  screens ////


// Reusable button components for all screens
@Composable
fun Btn(text: String, onclick: () -> Unit) {
    Button(onClick = onclick,
        colors = ButtonDefaults.buttonColors(Color.Black),
        border = BorderStroke(1.dp, Color.Red),
        modifier = Modifier
            .width(250.dp)
            .padding(20.dp)

    )  {

        Text(
            text = text,
            color = Color.Red,
            fontSize = 20.sp,

            )
    }
}


// Reusable image component for all screens except LoggedIn
@Composable
fun ImageComponent(img: Int) {
    Image(
        painter = painterResource(id = img),
        contentDescription = "about images",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(210.dp)
            .height(210.dp)
            .clip(CircleShape)
            .border(0.5.dp, Color.Red, CircleShape)
    )


}

// Reusable image component for LoggedIn Screen
@Composable
fun ImageLoggedInComponent(img: Int) {
    Image(
        painter = painterResource(id = img),
        contentDescription = "about images",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(160.dp)
            .height(160.dp)
            .clip(CircleShape)
            .border(0.5.dp, Color.Red, CircleShape)
    )


}