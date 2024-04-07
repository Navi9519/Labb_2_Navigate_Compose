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
import com.navi9519.labb_2.ui.screens.destinations.SignInScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
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