package com.scanfie.sumuphelper
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState); enableEdgeToEdge()
    setContent {
      MaterialTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
              // Demo: open PayActivity via ons eigen schema, alsof Scanfie ons roept
              val uri = Uri.parse("sumuphelper://pay?amount=18.50&order=1247&mode=sandbox")
              startActivity(Intent(Intent.ACTION_VIEW, uri))
            }) { Text("Toon popup (demo)") }
          }
        }
      }
    }
  }
}
