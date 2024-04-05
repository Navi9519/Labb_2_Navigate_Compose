package com.navi9519.labb_2

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_2.destinations.AboutScreenDestination
import com.navi9519.labb_2.destinations.HomeScreenDestination
import com.navi9519.labb_2.destinations.LoggedInScreenDestination
import com.navi9519.labb_2.destinations.SignInScreenDestination
import com.navi9519.labb_2.ui.theme.Labb_2Theme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


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
                        // withStyledAttributes(ProfileTransitions::class) // TODO - ProfileTransitions
                    )

                   // SignInScreen()
                    //HomeScreen()
                    //AboutScreen()
                   // LoggedInScreen()
                }
            }
        }
    }
}


////// HOME SCREEN COMPONENTS //////
@RootNavGraph(start = true)
@Destination
@Composable
//@Preview(showBackground = true)
fun HomeScreen(navigator: DestinationsNavigator) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
         verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

ImageComponent(img = R.drawable.home_4)

        Text(
            text = "WELCOME TO THE STOCKOLM BJJ APP",
            fontSize = 30.sp,
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 3,
            style = LocalTextStyle.current.copy(lineHeight = 50.sp),
            modifier = Modifier
                .padding(vertical = 40.dp)




        )
        Text(
            text = "FOR MORE INFO PRESS THE BUTTON BELOW",
            fontSize = 30.sp,
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 3,
            style = LocalTextStyle.current.copy(lineHeight = 50.sp),
            modifier = Modifier
                .padding(40.dp)



        )

        Btn("About Page") {
            navigator.navigate(AboutScreenDestination)
        }
    }


}



/////// ABOUT SCREEN COMPONENTS ///////
@Destination
@Composable
//@Preview(showBackground = true)
fun AboutScreen(navigator: DestinationsNavigator) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ImageComponent(img = R.drawable.about_1)

        Text(
            text = "BJJ is one of the most central martial arts within MMA (Mixed Martial Arts)" +
                    " and BJJ fighters from Sweden have also competed successfully in MMA.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            maxLines = 3,
            style = LocalTextStyle.current.copy(lineHeight = 50.sp),
            modifier = Modifier
                .padding(vertical = 40.dp)
        )

        ImageComponent(img = R.drawable.about_3)

        Text(
            text = "To Log in, press the button below ",
            fontSize = 15.sp,
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 2,
            style = LocalTextStyle.current.copy(lineHeight = 50.sp),
            modifier = Modifier
                .padding(40.dp)


        )

        Btn("Sign in Page") {
            navigator.navigate(SignInScreenDestination)
        }
    }


}


////// SIGN IN SCREEN COMPONENTS //////
@Destination
@Composable
//@Preview(showBackground = true)
fun SignInScreen(navigator: DestinationsNavigator) {


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
        SignInTitle()
        SignInInputField(input = "Name", icon = "person")
        SignInInputField(input = "Password", icon = "lock")
        Btn("Login") {
            navigator.navigate(LoggedInScreenDestination)
        }

    }

}
}


@Composable
fun SignInTitle() {
  Text(text = "BJJ STOCKHOLM",
      fontSize = 40.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Red,
      fontFamily = FontFamily.Cursive,
      modifier = Modifier.padding(40.dp))

    Text(text = "Login", fontSize = 50.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.padding(40.dp))
    
}

@Composable
fun SignInInputField(input: String, icon: String) {


   val (text, setText) = remember { mutableStateOf(TextFieldValue("")) }

    return OutlinedTextField(
        value = text,
        modifier = Modifier
            .padding(vertical = 40.dp)
            .background(Color.Black, RoundedCornerShape(22.dp)),
        shape = RoundedCornerShape(22.dp)
        ,

        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color.Red,
            unfocusedBorderColor = Color.Red,
            unfocusedLabelColor = Color.Red,
            unfocusedLeadingIconColor = Color.Red,
            focusedBorderColor = Color.Red,
            focusedLabelColor = Color.Red,


        ),

        textStyle = TextStyle(
            Color.Red,
            fontSize = 20.sp),

        leadingIcon = {
            Icon(
                imageVector = getLoginIcon(icon),
                contentDescription = "$icon Icon",
                tint = Color.Red
            ) },

        onValueChange = {
            setText(it)

        },
        label = {
            Text(
                text = input,
            ) },




    )

}

// Get Icon function for input field

private fun getLoginIcon(iconName: String): ImageVector {
    return when (iconName) {
        "person" -> Icons.Default.Person
        "lock" -> Icons.Default.Lock
        else -> Icons.Default.Warning
    }

}








/////// Logged In Screen COMPONENTS ///////
@Destination
@Composable
//@Preview(showBackground = true)
fun LoggedInScreen(navigator: DestinationsNavigator) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome NAME, here is the top 3 BJJ" +
                    " clubs in Stockholm, press the pictures to get to each clubs website:",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            maxLines = 3,
            style = LocalTextStyle.current.copy(lineHeight = 30.sp),
            modifier = Modifier
                .padding(vertical = 15.dp)

        )

        Text(
            text = "Team Leites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 15.dp)
        )
        ImageLoggedInComponent(img = R.drawable.loggedin_1 )

        Text(
            text = "Prana Jiu-Jitsu",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 15.dp)
        )
        ImageLoggedInComponent(img = R.drawable.loggedin_2 )

        Text(
            text = "Stark Jiu-Jitsu" ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 15.dp)
        )
        ImageLoggedInComponent(img = R.drawable.loggedin_3 )

        Btn(text = "Go Back to Home") {
            navigator.navigate(HomeScreenDestination)
        }
    }


}



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