package com.scanfie.sumuphelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PayActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val amount = intent?.data?.getQueryParameter("amount") ?: "0.00"
    val order = intent?.data?.getQueryParameter("order") ?: "-"
    val mode  = intent?.data?.getQueryParameter("mode") ?: "live"

    setContent {
      MaterialTheme {
        Box(Modifier.fillMaxSize().background(Color(0xFF0F2430)), contentAlignment = Alignment.Center) {
          // Card met “mint-glass” look (gradient + transparantie)
          Box(
            Modifier
              .padding(16.dp)
              .clip(RoundedCornerShape(24.dp))
              .background(
                Brush.verticalGradient(listOf(Color.White.copy(alpha = 0.16f), Color.White.copy(alpha = 0.08f)))
              )
              .padding(20.dp)
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("SumUp • Betaling", color = Color(0xCCFFFFFF))
              Spacer(Modifier.height(8.dp))
              Text("Gereed voor betaling", color = Color.White)
              Spacer(Modifier.height(8.dp))
              Text("Bedrag: € $amount", color = Color.White)
              Text("Bon: #$order", color = Color(0xCCFFFFFF))
              Text("Mode: ${mode.uppercase()}", color = Color(0xCCFFFFFF))
              Spacer(Modifier.height(16.dp))
              Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { finish() }) { Text("Sluiten") }
                Button(onClick = { /* later: SumUp-SDK */ }) { Text("Nieuwe betaling") }
              }
            }
          }
        }
      }
    }
  }
}
