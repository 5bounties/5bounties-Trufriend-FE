package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vbounties.trufriend.features.domain.model.EmotionModel
import com.vbounties.trufriend.features.domain.model.EmotionType
import com.vbounties.trufriend.features.domain.model.JournalModel
import java.time.LocalDateTime

@Composable
fun CreateJournalCard(
    emotion: EmotionModel = EmotionType.DATAR,
    onFinished: (JournalModel) -> Unit
){
    val reset = remember { mutableStateOf(false) }
    val desc = remember { mutableStateOf("Tambahkan catatan...") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Card(modifier = Modifier
                .width(120.dp)
                .height(40.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFB764))
            ) {
                Box(modifier = Modifier.fillMaxSize().clickable {

                    onFinished(JournalModel(
                        mood = emotion.emotion,
                        content = desc.value
                    ))
                }, contentAlignment = Alignment.Center){
                    Text(text = "Simpan", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
            ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)){
                    Image(painter = painterResource(id = emotion.resource), contentDescription = "mood", modifier = Modifier.fillMaxSize())
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = emotion.emotion, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "-- " + LocalDateTime.now().hour.toString() + ":" + LocalDateTime.now().minute.toString() + " --", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                BasicTextField(value = desc.value, onValueChange = {
                    if(reset.value) {
                        desc.value = it
                    } else {
                        desc.value = ""
                        reset.value = true
                    }
                }, modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp),
                    textStyle = TextStyle(color = Color.Gray, fontSize = 18.sp)
                )
            }
        }
    }
}