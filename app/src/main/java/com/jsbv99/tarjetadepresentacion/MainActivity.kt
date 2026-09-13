package com.jsbv99.tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

private val CardBackground = Color(0xFF718DB0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = CardBackground
            ) {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.logo_sb),
            contentDescription = "Logo personal SB",
            modifier = Modifier
                .padding(top = 50.dp)
                .size(145.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Logo de Android",
                modifier = Modifier
                    .size(180.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            ProfileSection(
                name = "Jordy Sebastián\nBravo Véliz",
                title = "Android Developer"
            )
        }

        ContactSection(
            telefono = "\uD83D\uDCDE +593 980153446",
            github = "\uD83D\uDC08\u200D⬛ @sebasbv11",
            correo = "✉\uFE0F jsbv99@gmail.com"
        )
    }
}

@Composable
fun ProfileSection(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 28.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 34.sp,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ContactSection(telefono: String, github: String, correo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactRow(text = telefono)
        ContactRow(text = github)
        ContactRow(text = correo)
    }
}

@Composable
fun ContactRow(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFFFFFFFF),
        modifier = modifier.padding(vertical = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = CardBackground
    ) {
        BusinessCardApp()
    }
}
