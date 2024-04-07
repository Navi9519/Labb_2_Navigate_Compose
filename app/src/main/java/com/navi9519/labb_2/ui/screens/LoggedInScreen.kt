package com.navi9519.labb_2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_2.Btn
import com.navi9519.labb_2.ImageLoggedInComponent
import com.navi9519.labb_2.R
import com.navi9519.labb_2.ui.screens.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoggedInScreen(username: String, navigator: DestinationsNavigator) {


    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome $username, here is the top 3 BJJ" +
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