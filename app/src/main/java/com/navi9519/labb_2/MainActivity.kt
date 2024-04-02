package com.navi9519.labb_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_2.ui.theme.Labb_2Theme




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
                    LoginPage()
                }
            }
        }
    }
}


////// HOME PAGE COMPONENTS //////

@Composable
fun HomePage() {
    
}


////// LOGIN PAGE COMPONENTS //////

@Composable
@Preview(showBackground = true)
fun LoginPage() {
Box(modifier = Modifier.fillMaxSize()) {

   Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = "Login-background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.matchParentSize())





    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTitle()
        LoginInputField(label = "Name", icon = "person")
        LoginInputField(label = "Password", icon = "lock")
        LoginBtn()

    }

}
}

@Composable
fun LoginTitle() {
  Text(text = "BJJ STOCKHOLM",
      fontSize = 40.sp,
      color = Color.Red,
      fontFamily = FontFamily.Cursive,
      modifier = Modifier.padding(40.dp))

    Text(text = "Login", fontSize = 50.sp,
        color = Color.Red,
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.padding(40.dp))
    
}

@Composable
fun LoginInputField(label: String, icon: String) {


    var text by remember { mutableStateOf(TextFieldValue("")) }

    return OutlinedTextField(
        value = text,
        modifier = Modifier
            .padding(horizontal = 40.dp, vertical = 40.dp)
            .background(Color.Black, RoundedCornerShape(22.dp)),
        shape = RoundedCornerShape(22.dp),

        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color.Red,
            unfocusedBorderColor = Color.Red,
            unfocusedLabelColor = Color.Red,
            unfocusedLeadingIconColor = Color.Red,


        ),
        leadingIcon = {
            Icon(
                imageVector = getIcon(icon),
                contentDescription = "$icon Icon",
                tint = Color.Red
            ) },

        onValueChange = {
            text = it

        },
        label = {
            Text(
                text = label,

            ) },


    )

}

// Get Icon function for input field

private fun getIcon(iconName: String): ImageVector {
    return when (iconName) {
        "person" -> Icons.Default.Person
        "lock" -> Icons.Default.Lock
        else -> Icons.Default.Warning
    }

}

@Composable
fun LoginBtn() {
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        modifier = Modifier
            .width(250.dp)
            .padding(20.dp)
    )  {

        Text(
            text = "Login",
            color = Color.Red,
            fontSize = 20.sp

        )

    }
}

/////// ABOUT PAGE COMPONENTS ///////

@Composable
fun AboutPage() {

}


/////// LOGGED IN PAGE COMPONENTS ///////

@Composable
fun LoggedInPage() {

}