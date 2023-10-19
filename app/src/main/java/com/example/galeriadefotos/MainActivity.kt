package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadefotos.ui.theme.GaleriaDeFotosTheme
import androidx.compose.foundation.Image as Image

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotosTheme {


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Galeria() {
    var resultado by remember { mutableStateOf(1) }
    var imagens = when (resultado) {
        1 -> R.drawable.allucard1
        2 -> R.drawable.dio2
        3 -> R.drawable.guts3
        4 -> R.drawable.luffy4
        5 -> R.drawable.sinbad5
        else -> R.drawable.kira6
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 100.dp,
                bottom = 30.dp
            )
    ) {
        Image(
            painter = painterResource(id = imagens),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(end = 4.dp, start = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp, start = 4.dp)
        ) {
            Button(
                onClick = {
                    if (resultado > 1) {
                        resultado++
                    } else {
                        resultado = 3
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Red),

            ) {
                Text(
                    text = "Anterior"
                )

            }
            Button(
                onClick = {
                    if (resultado < 3) {
                        resultado--
                    } else {
                        resultado = 1
                    }
                }
            ) {
                Text(text = "Próximo")
            }

        }

    }
}