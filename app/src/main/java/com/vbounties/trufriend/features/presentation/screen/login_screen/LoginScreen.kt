package com.vbounties.trufriend.features.presentation.screen.login_screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.presentation.design_system.TrufriendPurple
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun LoginScreen(
    parentController: NavController = rememberNavController(),
    loginController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<LoginViewModel>()
    val email = remember { mutableStateOf("Enter your email") }
    val password = remember { mutableStateOf("") }
    val reset = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val loginState = viewModel.loginstate.collectAsState()

    if(loginState.value.message.equals("Login Berhasil")){
        LaunchedEffect(Unit){
            Toast.makeText(context, loginState.value.message, Toast.LENGTH_LONG).show()
            parentController.navigate(ParentNavigation.BottomNav.route)
        }
    } else if(loginState.value.message.equals("Login Gagal")){
        LaunchedEffect(Unit){
            Toast.makeText(context, loginState.value.message, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Welcome\nBack.", fontWeight = FontWeight.Bold, fontSize = 36.sp, color = TrufriendPurple, lineHeight = 36.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Sign-in untuk melanjutkan", fontSize = 16.sp, fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(32.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Rounded.Person, contentDescription = "email", tint = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(value = email.value, onValueChange = {
                            if(reset.value) {
                                email.value = it
                            } else {
                                email.value = ""
                                reset.value = true
                            }
                    }, modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                        textStyle = TextStyle(color = Color.Gray)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.Gray)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Rounded.Key, contentDescription = "email", tint = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(value = password.value, onValueChange = {
                        password.value = it
                    }, modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                        textStyle = TextStyle(color = Color.Gray),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
                colors = CardDefaults.cardColors(TrufriendPurple)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clickable {
                        if (email.value.contains("@")) {
                            viewModel.login(LoginModel(email = email.value, password = password.value))
                        } else {
                            if (!email.value.contains("@")) {
                                Toast.makeText(context, "Email tidak valid", Toast.LENGTH_LONG).show()
                            }
                            if (password.value.length < 6) {
                                Toast.makeText(context, "Password minimal 6 karakter", Toast.LENGTH_LONG).show()
                            }
                        }
                        password.value = ""
                        email.value = "Enter your email"
                        reset.value = false
                    }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Text(text = "Sign-In", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                Text(text = "Forgot Password?", color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(64.dp))
            Row(modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Belum punya akun?", color = Color.Gray, fontSize = 14.sp)
                Text(text = " Sign up", color = TrufriendPurple, fontSize = 14.sp)
            }

        }
    }
}