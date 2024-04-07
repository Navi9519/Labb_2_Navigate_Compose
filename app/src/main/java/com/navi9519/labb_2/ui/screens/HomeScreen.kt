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
import com.navi9519.labb_2.ImageComponent
import com.navi9519.labb_2.R
import com.navi9519.labb_2.ui.screens.destinations.AboutScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
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