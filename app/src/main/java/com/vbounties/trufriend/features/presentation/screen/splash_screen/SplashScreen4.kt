package com.vbounties.trufriend.features.presentation.screen.splash_screen

import android.widget.Toast
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vbounties.trufriend.R
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.presentation.navigation.navhost.ParentNav
import com.vbounties.trufriend.features.presentation.navigation.`object`.LoginNavigation
import com.vbounties.trufriend.features.presentation.navigation.`object`.ParentNavigation

@Composable
@Preview
fun SplashScreen4(
    loginController: NavController = rememberNavController(),
    parentController: NavController = rememberNavController()
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(horizontal = 16.dp)
    ){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(60.dp))
            Box(modifier = Modifier.size(80.dp)) {
                Image(painter = painterResource(id = R.drawable.logoxl), contentDescription = "logo", modifier = Modifier.fillMaxSize())
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "TruFriend", fontWeight = FontWeight.SemiBold, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(24.dp))
            Box(modifier = Modifier.size(240.dp)){
                Image(painter = painterResource(id = R.drawable.family), contentDescription = "family", modifier = Modifier.fillMaxSize())
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Pilih opsi di bawah ini untuk melanjutkan masuk ke dalam aplikasi.", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(32.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
                colors = CardDefaults.cardColors(Color(0xFFC36528))
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        loginController.navigate(LoginNavigation.SignIn.route)
                    }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Text(text = "Daftar", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sudah punya akun?", fontWeight = FontWeight.Medium, color = Color(0xFF696969))
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(40.dp),
                        colors = CardDefaults.cardColors(Color(0xFFFFB764))
                    ) {
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                            .clickable {
                                loginController.navigate(LoginNavigation.Login.route)
                            }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            Text(text = "Masuk", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        }
                    }
                }
                VerticalDivider(thickness = 2.dp)
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Lanjutkan sebagai \nGuest", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color(0xFF696969), modifier = Modifier.clickable {
                        parentController.navigate(ParentNavigation.BottomNav.route)
                    })
                }
            }
        }
    }
}