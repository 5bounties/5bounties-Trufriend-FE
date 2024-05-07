package com.vbounties.trufriend.features.presentation.screen.login_screen

import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
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
import com.vbounties.trufriend.features.domain.model.RegisterModel
import com.vbounties.trufriend.features.presentation.design_system.TrufriendPurple
import com.vbounties.trufriend.features.presentation.design_system.TrufriendYellow
import com.vbounties.trufriend.features.presentation.navigation.`object`.LoginNavigation
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation
import com.vbounties.trufriend.features.utils.uriToBitmap

@Composable
@Preview
fun SignInScreen(
    parentController: NavController = rememberNavController(),
    loginController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<LoginViewModel>()
    val name = remember { mutableStateOf("Enter your full name") }
    val email = remember { mutableStateOf("Enter your email") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val reset = remember { mutableStateOf(false) }
    val reset2 = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImageUri.value = uri
            bitmap.value = selectedImageUri.value?.let { uriToBitmap(context, it) }
        }
    )
    val loginState = viewModel.loginstate.collectAsState()

    if(loginState.value.message.equals("Registrasi Berhasil")){
        LaunchedEffect(Unit){
            Toast.makeText(context, loginState.value.message, Toast.LENGTH_LONG).show()
            loginController.navigate(LoginNavigation.Login.route)
        }
    } else if(loginState.value.message.equals("Registrasi Gagal")){
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
            Text(text = "Sign up", fontWeight = FontWeight.Bold, fontSize = 36.sp, color = TrufriendPurple, lineHeight = 36.sp)
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Card(modifier = Modifier
                    .size(100.dp),
                    colors = CardDefaults.cardColors(TrufriendYellow),
                    border = BorderStroke(2.dp, TrufriendYellow),
                    shape = CircleShape
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }, contentAlignment = Alignment.Center){
                        bitmap.value?.let { Image(bitmap = it.asImageBitmap(), contentDescription = "profile", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop) }
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = "profile", tint = Color.White, modifier = Modifier.size(40.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Name", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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
                    Icon(imageVector = Icons.Rounded.Person, contentDescription = "email", tint = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(value = name.value, onValueChange = {
                        if(reset2.value) {
                            name.value = it
                        } else {
                            name.value = ""
                            reset2.value = true
                        }
                    }, modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                        textStyle = TextStyle(color = Color.Gray)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Email", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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
                    Icon(imageVector = Icons.Rounded.Email, contentDescription = "email", tint = Color.Gray)
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
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Password", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Confirm Password", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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
                    BasicTextField(value = confirmPassword.value, onValueChange = {
                        confirmPassword.value = it
                    }, modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                        textStyle = TextStyle(color = Color.Gray),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                Checkbox(checked = true, onCheckedChange ={}, colors = CheckboxDefaults.colors(TrufriendPurple))
                Text(text = "I have agreed to CODEMATE's Terms and Conditions", color = Color.Gray, fontSize = 11.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
                colors = CardDefaults.cardColors(TrufriendPurple)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clickable {
                        if(
                            !name.value.isEmpty() &&
                            !email.value.isEmpty() &&
                            !password.value.isEmpty() &&
                            bitmap.value != null
                            ) {
                            viewModel.register(context, RegisterModel(
                                name = name.value,
                                username = email.value.substringBefore("@"),
                                email = email.value,
                                password = password.value,
                                avatar = bitmap.value!!
                            ))
                        } else {
                            Toast.makeText(context, "Isikan form dengan benar", Toast.LENGTH_SHORT).show()
                        }
                    }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Text(text = "Sign-In", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                }
            }
        }
    }
}