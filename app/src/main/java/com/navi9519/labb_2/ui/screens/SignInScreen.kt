package com.navi9519.labb_2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_2.Btn
import com.navi9519.labb_2.R
import com.navi9519.labb_2.ui.models.User
import com.navi9519.labb_2.ui.screens.destinations.LoggedInScreenDestination
import com.navi9519.labb_2.users
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {

    val usernameState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState= remember { mutableStateOf(TextFieldValue("")) }


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

            // Username input field logic
            SignInInputField(
                usernameState.value ,
                { newValue ->usernameState.value = newValue },
                icon = "person",
                "Name")

            // Password input field logic
            SignInInputField(passwordState.value,
                { newValue ->passwordState.value = newValue },
                icon = "lock",
                "Password",
                visual = PasswordVisualTransformation()
            )
            Btn("Login") {


                // Add new User
                val newUser = User(usernameState.value.text, passwordState.value.text)

                // Update the userList state
                users.add(usernameState.value.text to passwordState.value.text)

                //  Navigating to login screen + sending username data to display ypu are logged in
                val username = newUser.userName

                for(user in users) {
                    println(user)
                }

                navigator.navigate(LoggedInScreenDestination(username))
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
fun SignInInputField(
    input: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    icon: String,
    label: String,
    visual: PasswordVisualTransformation? = null
) {


    return OutlinedTextField(
        value = input,
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
            onValueChange(it)


        },
        label = {
            Text(
                text = label,
            ) },

        visualTransformation = visual ?: VisualTransformation.None




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